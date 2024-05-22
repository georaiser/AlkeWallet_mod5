<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AlkeWallet - Administration</title>
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
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Account Manager</h5>
                        <p class="card-text">Manage your bank accounts.</p>
                        <a href="accountManager.jsp" class="btn btn-custom">Go to Account Manager</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Customer Manager</h5>
                        <p class="card-text">Manage your customer data.</p>
                        <a href="customerManager.jsp" class="btn btn-custom">Go to Customer Manager</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">Transaction Manager</h5>
                        <p class="card-text">Perform banking transactions.</p>
                        <a href="transactionManager.jsp" class="btn btn-custom">Go to Transaction Manager</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>