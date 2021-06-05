<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
</head>
<body>

	<div class="container-fluid text-center p-2 bg-dark text-light">
		<h2>Blood Bank</h2>
	</div>
	<div class="conatiner-fluid text-end p-1">
		<a class="btn btn-sm btn-warning" href="/userLogin">Logout</a>
	</div>

    <div class="container-fluid mx-auto text-left p-4">
    	<div class="row">
    		
    		<div class="col-md-2">
    			<button class="btn btn-sm btn-danger" onclick="requestblood()">REQUEST BLOOD</button>
	
				<br>
				<br>	
		
				<button class="btn btn-sm btn-success" onclick="saveblood()">DONATE BLOOD</button>
				
				<br>
				<br>
				
				<button class="btn btn-sm btn-primary" onclick="searchblood()">SEARCH DONOR</button>
				
				<br>
				<br> 
				
				<button class="btn btn-sm btn-secondary" onclick="history()">VIEW HISTORY</button>
    		</div>
    		
    		<div class="col-md-10">
    		
    			<div class="p-4">
				    <h4 class="text-secondary">Profile</h4>
    				User Name : ${name} <br>
					User Id : ${userid} <br>
				    Mobile Number : ${mobilenumber} <br>
				
    			</div>
    			
				
				<div class="col-md-3 p-2" id = "saveblood" style="display: none;">
					<form action="/saveblood" method="post">
					<h3>Donate Blood</h3>
					<input type="hidden" name="username" value="${name}">
					<input type="hidden" name="userid" value="${userid}">
					<input type="hidden" name="mobilenumber" value="${mobilenumber}">
					<input class="form-control" type="text" name="disease" placeholder="Disease"> 
					<br>
					<select class="form-control" name="bloodgroup" placeholder="Blood Group">
					  <option value="A+">A+</option>
					  <option value="A-">A-</option>
					  <option value="B+">B+</option>
					  <option value="B-">B-</option>
					  <option value="AB+">AB+</option>
					  <option value="AB-">AB-</option>
					  <option value="O+">O+</option>
					  <option value="O-">O-</option>
					</select>
					<br>
					<button class="btn btn-sm btn-success" type="submit">Donate</button>
				</form>
	      </div>
	
	
	
	<div class="col-md-3 p-2" id = "requestblood" style="display: none;">
		<form action="/requestblood" method="post">
			<h3>Request Blood</h3>
			<input type="hidden" name="username" value="${name}">
			<input type="hidden" name="userid" value="${userid}">
			<input type="hidden" name="mobilenumber" value="${mobilenumber}">
			<input class="form-control" type="text" name="disease" placeholder="Disease"> <br>
			
			<input class="form-control" type="text" name="units" placeholder="Units"> <br>
			
			<select class="form-control" name="bloodgroup">
			  <option value="A+">A+</option>
			  <option value="A-">A-</option>
			  <option value="B+">B+</option>
			  <option value="B-">B-</option>
			  <option value="AB+">AB+</option>
			  <option value="AB-">AB-</option>
			  <option value="O+">O+</option>
			  <option value="O-">O-</option>
			</select>
			<br>
			<button class="btn btn-sm btn-danger" type="submit">Request</button>
		</form>
	</div>	
	
	
	<div class="col-md-3 p-2" id = "searchblood" style="display: none;">
		<form action="/searchdonor" method="post">
		    <h3>Search Blood</h3>
			<input type="hidden" name="username" value="${name}">
			<input type="hidden" name="userid" value="${userid}">
			<input type="hidden" name="mobilenumber" value="${mobilenumber}">
			<select class="form-control" name="bloodgroup">
			   <option value="A+">A+</option>
			  <option value="A-">A-</option>
			  <option value="B+">B+</option>
			  <option value="B-">B-</option>
			  <option value="AB+">AB+</option>
			  <option value="AB-">AB-</option>
			  <option value="O+">O+</option>
			  <option value="O-">O-</option>
			</select>
			<br>
			<button class="btn btn-sm btn-primary" type="submit">Search</button>
		</form>
	</div>	
	
	<div class="p-4" id="donortable" style="display:none;">
		<table class="table table-striped" >
			<c:forEach var="donor" items="${donorlist}">
			
				<div class="card col-md-4 p-4 m-2 d-flex justify-content-around">
					<span>Donor Name : ${donor.username}</span>
					<span>Mobile Number : ${donor.mobilenumber}</span>
					<span>Last Blood Donated Date : ${donor.date}</span>
				</div>
				
				
				
			</c:forEach>
		</table>
	</div>

	<div class="p-4" id="history" style="display:none;">
	
	    <h3>Request History</h3>
			<c:forEach var="req" items="${request}">
				
					<div class="card col-md-4 p-4 m-2 d-flex justify-content-around">
						<span>Name : ${req.username}</span>
						<span>Last Blood Donated req : ${req.date}</span>
						<span>Donation ID : ${req.blood_donor_id}</span>
						<span>BloodGroup : ${req.bloodgroup}</span>
						<span>Disease : ${req.disease}</span>
						<span>Units : ${req.units} </span>
						<span>Status: ${req.status}</span>
					</div>		
					
			</c:forEach>
		<hr>
		
		<h3>Donor History</h3>
		
		<c:forEach var="req" items="${donor}">
				
					<div class="card col-md-4 p-4 m-2 d-flex justify-content-around">
						<span>Name : ${req.username}</span>
						<span>Last Blood Donated req : ${req.date}</span>
						<span>Donation ID : ${req.blood_donor_id}</span>
						<span>BloodGroup : ${req.bloodgroup}</span>
						<span>Disease : ${req.disease}</span>
						<span>Status: ${req.status}</span>
					</div>		
					
			</c:forEach>
		
	</div>
	
				
				
    		</div>
    	</div>
    	
    </div>
	
	
	
</body>

<script>

    function requestblood()
    {
    	document.getElementById('requestblood').style.display = "";
    	document.getElementById('saveblood').style.display = "none";
    	document.getElementById('searchblood').style.display = "none";
    	document.getElementById('donortable').style.display = "none";
    	document.getElementById('history').style.display = "none";
    }
    
    function saveblood()
    {
    	document.getElementById('requestblood').style.display = "none";
    	document.getElementById('saveblood').style.display = "";
    	document.getElementById('searchblood').style.display = "none";
    	document.getElementById('donortable').style.display = "none";
    	document.getElementById('history').style.display = "none";
    	
    }
    
    function searchblood()
    {
    	document.getElementById('requestblood').style.display = "none";
    	document.getElementById('saveblood').style.display = "none";
    	document.getElementById('searchblood').style.display = "";
    	document.getElementById('donortable').style.display = "";
    	document.getElementById('history').style.display = "none";
    }
    
    function history()
    {
    	document.getElementById('requestblood').style.display = "none";
    	document.getElementById('saveblood').style.display = "none";
    	document.getElementById('searchblood').style.display = "none";
    	document.getElementById('donortable').style.display = "none";
    	document.getElementById('history').style.display = "";
    }

</script>

</html>