package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.DateTimeUtil;
import ru.javawebinar.topjava.util.MealsUtil;
import ru.javawebinar.topjava.util.ValidationUtil;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Controller
public class MealRestController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    private final MealService service;

    public MealRestController(MealService service) {
        this.service = service;
    }

    public List<MealTo> getAll(String minTimeString, String maxTimeString, String minDateString, String maxDateString) {
        log.info("getAll");
        LocalTime minTime = DateTimeUtil.getLocalTimeMin(minTimeString);
        LocalTime maxTime = DateTimeUtil.getLocalTimeMax(maxTimeString);
        LocalDate minDate = DateTimeUtil.getLocalDateMin(minDateString);
        LocalDate maxDate = DateTimeUtil.getLocalDateMax(maxDateString);
        int userId = SecurityUtil.getAuthUserId();

        return MealsUtil.getFilteredTos(service.getAll(userId, minDate, maxDate),
                MealsUtil.DEFAULT_CALORIES_PER_DAY, minTime, maxTime);
    }


    public List<MealTo> getAll() {
        log.info("getAll");
        int userId = SecurityUtil.getAuthUserId();
        return MealsUtil.getTos(service.getAll(userId),
                MealsUtil.DEFAULT_CALORIES_PER_DAY);
    }

    public Meal get(int id) {
        log.info("get {}", id);
        int userId = SecurityUtil.getAuthUserId();
        return service.get(id, userId);
    }

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        int userId = SecurityUtil.getAuthUserId();
        ValidationUtil.checkNew(meal);
        return service.create(meal, userId);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        int userId = SecurityUtil.getAuthUserId();
        service.delete(id, userId);
    }

    public void update(Meal meal, int id) {
        log.info("update {} with id={}", meal, id);
        int userId = SecurityUtil.getAuthUserId();
        ValidationUtil.assureIdConsistent(meal, id);
        service.update(meal, userId);
    }
}