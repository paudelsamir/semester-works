# .NET Centric Computing - Cheat Sheet (generated with claude)
---

## **Unit 1: Language Preliminaries**

### 1. Constructors - Special methods that initialize objects when created

```csharp
// Default Constructor
public class Vehicle {
    public Vehicle() { // no params
        Console.WriteLine("Vehicle created");
    }
}

// Parameterized Constructor
public class Person {
    private string name;
    private int age;
    
    public Person(string name, int age) { // with params
        this.name = name;
        this.age = age;
    }
}
```

### 2. Properties

```csharp
// read (get) and write (set) values of private field
public class Person {
    private string name;
    
    // Full Property
    public string Name {
        get { return name; }
        set { name = value; }
    }
    
    // Auto-Property
    public int Age { get; set; }
}
```

### 3. Arrays & Strings

```csharp
int[] array = new int[] {5, 6, 7, 8, 9};
int[] array2 = new int[5];  // can be multidimensional as well

Console.WriteLine("Length: " + array.Length); //5
Array.Sort(array);
Array.Reverse(array);
Array.Copy(array, array2, array.Length); ....


string name = "sam"
name.Length(); //3
name.ToUpper();
name.ToLower(); ....

```

### 4. Indexers

```csharp
// allows accessing object elements using bracket notation like an array
public class MyCollection {
    private string[] data = new string[3];
    
    // Indexer - similar as property but with index
    public string this[int index] {
        get { return data[index]; }
        set { data[index] = value; }
    }
}

// Usage
MyCollection col = new MyCollection();
col[0] = "Hello";
Console.WriteLine(col[0]);  //hello
```

### 5. Inheritance & Base Keyword

```csharp
public class Animal {
    public void Eat() {
        Console.WriteLine("Animal Eats");
    }
}

public class Dog : Animal {  //inheritance: Dog d= new Dog(); d.Eat() // animal eats 
    public void Eat() {
        base.Eat(); // Call parent method
        Console.WriteLine("Dog eats");
    }
}
```

### 6. Method Overriding (runtime polymorphism)

```csharp
public class Animal {
    public virtual void MakeSound() { // virtual and override keywrod necessary
        Console.WriteLine("Animal sound");
    }
}

public class Dog : Animal {
    public override void MakeSound() {
        Console.WriteLine("Dog barks");  // prints Dog Barks
    }
}
```

### 7. Polymorphism

```csharp
Animal animal = new Dog();
animal.MakeSound(); // Calls Dog's MakeSound
```

> **Note:** Runtime polymorphism achieved through method overriding with virtual/override keywords.

> Also there's compiletime polymorphism (overloading) where compiler decide which method to use, like Add (inta, intb) and Add (double a, double b) and also there's method hiding (child class define method with the same name as parent class but no override, it hides the parent method using new keyword indicating hiding)


### 8. Structs (stored in stack rather than heap like class)

```csharp
public struct Point {
    public int X;
    public int Y;
}

Point p1;
p1.X = 10;
p1.Y = 20;
```

> **Tip:** Structs are value types, classes are reference types.

### 9. Enums - give names to numeric constants

```csharp
public enum DaysOfWeek {
    Sunday, Monday, Tuesday,
    Wednesday, Thursday, Friday, Saturday
}

DaysOfWeek today = DaysOfWeek.Monday;
```

### 10. Abstract Class

```csharp
// you cannot create an object of it, only use it make other classes
public abstract class Animal {
    public abstract void MakeSound();
    
    public void Sleep() {
        Console.WriteLine("Sleeping...");
    }
}

public class Dog : Animal {
    public override void MakeSound() {
        Console.WriteLine("Bark!");
    }
}

// you can't do this: Animal a = New Animal()
// but you can do this: Animal a = New Dog()
```

### 11. Sealed Class

```csharp

// you can create an object but no inheritance allowed
public sealed class FinalClass {
    // Cannot be inherited
}

// This will cause error:
// public class Derived : FinalClass { }
```

### 12. Interfaces

