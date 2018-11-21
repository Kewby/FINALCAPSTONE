<?php 

  include_once ('..\connection.php'); 

  $query = "SELECT * FROM `stock`";


    if($result=mysqli_query($conn,$query)){

      $fp = fopen('viewStock.json', 'w');
      fwrite($fp, '{"data":[');

    while ($r=mysqli_fetch_assoc($result)) {
      $rows['stock_id'] = $r['branch_id'];
      $rows['product_id'] = $r['product_id']; 
      $rows['stock_onhand'] = $r['stock_onhand'];
      $rows['branch_id'] = $r['branch_id'];
      $rows['deleteStatus'] = $r['deleteStatus'];
      
      fwrite($fp, json_encode($rows));
    }

    fwrite($fp, "]}");
    fclose($fp);

  }
?>