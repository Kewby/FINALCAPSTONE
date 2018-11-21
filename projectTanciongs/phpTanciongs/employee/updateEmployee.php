<?php

	include_once ('..\connection.php');   
	
	$employee_id = $_GET['empID'];
	$employee_firstname = $_GET['firstName'];
	$employee_lastname = $_GET['lastName'];
	$username = $_GET['username'];
	$password = $_GET['password'];
	$employee_email = $_GET['email'];
	$employee_contactnumber = $_GET['contactNumber'];
	$employee_address = $_GET['address'];
	$isAdmin = $_GET['role'];


	$conn = getConnection();
	

	$query = "UPDATE `employee` SET employee_firstname='".$employee_firstname."', 
			employee_lastname='".$employee_lastname."', 
			username='".$username."', 
			password='".$password."', 
			employee_email='".$employee_email."', 
			employee_contactnumber='".$employee_contactnumber."', 
			employee_address='".$employee_address."', 
			isAdmin='".$isAdmin."' WHERE employee_id = '".$employee_id."'";
			
			
		echo $query;

		$result = mysqli_query($conn, $query) or die ("ERROR" .mysqli_error($conn));
    	echo $result;

	?>