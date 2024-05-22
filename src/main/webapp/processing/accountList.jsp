<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AlkeWallet - Account List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #323232;
            color: #fff;
        }
        .container {
            max-width: 960px;
            margin-top: 50px;
        }
        .card {
            box-shadow: 0 0.5rem 1rem rgba(255, 255, 255, 0.15);
            background-color: #222;
        }
        .card-title {
            font-weight: bold;
        }
        .btn-custom {
            background-color: #007bff;
            color: #fff;
            margin-bottom: 10px;
        }
        @media (max-width: 767px) {
            .container {
                max-width: 100%;
                padding: 0 15px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Account List</h5>
                        <a href="processing/accountManager.jsp" class="btn btn-custom">Return</a>
                        <table class="table table-striped table-dark">
                            <thead>
                                <tr>
                                    <th>Account Number</th>
                                    <th>Account Holder</th>
                                    <th>Account Balance</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${accountList}" var="account">
                                    <tr>
                                        <td>${account.accountNumber}</td>
                                        <td>${account.accountHolder}</td>
                                        <td>${account.accountBalance}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

