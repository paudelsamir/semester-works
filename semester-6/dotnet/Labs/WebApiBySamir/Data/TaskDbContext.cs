using Microsoft.EntityFrameworkCore;
using WebApiBySamir.Models;

namespace WebApiBySamir.Data
{
    public class TaskDbContext : DbContext
    {
        public TaskDbContext(DbContextOptions<TaskDbContext> options) : base(options) { }

        public DbSet<Models.Task> Tasks { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            modelBuilder.Entity<Models.Task>().HasData(
                new Models.Task
                {
                    TaskId = 1,
                    Title = "Complete Lab 24",
                    Description = "Create Web API with Swagger",
                    Priority = "High",
                    IsCompleted = false,
                    CreatedDate = DateTime.Now
                },
                new Models.Task
                {
                    TaskId = 2,
                    Title = "Study EF Core",
                    Description = "Learn Entity Framework Core basics",
                    Priority = "Medium",
                    IsCompleted = true,
                    CreatedDate = DateTime.Now
                }
            );
        }
    }
}
