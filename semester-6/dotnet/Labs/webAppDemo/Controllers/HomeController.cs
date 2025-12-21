using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using webAppDemo.Models;
using System.Text.Encodings.Web;
using System.ComponentModel.Design;
using System.Runtime.Versioning;
using System.Reflection.PortableExecutable;


namespace webAppDemo.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;

    public HomeController(ILogger<HomeController> logger)
    {
        _logger = logger;
    }

    public IActionResult Index()
    {
        return View();
    }

    public IActionResult Privacy()
    {
        return View();
    }


    [HttpGet]
    public IActionResult About(string name = "Samir Paudel", int age = 21)
    {
        var person = new PersonModel
        {
            Name = name,
            Age = age,
            Email = "contact@samirpaudel.me",
            Github = "github.com/paudelsamir"
        };
        
        return View(person);
    }

    [HttpPost]
    public IActionResult UpdateInfo(PersonModel person)
    {       
        if (ModelState.IsValid)
        {
            // Here you would typically update a database
            return RedirectToAction("About", new { name = person.Name, age = person.Age });
        }
        return View("About", person);
    }


    [HttpGet]
    public IActionResult Profile()
    {
        var person = new PersonModel
        {
            Name = "Samir Paudel",
            Age = 21,
            Email = "contact@samirpaudel.me",
            Github = "github.com/paudelsamir"
        };

        var address = new AddressViewModel
        {
            City = "Kathmandu",
            State = "Bagmati"
        };

        var viewModel = new PersonAddressViewModel
        {
            Person = person,
            Address = address
        };

        return View(viewModel);
    }



    public IActionResult Redirect()
    {
        return Redirect("https://www.samirpaudel.me");
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
