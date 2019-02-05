package com.workoutStats.workoutStats.Repository;

import com.workoutStats.workoutStats.domain.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends MongoRepository<Exercise, String> {
    List<Exercise> findByName(String name);

    @Query(value="{}", fields="{'category' : 0}")
    List<Exercise> findAllnames();
}
