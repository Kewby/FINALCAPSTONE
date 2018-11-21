<?php

  include_once ('..\connection.php');   

  $supplier_id = $_GET['SupplierID'];
  $supplier_name = $_GET['supName'];
  $supplier_address = $_GET['supAdd'];
  $supplier_email = $_GET['supEmail'];
  $supplier_contactnumber = $_GET['supNumber'];
  $supplier_contactperson = $_GET['supPerson'];
  $deleteStatus = $_GET['delstatus'];


  $conn = getConnection();


  $query = "UPDATE `supplier` SET deleteStatus = 1 WHERE supplier_id = '".$supplier_id."'";
      

  echo $query;

  $result = mysqli_query($conn, $query) or die ("ERROR" .mysqli_error($conn));
    echo $result;

  ?>