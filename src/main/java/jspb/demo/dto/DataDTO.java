package jspb.demo.dto;

import lombok.Data;

@Data
public class DataDTO {
    private String name;
    private double calories;
    private double fat;
    private double carbs;
    private double protein;
    private String iron;

    public DataDTO(String name, double calories, double fat, double carbs, double protein, String iron) {
        this.name = name;
        this.calories = calories;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
        this.iron = iron;
    }
}
