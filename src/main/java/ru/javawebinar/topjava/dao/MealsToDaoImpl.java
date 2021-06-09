package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class MealsToDaoImpl implements MealsToDao {

    private static final List<Meal> meals = new CopyOnWriteArrayList<>();
    private static final AtomicInteger count = new AtomicInteger();

    static {
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500));
        meals.add(new Meal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410));
    }

    @Override
    public List<Meal> getMeals() {
        return meals;
    }

    @Override
    public Meal getMealsToId(String stringId) {
        int id = validationId(stringId);
        return meals.stream().filter(meal -> meal.getId() == id).findAny().orElse(null);
    }

    @Override
    public void deleteMeal(String stringId) {
        Meal meal = getMealsToId(stringId);
        meals.remove(meal);
    }

    @Override
    public void createAndUpdateMeal(String stringTime, String description, String stringCalories, String stringId) {
        int id = validationId(stringId);
        LocalDateTime time = LocalDateTime.parse(stringTime);
        int calories = Integer.parseInt(stringCalories);
        if (id == 0) {
            createMeal(time, description, calories);
            return;
        }
        Meal meal = getMealsToId(stringId);
        meal.setDateTime(time);
        meal.setDescription(description);
        meal.setCalories(calories);
    }

    private void createMeal(LocalDateTime time, String description, int calorie) {
        Meal meal = new Meal(time, description, calorie);
        meals.add(meal);
    }

    private int validationId(String id) {
        int result = 0;
        if (!id.isEmpty()) {

            result = Integer.parseInt(id);
        }
        return result;
    }

    public synchronized int incrementId() {
        return count.incrementAndGet();
    }
}
