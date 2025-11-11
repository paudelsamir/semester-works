using Microsoft.AspNetCore.Mvc;          // ASP.NET core API tools
using webAppDemo.Models;                  // your model class TodoItem

namespace webAppDemo.Controllers
{
    // mark this class as an API controller
    [ApiController]

    // base route for all endpoints in this controller
    // [controller] is replaced with class name minus "Controller" → TodoApi
    [Route("api/[controller]")]
    public class TodoApiController : ControllerBase
    {
        private readonly List<TodoItem> _todos = new(); // in-memory list of todos

        public TodoApiController()
        {
        }

        // GET /api/TodoApi
        // returns all todos as JSON
        [HttpGet]
        public IActionResult GetAll()
        {
            return Ok(_todos);
        }

        // GET /api/TodoApi/{id}
        // returns one todo by id, or 404 if not found
        [HttpGet("{id}")]
        public IActionResult Get(int id)
        {
            var todo = _todos.FirstOrDefault(t => t.Id == id);
            return todo == null ? NotFound() : Ok(todo);
        }

        // POST /api/TodoApi
        // create a new todo
        [HttpPost]
        public IActionResult Create([FromBody] TodoItem item)
        {
            item.Id = _todos.Count + 1;
            _todos.Add(item);
            return CreatedAtAction(nameof(Get), new { id = item.Id }, item);
        }

        // PUT /api/TodoApi/{id}
        // update an existing todo
        [HttpPut("{id}")]
        public IActionResult Update(int id, [FromBody] TodoItem item)
        {
            var todo = _todos.FirstOrDefault(t => t.Id == id);
            if (todo == null) return NotFound();

            todo.Title = item.Title;
            todo.Description = item.Description;
            todo.IsCompleted = item.IsCompleted;
            return NoContent();
        }

        // DELETE /api/TodoApi/{id}
        // remove a todo by id
        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            var todo = _todos.FirstOrDefault(t => t.Id == id);
            if (todo == null) return NotFound();

            _todos.Remove(todo);
            return NoContent();
        }
    }
}
