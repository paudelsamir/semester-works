using Microsoft.AspNetCore.Mvc;
using WebApp1BySamir.Models;

namespace WebApp1BySamir.Controllers
{
    public class MyController : Controller
    {
        // Action to display MyRazorPage
        public IActionResult MyRazorPage()
        {
            return View();
        }

        // Action to display Create Student form
        [HttpGet]
        public IActionResult CreateStudent()
        {
            return View();
        }

        // Action to handle form submission
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult CreateStudent(Student student)
        {
            if (ModelState.IsValid)
            {
                // If validation successful, redirect to StudentDetails page
                return RedirectToAction("StudentDetails", student);
            }
            
            // If validation fails, return to form with error messages
            return View(student);
        }

        // Action to display student details
        public IActionResult StudentDetails(Student student)
        {
            return View(student);
        }
    }
}
