namespace WebApp2BySamir.Services
{
    // Interface for logger service
    public interface ILoggerService
    {
        void LogInfo(string message);
        List<string> GetLogs();
    }

    // Scoped service - new instance per request
    public class LoggerService : ILoggerService
    {
        private readonly List<string> _logs;
        private readonly Guid _instanceId;

        public LoggerService()
        {
            _logs = new List<string>();
            _instanceId = Guid.NewGuid();
            LogInfo("LoggerService instance created");
        }

        public void LogInfo(string message)
        {
            var logEntry = $"[{DateTime.Now:HH:mm:ss}] [{_instanceId.ToString().Substring(0, 8)}] {message}";
            _logs.Add(logEntry);
        }

        public List<string> GetLogs()
        {
            return _logs;
        }

        public Guid GetInstanceId()
        {
            return _instanceId;
        }
    }
}
