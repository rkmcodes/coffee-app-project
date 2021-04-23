package com.launchcode.coffeeapp.models.data;


import com.launchcode.coffeeapp.models.Flavor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavorRepository extends CrudRepository<Flavor, Integer> {
}
