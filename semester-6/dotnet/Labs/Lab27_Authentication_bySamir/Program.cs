using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using Lab27_Authentication_bySamir.Data;

var builder = WebApplication.CreateBuilder(args);

// Add DbContext
builder.Services.AddDbContext<ApplicationDbContext>(options =>
    options.UseSqlite("Data Source=auth.db"));

// Add Identity
builder.Services.AddIdentity<IdentityUser, IdentityRole>(options =>
{
    options.Password.RequireDigit = true;
    options.Password.RequiredLength = 6;
    options.Password.RequireNonAlphanumeric = false;
    options.Password.RequireUppercase = true;
    options.Password.RequireLowercase = true;
})
.AddEntityFrameworkStores<ApplicationDbContext>()
.AddDefaultTokenProviders();

// Add Cookie Authentication
builder.Services.ConfigureApplicationCookie(options =>
{
    options.LoginPath = "/Auth/Login";
    options.LogoutPath = "/Auth/Logout";
    options.AccessDeniedPath = "/Auth/AccessDenied";
    options.ExpireTimeSpan = TimeSpan.FromDays(30);
    options.SlidingExpiration = true;
});

builder.Services.AddControllersWithViews();

var app = builder.Build();

app.Urls.Add("http://localhost:5002");

// Seed roles and users
using (var scope = app.Services.CreateScope())
{
    var roleManager = scope.ServiceProvider.GetRequiredService<RoleManager<IdentityRole>>();
    var userManager = scope.ServiceProvider.GetRequiredService<UserManager<IdentityUser>>();
    var dbContext = scope.ServiceProvider.GetRequiredService<ApplicationDbContext>();

    dbContext.Database.EnsureCreated();

    // Create roles
    string[] roles = { "Admin", "Teacher", "Student" };
    foreach (var role in roles)
    {
        if (!await roleManager.RoleExistsAsync(role))
            await roleManager.CreateAsync(new IdentityRole(role));
    }

    // Create test users
    var testUsers = new[]
    {
        new { Email = "admin@lab27.com", Password = "Admin@123", Role = "Admin" },
        new { Email = "teacher@lab27.com", Password = "Teacher@123", Role = "Teacher" },
        new { Email = "student@lab27.com", Password = "Student@123", Role = "Student" }
    };

    foreach (var testUser in testUsers)
    {
        if (await userManager.FindByEmailAsync(testUser.Email) == null)
        {
            var user = new IdentityUser { UserName = testUser.Email, Email = testUser.Email };
            var result = await userManager.CreateAsync(user, testUser.Password);
            if (result.Succeeded)
                await userManager.AddToRoleAsync(user, testUser.Role);
        }
    }
}

if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();
app.UseRouting();
app.UseAuthentication();
app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
