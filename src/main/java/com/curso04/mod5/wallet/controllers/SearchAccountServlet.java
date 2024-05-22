package com.curso04.mod5.wallet.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso04.mod5.wallet.model.Account;
import com.curso04.mod5.wallet.services.AccountServices;

/**
 * Servlet implementation class SearchAccountServlet
 */
@WebServlet("/searchAccountServlet")
public class SearchAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("processing/searchAccount.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));

        AccountServices accountServices = new AccountServices();
        Account account = accountServices.searchAccountNumber(accountNumber);

        if (account != null) {
            request.setAttribute("account", account);
            request.getRequestDispatcher("processing/editAccount.jsp").forward(request, response);
        } else {
            // account not found
            request.setAttribute("errorMessage", "Account not found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}