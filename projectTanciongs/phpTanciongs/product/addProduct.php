<?php

	include_once ('..\connection.php');

	$product_code = $_GET['productCode'];
	$product_name = $_GET['productName'];
	$product_type = $_GET['productType'];
	$category = $_GET['category'];
	$standard_cost = $_GET['standardCost'];
	$markup_cost = $_GET['markupCost'];


	$conn = getConnection();


	$query = "INSERT INTO `product` (`product_id`, `product_code`, `product_name`, `product_type`, `category_id`, `standard_cost`, `markup_cost`, `branch_id`, `deleteStatus`)
		VALUES (' ', '".$product_code."', '".$product_name."', '".$product_type."', (SELECT category.category_id FROM `category` WHERE category.category_name = '".$category."' LIMIT 1), '".$standard_cost."', '".$markup_cost."', '1','0')";
			
	echo $query;
	$result = mysqli_query($conn, $query) or die ("ERROR" .mysqli_error($conn));
    echo $result;

	?>