package com.curso04.mod5.wallet.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso04.mod5.wallet.model.User;
import com.curso04.mod5.wallet.services.UserServices;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters from login.jsp (form tag)
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        
        
        // make user type with form parameters
        User user = new User(username, password);
        // user validation Services ----> DAO
        UserServices userServices = new UserServices();
        if(userServices.userValidation(user)) {
        	HttpSession  user_sesion = request.getSession();
        	user_sesion.setAttribute("user", user);
        	response.sendRedirect("processing/walletAdministration.jsp");
        }else {
            response.sendRedirect("error.jsp");
        }
	}

}


