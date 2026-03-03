package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.exception.ProductNotFoundException;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public interface ProductRepository {
    public Product create(Product product);
    public Iterator<Product> findAll();
    public Product findById(String productId);
    public Product edit(String productId, Product editedProduct);
    public void delete(String productId);
}
