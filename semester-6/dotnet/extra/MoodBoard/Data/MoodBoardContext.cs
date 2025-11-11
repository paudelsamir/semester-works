using Microsoft.EntityFrameworkCore;
using MoodBoard.Models;

namespace MoodBoard.Data;

public class MoodBoardContext : DbContext
{
    public MoodBoardContext(DbContextOptions<MoodBoardContext> options)
        : base(options)
    {
    }

    public DbSet<Mood> Moods { get; set; } = null!;
}