<?php

  include_once ('..\connection.php');   

  $supplier_id = $_GET['suppID'];
  $supplier_name = $_GET['supplierName'];
  $supplier_address = $_GET['address'];
  $supplier_email = $_GET['email'];
  $supplier_contactnumber = $_GET['contactNumber'];
  $supplier_contactperson = $_GET['contactPerson'];


  $conn = getConnection();


  $query = "UPDATE `supplier` SET supplier_name='".$supplier_name."' , 
          supplier_address='".$supplier_address."' , 
          supplier_email='".$supplier_email."' , 
          supplier_contactnumber='".$supplier_contactnumber."' , 
          supplier_contactperson='".$supplier_contactperson."' , 
          deleteStatus='".$deleteStatus."' WHERE supplier_id = '".$supplier_id."'";
      

  echo $query;

  $result = mysqli_query($conn, $query) or die ("ERROR" .mysqli_error($conn));
    echo $result;

  ?>