```csharp

// like contract. any class that sign the contract must follow the rule
public interface IWalk {
    void Walk();
}

public interface ISwim {
    void Swim();
}

// Multiple Interface Implementation
public class Human : IWalk, ISwim { // must contain both rules
    public void Walk() {
        Console.WriteLine("Walking");
    }
    
    public void Swim() {
        Console.WriteLine("Swimming");
    }
}
```

### 13. Delegates

```csharp
// instead of call the method direclty, you call delegate to call that method
// Declaration
public delegate void SimpleDelegate();

// Usage
class Program {
    static void Main() {
        SimpleDelegate d = new SimpleDelegate(MyFunc); // SimpleDelegate call MyFunc
        d(); // Invocation
    }
    
    static void MyFunc() {
        Console.WriteLine("Called by delegate");
    }
}


// Action: for method with no return
// Function: with return values
// Predicate: for method returning bool


// Multicasting: euta delegate object le multiple function call garna sakyo in a sequence. with obj+= function()
```

### 14. Events

```csharp
// Event: notify when something happens
public class Button {
    public event EventHandler Click;
    
    public void Press() {
        Click?.Invoke(this, EventArgs.Empty);
    }
}

// Usage
Button btn = new Button();
btn.Click += (s, e) => Console.WriteLine("Button clicked!");
btn.Press(); // Output: Button clicked!
```


### 15. Partial Classes

```csharp

// split class into multiple files, compiler compiles them at compiletime

// File1.cs
public partial class Animal {
    public void Method1() { }
}

// File2.cs
public partial class Animal {
    public void Method2() { }
}
```

### 16. Collections:Non generic and Generics

```csharp

// class that hold multiple items unline array and can grow/shirnk at runtime
// non generic - no type check (list.add(10) list.add(sam))
// generic - type-safe (list <T> T is type of value)


using System.Collections.Generic;
// types - important
// List
List<string> names = new List<string>();
names.Add("John");

// Dictionary
Dictionary<string, int> ages = new Dictionary<string, int>();
ages.Add("John", 25);

// Iteration
foreach (var name in names) {
    Console.WriteLine(name);
}
```

### 17. LINQ & Lambda Expressions

```csharp
// LINQ - Language integrated query
// provide a way to query and manipulate data from different sources like collections, xml, dbs 
// sql like syntaxes, where, select, sort, project, group, aggregate

List<int> numbers = new List<int> {1, 2, 3, 4, 5};

// Lambda Expression
var evenNums = numbers.Where(n => n % 2 == 0);  // After where is lambda expression

// LINQ Query Syntax
var result = from n in numbers
             where n > 2
             select n;

foreach (var num in evenNums) {
    Console.WriteLine(num);
}

// Architecture of LINQ: Top layer: language extension like c# vbnet , Middle layer - Linq providers like linq to boject, inq to xml, linq to dataset, sql, entities, Bottom layer - actual data collection like rellational, xml, objects

// Linq to XML: System.XML.Linq, make it easy to query without learning compllex xml queries like xpath and xquery
// key classes: XDocument(.parse to load, .element for add, .descendents for delete), XElement, XAttribute, XNode, XNamespace, XText, XObject
```

### 18. Exception Handling

```csharp
// use try, catch, finally for exceptions
try {
    int result = 10 / 0;
}
catch (DivideByZeroException ex) { // some standards exceptions are: dividebyzero, nullreference, indexoutofrange, filenotfound, arithmetic,.... userdefined exceptions as well
    Console.WriteLine("Cannot divide by zero");
}
catch (Exception ex) { // handlle exception
    Console.WriteLine($"Error: {ex.Message}"); // cannot divide by zero is output
}
finally {
    Console.WriteLine("Cleanup code");
}


// Uncaught exception : if any exception occur and there's no catch block program crahses and print type of exception and location & callstack.

// you can catch different exceptions separately using mutlipel catch block 
// or you cna even catch all exception when you don't know what type of error might occur


```

### 19. Async/Await Programming

