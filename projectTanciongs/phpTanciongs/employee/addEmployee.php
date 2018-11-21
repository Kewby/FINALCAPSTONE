<?php

	include_once ('..\connection.php');   

	$employee_firstname = $_GET['firstName'];
	$employee_lastname = $_GET['lastName'];
	$username = $_GET['username'];
	$password = $_GET['password'];
	$employee_email = $_GET['email'];
	$employee_contactnumber = $_GET['contactNumber'];
	$employee_address = $_GET['address'];

	$conn = getConnection();


	$query = "INSERT INTO `employee` (`employee_id`, `employee_firstname`, `employee_lastname`, `username`, `password`, `employee_email`, `employee_contactnumber`, `employee_address`, `branch_id`, `isAdmin`, `deleteStatus`)
		
		VALUES ('', '".$employee_firstname."', '".$employee_lastname."', '".$username."', '".$password."', 
		'".$employee_email."', '".$employee_contactnumber."', '".$employee_address."', '1', '0', '0')";
			

	echo $query;

	$result = mysqli_query($conn, $query) or die ("ERROR" .mysqli_error($conn));
    
    echo $result;

	?>