package com.launchcode.coffeeapp.controllers;

import org.launchcode.hellospring.models.Type;
import org.launchcode.hellospring.models.data.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("types")
public class TypeController {

    @Autowired
    private TypeRepository typeRepository;

    @GetMapping("add")
    public String displayAddTypeForm(Model model) {
        model.addAttribute(new Type());
        return "types/add";
    }

    @PostMapping("add")
    public String processAddTypeForm(@ModelAttribute @Valid Type newType,
                                      Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "types/add";
        }

        typeRepository.save(newType);
        return "redirect:";
    }

    @GetMapping("view/{typeId}")
    public String displayViewType(Model model, @PathVariable int typeId) {

        Optional optType = typeRepository.findById(typeId);
        if (optType.isPresent()) {
            Type type = (Type) optType.get();
            model.addAttribute("type", type);
            return "types/view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("")
    public String displayTypes(Model model) {
        List<Type> types = (List<Type>) typeRepository.findAll();
        model.addAttribute("types", types);
        return "types/index";
    }









}