```csharp
// System.Threading.Task
// Task : single unit of work
// Thread: basic unit of cpu utilization resposible for doing a task
// Use await after async


public static async Task Main() { // no return
    Console.WriteLine("Start");
    await DoSomethingAsync();
    Console.WriteLine("End");
}

public static async Task <int> Calculate(){ // with return
    await Task.Delay(1000)
    return 54;
}

```

> **Important:** Use async/await for I/O operations, network calls, and database queries.

NOTES:
> File I/O operations: System.IO.namespace: handlling file with some I/O classes:
> Binaryreader, Binarywritier, Bufferedstream, directory, directoryinfor, driveinfo, file, fileinfo, filestream, path, streamreader, streamwriter etc

- Filestream: reading/writing bytes {Filemode: create, open, append} {fileaccess: read, write} {fileshare: read, write}
- StreamReader: read text from file {close, peek, read, readline, seek}
- StreamWriter: write text to file {close, flush, writeline}
- BinaryReader : read binary file {readchar, readint32}
- Binarywriter: write to binary file{ write(byte[])}

### 20. Attributes

```csharp

// metadata tags used to add extra information

[Obsolete("Use NewMethod instead")] // mark somehting as old and discouraged
public void OldMethod() { }

[Serializable] // basiooc- tell compiler that class can be serialized
public class MyClass { }

// Custom Attribute
[AttributeUsage(AttributeTargets.Class)]
public class AuthorAttribute : Attribute { // inherited from System.Attribute
    public string Name { get; set; }
}

// Conditional: like DEBUG (runs or ignore method based on compiler symbol)
```

---

## **Unit 2: Introduction to ASP.NET**

### .NET Framework Comparison

| Framework | Description |
|-----------|-------------|
| **.NET Framework** | legacy framework by Microsoft to build and run app on windows only|
| **.NET Core** | Cross-platform version of dotnet, support CLI commands, modern, lightweight |
| **Mono** | Open-source implementation for non windows platforms, use MCS to compile c# and mono to run |
| **ASP.NET** | Framework for building webapp and web api on top of .net, types: below|
| **ASP.NET Web Forms** | Event-driven, legacy, .aspx extension, good for rapid form based apps |
| **ASP.NET MVC** | Model-View-Controller pattern, better test, maintainability |
| **ASP.NET Web API** | RESTful (backend) services, no UI |
| **ASP.NET Core** | Unified(mvc + webapi), cross-platform framework |

> .NET Architecture Framework: languages -> common language specification (rules and guidelines -> applications like webservices webforms, win forms -> Data and XML classes like ADO.net -> Framework class library vanya readymade code colelctions -> Common language runtime (CLR) it executes, manages memory, garbage colelction, and convert intermediate lang into machine code)
### Compilation & Execution

```
Process:
1. C# Code → Compiler → MSIL (Microsoft Intermediate Language)
2. MSIL → CLR (Common Language Runtime) → Native Code
3. CLI: Common Language Infrastructure specification
4. CLR: Execution engine (.NET runtime)
```

### .NET CLI Commands

```bash
# Create new project
dotnet new webapp -n MyApp

# Build project
dotnet build

# Run application
dotnet run

# Test application
dotnet test

# Publish for deployment
dotnet publish -c Release
```

---

## **Unit 3: HTTP & ASP.NET Core**

### HTTP Request/Response

```
HTTP Request Format:
GET /api/products HTTP/1.1
Host: example.com
Content-Type: application/json
Authorization: Bearer token123

HTTP Response Format:
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 256

{ "id": 1, "name": "Product" }
```

### MVC Pattern

- **Model:** Data and business logic
- **View:** UI presentation layer
- **Controller:** Handles requests, coordinates Model & View

**Flow:** User → Controller → Model → Controller → View → User

### how ASP.net core process a request

- **Kestrel:** Cross-platform web server
- **Middleware Pipeline:** Request/response processing
- **Dependency Injection:** Built-in IoC container
    - **Configuration:** appsettings.json
    - **Logging:** Built-in logging providers
    - **app** 

