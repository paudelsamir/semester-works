using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using TodoApp.Data;
using TodoApp.Models;

namespace TodoApp.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class TodoApiController : ControllerBase
    {
        private readonly TodoDbContext _context;
        private readonly ILogger<TodoApiController> _logger;

        public TodoApiController(TodoDbContext context, ILogger<TodoApiController> logger)
        {
            _context = context;
            _logger = logger;
        }

        // GET /api/TodoApi
        // returns all todos as JSON
        [HttpGet]
        public async Task<ActionResult<IEnumerable<TodoItem>>> GetAll()
        {
            _logger.LogInformation("Getting all todos");
            return await _context.TodoItems.ToListAsync();
        }

        // GET /api/TodoApi/{id}
        // returns one todo by id, or 404 if not found
        [HttpGet("{id}")]
        public async Task<ActionResult<TodoItem>> Get(int id)
        {
            _logger.LogInformation("Getting todo with id: {TodoId}", id);
            
            var todo = await _context.TodoItems.FindAsync(id);
            if (todo == null)
            {
                _logger.LogWarning("Todo with id {TodoId} not found", id);
                return NotFound();
            }
            return Ok(todo);
        }

        // POST /api/TodoApi
        // create a new todo
        [HttpPost]
        public async Task<ActionResult<TodoItem>> Create([FromBody] TodoItem item)
        {
            _logger.LogInformation("Creating new todo: {TodoTitle}", item.Title);

            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            item.CreatedDate = DateTime.UtcNow;
            _context.TodoItems.Add(item);
            await _context.SaveChangesAsync();

            return CreatedAtAction(nameof(Get), new { id = item.Id }, item);
        }

        // PUT /api/TodoApi/{id}
        // update an existing todo
        [HttpPut("{id}")]
        public async Task<IActionResult> Update(int id, [FromBody] TodoItem item)
        {
            _logger.LogInformation("Updating todo with id: {TodoId}", id);

            if (id != item.Id)
            {
                return BadRequest("ID mismatch");
            }

            var existingTodo = await _context.TodoItems.FindAsync(id);
            if (existingTodo == null)
            {
                _logger.LogWarning("Todo with id {TodoId} not found for update", id);
                return NotFound();
            }

            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);
            }

            existingTodo.Title = item.Title;
            existingTodo.Description = item.Description;
            existingTodo.IsCompleted = item.IsCompleted;
            
            if (item.IsCompleted && !existingTodo.CompletedDate.HasValue)
            {
                existingTodo.CompletedDate = DateTime.UtcNow;
            }

            _context.TodoItems.Update(existingTodo);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        // DELETE /api/TodoApi/{id}
        // remove a todo by id
        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(int id)
        {
            _logger.LogInformation("Deleting todo with id: {TodoId}", id);

            var todo = await _context.TodoItems.FindAsync(id);
            if (todo == null)
            {
                _logger.LogWarning("Todo with id {TodoId} not found for deletion", id);
                return NotFound();
            }

            _context.TodoItems.Remove(todo);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        // GET /api/TodoApi/completed/true
        // get all completed todos
        [HttpGet("completed/{isCompleted}")]
        public async Task<ActionResult<IEnumerable<TodoItem>>> GetByCompletionStatus(bool isCompleted)
        {
            _logger.LogInformation("Getting todos with completion status: {IsCompleted}", isCompleted);
            
            return await _context.TodoItems
                .Where(t => t.IsCompleted == isCompleted)
                .ToListAsync();
        }
    }
}
