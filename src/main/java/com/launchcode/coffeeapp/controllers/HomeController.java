package com.launchcode.coffeeapp.controllers;

import com.launchcode.coffeeapp.models.Place;
import com.launchcode.coffeeapp.models.Type;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.launchcode.coffeeapp.models.Place;
import org.launchcode.coffeeapp.models.Review;
import org.launchcode.coffeeapp.models.Type;
import org.launchcode.coffeeapp.models.data.PlaceRepository;
import org.launchcode.coffeeapp.models.data.ReviewRepository;
import org.launchcode.coffeeapp.models.data.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping("")
    public String index(Model model) {

        model.addAttribute("title", "My Reviews");

        return "index";
    }

    @GetMapping("add")
    public String displayAddReviewForm(Model model) {
        model.addAttribute("places", placeRepository.findAll());
        model.addAttribute("title", "Add Review");
        model.addAttribute("types", typeRepository.findAll());
        model.addAttribute(new Review());
        return "add";
    }

    @PostMapping("add")
    public String processAddReviewForm(@ModelAttribute @Valid Review newReview,
                                    Errors errors, Model model, @RequestParam int placeId ,@RequestParam List<Integer> types) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Error");
            return "add";
        }

        Place place = placeRepository.findById(placeId).get();
        newReview.setPlace(place);

        List<Type> typeObjs = (List<Type>) typeRepository.findAllById(places);
        newReview.setTypes(typeObjs);

        reviewRepository.save(newReview);

        return "redirect:";

    }

    @GetMapping("view/{reviewId}")
    public String displayViewReview(Model model, @PathVariable int reviewId) {

        Optional optReview = reviewRepository.findById(reviewId);
        if (optReview.isPresent()) {
            Review review = (Review) optReview.get();
            model.addAttribute("review", review);
            return "view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("")
    public String displayReview(Model model) {
        ArrayList<Review> review = (ArrayList<Review>) reviewRepository.findAll();
        model.addAttribute("reviews", review);
        return "index";
    }







//    @RequestMapping(value="")
//    @ResponseBody
//    public String index(){
//        return "Hello World";
//    }
}
