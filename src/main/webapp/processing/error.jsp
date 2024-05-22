<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AlkeWallet - Error</title>
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
            background-color: #444;
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
                        <h5 class="card-title">Error</h5>
                        <p class="text-danger">${errorMessage}</p>
                        <a href="processing/transactionManager.jsp" class="btn btn-custom">Return</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>