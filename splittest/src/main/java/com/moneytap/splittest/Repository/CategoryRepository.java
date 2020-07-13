package com.moneytap.splittest.Repository;

import com.moneytap.splittest.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {


}

