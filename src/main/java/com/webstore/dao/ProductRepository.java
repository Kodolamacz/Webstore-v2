package com.webstore.dao;

import com.webstore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Blazej on 03.03.2018.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findById(Long id);
    Product findByName(String name);
    List<Product> findByCategoryOrManufacturer(String category, String manufacturer);
    Product save(Product product);
    void deleteById(Long id);
    List<Product> findByUnitsInStockGreaterThan(int unitsInStock);
    List<Product> findByUnitsInStockLessThan(int unitsInStock);
    List<Product> findByPriceBetween(double min, double max);
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByPriceLessThan(double price);

}
