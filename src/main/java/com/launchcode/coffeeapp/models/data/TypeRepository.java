package com.launchcode.coffeeapp.models.data;

import org.launchcode.hellospring.models.Type;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer> {
}
