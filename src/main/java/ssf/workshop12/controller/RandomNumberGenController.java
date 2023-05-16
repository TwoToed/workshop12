package ssf.workshop12.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import ssf.workshop12.model.Image;
import ssf.workshop12.service.RandomNumService;

@Controller
//Request Mapping is optional because we're only using 1 controller class or smth
//@RequestMapping(path = "/api")
public class RandomNumberGenController {

    //injecting service class dependency generally used for small application
    @Autowired
    RandomNumService service;
    
    @GetMapping("/home")
    public String landingPage(){
        return "home";

    }

    @GetMapping("/get")
    public String generateRanNumbers(Model model, HttpServletRequest request){
        //fetches input parameter
        int number = Integer.parseInt(request.getParameter("number"));
        System.out.println("input no is: " + number);
        
        if(number < 1 || number > 30){
            String errorMessage = "Invalid Number:" + number;
            model.addAttribute("errorMessage", errorMessage);
            return "home";
        }

        //calling service method to generate random numbers
        List<Integer> randomNumbers = service.generateRanNumbers(number);

        //populate image objects and create list of Image objects
        List<Image> imageList = new ArrayList<Image>();

        for(int randomNumber : randomNumbers){
            imageList.add(new Image(Integer.toString(randomNumber), "/images/"+Integer.toString(randomNumber)+".png"));
        }
        System.out.println("image list :" + imageList);

        model.addAttribute(imageList);

        return "display";
    }

}