user cllick a link or api call -> request forwared to kestrel via reverse proxy (NGINX/Apache) -> request passes through middleware pipeline (routing, auth, logging) which controller handles which request-> response goes back to web server -> kestrel forward to reverse proxy -> http response send to browser   

### Common Web Application Architectures

**1. Monolithic Architecture**
- Single unified application with all components together
- UI, business logic, and data access in one codebase
- Simple to develop and deploy but hard to scale and maintain

**2. Layered Architecture (3-Tier)**
```
┌─────────────────────┐
│   Presentation (UI) │  - Views, Controllers
├─────────────────────┤
│ Business Logic (BLL)│  - Services, Business Rules
├─────────────────────┤
│   Data Access (DAL) │  - EF Core, Repositories
└─────────────────────┘
```

**3. Onion Architecture (Clean Architecture)**
```
    ┌───────────────────┐
    │    UI Layer       │
    └─────────┬─────────┘
          │
    ┌─────────▼─────────┐
    │  Infrastructure   │  - EF Core, External APIs
    └─────────┬─────────┘
          │
    ┌─────────▼─────────┐
    │  Application Core │  - Interfaces, Entities, Services
    └───────────────────┘
```
- Domain entities at center (no dependencies)
- Business rules independent of external concerns
- Dependencies point inward

**4. ASP.NET Core Multi-Project Architecture**

```
┌──────────────────────────────────────┐
│      ASP.NET Core Web App (MVC)      │
│  - Controllers, Views, Filters       │
│  - Identity (Authentication)         │
│  - Program.cs, Startup               │
└──────────────┬───────────────────────┘
           │
           ├──────────────────────────────┐
           │                              │
    ┌──────────▼─────────────┐    ┌──────────▼────────────┐
    │  Infrastructure Layer  │    │ Application Core      │
    │  - EF Core DbContext   │    │ - Interfaces          │
    │  - Redis Cache         │    │ - Domain Models       │
    │  - InMemory Data       │    │ - Business Services   │
    │  - 3rd Party Services  │    │ - Domain Events       │
    │    (Email, SMS)        │    │ - Custom Exceptions   │
    └────────────────────────┘    └───────────────────────┘
           │
    ┌──────────▼─────────────┐
    │     Data Sources       │
    │  - SQL Server          │
    │  - MongoDB             │
    │  - File System         │
    └────────────────────────┘
           │
    ┌──────────▼─────────────┐
    │  Third-Party APIs      │
    │  - GitHub API          │
    │  - Twilio (SMS)        │
    │  - Payment Gateway     │
    └────────────────────────┘
```

- Separation of concerns
- Testable and maintainable
- Easy to swap implementations
- Independent deployment of layers


### Project Conventions

- **Program.cs:** Application entry point
- **Startup.cs:** Configure services & middleware
- **Controllers/:** Controller classes
- **Views/:** Razor view files
- **Models/:** Data models
- **wwwroot/:** Static files (CSS, JS, images)
- **Dependencies nodes**: contains all installed NUGet packages

---

## **Unit 4: Creating ASP.NET Core MVC Applications**

### 1. Controllers & Actions

```csharp

// controller: handle request, build model, send response 
// MVC controller return views, API controller return JSON

// action: every public method in controller
// Action verbs: HttpGet, HttpPost, HttpRoute
// Action return type: view, json, content, file, staticcode, redirect

public class HomeController : Controller {
    // Action returning View
    public IActionResult Index() {
        return View();
    }
    
    // Action returning JSON
    public IActionResult GetData() {
        var data = new { Name = "John", Age = 25 };
        return Json(data);
    }
    
    // Action with parameters
    public IActionResult Details(int id) {
        return View();
    }
}
// startup.cs
app.MapControlllerRoute{
    name = default
    pattern = {controller = Home}/{action = /{id}}. WithStaticAssetsIndex}
}

```

**Action Results:** ViewResult, JsonResult, RedirectResult, ContentResult, FileResult, StatusCodeResult

### 2. Razor Views & Syntax
razor starts with @ to switch from csthml to cs.

