package com.codeid.eshoppay_backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codeid.eshoppay_backend.model.entity.Suppliers;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {
    
}
