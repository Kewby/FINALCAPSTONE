<?php
	
	include_once ('..\connection.php'); 

	$conn = getConnection(); 

	$query = "SELECT supplier_name AS 'Supplier Name', supplier_address AS 'Address', supplier_email AS 'Email', supplier_contactnumber AS 'Contact Number', supplier_contactperson AS 'Contact Person' FROM `supplier` WHERE deleteStatus=0";

	if($result=mysqli_query($conn, $query)){

		$fp = fopen('viewSupplier.json', 'w'); 
		fwrite($fp, '{"data":[');

		while ($r = mysqli_fetch_assoc($result)) {
			$rows['supplier_name'] = $r['Supplier Name'];
			$rows['supplier_address'] = $r['Address'];
			$rows['supplier_email'] = $r['Email'];
			$rows['supplier_contactnumber'] = $r['Contact Number'];
			$rows['supplier_contactperson'] = $r['Contact Person'];

			fwrite($fp, json_encode($rows));
		}

		fwrite($fp, "]}");
		fclose($fp);
	}


	?>