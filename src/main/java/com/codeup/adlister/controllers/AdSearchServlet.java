package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "search", urlPatterns = "/search")
public class AdSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }

        String search = "%" + request.getParameter("search") + "%";
        List<Ad> ads = DaoFactory.getAdsDao().findBy(search);
        if(ads.isEmpty()) {
            request.getSession().setAttribute("message", "Sorry, please edit your " +
                    "search and try again.");
        response.sendRedirect("/ads");
            return;
        }

        request.setAttribute("ads", ads);
        request.getRequestDispatcher("/WEB-INF/ads/search.jsp").forward(request, response);
    }

}
