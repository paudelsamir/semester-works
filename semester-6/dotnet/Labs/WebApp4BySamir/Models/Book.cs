using System.ComponentModel.DataAnnotations;

namespace WebApp4BySamir.Models
{
    public class Book
    {
        [Key]
        public int BookId { get; set; }

        [Required(ErrorMessage = "Title is required")]
        [StringLength(200, MinimumLength = 1)]
        public string Title { get; set; } = string.Empty;

        [Required(ErrorMessage = "Author is required")]
        [StringLength(100, MinimumLength = 2)]
        public string Author { get; set; } = string.Empty;

        [Required]
        [StringLength(13)]
        [RegularExpression(@"^[\d-]+$", ErrorMessage = "Invalid ISBN format")]
        public string ISBN { get; set; } = string.Empty;

        [Range(1, 10000, ErrorMessage = "Price must be between 1 and 10000")]
        public decimal Price { get; set; }

        [StringLength(50)]
        public string? Genre { get; set; }

        public DateTime PublishedDate { get; set; }

        public DateTime CreatedAt { get; set; } = DateTime.Now;
    }
}
