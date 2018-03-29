package com.webstore.services.Implementation;

import com.webstore.dao.ProductRepository;
import com.webstore.domain.Product;
import com.webstore.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 24.03.2018.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByCategoryOrManufacturer(String category, String manufacturer) {
        return productRepository.findByCategoryOrManufacturer(category,manufacturer);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findByUnitsInStockGreaterThan(int unitsInStock) {
        return productRepository.findByUnitsInStockGreaterThan(unitsInStock);
    }

    @Override
    public List<Product> findByUnitsInStockLessThan(int unitsInStock) {
        return productRepository.findByUnitsInStockLessThan(unitsInStock);
    }

    @Override
    public List<Product> findByPriceBetween(double min, double max) {
        return productRepository.findByPriceBetween(min,max);
    }

    @Override
    public List<Product> findByPriceGreaterThan(double price) {
        return productRepository.findByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findByPriceLessThan(double price) {
        return productRepository.findByPriceLessThan(price);
    }
}
