using Microsoft.AspNetCore.Mvc;
using WebApp3BySamir.Data;
using WebApp3BySamir.Models;

namespace WebApp3BySamir.Controllers
{
    public class ProductController : Controller
    {
        private readonly ProductDataAccess _dataAccess;

        public ProductController(IConfiguration configuration)
        {
            _dataAccess = new ProductDataAccess(configuration);
            _dataAccess.InitializeDatabase();
        }

        // GET: Product/Index
        public IActionResult Index()
        {
            var products = _dataAccess.GetAllProducts();
            return View(products);
        }

        // GET: Product/Create
        public IActionResult Create()
        {
            return View();
        }

        // POST: Product/Create
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Create(Product product)
        {
            if (ModelState.IsValid)
            {
                if (_dataAccess.InsertProduct(product))
                {
                    TempData["SuccessMessage"] = "Product created successfully!";
                    return RedirectToAction(nameof(Index));
                }
                ModelState.AddModelError("", "Error creating product");
            }
            return View(product);
        }

        // GET: Product/Edit/5
        public IActionResult Edit(int id)
        {
            var product = _dataAccess.GetProductById(id);
            if (product == null)
            {
                return NotFound();
            }
            return View(product);
        }

        // POST: Product/Edit/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public IActionResult Edit(Product product)
        {
            if (ModelState.IsValid)
            {
                if (_dataAccess.UpdateProduct(product))
                {
                    TempData["SuccessMessage"] = "Product updated successfully!";
                    return RedirectToAction(nameof(Index));
                }
                ModelState.AddModelError("", "Error updating product");
            }
            return View(product);
        }

        // GET: Product/Details/5
        public IActionResult Details(int id)
        {
            var product = _dataAccess.GetProductById(id);
            if (product == null)
            {
                return NotFound();
            }
            return View(product);
        }

        // GET: Product/Delete/5
        public IActionResult Delete(int id)
        {
            var product = _dataAccess.GetProductById(id);
            if (product == null)
            {
                return NotFound();
            }
            return View(product);
        }

        // POST: Product/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public IActionResult DeleteConfirmed(int id)
        {
            if (_dataAccess.DeleteProduct(id))
            {
                TempData["SuccessMessage"] = "Product deleted successfully!";
            }
            else
            {
                TempData["ErrorMessage"] = "Error deleting product";
            }
            return RedirectToAction(nameof(Index));
        }
    }
}
