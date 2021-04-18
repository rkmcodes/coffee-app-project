//I AM CHANGING HELLOSPRING TO COFFEEAPP EVERYWHERE

package com.launchcode.coffeeapp.controllers;

import com.launchcode.coffeeapp.models.data.ReviewRepository;
import org.launchcode.hellospring.models.Review;
import org.launchcode.hellospring.models.data.PlaceRepository;
import org.launchcode.hellospring.models.data.ReviewRepository;
import org.launchcode.hellospring.models.data.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.launchcode.hellospring.models.ReviewData;

import java.util.HashMap;


@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("place", "Place");
        columnChoices.put("type", "Type");

    }

    @RequestMapping("")
    public String list(Model model) {

        model.addAttribute("places", placeRepository.findAll());
        model.addAttribute("types", typeRepository.findAll());


        return "list";
    }

    @RequestMapping(value = "reviews")
    public String listReviewsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {
        Iterable<Review> reviews;
        if (column.toLowerCase().equals("all")){
            reviews = reviewRepository.findAll();
            model.addAttribute("title", "All Reviews");
        } else {
            reviews = ReviewData.findByColumnAndValue(column, value, reviewRepository.findAll());
            model.addAttribute("title", "Reviews with " + columnChoices.get(column) + ": " + value);
        }
        model.addAttribute("reviews", reviews);

        return "list-reviews";
    }











}
