package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.exception.ProductNotFoundException;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {
    private final List<Product> productData = new ArrayList<>();

    @Override
    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    @Override
    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    @Override
    public Product findById(String productId) {
        return productData.stream()
                .filter(product -> product.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }

    @Override
    public Product edit(String productId, Product editedProduct) {
        Product product = findById(productId);

        product.setProductName(editedProduct.getProductName());
        product.setProductQuantity(editedProduct.getProductQuantity());

        return product;
    }

    @Override
    public void delete(String productId) {
        Product product = findById(productId);
        productData.remove(product);
    }
}
