package com.curso04.mod5.wallet.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso04.mod5.wallet.model.Account;
import com.curso04.mod5.wallet.services.AccountServices;

@WebServlet("/withdrawalServlet")
public class WithdrawalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("processing/withdrawal.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int accountNumber = Integer.parseInt(request.getParameter("accountNumber"));
        double withdrawalAmount = Double.parseDouble(request.getParameter("withdrawalAmount"));

        AccountServices accountServices = new AccountServices();
        Account account = accountServices.searchAccountNumber(accountNumber);

        if (account != null) {
            double currentBalance = account.getAccountBalance();
            if (withdrawalAmount <= currentBalance) {
                double newBalance = currentBalance - withdrawalAmount;
                account.setAccountBalance(newBalance);
                boolean isUpdated = accountServices.updateAccount(account);

                if (isUpdated) {
                    request.setAttribute("successMessage", "Withdrawal successful. New balance: " + newBalance);
                    request.getRequestDispatcher("processing/transactionManager.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "Failed to perform withdrawal.");
                    request.getRequestDispatcher("processing/error.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "Insufficient balance for withdrawal.");
                request.getRequestDispatcher("processing/error.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorMessage", "Account not found.");
            request.getRequestDispatcher("processing/error.jsp").forward(request, response);
        }
    }
}