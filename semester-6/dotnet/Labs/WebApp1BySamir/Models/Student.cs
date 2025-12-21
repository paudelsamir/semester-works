using System.ComponentModel.DataAnnotations;

namespace WebApp1BySamir.Models
{
    public class Student
    {
        [Required(ErrorMessage = "Student ID is required")]
        [Display(Name = "Student ID")]
        [Range(1, 9999, ErrorMessage = "Student ID must be between 1 and 9999")]
        public int StdID { get; set; }

        [Required(ErrorMessage = "Name is required")]
        [StringLength(100, MinimumLength = 2, ErrorMessage = "Name must be between 2 and 100 characters")]
        [Display(Name = "Full Name")]
        public string Name { get; set; } = string.Empty;

        [Required(ErrorMessage = "Address is required")]
        [StringLength(200, ErrorMessage = "Address cannot exceed 200 characters")]
        public string Address { get; set; } = string.Empty;

        [Required(ErrorMessage = "Faculty is required")]
        [Display(Name = "Faculty")]
        public string Faculty { get; set; } = string.Empty;

        [Required(ErrorMessage = "Email is required")]
        [EmailAddress(ErrorMessage = "Invalid email address")]
        [Display(Name = "Email Address")]
        public string Email { get; set; } = string.Empty;

        [Phone(ErrorMessage = "Invalid phone number")]
        [Display(Name = "Phone Number")]
        public string? Phone { get; set; }

        [Range(16, 100, ErrorMessage = "Age must be between 16 and 100")]
        public int? Age { get; set; }
    }
}
