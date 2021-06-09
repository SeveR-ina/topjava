package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.dao.MealsToDao;
import ru.javawebinar.topjava.dao.MealsToDaoImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    private final MealsToDao mealsToDao;

    public ContextListener() {
        this.mealsToDao = new MealsToDaoImpl();
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        final ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("dao", mealsToDao);
    }
}