```html
@* Razor View Example *@
@model MyApp.Models.Product

<h1>@Model.Name</h1>
<p>Price: @Model.Price</p>

@* Code blocks *@
@{
    var total = Model.Price * Model.Quantity;
}

@* Loops *@
@foreach (var item in Model.Items) {
    <li>@item.Name</li>
}

@* Conditionals *@
@if (Model.IsActive) {
    <span>Active</span>
}

// passing data to views
// 1. viewdata: dictobject (viewdata[key])
// 2. viewbag: dynamicobject (viebag.key)
// 3. viewmodel: strongly typed (pass class or object both)


// partial views/shared views: mini reusable components stroed in views/shared
```

### 3. Tag Helpers

```html
// enable server side code to generate and manipulate html elements in razor views.
<!-- Form Tag Helper -->
<form asp-controller="Home" asp-action="Submit"> // in html helper there used label-for instead of asp-for
    <input asp-for="Name" />
    <span asp-validation-for="Name"></span>
    <button type="submit">Submit</button>
</form>

<!-- Anchor Tag Helper -->
<a asp-controller="Product" asp-action="Details" 
   asp-route-id="5">View Product</a>

<!-- Others are: <form>, <input>, <link>, <select>, <partial>, <input> etc... validation-for, validation-summary -->
```

### 4. Model Binding & Validation
- what's model? the state of the application eg: userinfo, products
- what's view model? representing extra data not covered by model like combine addressviewmodel and personmodel both in a viewmodel.

- what's model binding? auto map http request data from from ... to method params.
```csharp
// Model with Data Annotations (metadata attributes used to descrirbe validatio, format data etc)

using system.componentmodel.dataannotations
public class Product {
    [Required(ErrorMessage = "Name is required")]  // validation 
    [StringLength(100)]
    public string Name { get; set; }
    
    [Range(0.01, 999999)]
    public decimal Price { get; set; }
    
    [EmailAddress]
    public string Email { get; set; }
}
// Display label name in UI

    [Display (Name: "FULL NAME")]
    public string Name {get; set;}

// Action with Model Binding
[HttpPost]
public IActionResult Create(Product product) {
    if (ModelState.IsValid) {
        // Save to database
        return RedirectToAction("Index");
    }
    return View(product);
}

// other common validation annotations are [stringlenght] [range] [compare] [email address] etc'
```

### 5. URL Routing
- mechanism that connects icoming urls to appropriate controller actions and also generate outgoing url.

```csharp
// 1.Attribute Routing
[Route("")]
public class HomeController : Controller {
    [Route("/")]
    public IActionResult Index() => View();
    
    [Route("about")]
    public IActionResult About() => View();
}

//2. Convention based Routing: Configure default route in Program.cs
app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");


```

### 6. Dependency (services) Injection
- every classes in your app often need other classes to do its job eg: homecontroller wants to log msg. logger is dependency


```csharp
// Service Interface
public interface IProductService {
    List<Product> GetAll();
}

public class ProductService : IProductService {
    public List<Product> GetAll() {
        return new List<Product>();
    }
}

// Register in Program.cs
builder.Services.AddScoped<IProductService, ProductService>();

// Use in Controller
public class ProductController : Controller {
    private readonly IProductService _service;
    
    public ProductController(IProductService service) {
        _service = service;
    }
}
```

**DI Lifetimes:**
- **Transient:** New instance each time
- **Scoped:** Once per request
- **Singleton:** Once per application

### 7. Web API Controllers
- they expose data model through rest endpoints, no need for razor or html views
- api controllers deal with resource and status codes

```csharp
[ApiController]
[Route("api/[controller]")]
public class ProductApiController : ControllerBase {
    [HttpGet]
    public ActionResult<List<Product>> GetAll() {
        return Ok(new List<Product>());
    }
    
    [HttpGet("{id}")]
    public ActionResult<Product> GetById(int id) {
        return Ok(new Product());
    }
    
    [HttpPost]
    public ActionResult<Product> Create(Product product) {
        return CreatedAtAction("GetById", new { id = 1 }, product);
    }
}
```

