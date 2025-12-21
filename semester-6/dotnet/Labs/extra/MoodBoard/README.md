# MoodBoard MVC Project Documentation

## Project Setup

1. Create new MVC project:
```bash
dotnet new mvc -n MoodBoard
cd MoodBoard
```

2. Install required packages:
```bash
dotnet add package Microsoft.EntityFrameworkCore.SQLite
dotnet add package Microsoft.EntityFrameworkCore.Design
```

3. Start the development server:
```bash
dotnet watch run
```

## Project Structure

### 1. Models
Located in `Models/Mood.cs`:
- Represents a mood entry with feeling and associated quote
- Contains: Id, Feeling, Quote, CreatedAt

### 2. Database Context
Located in `Data/MoodBoardContext.cs`:
- Entity Framework Core context
- Manages database operations
- Configures Mood entity

### 3. Controllers
Located in `Controllers/MoodController.cs`:
- Handles mood-related operations
- Actions: Index, Create, Edit, Delete

### 4. Views
Located in `Views/Mood/`:
- Index.cshtml: Lists all moods
- Create.cshtml: Form for new moods
- Edit.cshtml: Edit existing moods
- _MoodCard.cshtml: Partial view for mood display

### 5. Styles
Located in `wwwroot/css/`:
- Custom styles for mood cards
- Dark mode implementation

## Features Implementation

### Basic Features
- [x] CRUD operations for moods
- [x] Quote display with each mood
- [x] Responsive design with Bootstrap

### Extra Features
- [x] Random quote generation
- [x] SQLite database integration
- [x] Dark mode toggle
- [x] Hot reload support

## Database Setup

1. Initialize database:
```bash
dotnet ef migrations add InitialCreate
dotnet ef database update
```

## Testing

1. Run the application:
```bash
dotnet watch run
```

2. Access the application:
- Main page: https://localhost:5001/Mood
- Create new mood: https://localhost:5001/Mood/Create

## Development Tips

1. Use Visual Studio Code with these extensions:
   - C# Dev Kit
   - .NET Install Tool
   - SQLite

2. Enable hot reload:
   - Already configured with `dotnet watch run`
   - Changes apply automatically

3. Database management:
   - SQLite database file: `MoodBoard.db`
   - Use SQLite browser for direct DB access

## Troubleshooting

Common issues and solutions:

1. Database migrations failing:
```bash
dotnet ef database drop
dotnet ef migrations remove
dotnet ef migrations add InitialCreate
dotnet ef database update
```

2. Hot reload not working:
   - Ensure you're using `dotnet watch run`
   - Check for syntax errors in changed files

3. Package references missing:
```bash
dotnet restore
```

## Deployment

1. Build for production:
```bash
dotnet publish -c Release
```

2. Deploy the published files from `bin/Release/net7.0/publish/`

## Next Steps

Potential improvements:
1. Add user authentication
2. Implement mood statistics
3. Add date-based filtering
4. Create mood categories
5. Add image upload support