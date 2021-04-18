package com.launchcode.coffeeapp.models.data;

import com.launchcode.coffeeapp.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
