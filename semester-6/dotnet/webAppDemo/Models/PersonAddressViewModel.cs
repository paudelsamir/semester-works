namespace webAppDemo.Models
{
    public class PersonAddressViewModel
    {
        public PersonModel Person { get; set; } = new();
        public AddressViewModel Address { get; set; } = new();
    }
}