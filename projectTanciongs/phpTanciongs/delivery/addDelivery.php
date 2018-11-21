<?php

	include_once ('..\connection.php'); 

	$delivery_id = $_GET['DeliveryId'];
	$delivery_datetime = $_GET['dateTime'];
	$product_id = $_GET['ProductId'];
	$delivery_unitprice = $_GET['unitprice'];
	$delivery_numberofunits = $_GET['numberOfUnits'];
	$delivery_unitofmeasure = $_GET['unitOfMeasure'];
	$delivery_totalcostamount = $_GET['totalAmount'];
	$supplier_id = $_GET['SupplierId'];
	$branch_id = $_GET['BranchId'];
	$employee_id = $_GET['EmployeeId'];
	$delDeleteStatus = $_GET['deleteStatus'];

	//$conn = getConnection();

	$query = "INSERT INTO `delivery` (`delivery_id`, `delivery_datetime`, `product_id`, `delivery_unitprice`, `delivery_numberofunits`, 
			`delivery_unitofmeasure`, `supplier_id`, `branch_id`, `employee_id`, `deleteStatus`) 
			VALUES ('', CURRENT_TIMESTAMP , '".$delProduct."', '".$delUnitPrice."', '".$delNumberofUnits."', '".$delUnitOfMeasure."', '".$delTotal."', '".$delSupplier."', '".$delBranch."', '".$delEmployee."', '".$delDeleteStatus."')";

	//echo $query;

	$result = mysqli_query($conn, $query) or die ("ERROR" .mysqli_error($conn));
    //echo $result; 

?>