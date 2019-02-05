package com.workoutStats.workoutStats.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document
public @Data class Exercise {
    @Id
    private String id;
    private String name;
    private String category;

    public Exercise(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
