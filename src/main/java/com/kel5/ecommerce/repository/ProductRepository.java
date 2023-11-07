package com.kel5.ecommerce.repository;

import com.kel5.ecommerce.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE CONCAT(p.id, ' ', p.name, ' ', p.description) LIKE %:keyword%")
    List<Product> search(@Param("keyword") String keyword);
}
