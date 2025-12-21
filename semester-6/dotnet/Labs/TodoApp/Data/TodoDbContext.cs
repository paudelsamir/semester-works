using Microsoft.EntityFrameworkCore;
using TodoApp.Models;

namespace TodoApp.Data
{
    public class TodoDbContext : DbContext
    {
        public TodoDbContext(DbContextOptions<TodoDbContext> options) : base(options)
        {
        }

        public DbSet<TodoItem> TodoItems { get; set; } = null!;

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Configure TodoItem table
            modelBuilder.Entity<TodoItem>()
                .HasKey(t => t.Id);

            modelBuilder.Entity<TodoItem>()
                .Property(t => t.Title)
                .IsRequired()
                .HasMaxLength(200);

            modelBuilder.Entity<TodoItem>()
                .Property(t => t.Description)
                .HasMaxLength(1000);

            modelBuilder.Entity<TodoItem>()
                .Property(t => t.CreatedDate)
                .HasDefaultValueSql("CURRENT_TIMESTAMP");

            // Seed initial data
            modelBuilder.Entity<TodoItem>().HasData(
                new TodoItem 
                { 
                    Id = 1, 
                    Title = "Learn Entity Framework Core",
                    Description = "Master EF Core for database operations",
                    IsCompleted = false,
                    CreatedDate = DateTime.UtcNow
                },
                new TodoItem 
                { 
                    Id = 2, 
                    Title = "Build REST API",
                    Description = "Create a complete REST API with CRUD operations",
                    IsCompleted = false,
                    CreatedDate = DateTime.UtcNow
                },
                new TodoItem 
                { 
                    Id = 3, 
                    Title = "Test with Swagger",
                    Description = "Test all endpoints using Swagger UI",
                    IsCompleted = false,
                    CreatedDate = DateTime.UtcNow
                }
            );
        }
    }
}
