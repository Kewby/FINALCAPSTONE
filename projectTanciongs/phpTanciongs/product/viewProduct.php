<?php
	
	include_once ('..\connection.php');   

	$conn = getConnection();
	
	$query =  "SELECT product_code AS 'Product Code', product_name AS 'Product Name', (SELECT category.category_name FROM `category` WHERE product.category_id = category.category_id) AS 'Product Category', (CASE WHEN product_type = 'true' THEN 'Non-Agricultural' ELSE 'Agricultural' END) AS'Product Type', standard_cost AS 'Standard Cost', markup_cost AS 'Markup Cost', list_price AS 'List Price' FROM `product` WHERE deleteStatus = 0";


	if($result=mysqli_query($conn, $query)){

		$fp = fopen('viewProduct.json', 'w'); 
		fwrite($fp, '{"data":[');

		while ($r = mysqli_fetch_assoc($result)) {
		//	$rows['product_id'] = $r['product_id'];
			$rows['product_code'] = $r['Product Code'];
			$rows['product_name'] = $r['Product Name'];
			$rows['product_type'] = $r['Product Type'];
			$rows['standard_cost'] = $r['Standard Cost'];
			$rows['markup_cost'] = $r['Markup Cost'];
			$rows['list_price'] = $r['List Price'];
			$rows['category_id'] = $r['Product Category'];
			

			fwrite($fp, json_encode($rows));
		}

		fwrite($fp, "]}");
		fclose($fp);
	}


	?>