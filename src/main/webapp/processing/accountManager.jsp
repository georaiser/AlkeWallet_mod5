<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AlkeWallet - Account Manager</title>
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
            margin-right: 30px;
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
                        <h5 class="card-title">Account Manager</h5>
                        <div class="btn-group" role="group">
                            <a href="${pageContext.request.contextPath}/listAccountsServlet" class="btn btn-custom">List All Accounts</a>
                            <a href="${pageContext.request.contextPath}/searchAccountServlet" class="btn btn-custom">Search/Edit Account</a>
                            <a href="${pageContext.request.contextPath}/createAccountServlet" class="btn btn-custom">Create Account</a>
                            <a href="walletAdministration.jsp" class="btn btn-custom">Return</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>