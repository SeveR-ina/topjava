package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealsToDao;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private MealsToDao mealsToDao;

    @Override
    public void init() {
        mealsToDao = (MealsToDao) getServletContext().getAttribute("dao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");

        List<MealTo> mealsTo = MealsUtil.filteredByStreams(mealsToDao.getMeals(), LocalTime.MIN, LocalTime.MAX, mealsToDao.CALORIES_PER_DAY);
        mealsTo.sort(Comparator.comparing(MealTo::getDateTime));
        request.setAttribute("mealsTo", mealsTo);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}