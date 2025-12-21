namespace WebApp2BySamir.Services
{
    // Interface for data service
    public interface IDataService
    {
        List<string> GetStudents();
        int GetStudentCount();
        string GetLastAccessTime();
    }

    // Singleton service - single instance throughout app lifetime
    public class DataService : IDataService
    {
        private readonly List<string> _students;
        private readonly DateTime _createdTime;

        public DataService()
        {
            _students = new List<string>
            {
                "Samir Paudel",
                "Ram Sharma",
                "Sita Devi",
                "Hari Prasad",
                "Gita Karki"
            };
            _createdTime = DateTime.Now;
        }

        public List<string> GetStudents()
        {
            return _students;
        }

        public int GetStudentCount()
        {
            return _students.Count;
        }

        public string GetLastAccessTime()
        {
            return $"Service created at: {_createdTime:hh:mm:ss tt}";
        }
    }
}
