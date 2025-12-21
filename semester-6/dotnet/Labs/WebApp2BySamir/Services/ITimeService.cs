namespace WebApp2BySamir.Services
{
    // Interface for time service
    public interface ITimeService
    {
        string GetCurrentTime();
        string GetCurrentDate();
        Guid GetInstanceId();
    }

    // Transient service - new instance every time
    public class TimeService : ITimeService
    {
        private readonly Guid _instanceId;

        public TimeService()
        {
            _instanceId = Guid.NewGuid();
        }

        public string GetCurrentTime()
        {
            return DateTime.Now.ToString("hh:mm:ss tt");
        }

        public string GetCurrentDate()
        {
            return DateTime.Now.ToString("dddd, MMMM dd, yyyy");
        }

        public Guid GetInstanceId()
        {
            return _instanceId;
        }
    }
}
