package com.workoutStats.workoutStats.controllers;

import com.workoutStats.workoutStats.domain.Exercise;
import com.workoutStats.workoutStats.Service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseController {
    @Autowired
    private ExerciseService ExerciseService;

    //POST
    @PostMapping("exercise")
    public String post(@RequestParam String name, String category) {
        Exercise ex = ExerciseService.create(name, category);
        return ex.toString();
    }

    //GET
    @GetMapping("exercise")
    public List<Exercise> get(@RequestParam String name) {
        return ExerciseService.getExercisesByName(name);
    }

    //DELETE
    @DeleteMapping("exercise")
    public String delete(@RequestParam String name) {
        ExerciseService.delete(name);
        return "Deleted " + name;
    }

    //GET ALL
    @CrossOrigin
    @GetMapping("exercises")
    public List<Exercise> getAllNames() {
        return ExerciseService.getExercises();
    }

    //DELETE ALL
    @DeleteMapping("exercises")
    public String deleteAll() {
        ExerciseService.deleteAll();
        return "Deleted every exercise!";
    }
}
