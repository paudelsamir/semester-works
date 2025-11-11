using System.ComponentModel.DataAnnotations;

namespace webAppDemo.Models;

public class PersonModel
{
    [Required(ErrorMessage = "Name is required")]
    [StringLength(100, ErrorMessage = "Name cannot be longer than 100 characters")]
    public string Name { get; set; } = string.Empty;

    [Required(ErrorMessage = "Age is required")]
    [Range(0, 150, ErrorMessage = "Age must be between 0 and 150")]
    public int Age { get; set; }

    [Required(ErrorMessage = "Email is required")]
    [EmailAddress(ErrorMessage = "Invalid email address")]
    public string Email { get; set; } = string.Empty;

    [Required(ErrorMessage = "Github profile is required")]
    [Url(ErrorMessage = "Invalid URL format")]
    public string Github { get; set; } = string.Empty;
}