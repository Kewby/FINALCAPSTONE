<?php
	
	include_once ('..\connection.php');   

	$conn = getConnection();

	$query = "SELECT employee_id AS 'ID Number',employee_firstname AS 'First Name', employee_lastname AS 'Last Name', username AS 'Username', employee_email AS 'Email', employee_contactnumber AS 'Contact Number', employee_address AS 'Address', (CASE WHEN isAdmin = '0' THEN 'Cashier' ELSE 'Admin' END) AS Role, (SELECT branch.branch_name FROM `branch` WHERE employee.branch_id = branch.branch_id) AS 'Branch' FROM `employee` WHERE isAdmin=0 AND deleteStatus=0";

	if($result=mysqli_query($conn, $query)){

		$fp = fopen('viewEmployee.json', 'w'); 
		fwrite($fp, '{"data":[');

		while ($r = mysqli_fetch_assoc($result)) {
			$rows['employee_id'] = $r['ID Number'];
			$rows['employee_firstname'] = $r['First Name'];
			$rows['employee_lastname'] = $r['Last Name'];
			$rows['username'] = $r['Username'];
			$rows['employee_email'] = $r['Email'];
			$rows['employee_contactnumber'] = $r['Contact Number'];
			$rows['employee_address'] = $r['Address'];
			$rows['branch_id'] = $r['Branch'];
			$rows['isAdmin'] = $r['Role'];
			

			fwrite($fp, json_encode($rows));
		}

		fwrite($fp, "]}");
		fclose($fp);
	}


	?>