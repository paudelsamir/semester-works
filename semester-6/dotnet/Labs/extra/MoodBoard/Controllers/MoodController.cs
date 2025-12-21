using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using MoodBoard.Data;
using MoodBoard.Models;

namespace MoodBoard.Controllers;

public class MoodController : Controller
{
    private readonly MoodBoardContext _context;

    public MoodController(MoodBoardContext context)
    {
        _context = context;
    }

    // GET: Mood
    public async Task<IActionResult> Index()
    {
        return View(await _context.Moods.OrderByDescending(m => m.CreatedAt).ToListAsync());
    }

    // GET: Mood/Create
    public IActionResult Create()
    {
        return View();
    }

    // POST: Mood/Create
    [HttpPost]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> Create([Bind("Feeling,Quote")] Mood mood)
    {
        if (ModelState.IsValid)
        {
            mood.CreatedAt = DateTime.UtcNow;
            _context.Add(mood);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }
        return View(mood);
    }

    // GET: Mood/Edit/5
    public async Task<IActionResult> Edit(int? id)
    {
        if (id == null)
        {
            return NotFound();
        }

        var mood = await _context.Moods.FindAsync(id);
        if (mood == null)
        {
            return NotFound();
        }
        return View(mood);
    }

    // POST: Mood/Edit/5
    [HttpPost]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> Edit(int id, [Bind("Id,Feeling,Quote")] Mood mood)
    {
        if (id != mood.Id)
        {
            return NotFound();
        }

        if (ModelState.IsValid)
        {
            try
            {
                var existingMood = await _context.Moods.FindAsync(id);
                if (existingMood == null)
                {
                    return NotFound();
                }

                existingMood.Feeling = mood.Feeling;
                existingMood.Quote = mood.Quote;
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!MoodExists(mood.Id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }
            return RedirectToAction(nameof(Index));
        }
        return View(mood);
    }

    // GET: Mood/Delete/5
    public async Task<IActionResult> Delete(int? id)
    {
        if (id == null)
        {
            return NotFound();
        }

        var mood = await _context.Moods
            .FirstOrDefaultAsync(m => m.Id == id);
        if (mood == null)
        {
            return NotFound();
        }

        return View(mood);
    }

    // POST: Mood/Delete/5
    [HttpPost, ActionName("Delete")]
    [ValidateAntiForgeryToken]
    public async Task<IActionResult> DeleteConfirmed(int id)
    {
        var mood = await _context.Moods.FindAsync(id);
        if (mood != null)
        {
            _context.Moods.Remove(mood);
        }

        await _context.SaveChangesAsync();
        return RedirectToAction(nameof(Index));
    }

    private bool MoodExists(int id)
    {
        return _context.Moods.Any(e => e.Id == id);
    }
}