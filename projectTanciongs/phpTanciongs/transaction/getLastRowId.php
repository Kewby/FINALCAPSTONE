<?php 

  include_once ('..\connection.php'); 

  $query = "SELECT * FROM `transaction`";


    if($result=mysqli_query($conn,$query)){

      $fp = fopen('transaction.json', 'w');
      fwrite($fp, '{"data":[');

    while ($r=mysqli_fetch_assoc($result)) {
      $rows['transaction_id'] = $r['transaction_id'];
      $rows['transaction_datetime'] = $r['transaction_datetime']; 
      $rows['transaction_tender'] = $r['transaction_tender']; 
      $rows['transaction_change'] = $r['transaction_change']; 
      $rows['employee_id'] = $r['employee_id']; 
      $rows['transaction_grandtotal'] = $r['transaction_grandtotal']; 
      
      fwrite($fp, json_encode($rows));
    }

    fwrite($fp, "]}");
    fclose($fp);

  }
?>