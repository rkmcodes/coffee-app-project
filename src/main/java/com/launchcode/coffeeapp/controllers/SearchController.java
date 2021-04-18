package com.launchcode.coffeeapp.controllers;

import com.launchcode.coffeeapp.models.Review;
import com.launchcode.coffeeapp.models.ReviewData;
import com.launchcode.coffeeapp.models.data.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import static com.launchcode.coffeeapp.controllers.ListController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

        @Autowired
        private ReviewRepository reviewRepository;

        @RequestMapping("")
        public String search(Model model) {
            model.addAttribute("columns", columnChoices);
            return "search";
        }

        @PostMapping("results")
        public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
            Iterable<Review> reviews;
            if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")){
                reviews = reviewRepository.findAll();
            } else {
                reviews = ReviewData.findByColumnAndValue(searchType, searchTerm, reviewRepository.findAll());
            }
            model.addAttribute("columns", columnChoices);
            model.addAttribute("title", "Reviews with " + columnChoices.get(searchType) + ": " + searchTerm);
            model.addAttribute("reviews", reviews);

            return "search";
        }
    }


