using WebApp2BySamir.Services;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();

// Register Dependency Injection Services
// Transient: New instance every time (injected twice = 2 different instances)
builder.Services.AddTransient<ITimeService, TimeService>();

// Scoped: New instance per request (same instance within a request)
builder.Services.AddScoped<ILoggerService, LoggerService>();

// Singleton: Single instance throughout application lifetime
builder.Services.AddSingleton<IDataService, DataService>();
builder.Services.AddSingleton<IGreetingService, GreetingService>();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();
app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Home}/{action=Index}/{id?}");

app.Run();
