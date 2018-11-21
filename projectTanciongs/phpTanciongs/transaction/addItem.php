<?php

	include_once ('..\connection.php');   

	$transactionItem_id = $_GET['TransactionItemId']
	$transaction_id = $_GET['TransactionID'];
	$product_id = $_GET['productId'];
	$transactionItem_qty = $_GET['qty'];
	$transactionItem_unitprice = $_GET['unitprice'];
	$transactionItem_subtotal = $_GET['subtotal'];



	$conn = getConnection();


	$query = "INSERT INTO `transactionItem` (`transaction_id`, `product_id`, `transactionItem_qty`, `transactionItem_unitprice`)
		
		VALUES ('transaction.'".$transaction_id."', '".$transaction_tender."', '".$transaction_change."', '".$employee_id."', '".$transaction_grandtotal."')";
			

	echo $query;

	$result = mysqli_query($conn, $query) or die ("ERROR" .mysqli_error($conn));
    echo $result;

	?>