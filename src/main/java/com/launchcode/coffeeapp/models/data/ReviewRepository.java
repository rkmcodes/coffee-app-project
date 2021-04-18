package com.launchcode.coffeeapp.models.data;

import org.launchcode.hellospring.models.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ReviewRepository extends CrudRepository<Review, Integer> {
}
