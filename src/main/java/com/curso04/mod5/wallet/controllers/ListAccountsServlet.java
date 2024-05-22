package com.curso04.mod5.wallet.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso04.mod5.wallet.model.Account;
import com.curso04.mod5.wallet.services.AccountServices;

/**
 * Servlet implementation class ListAccountsServlet
 */	

@WebServlet("/listAccountsServlet")
public class ListAccountsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountServices accountServices = new AccountServices();
        List<Account> accountList = accountServices.listAccount();

        request.setAttribute("accountList", accountList);
        request.getRequestDispatcher("processing/accountList.jsp").forward(request, response);
    }
}
	
	
