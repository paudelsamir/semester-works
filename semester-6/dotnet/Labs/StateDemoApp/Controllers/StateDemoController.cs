using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Http;
using StateDemoApp.Models;

namespace StateDemoApp.Controllers
{
    public class StateDemoController : Controller
    {
    // ---------------- SESSION ----------------
    public IActionResult SetSession()
    {
        HttpContext.Session.SetString("Name", "Alice");
        HttpContext.Session.SetInt32("Age", 25);
        return Content("Session set: Name=Alice, Age=25");
    }

    public IActionResult GetSession()
    {
        string name = HttpContext.Session.GetString("Name") ?? "Not Set";
        int age = HttpContext.Session.GetInt32("Age") ?? 0;
        return Content($"Session values: Name={name}, Age={age}");
    }

    // ---------------- TEMPDATA ----------------
    public IActionResult SetTempData()
    {
        TempData["Message"] = "Hello from TempData!";
        return RedirectToAction("GetTempData");
    }

    public IActionResult GetTempData()
    {
        string msg = TempData["Message"]?.ToString() ?? "No TempData";
        return Content($"TempData value: {msg}");
    }

    // ---------------- COOKIES ----------------
    public IActionResult SetCookie()
    {
        CookieOptions options = new CookieOptions { Expires = DateTime.Now.AddMinutes(10) };
        Response.Cookies.Append("MyCookie", "CookieValue", options);
        return Content("Cookie set: MyCookie=CookieValue");
    }

    public IActionResult GetCookie()
    {
        string val = Request.Cookies["MyCookie"] ?? "Not Found";
        return Content($"Cookie value: {val}");
    }

    // ---------------- QUERY STRING ----------------
    public IActionResult QueryStringDemo(string name, int age)
    {
        return Content($"Query String values: Name={name}, Age={age}");
    }

    // ---------------- HIDDEN FIELD ----------------
    [HttpGet]
    public IActionResult HiddenFieldDemo()
    {
        User u = new User { Id = 101, Name = "Bob", Age = 30 };
        return View(u);
    }

    [HttpPost]
    public IActionResult HiddenFieldDemo(User u)
    {
        return Content($"Hidden field value received: Id={u.Id}, Name={u.Name}, Age={u.Age}");
    }

    // ---------------- HttpContext Info ----------------
    public IActionResult HttpContextDemo()
    {
        string url = HttpContext.Request.Path;
        string method = HttpContext.Request.Method;
        int sessionCount = HttpContext.Session.Keys.Count();
        return Content($"Request URL: {url}, Method: {method}, Session Keys: {sessionCount}");
    }
    }
}
