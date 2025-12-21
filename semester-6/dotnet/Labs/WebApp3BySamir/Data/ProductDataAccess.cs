using WebApp3BySamir.Models;

namespace WebApp3BySamir.Data
{
    public class ProductDataAccess
    {
        private static List<Product> _products = new();
        private int _nextId = 1;

        public ProductDataAccess(IConfiguration configuration)
        {
            // Mock initialization
        }

        public void InitializeDatabase()
        {
            // Initialize with sample data if empty
            if (_products.Count == 0)
            {
                _products = new List<Product>
                {
                    new Product { ProductID = 1, ProductName = "Laptop", Price = 50000, Quantity = 5, Category = "Electronics", CreatedDate = DateTime.Now },
                    new Product { ProductID = 2, ProductName = "Mouse", Price = 500, Quantity = 20, Category = "Accessories", CreatedDate = DateTime.Now },
                    new Product { ProductID = 3, ProductName = "Keyboard", Price = 2000, Quantity = 10, Category = "Accessories", CreatedDate = DateTime.Now }
                };
                _nextId = 4;
            }
        }

        // CREATE
        public bool InsertProduct(Product product)
        {
            try
            {
                product.ProductID = _nextId++;
                product.CreatedDate = DateTime.Now;
                _products.Add(product);
                return true;
            }
            catch
            {
                return false;
            }
        }

        // READ ALL
        public List<Product> GetAllProducts()
        {
            return _products.OrderByDescending(p => p.CreatedDate).ToList();
        }

        // READ BY ID
        public Product? GetProductById(int id)
        {
            return _products.FirstOrDefault(p => p.ProductID == id);
        }

        // UPDATE
        public bool UpdateProduct(Product product)
        {
            try
            {
                var existingProduct = _products.FirstOrDefault(p => p.ProductID == product.ProductID);
                if (existingProduct != null)
                {
                    existingProduct.ProductName = product.ProductName;
                    existingProduct.Price = product.Price;
                    existingProduct.Quantity = product.Quantity;
                    existingProduct.Category = product.Category;
                    return true;
                }
                return false;
            }
            catch
            {
                return false;
            }
        }

        // DELETE
        public bool DeleteProduct(int id)
        {
            try
            {
                var product = _products.FirstOrDefault(p => p.ProductID == id);
                if (product != null)
                {
                    _products.Remove(product);
                    return true;
                }
                return false;
            }
            catch
            {
                return false;
            }
        }
    }
}
