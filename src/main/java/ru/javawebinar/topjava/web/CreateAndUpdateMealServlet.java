package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealsToDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class CreateAndUpdateMealServlet extends HttpServlet {
    private static final Logger log = getLogger(DeleteMealServlet.class);
    private MealsToDao mealsToDao;

    @Override
    public void init() {
        mealsToDao = (MealsToDao) getServletContext().getAttribute("dao");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("update meal get");

        String id = request.getParameter("id");
        if (id != null) {
            request.setAttribute("meal", mealsToDao.getMealsToId(id));
        }
        request.getRequestDispatcher("/createAndUpdate.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.debug("update meal post");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        mealsToDao.createAndUpdateMeal(request.getParameter("date"),
                request.getParameter("description"),
                request.getParameter("calories"),
                request.getParameter("id"));

        response.sendRedirect("meals");
    }
}