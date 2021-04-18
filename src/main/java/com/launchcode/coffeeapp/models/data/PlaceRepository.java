package com.launchcode.coffeeapp.models.data;

import org.launchcode.hellospring.models.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {
}