---

## **Unit 5: Working with Database**

### 1. ADO.NET Basics
- bridge betn app and dbs, old but fundamental way to connect app with db which provides classes like sqlconnection, sqlcommand etc.
- important connectiong and retrieving data::
```csharp
using System.Data;
using System.Data.SqlClient;

// Connection
string connectionString = "Server=.;Database=MyDb;Trusted_Connection=true;";
SqlConnection conn = new SqlConnection(connectionString);

// Command
SqlCommand cmd = new SqlCommand("SELECT * FROM Products", conn);

// Reader
conn.Open();
SqlDataReader reader = cmd.ExecuteReader();
while (reader.Read()) {
    var id = reader["Id"];
    var name = reader["Name"];
}
conn.Close();
```

### 2. Entity Framework Core Setup

```csharp
// DbContext
public class ApplicationDbContext : DbContext {
    public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options) 
        : base(options) { }
    
    public DbSet<Product> Products { get; set; }
    public DbSet<Category> Categories { get; set; }
}

// Configure in Program.cs
builder.Services.AddDbContext<ApplicationDbContext>(options =>
    options.UseSqlServer(builder.Configuration
        .GetConnectionString("DefaultConnection")));
```

### 3. Data Models & Relationships

```csharp
public class Product {
    [Key]
    public int Id { get; set; }
    
    [Required]
    public string Name { get; set; }
    
    public decimal Price { get; set; }
    
    [ForeignKey("Category")]
    public int CategoryId { get; set; }
    
    public Category Category { get; set; }
}

public class Category {
    public int Id { get; set; }
    public string Name { get; set; }
    
    // Navigation property
    public ICollection<Product> Products { get; set; }
}
```

### 4. CRUD Operations with EF Core

```csharp
// Create
var product = new Product { Name = "Laptop", Price = 50000 };
_context.Products.Add(product);
await _context.SaveChangesAsync();

// Read
var products = await _context.Products.ToListAsync();
var singleProduct = await _context.Products.FindAsync(id);

// Update
product.Name = "Desktop";
_context.Products.Update(product);
await _context.SaveChangesAsync();

// Delete
_context.Products.Remove(product);
await _context.SaveChangesAsync();
```

### 5. Migrations

```bash
# Create migration
dotnet ef migrations add InitialCreate

# Apply migration
dotnet ef database update

# Remove migration
dotnet ef migrations remove

# Update to specific migration
dotnet ef database update 20231207100000
```

---

## **Unit 6: State Management**

### 1. Session State (Server-side)

```csharp
// Configure in Program.cs
builder.Services.AddSession();
app.UseSession();

// Store data
HttpContext.Session.SetString("Username", "John");
HttpContext.Session.SetInt32("UserId", 123);

// Retrieve data
var username = HttpContext.Session.GetString("Username");
var userId = HttpContext.Session.GetInt32("UserId");
```

### 2. TempData

```csharp
// Store temporary data
TempData["Message"] = "Operation successful";
return RedirectToAction("Index");

// Retrieve in next action
var message = TempData["Message"];

// In View with Razor
@TempData["Message"]
```

### 3. Cookies (Client-side)

```csharp
// Set cookie
Response.Cookies.Append("UserPreference", "Dark", 
    new CookieOptions { Expires = DateTimeOffset.UtcNow.AddDays(7) });

// Read cookie
Request.Cookies.TryGetValue("UserPreference", out var preference);

// Delete cookie
Response.Cookies.Delete("UserPreference");
```

### 4. Caching

```csharp
// Configure in Program.cs
builder.Services.AddMemoryCache();

// Use cache
public class ProductController : Controller {
    private readonly IMemoryCache _cache;
    
    public ProductController(IMemoryCache cache) {
        _cache = cache;
    }
    
    public async Task<IActionResult> Index() {
        if (!_cache.TryGetValue("products", out var products)) {
            products = await _context.Products.ToListAsync();
            _cache.Set("products", products, 
                new MemoryCacheEntryOptions().SetAbsoluteExpiration(
                    TimeSpan.FromMinutes(10)));
        }
        return View(products);
    }
}
```

