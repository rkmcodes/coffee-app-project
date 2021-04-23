package com.launchcode.coffeeapp.controllers;

import com.launchcode.coffeeapp.models.Flavor;
import com.launchcode.coffeeapp.models.data.FlavorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("flavors")
public class FlavorController {


    @Autowired
    private FlavorRepository flavorRepository;

    @GetMapping("add")
    public String displayAddFlavorForm(Model model) {
        model.addAttribute(new Flavor());
        return "flavors/add";
    }

    @PostMapping("add")
    public String processAddFlavorForm(@ModelAttribute @Valid Flavor newFlavor,
                                     Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "flavors/add";
        }

        flavorRepository.save(newFlavor);
        return "redirect:";
    }

    @GetMapping("view/{flavorId}")
    public String displayViewFlavor(Model model, @PathVariable int flavorId) {

        Optional optFlavor = flavorRepository.findById(flavorId);
        if (optFlavor.isPresent()) {
            Flavor flavor = (Flavor) optFlavor.get();
            model.addAttribute("flavor", flavor);
            return "flavors/view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("")
    public String displayFlavors(Model model) {
        List<Flavor> flavors = (List<Flavor>) flavorRepository.findAll();
        model.addAttribute("flavors", flavors);
        return "flavors/index";
    }



















}
