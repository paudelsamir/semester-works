using Microsoft.AspNetCore.Mvc;

namespace Lab25_StateManagement_bySamir.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
    }

    public class StateController : Controller
    {
        public IActionResult Index()
        {
            ViewBag.Message = "Lab 25: State Management Techniques";
            return View();
        }

        public IActionResult SetSession()
        {
            HttpContext.Session.SetString("UserName", "Samir Paudel");
            HttpContext.Session.SetInt32("RollNo", 114079);
            HttpContext.Session.SetString("Section", "D");
            
            ViewBag.Message = "✓ Session data stored!";
            return View("GetSession");
        }

        public IActionResult GetSession()
        {
            var userName = HttpContext.Session.GetString("UserName");
            var rollNo = HttpContext.Session.GetInt32("RollNo");
            var section = HttpContext.Session.GetString("Section");
            
            ViewBag.SessionData = new { UserName = userName, RollNo = rollNo, Section = section };
            return View();
        }

        public IActionResult SetTempData()
        {
            TempData["SuccessMessage"] = "✓ Data saved successfully!";
            TempData["InfoMessage"] = "This survives one redirect";
            
            return RedirectToAction("GetTempData");
        }

        public IActionResult GetTempData()
        {
            ViewBag.SuccessMsg = TempData["SuccessMessage"] ?? "No success message";
            ViewBag.InfoMsg = TempData["InfoMessage"] ?? "No info message";
            
            return View();
        }

        public IActionResult SetCookie()
        {
            Response.Cookies.Append("UserTheme", "Dark", new CookieOptions
            {
                Expires = DateTimeOffset.Now.AddDays(7),
                HttpOnly = true
            });
            
            ViewBag.Message = "✓ Cookies set (expires in 7 days)";
            return View("GetCookie");
        }

        public IActionResult GetCookie()
        {
            Request.Cookies.TryGetValue("UserTheme", out string theme);
            
            ViewBag.CookieTheme = theme ?? "Not set";
            return View();
        }

        public IActionResult QueryStringDemo(int id = 0, string name = "", string course = "")
        {
            ViewBag.Id = id;
            ViewBag.Name = name;
            ViewBag.Course = course;
            return View();
        }
    }
}
