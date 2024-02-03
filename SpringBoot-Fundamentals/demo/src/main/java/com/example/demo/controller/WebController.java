package com.example.demo.controller;
import com.example.demo.entity.Creature;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CreatureRepository;
import com.example.demo.service.CreatureService;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/creatures")

public class WebController {

    private CreatureService creatureService;

    @GetMapping("/home")
    public String home() {
        return "home"; //grab home.html from templates dir
    }
    @PostMapping("/action")
    public String handleDeleteButton(@RequestParam("userInput") String userInput) {

        return "result";
    }
    @GetMapping("/list")
    public String getList(Model model) {
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
        model.addAttribute("items", items); // "items" is the attribute name you'll use in your HTML template
        return "home"; // This should be the name of your HTML template (listPage.html)
    }

    @Autowired /*Ensure the service loads*/
    public WebController(CreatureService creatureService) {
        this.creatureService = creatureService;
    }/*So Spring because it sees the @Autowired, it will know to use this constructor
    when creating an instance of the WebController, and thus be forced to create a CreatureService,
    because it's a constructor with that as a required parameter.*/

    @GetMapping("/all")
    public List<Creature> getAllCustomers() {
            return creatureService.getAllData();
    }
    @GetMapping("/find/{creatureID}")
    public Creature findById(@PathVariable String creatureID){
        return creatureService.findById(creatureID);
    }
    @PostMapping("/delete/{creatureID}")
    public String deleteById(@PathVariable String creatureID){
        return creatureService.deleteById(creatureID);
    }
    @PostMapping("/update/{creatureID}/{name}")
    public Creature updateById(@PathVariable String creatureID,@PathVariable String name){
        return creatureService.updateById(creatureID, name);
    }
    @PostMapping("/create/{creatureID}/{name}")
    public Creature create(@PathVariable String creatureID,@PathVariable String name){
        return creatureService.create(creatureID, name);
    }
    /* For documentation purposes, this is no longer needed to force the service
    @GetMapping("/all")
    public List<Creature> getAllCustomers() {
        if (creatureService == null) { //Springboot does not automatically make a CreatureService class
            //So im forcing it to make one.
            CreatureRepository repo = new CreatureRepository();
            creatureService = new CreatureService(repo);

            return creatureService.getAllData();
        }
        else {
            return creatureService.getAllData();
        }
    }
     */
}
