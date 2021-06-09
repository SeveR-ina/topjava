package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealsToDao {
    int CALORIES_PER_DAY = 2000;

    List<Meal> getMeals();

    Meal getMealsToId(String id);

    void deleteMeal(String id);

    void createAndUpdateMeal(String time, String description, String calorie, String id);

    int incrementId();
}
