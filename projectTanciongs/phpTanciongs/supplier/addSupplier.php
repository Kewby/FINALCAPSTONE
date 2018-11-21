<?php

	include_once ('..\connection.php');   

	$supplier_name = $_GET['supplierName'];
	$supplier_address = $_GET['address'];
	$supplier_email = $_GET['email'];
	$supplier_contactnumber = $_GET['contactNumber'];
	$supplier_contactperson = $_GET['contactPerson'];


	$conn = getConnection();


	$query = "INSERT INTO `supplier` (`supplier_id`, `supplier_name`, `supplier_address`, `supplier_email`, 
	`supplier_contactnumber`, `supplier_contactperson`, `deleteStatus`)
		
		VALUES ('', '".$supplier_name."', '".$supplier_address."', '".$supplier_email."', 
		'".$supplier_contactnumber."', '".$supplier_contactperson."', '0')";
			

	echo $query;

	$result = mysqli_query($conn, $query) or die ("ERROR" .mysqli_error($conn));
    echo $result;

	?>