---

## **Unit 7: Client-side Development**

### 1. jQuery Basics

```javascript
// Selectors
$(".class-name").hide();
$("#id-name").show();
$("p").css("color", "red");

// Event Handling
$(".btn").click(function() {
    alert("Button clicked!");
});

// AJAX Request
$.ajax({
    type: "GET",
    url: "/api/products",
    dataType: "json",
    success: function(data) {
        console.log(data);
    }
});
```

### 2. Form Validation

```html
@model MyApp.Models.Product

<form asp-action="Create">
    <div>
        <label asp-for="Name"></label>
        <input asp-for="Name" required />
        <span asp-validation-for="Name"></span>
    </div>
    <button type="submit">Submit</button>
</form>

<!-- Include jQuery validation -->
<script src="~/lib/jquery-validation/jquery.validate.js"></script>
<script src="~/lib/jquery-validation-unobtrusive/jquery.validate.unobtrusive.js"></script>
```

### 3. Single Page Applications (SPA)

| Framework | Description |
|-----------|-------------|
| **Angular** | Full-featured framework by Google, TypeScript-based |
| **React** | Component-based library by Facebook, JSX syntax |
| **Vue.js** | Progressive framework, easy learning curve |

**Advantages:** Better UX, faster interactions, offline support  
**Disadvantages:** Higher complexity, SEO challenges, larger bundle size

### 4. Angular Basics

```typescript
// Component
@Component({
  selector: 'app-product',
  template: `<h1>{{title}}</h1>`,
  styleUrls: ['./product.component.css']
})
export class ProductComponent {
  title = 'Product List';
}

// Service
@Injectable()
export class ProductService {
  constructor(private http: HttpClient) { }
  
  getProducts() {
    return this.http.get('/api/products');
  }
}
```

### 5. React Basics

```javascript
// Functional Component
function ProductList() {
  const [products, setProducts] = React.useState([]);
  
  React.useEffect(() => {
    fetch('/api/products')
      .then(res => res.json())
      .then(data => setProducts(data));
  }, []);
  
  return (
    <div>
      {products.map(p => <div key={p.id}>{p.name}</div>)}
    </div>
  );
}
```

---

## **Unit 8: Securing ASP.NET Core Applications**

### 1. ASP.NET Core Identity

```csharp
// Configure Identity in Program.cs
builder.Services.AddDefaultIdentity<IdentityUser>(options => 
    options.SignIn.RequireConfirmedAccount = true)
    .AddEntityFrameworkStores<ApplicationDbContext>();

// Sign up user
var user = new IdentityUser { UserName = "john@example.com", Email = "john@example.com" };
var result = await _userManager.CreateAsync(user, "Password@123");

// Sign in user
await _signInManager.SignInAsync(user, isPersistent: false);
```

### 2. Authorization - Roles & Claims

```csharp
// Add role to user
await _userManager.AddToRoleAsync(user, "Admin");

// Authorize by role
[Authorize(Roles = "Admin")]
public IActionResult AdminPanel() {
    return View();
}

// Add claims
var claims = new List<Claim> {
    new Claim("Department", "IT"),
    new Claim("Level", "Senior")
};
await _userManager.AddClaimsAsync(user, claims);

// Authorize by claim
[Authorize(Policy = "ITDepartment")]
public IActionResult ItPanel() {
    return View();
}
```

### 3. Policies & Authorization

```csharp
// Define policy in Program.cs
builder.Services.AddAuthorizationBuilder()
    .AddPolicy("ITDepartment", policy => 
        policy.RequireClaim("Department", "IT"));

// Use policy
[Authorize(Policy = "ITDepartment")]
public IActionResult SecureAction() {
    return View();
}
```

### 4. Security Best Practices

