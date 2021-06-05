<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
	
	<div class="container-fluid text-center p-2 bg-dark text-light">
		<h2>Blood Bank</h2>
	</div>
	<div class="conatiner-fluid text-end p-1">
		<a class="btn btn-sm btn-warning" href="/adminLogin">Logout</a>
	</div>
	<p class="p-4"> Hello, ${name} </p>
	
	<div class="container-fluid mx-auto text-left p-4">
    	<div class="row">
    		
    		<div class="col-md-2">
    		
 				
	    		<button type="submit" class="btn btn-sm btn-danger" onclick="bloodcount()">BLOOD COUNT</button>
				
				<br>
				<br>	
		
				
				<button type="submit" class="btn btn-sm btn-success" onclick="requestlist()">REQUEST LIST</button>
				
				
				<br>
				<br>
				
				
				<button type="submit" class="btn btn-sm btn-primary" onclick="donorlist()">DONOR LIST</button>
				
				<br>
				<br>
				
				<button type="submit" class="btn btn-sm btn-secondary" onclick="alllist()">ALL LIST</button>
					
    		</div>
    		
    		<div class="col-md-10">
    			
    			<div class="container" id="bloodcount" style="display: none;">
    			    <h1>Blood Count</h1>
    				<c:forEach var="bcl" items="${bloodcountList}">
    				
    				
    				<span class="p-2 m-2 shadow">A+  : ${bcl.apos} </span>
    				<span class="p-2 m-2 shadow">	B+  : ${bcl.bpos} </span>
    				<span class="p-2 m-2 shadow">	AB+ : ${bcl.abpos}</span>
    				<span class="p-2 m-2 shadow">	O+  : ${bcl.opos} </span>
    				<span class="p-2 m-2 shadow">	A-  : ${bcl.aneg} </span>
    				<span class="p-2 m-2 shadow">	B-  : ${bcl.bneg} </span>
    				<span class="p-2 m-2 shadow">	AB- : ${bcl.abneg}</span>
    				<span class="p-2 m-2 shadow">	O-  : ${bcl.oneg}</span>
    					
    				</c:forEach>
    			</div>
    			
    			<div class="container" id="requestList" style="display: none;">
    				<h1>Request List</h1>
    				<table class="table table-striped" >
    				    
						<c:forEach var="req" items="${requestlist}">
						
							<div class="card col-md-4 p-4 m-2">
								${req.blood_donor_id}
								<span>Requestor Name : ${req.username}</span>
								<span>Mobile Number : ${req.mobilenumber}</span>
								<span>Blood Group : ${req.bloodgroup}</span>
								<span>User ID : ${req.userid}</span>
								<span>Disease : ${req.disease}</span>
								<span>Units : ${req.units}</span>
								<span>Status : ${req.status}</span>
								<div class="d-flex justify-content-center">
									<form  action="/acceptRequest" method="post" class="p-2">
									    <input type="hidden" name="requestid" value="${req.blood_donor_id}">
									    <input type="hidden" name="name" value="${name}">
									    <input type="hidden" name="bloodgroup" value="${req.bloodgroup}">
									    <input type="hidden" name="units" value="${req.units}">
										<button type="submit" class="btn btn-sm btn-success">Accept</button>
									</form>
									<form action="/rejectRequest" method="post" class="p-2">
										<input type="hidden" name="requestid" value="${req.blood_donor_id}">
									    <input type="hidden" name="name" value="${name}">
										<button type="submit" class="btn btn-sm btn-danger">Reject</button>
									</form>
								</div>
								
							</div>
							
						
						</c:forEach>
					</table>
    			</div>
    			
    			<div class="container" id="donorList" style="display: none;">
    				<h1>Donor List</h1>
    				<table class="table table-striped" >
    				    
						<c:forEach var="donor" items="${donorlist}">
						
							<div class="card col-md-4 p-4 m-2">
								<span>Donor Name : ${donor.username}</span>
								<span>Mobile Number : ${donor.mobilenumber}</span>
								<span>Last Blood Donated Date : ${donor.date}</span>
								<span>Blood Group : ${donor.bloodgroup}</span>
								<span>User ID : ${donor.userid}</span>
								<span>Disease : ${donor.disease}</span>
								<span>Status : ${donor.status}</span>
								<div class="d-flex justify-content-center">
									<form  action="/acceptDonor" method="post" class="p-2">
									    <input type="hidden" name="requestid" value="${donor.blood_donor_id}">
									    <input type="hidden" name="name" value="${name}">
									    <input type="hidden" name="bloodgroup" value="${donor.bloodgroup}">
										<button type="submit" class="btn btn-sm btn-success">Accept</button>
									</form>
									<form action="/rejectDonor" method="post" class="p-2">
										<input type="hidden" name="requestid" value="${donor.blood_donor_id}">
									    <input type="hidden" name="name" value="${name}">
										<button type="submit" class="btn btn-sm btn-danger">Reject</button>
									</form>
								</div>
							</div>
							
						
						</c:forEach>
					</table>
    			</div>
    			
    			<div class="container" id="AllList" style="display: none;">
    				
    				<h1>Request List</h1>
    			
    				    
						<c:forEach var="req" items="${requestlistall}">
						
							<div class="card col-md-4 p-4 m-2">
								${req.blood_donor_id}
								<span>Requestor Name : ${req.username}</span>
								<span>Mobile Number : ${req.mobilenumber}</span>
								<span>Blood Group : ${req.bloodgroup}</span>
								<span>User ID : ${req.userid}</span>
								<span>Disease : ${req.disease}</span>
								<span>Units : ${req.units}</span>
								<span>Status : ${req.status}</span>
								
							</div>
							
						
						</c:forEach>
						
						<hr>
						
						<h1>Donor List</h1>
    				<table class="table table-striped" >
    				    
						<c:forEach var="donor" items="${donorlistall}">
						
							<div class="card col-md-4 p-4 m-2">
								<span>Donor Name : ${donor.username}</span>
								<span>Mobile Number : ${donor.mobilenumber}</span>
								<span>Last Blood Donated Date : ${donor.date}</span>
								<span>Blood Group : ${donor.bloodgroup}</span>
								<span>User ID : ${donor.userid}</span>
								<span>Disease : ${donor.disease}</span>
								<span>Status : ${donor.status}</span>
							</div>
							
						
						</c:forEach>
					</table>
				
    			
    			</div>
    		
    		</div>
    		
    	</div>
    </div>		
    		
				
				
	
	

	
	
	
</body>

<script>

    function bloodcount()
    {
    	document.getElementById('bloodcount').style.display = "";
    	document.getElementById('requestList').style.display = "none";
    	document.getElementById('donorList').style.display = "none";
    	document.getElementById('AllList').style.display = "none";
    	
    }
    
    function requestlist()
    {
    	document.getElementById('bloodcount').style.display = "none";
    	document.getElementById('requestList').style.display = "";
    	document.getElementById('donorList').style.display = "none";
    	document.getElementById('AllList').style.display = "none";
    }
    
    function donorlist()
    {
    	document.getElementById('bloodcount').style.display = "none";
    	document.getElementById('requestList').style.display = "none";
    	document.getElementById('donorList').style.display = "";
    	document.getElementById('AllList').style.display = "none";
    }
    
    function alllist()
    {
    	document.getElementById('bloodcount').style.display = "none";
    	document.getElementById('requestList').style.display = "none";
    	document.getElementById('donorList').style.display = "none";
    	document.getElementById('AllList').style.display = "";
    }

</script>

</html>
	
	
