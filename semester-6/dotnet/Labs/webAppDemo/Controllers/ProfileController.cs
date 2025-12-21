using Microsoft.AspNetCore.Mvc;
using webAppDemo.Models;

namespace webAppDemo.Controllers
{
    public class ProfileController : Controller
    {
        [HttpGet]
        public IActionResult Edit()
        {
            var model = new PersonAddressViewModel
            {
                Person = new PersonModel 
                { 
                    Name = "John Doe",
                    Email = "john@example.com",
                    Github = "johndoe"
                },
                Address = new AddressViewModel 
                { 
                    City = "Kathmandu",
                    State = "Bagmati"
                }
            };
            return View(model);
        }

        [HttpPost]
        public IActionResult Edit(PersonAddressViewModel model)
        {
            if (model.Person != null && model.Address != null)
            {
                return Content($"Updated profile: {model.Person.Name} from {model.Address.City}");
            }
            return RedirectToAction(nameof(Edit));
        }
    }
}
