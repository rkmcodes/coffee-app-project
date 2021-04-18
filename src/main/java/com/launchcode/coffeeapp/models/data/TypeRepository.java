package com.launchcode.coffeeapp.models.data;

import com.launchcode.coffeeapp.models.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {
}
