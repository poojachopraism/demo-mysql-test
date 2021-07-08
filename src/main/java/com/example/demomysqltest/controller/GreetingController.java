package com.example.demomysqltest.controller;


import com.example.demomysqltest.dto.Greeting;
import com.example.demomysqltest.repository.UserRepository;
import com.example.demomysqltest.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greetings")
public class GreetingController {


    @GetMapping("/getGreeting")
    Greeting getGreeting(){

        return new Greeting("Pooja", 1);
    }

    @GetMapping("/getGreetID/{id}")
    Greeting getGreetingId(@PathVariable String id){


        return new Greeting("Pooja" + id, 2);
    }

    @GetMapping("/getGreetName")
   Greeting getGreetingName(@RequestParam String name, Model model){
        model.addAttribute("input","Hello !!");
        return new Greeting(model.getAttribute("input") + " : Pooja : " + name, 5);
    }

    @PostMapping("/greets")
    @ResponseBody String greets(@RequestBody Greeting greet){
        System.out.println(" Greet : " +  greet);

        return "Saved";
    }

}
