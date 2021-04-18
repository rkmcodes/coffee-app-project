package com.launchcode.coffeeapp.models.data;

import com.launchcode.coffeeapp.models.Place;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceRepository extends CrudRepository<Place, Integer> {
}

