using Microsoft.AspNetCore.Mvc;
using WebApp2BySamir.Services;

namespace WebApp2BySamir.Controllers
{
    public class DIController : Controller
    {
        private readonly IGreetingService _greetingService;
        private readonly IDataService _dataService;
        private readonly ILoggerService _loggerService;
        private readonly ITimeService _timeService1;
        private readonly ITimeService _timeService2;

        // Constructor Injection
        public DIController(
            IGreetingService greetingService,
            IDataService dataService,
            ILoggerService loggerService,
            ITimeService timeService1,
            ITimeService timeService2)
        {
            _greetingService = greetingService;
            _dataService = dataService;
            _loggerService = loggerService;
            _timeService1 = timeService1;
            _timeService2 = timeService2;

            _loggerService.LogInfo("DIController created");
        }

        public IActionResult Index()
        {
            _loggerService.LogInfo("Index action called");

            ViewBag.Greeting = _greetingService.GetGreeting("Samir");
            ViewBag.TimeBasedGreeting = _greetingService.GetTimeBasedGreeting();
            
            ViewBag.Students = _dataService.GetStudents();
            ViewBag.StudentCount = _dataService.GetStudentCount();
            ViewBag.ServiceCreated = _dataService.GetLastAccessTime();
            
            ViewBag.CurrentTime = _timeService1.GetCurrentTime();
            ViewBag.CurrentDate = _timeService1.GetCurrentDate();
            
            ViewBag.TimeService1Id = _timeService1.GetInstanceId();
            ViewBag.TimeService2Id = _timeService2.GetInstanceId();
            
            ViewBag.Logs = _loggerService.GetLogs();

            return View();
        }

        public IActionResult Lifetimes()
        {
            _loggerService.LogInfo("Lifetimes action called");

            ViewBag.SingletonInfo = _dataService.GetLastAccessTime();
            ViewBag.ScopedLogs = _loggerService.GetLogs();
            ViewBag.TransientId1 = _timeService1.GetInstanceId();
            ViewBag.TransientId2 = _timeService2.GetInstanceId();

            return View();
        }
    }
}
