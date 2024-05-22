<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AlkeWallet - Search Account</title>
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
            <div class="col-md-6 offset-md-3">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Search Account</h5>
                        <form action="searchAccountServlet" method="post">
                            <div class="form-group">
                                <label for="accountNumber">Account Number:</label>
                                <input type="text" class="form-control" id="accountNumber" name="accountNumber" required>
                            </div>
                            <button type="submit" class="btn btn-custom">Search</button>
                            <a href="processing/accountManager.jsp" class="btn btn-custom">Return</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>