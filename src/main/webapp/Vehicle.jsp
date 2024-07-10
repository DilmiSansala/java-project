<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vehicle Registration</title>
    <link rel="stylesheet" href="styles.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style type="text/css">
    	body{
    		background-image:url('transport5.jpg');
    	}
    	.Footercontainer{
		    height: 300px;
	    	max-width: 1170px;
			margin:auto;
		} 
		.Footercontainer .row{
			display: flex;
			flex-wrap: wrap;
		}
		.Footercontainer ul{
			list-style: none;
		}
		.footer{
			background-color: #24262b;
		    padding: 70px 0;
		}
		.footer-col{
		   width: 25%;
		   padding: 0 15px;
		}
		.footer-col h4{
			font-size: 18px;
			color: #ffffff;
			text-transform: capitalize;
			margin-bottom: 35px;
			font-weight: 500;
			position: relative;
		}
		.footer-col h4::before{
			content: '';
			position: absolute;
			left:0;
			bottom: -10px;
			background-color: #e91e63;
			height: 2px;
			box-sizing: border-box;
			width: 50px;
		}
		.footer-col ul li:not(:last-child){
			margin-bottom: 10px;
		}
		.footer-col ul li a{
			font-size: 16px;
			text-transform: capitalize;
			color: #ffffff;
			text-decoration: none;
			font-weight: 300;
			color: #bbbbbb;
			display: block;
			transition: all 0.3s ease;
		}
		.footer-col ul li a:hover{
			color: #ffffff;
			padding-left: 8px;
		}
		.footer-col .social-links a{
			display: inline-block;
			height: 40px;
			width: 40px;
			background-color: rgba(255,255,255,0.2);
			margin:0 10px 10px 0;
			text-align: center;
			line-height: 40px;
			border-radius: 50%;
			color: #ffffff;
			transition: all 0.5s ease;
		}
		.footer-col .social-links a:hover{
			color: #24262b;
			background-color: #ffffff;
		}
    </style>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>

    
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
       <a class="navbar-brand" href="#"><h1>GoConnect</h1></a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="#">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Pricing</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Services</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Contact Us</a>
            </li>
          </ul>
          <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>


    <div class="Ordercontainer">
        <h1>Vehicle Registration</h1><br><br>
        <form id="orderForm" action="OrderServlet" method="post" onsubmit="validateForm(event)">
			<input type="hidden" name="orderid" id="orderidInput" value=""/>

            <div class="form-group">
                <label for="serviceType">Vehicle Type:</label>
                <select id="serviceType" name="type" class="form-control" required>
                    <option value="">Select a service</option>
                    <option value="Car" <c:if test="${vehicle.type == 'Car'}">selected </c:if>>Car</option>
                    <option value="Bike" <c:if test="${vehicle.type == 'Bike'}">selected </c:if>>Bike</option>
                    <option value="Van" <c:if test="${vehicle.type == 'Van'}">selected </c:if>>Van</option>
                    <option value="ThreeWheel" <c:if test="${vehicle.type == 'ThreeWheel'}">selected </c:if>>ThreeWheel</option>
                </select>
            </div>
            <div class="form-group">
                <label for="quantity">Engine Capacity:</label>
                <input type="number" id="quantity" name="quantity" min="1" required value="<c:out value="${vehicle.quantity}"/>">
            </div>
            <div class="form-group">
                <label for="item">Owner Name:</label>
                <input type="text" id="ownerName" name="Fname" required oninput="validateOwnerName(this)" value="<c:out value="${vehicle.name}"/>">
            </div>
            <div class="form-group">
                <label for="item">Address:</label>
                <input type="text" id="item" name="no" required value="<c:out value="${vehicle.address}"/>">
            </div>
            <div class="form-group">
                <label for="item">Phone Number:</label>
                <input type="text" id="phoneNumber" name="email" required oninput="validatePhoneNumber(this)" value="<c:out value="${vehicle.phoneNo}"/>">
            </div>
            <div class="form-group">
                <label for="notes">Chassis Number:</label>
                <input type="text" id="notes" name="notes" value="<c:out value="${vehicle.chassisNo}"/>">
            </div>
            <div class="form-group">
                <label for="notes">Vehicle Number:</label>
                <input type="text" id="notes" name="pick" value="<c:out value="${vehicle.vehicleNo}"/>">
            </div>
            <div class="form-group">
                <label for="notes">Register Date:</label>
                <input type="date" id="notes" name="deliver" value="<c:out value="${vehicle.registerDate}"/>">
            </div>
            <div class="form-group">
                <button type="submit">Confirm</button>
                
            </div>
        </form>
        <div id="message"></div>
    </div>
    
   

    <footer class="footer">
        <div class="Footercontainer">
            <div class="row">
                <div class="footer-col">
                    <h4>company</h4>
                    <ul>
                        <li><a href="#">about us</a></li>
                        <li><a href="#">our services</a></li>
                        <li><a href="#">privacy policy</a></li>
                        <li><a href="#">affiliate program</a></li>
                    </ul>
                </div>
                <div class="footer-col">
                    <h4>get help</h4>
                    <ul>
                        <li><a href="#">FAQ</a></li>
                        <li><a href="#">Complaints</a></li>
                        <li><a href="#">driver details</a></li>
                        <li><a href="#">rider status</a></li>
                        <li><a href="#">payment options</a></li>
                    </ul>
                </div>
               
                <div class="footer-col">
                    <h4>follow us</h4>
                    <div class="social-links">
                        <a href="#"><i class="fab fa-facebook-f"></i></a>
                        <a href="#"><i class="fab fa-twitter"></i></a>
                        <a href="#"><i class="fab fa-instagram"></i></a>
                        <a href="#"><i class="fab fa-linkedin-in"></i></a>
                    </div>
                </div>
            </div>
        </div>
   </footer>
   <script>
    function getUrlParam(name) {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(name);
    }

    const orderidFromUrl = getUrlParam('orderid');

    document.getElementById('orderidInput').value = orderidFromUrl;
    
    function validateOwnerName(input) {
        const ownerName = input.value;
        const containsDigits = /\d/.test(ownerName); 

        if (containsDigits) {
            alert("Owner name cannot contain digits");
            input.value = ''; 
        }
    }

    function validatePhoneNumber(input) {
        const phoneNumber = input.value;
        const containsNonDigits = /\D/.test(phoneNumber); 

        if (containsNonDigits) {
            alert("Phone number cannot contain non-digits");
            input.value = ''; 
        }
    }
    

    function validateForm(event) {
        const phoneNumberInput = document.getElementById("phoneNumber");
        const phoneNumber = phoneNumberInput.value;
        const phoneNumberLength = phoneNumber.replace(/\D/g, '').length; 

        if (phoneNumberLength !== 10) {
            alert("Phone number must have exactly 10 digits");
            phoneNumberInput.value = ''; 
            event.preventDefault(); 
            return false; 
        }

    }


</script>

</body>
</html>