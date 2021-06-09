package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealsToDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class DeleteMealServlet extends HttpServlet {
    private static final Logger log = getLogger(DeleteMealServlet.class);
    private MealsToDao mealsToDao;

    @Override
    public void init() {
        mealsToDao = (MealsToDao) getServletContext().getAttribute("dao");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("delete meal post");

        mealsToDao.deleteMeal(request.getParameter("id"));
        response.sendRedirect("meals");
    }
}