```csharp
// Prevent CSRF attacks - 
<form asp-controller="Home" asp-action="Submit">
    <input type="hidden" name="__RequestVerificationToken" 
           value="@Html.AntiForgeryToken()" />
</form>

// Escape output to prevent XSS
<p>@Html.Encode(Model.UserInput)</p>

// Parameterized queries prevent SQL Injection
var user = await _context.Users
    .FromSqlInterpolated($"SELECT * FROM Users WHERE Email = {email}")
    .FirstOrDefaultAsync();

// Use HTTPS only
app.UseHttpsRedirection();
```

### 5. Common Vulnerabilities

| Attack | Description | Prevention |
|--------|-------------|-----------|
| **XSS** | Inject malicious scripts via user input | Input validation, HTML encoding |
| **SQL Injection** | Malicious SQL commands through parameters | Parameterized queries |
| **CSRF** | Unauthorized actions on behalf of user | CSRF tokens, SameSite cookies |
| **Open Redirect** | Redirect to untrusted external site | Validate redirect URLs |

---

## **Unit 9: Hosting & Deploying Applications**

### 1. Web Servers & Hosting Models

- **IIS (Internet Information Services):** Windows-based web server by Microsoft
- **Nginx:** High-performance reverse proxy and web server
- **Apache:** Cross-platform open-source web server
- **Kestrel:** Cross-platform ASP.NET Core web server
- **ASP.NET Core Module:** Manages ASP.NET Core application lifecycle on IIS

### 2. Deployment Process

```bash
# Create release build
dotnet publish -c Release

# Output structure
bin/Release/net6.0/publish/
  - MyApp.dll
  - appsettings.json
  - wwwroot/
  - deps files
  - runtime config

# Deply to IIS
# - publish the folder to generate app file like above
# - copy file to IIS location
# - create application in IIS
# - load the app
```

### 3. Docker & Containerization - CLI not manual

```dockerfile
# Dockerfile
FROM mcr.microsoft.com/dotnet/aspnet:6.0 AS runtime
WORKDIR /app
COPY . .
EXPOSE 80
ENTRYPOINT ["dotnet", "MyApp.dll"]
```

```bash
# Build Docker image
docker build -t myapp:1.0 .

# Run container
docker run -d -p 8080:80 myapp:1.0
```

```yaml
# docker-compose.yml
version: '3'
services:
  app:
    build: .
    ports:
      - "80:80"
  db:
    image: mcr.microsoft.com/mssql/server:2019-latest
    environment:
      ACCEPT_EULA: Y
      SA_PASSWORD: MyPassword@123
```

### 4. Environment Configuration

```json
// appsettings.json
{
  "ConnectionStrings": {
    "DefaultConnection": "Server=localhost;Database=MyDb;..."
  },
  "Logging": {
    "LogLevel": {
      "Default": "Information"
    }
  }
}

// appsettings.Production.json
{
  "ConnectionStrings": {
    "DefaultConnection": "Server=prod-server;Database=ProdDb;..."
  },
  "Logging": {
    "LogLevel": {
      "Default": "Error"
    }
  }
}
```

```bash
# Set environment
ASPNETCORE_ENVIRONMENT=Production
```

### 5. Azure Cloud Deployment 


```bash
1. Right click on project in Visual studio -> publlish
2. choose azure as target platform
3. select azure app service
4. createa app service by filling name, subscription, hosting plan, for hp choose free with locaiton and size create
5. sellect instance 
6. skip api managemennt
7. you app is published to azure 
```


### 6. Performance Considerations

- **Caching:** Use memory cache and distributed cache for frequently accessed data
- **Compression:** Enable gzip compression for responses
- **Async Operations:** Use async/await to improve throughput
- **Database Indexing:** Index frequently queried columns
- **CDN:** Use Content Delivery Network for static assets
- **Monitoring:** Track application performance with Application Insights

---

### Useful NuGet Packages

- `Microsoft.EntityFrameworkCore` - ORM
- `Microsoft.AspNetCore.Identity.EntityFrameworkCore` - Authentication
- `AutoMapper` - DTO mapping
- `Newtonsoft.Json` - JSON serialization
- `Serilog` - Advanced logging
- `FluentValidation` - Advanced validation





