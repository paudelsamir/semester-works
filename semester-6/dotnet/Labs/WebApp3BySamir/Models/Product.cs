using System.ComponentModel.DataAnnotations;

namespace WebApp3BySamir.Models
{
    public class Product
    {
        public int ProductID { get; set; }

        [Required(ErrorMessage = "Product name is required")]
        [StringLength(100, MinimumLength = 2)]
        public string ProductName { get; set; } = string.Empty;

        [Required]
        [Range(0.01, 999999.99)]
        public decimal Price { get; set; }

        [Required]
        [Range(0, 100000)]
        public int Quantity { get; set; }

        [StringLength(50)]
        public string Category { get; set; } = string.Empty;

        public DateTime CreatedDate { get; set; }
    }
}
