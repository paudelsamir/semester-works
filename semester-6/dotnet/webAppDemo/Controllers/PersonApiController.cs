using Microsoft.AspNetCore.Mvc;
using webAppDemo.Models;

namespace webAppDemo.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class PersonApiController : ControllerBase
    {
        private readonly DataAccess _dataAccess;

        public PersonApiController(DataAccess dataAccess)
        {
            _dataAccess = dataAccess;
        }

        [HttpGet]
        public IActionResult GetAll()
        {
            var persons = _dataAccess.GetAllPersons();
            return Ok(persons);
        }

        [HttpGet("{name}")]
        public IActionResult Get(string name)
        {
            var person = _dataAccess.GetPersonByName(name);
            if (person == null) return NotFound();
            return Ok(person);
        }

        [HttpPost]
        public IActionResult Create([FromBody] PersonModel person)
        {
            _dataAccess.CreatePerson(person);
            return CreatedAtAction(nameof(Get), new { name = person.Name }, person);
        }

        [HttpPut("{name}")]
        public IActionResult Update(string name, [FromBody] PersonModel person)
        {
            person.Name = name;
            _dataAccess.UpdatePerson(person);
            return Ok();
        }

        [HttpDelete("{name}")]
        public IActionResult Delete(string name)
        {
            _dataAccess.DeletePerson(name);
            return Ok();
        }
    }
}
