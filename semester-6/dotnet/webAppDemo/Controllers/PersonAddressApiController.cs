using Microsoft.AspNetCore.Mvc;          // ASP.NET core API tools
using webAppDemo.Models;                  // your model class PersonAddressViewModel

namespace webAppDemo.Controllers
{
    // mark this class as an API controller
    [ApiController]

    // base route for all endpoints in this controller
    // [controller] is replaced with class name minus "Controller" → PersonAddressApi
    [Route("api/[controller]")]
    public class PersonAddressApiController : ControllerBase
    {
        private readonly PersonAddressDataAccess _personAddressDataAccess;

        public PersonAddressApiController(PersonAddressDataAccess personAddressDataAccess)
        {
            _personAddressDataAccess = personAddressDataAccess;
        }

        // GET /api/PersonAddressApi
        // returns all person addresses as JSON
        [HttpGet]
        public IActionResult GetAll()
        {
            var personAddresses = _personAddressDataAccess.GetAllPersonAddresses();
            return Ok(personAddresses);
        }

        // GET /api/PersonAddressApi/{name}
        // returns one person address by name, or 404 if not found
        [HttpGet("{name}")]
        public IActionResult Get(string name)
        {
            var personAddress = _personAddressDataAccess.GetPersonAddressByName(name);
            if (personAddress == null) return NotFound();
            return Ok(personAddress);
        }

        // POST /api/PersonAddressApi
        // create a new person address
        [HttpPost]
        public IActionResult Create([FromBody] PersonAddressViewModel personAddress)
        {
            _personAddressDataAccess.CreatePersonAddress(personAddress);
            return CreatedAtAction(nameof(Get), new { name = personAddress.Person.Name }, personAddress);
        }

        // PUT /api/PersonAddressApi/{name}
        // update an existing person address
        [HttpPut("{name}")]
        public IActionResult Update(string name, [FromBody] PersonAddressViewModel personAddress)
        {
            personAddress.Person.Name = name;
            _personAddressDataAccess.UpdatePersonAddress(personAddress);
            return Ok();
        }

        // DELETE /api/PersonAddressApi/{name}
        // remove a person address by name
        [HttpDelete("{name}")]
        public IActionResult Delete(string name)
        {
            _personAddressDataAccess.DeletePersonAddress(name);
            return Ok();
        }
    }
}
