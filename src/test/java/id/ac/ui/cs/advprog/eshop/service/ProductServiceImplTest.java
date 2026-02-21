package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product();
        product.setProductName("Laptop");
        product.setProductQuantity(10);
    }

    @Test
    void testCreate() {
        Product created = productService.create(product);

        assertNotNull(created.getProductId());
        verify(productRepository, times(1)).create(product);
    }

    @Test
    void testFindAll() {
        List<Product> products = List.of(product);
        Iterator<Product> iterator = products.iterator();

        when(productRepository.findAll()).thenReturn(iterator);

        List<Product> result = productService.findAll();

        assertEquals(1, result.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        when(productRepository.findById("1")).thenReturn(product);

        Product result = productService.findById("1");

        assertEquals(product, result);
        verify(productRepository, times(1)).findById("1");
    }

    @Test
    void testEdit() {
        when(productRepository.edit("1", product)).thenReturn(product);

        Product result = productService.edit("1", product);

        assertEquals(product, result);
        verify(productRepository, times(1)).edit("1", product);
    }

    @Test
    void testDelete() {
        productService.delete("1");

        verify(productRepository, times(1)).delete("1");
    }
}