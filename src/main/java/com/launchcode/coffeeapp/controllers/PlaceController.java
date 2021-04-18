package com.launchcode.coffeeapp.controllers;

import com.launchcode.coffeeapp.models.Place;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.launchcode.hellospring.models.Place;
import org.launchcode.hellospring.models.data.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("places")
public class PlaceController {

    @Autowired
    private PlacRepository placeRepository;


    @GetMapping("add")
    public String displayAddPlaceForm(Model model) {
        model.addAttribute(new Place());
        return "places/add";
    }

    @PostMapping("add")
    public String processAddPlaceForm(@ModelAttribute @Valid Place newPlace,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "places/add";
        }

        placeRepository.save(newPlace);
        return "redirect:";
    }

    @GetMapping("view/{placeId}")
    public String displayViewPlace(Model model, @PathVariable int placeId) {

        Optional optPlace = placeRepository.findById(placeId);
        if (optPlace.isPresent()) {
            Place place = (Place) optPlace.get();
            model.addAttribute("place", place);
            return "places/view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("")
    public String displayPlace(Model model) {
        ArrayList<Place> place = (ArrayList<Place>) placeRepository.findAll();
        model.addAttribute("places", place);
        return "places/index";
    }









//
//    @RequestMapping(value="goodbye")
//    @ResponseBody
//    public String goodbye(){
//        return "Goodbye";
//    }

}
