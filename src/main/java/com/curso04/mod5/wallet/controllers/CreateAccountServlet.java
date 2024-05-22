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
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/createAccountServlet")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward to the createAccount.jsp page
        request.getRequestDispatcher("processing/createAccount.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve account details from the request parameters
        int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
        String accountHolder = request.getParameter("accountHolder");
        double accountBalance = Double.parseDouble(request.getParameter("accountBalance"));

        // new Account object
        Account account = new Account(accountNumber, accountHolder, accountBalance);

        // Use the AccountServices to insert the new account
        AccountServices accountServices = new AccountServices();
        boolean isInserted = accountServices.insertAccount(account);

        if (isInserted) {
            response.sendRedirect("processing/accountManager.jsp");
        } else {
            //account creation failure
            request.setAttribute("errorMessage", "Failed to create account.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
