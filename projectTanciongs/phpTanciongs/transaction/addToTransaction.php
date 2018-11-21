<?php

	include_once ('..\connection.php');   

	$transaction_id = $_GET['TransactionID'];
	$transaction_datetime = $_GET['TransactionDateTime'];
	$transaction_tender = $_GET['tender'];
	$transaction_change = $_GET['change'];
	$employee_id = $_GET['EmployeeId'];
	$transaction_grandtotal = $_GET['grandtotal'];



	$conn = getConnection();


	$query = "INSERT INTO `transaction` (`transaction_datetime`, `transaction_tender`, `transaction_change`, `employee_id`, `transaction_grandtotal`)
		
		VALUES ('CURRENT_TIMESTAMP', '".$transaction_tender."', '".$transaction_change."', '".$employee_id."', '".$transaction_grandtotal."')";
			

	echo $query;

	$result = mysqli_query($conn, $query) or die ("ERROR" .mysqli_error($conn));
    echo $result;

	?>