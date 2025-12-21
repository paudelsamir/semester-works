namespace WebApp2BySamir.Services
{
    // Interface for greeting service
    public interface IGreetingService
    {
        string GetGreeting(string name);
        string GetTimeBasedGreeting();
    }

    // Implementation of greeting service
    public class GreetingService : IGreetingService
    {
        public string GetGreeting(string name)
        {
            return $"Hello, {name}! Welcome to Dependency Injection Demo.";
        }

        public string GetTimeBasedGreeting()
        {
            var hour = DateTime.Now.Hour;
            if (hour < 12)
                return "Good Morning!";
            else if (hour < 18)
                return "Good Afternoon!";
            else
                return "Good Evening!";
        }
    }
}
