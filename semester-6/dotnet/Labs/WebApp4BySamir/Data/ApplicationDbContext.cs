using Microsoft.EntityFrameworkCore;
using WebApp4BySamir.Models;

namespace WebApp4BySamir.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        public DbSet<Book> Books { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Configure Book entity
            modelBuilder.Entity<Book>(entity =>
            {
                entity.HasKey(e => e.BookId);
                entity.Property(e => e.Price).HasColumnType("decimal(18,2)");
                entity.Property(e => e.Title).IsRequired().HasMaxLength(200);
                entity.Property(e => e.Author).IsRequired().HasMaxLength(100);
                entity.Property(e => e.ISBN).IsRequired().HasMaxLength(13);
            });

            // Seed initial data
            modelBuilder.Entity<Book>().HasData(
                new Book
                {
                    BookId = 1,
                    Title = "C# Programming Guide",
                    Author = "Samir Paudel",
                    ISBN = "978-0-123456",
                    Price = 499.99m,
                    Genre = "Programming",
                    PublishedDate = new DateTime(2024, 1, 1),
                    CreatedAt = DateTime.Now
                },
                new Book
                {
                    BookId = 2,
                    Title = "ASP.NET Core in Action",
                    Author = "Andrew Lock",
                    ISBN = "978-1-617294",
                    Price = 799.50m,
                    Genre = "Web Development",
                    PublishedDate = new DateTime(2023, 6, 15),
                    CreatedAt = DateTime.Now
                }
            );
        }
    }
}
