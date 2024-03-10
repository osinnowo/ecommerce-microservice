package com.ecommerce.service.catalog.repository;

import com.ecommerce.service.catalog.model.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> { }
