using System.ComponentModel.DataAnnotations;

namespace WebApiBySamir.Models
{
    public class Task
    {
        [Key]
        public int TaskId { get; set; }

        [Required]
        [StringLength(200)]
        public string Title { get; set; } = string.Empty;

        [StringLength(1000)]
        public string? Description { get; set; }

        public bool IsCompleted { get; set; } = false;

        [Required]
        public string Priority { get; set; } = "Medium"; // Low, Medium, High

        public DateTime CreatedDate { get; set; } = DateTime.Now;

        public DateTime? DueDate { get; set; }
    }
}
