package com.workoutStats.workoutStats.Service;

import com.workoutStats.workoutStats.domain.Exercise;
import com.workoutStats.workoutStats.Repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    //POST
    public Exercise create(String name, String category) {
        return exerciseRepository.save(new Exercise(name, category));
    }

    //GET
    public List<Exercise> getExercises(){
        return exerciseRepository.findAllnames();
        // return exerciseRepository.findAll();
    }

    public List<Exercise> getExercisesByName(String name){
        return exerciseRepository.findByName(name);
    }

    //DELETE
    public void delete(String name) {
        List<Exercise> ExercisesToBeDeleted = exerciseRepository.findByName(name);
        for (Exercise ex : ExercisesToBeDeleted) {
            exerciseRepository.delete(ex);
        }
    }

    public void deleteAll() {
        exerciseRepository.deleteAll();
    }

}
