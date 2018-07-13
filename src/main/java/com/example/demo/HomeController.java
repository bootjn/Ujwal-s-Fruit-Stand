package com.example.demo;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
public class HomeController {
//
    @Autowired
    FruitRepository fruitRepository;

    @Autowired
    WeekRepository weekRepository;

    @Autowired
    CloudinaryConfig cloudc;

//    @RequestMapping("/")
//    public String list(){
//        return "list";
//    }

//        @RequestMapping("/")
//    public String list(){
//        return "form";
//    }

    @RequestMapping("/")
    public String list(Model model){
        model.addAttribute("fruits", fruitRepository.findAll());

        model.addAttribute("weeks", weekRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String fruitForm(Model model){
        model.addAttribute("fruit", new Fruit());

        //model.addAttribute("week", new Week());

        model.addAttribute("weeks", weekRepository.findAll());

        return "form";
    }

    @PostMapping("/process")
    public String processForm(Fruit fruit){
        fruitRepository.save(fruit);


        return "redirect:/";
    }

    @GetMapping("/addweek")
    public String weekForm(Model model){
        //model.addAttribute("fruit", new Fruit());

        model.addAttribute("week", new Week());

        return "formweek";
    }

    @PostMapping("/addweek")
    public String processWeekForm(Week week){


        weekRepository.save(week);
        return "redirect:/";
    }

    //    @RequestMapping("/")
//    public String index()
//    {
//        return "list";
//    }
//    @GetMapping("/add")
//    public String addFruit(Model model)
//    {
//        model.addAttribute("fruit", new Fruit());
//        model.addAttribute("weeks", weekRepository.findAll());
//        return "form";
//    }

//    @PostMapping("/process")
//    public String processForm(Fruit fruit){
//
//        fruitRepository.save(fruit);
//
//        return "redirect:/";
//    }




    @RequestMapping("/detail/{id}")
    public String showFruit(@PathVariable("id") long id, Model model) {
//        Fruit fruit = fruitRepository.findById(id).get();
//        Week week = weekRepository.findById(fruit.getWeek_id()).get();
        model.addAttribute("fruit", fruitRepository.findById(id).get());
//        model.addAttribute("fruitWeek", week);
        return "show";
    }


    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Model model) {
        model.addAttribute("fruit", fruitRepository.findById(id).get());
        model.addAttribute("week", weekRepository.findAll());
        return "form";
    }

    @RequestMapping("/delete/{id}")
    public String deleteWeek(@PathVariable("id") long id) {
        fruitRepository.deleteById(id);
        return "redirect:/";
    }


//    @PostMapping("/add")
//    public String processCar(@Valid @ModelAttribute("fruit") Fruit fruit,
//                             @RequestParam("file") MultipartFile file) {
//
//        if (file.isEmpty()) {
//            System.out.println("Picture is empty");
//            return "redirect:/add";
//        }
//        try {
//            Map uploadResult = cloudc.upload(file.getBytes(), ObjectUtils.asMap("resourcetype", "auto"));
//            fruit.setPictureUrl(uploadResult.get("url").toString());
//
//
//
//
//
//            fruitRepository.save(fruit);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return "redirect:/add";
//        }
//        return "redirect:/";
//    }

}
