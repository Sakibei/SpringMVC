package com.benny.controller;

import com.benny.model.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//關鍵字自動填入功能
@Controller
public class ReadAnimalController {

    ArrayList<Animal> animals = new ArrayList<>();

    public ReadAnimalController(){
        animals.add(new Animal(1,"monkey"));
        animals.add(new Animal(2,"rabbit"));
        animals.add(new Animal(3,"tiger"));
        animals.add(new Animal(4,"bird"));
        animals.add(new Animal(5,"bear"));
        animals.add(new Animal(6,"cat"));
        animals.add(new Animal(7,"wife"));
        animals.add(new Animal(8,"zebra"));
        animals.add(new Animal(9,"lion"));
    }

    @PostMapping(path = "/animalReader.controller")
    @ResponseBody
    public List<Animal> processAction(@RequestParam("keyword") String animalName){
        return searchResult(animalName);
    }

    private List<Animal> searchResult(String animalName){
        ArrayList<Animal> results = new ArrayList<>();
        for(Animal a : animals){
            if(a.getAnimalName().contains(animalName) && animalName.length() != 0){
                results.add(a);
            }
        }
        return results;
    }

}
