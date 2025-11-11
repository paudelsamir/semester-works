using System.ComponentModel.DataAnnotations;

namespace MoodBoard.Models;

public class Mood
{
    public int Id { get; set; }

    [Required]
    [StringLength(100)]
    public string Feeling { get; set; } = string.Empty;

    [Required]
    [StringLength(1000)]
    public string Quote { get; set; } = string.Empty;

    public DateTime CreatedAt { get; set; } = DateTime.UtcNow;
}