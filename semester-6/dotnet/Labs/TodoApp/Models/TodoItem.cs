using System.ComponentModel.DataAnnotations;

namespace TodoApp.Models
{
    public class TodoItem
    {
        [Key]
        public int Id { get; set; }

        [Required(ErrorMessage = "Title is required")]
        [StringLength(200, ErrorMessage = "Title cannot be longer than 200 characters")]
        public string Title { get; set; } = string.Empty;

        [StringLength(1000, ErrorMessage = "Description cannot be longer than 1000 characters")]
        public string Description { get; set; } = string.Empty;

        [Required(ErrorMessage = "IsCompleted is required")]
        public bool IsCompleted { get; set; } = false;

        [Required]
        public DateTime CreatedDate { get; set; } = DateTime.UtcNow;

        public DateTime? CompletedDate { get; set; }
    }
}
