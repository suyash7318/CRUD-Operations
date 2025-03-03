package com.productcruds.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcruds.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{

}
