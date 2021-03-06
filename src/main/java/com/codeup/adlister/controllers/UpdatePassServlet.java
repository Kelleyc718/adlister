package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "update", urlPatterns = "/update-pass")
public class UpdatePassServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("url", "/update-pass");
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/update-pass.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");


        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        // validate input
        boolean inputHasErrors = password.isEmpty() || (! password.equals(passwordConfirmation));

        if (inputHasErrors) {
            request.setAttribute("message", "The passwords did not match.");
            response.sendRedirect("/update-pass");
            return;
        }

        user.setPassword(password);
        DaoFactory.getUsersDao().updatePassword(user);
        request.setAttribute("confirmation", "Your password was updated successfully.");
        response.sendRedirect("/profile");
    }
}


