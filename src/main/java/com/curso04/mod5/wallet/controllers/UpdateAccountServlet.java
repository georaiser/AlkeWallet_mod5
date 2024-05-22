package com.curso04.mod5.wallet.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso04.mod5.wallet.model.Account;
import com.curso04.mod5.wallet.services.AccountServices;

@WebServlet("/updateAccountServlet")
public class UpdateAccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve updated account details from the request parameters
        int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
        String accountHolder = request.getParameter("accountHolder");
        double accountBalance = Double.parseDouble(request.getParameter("accountBalance"));

        // new Account object with the updated details
        Account updatedAccount = new Account(accountNumber, accountHolder, accountBalance);

        // Use the AccountServices to update the account
        AccountServices accountServices = new AccountServices();
        boolean isUpdated = accountServices.updateAccount(updatedAccount);

        if (isUpdated) {
            // successfully
            response.sendRedirect("processing/accountManager.jsp");
        } else {
            // account update failure
            request.setAttribute("errorMessage", "Failed to update account.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}