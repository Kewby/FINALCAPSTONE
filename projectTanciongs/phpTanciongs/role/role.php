<?php 

  include_once ('..\connection.php'); 

  $query = "SELECT role_name FROM `role`";


    if($result=mysqli_query($conn,$query)){

      $fp = fopen('role.json', 'w');
      fwrite($fp, '{"data":[');

    while ($r=mysqli_fetch_assoc($result)) {
      //$rows['role_id'] = $r['role_id'];
      $rows['role_name'] = $r['role_name']; 
      
      fwrite($fp, json_encode($rows));
    }

    fwrite($fp, "]}");
    fclose($fp);

  }
?>