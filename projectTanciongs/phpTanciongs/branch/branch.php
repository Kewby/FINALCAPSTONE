<?php 

  include_once ('..\connection.php'); 

  $query = "SELECT branch_name FROM `branch`";


    if($result=mysqli_query($conn,$query)){

      $fp = fopen('branch.json', 'w');
      fwrite($fp, '{"data":[');

    while ($r=mysqli_fetch_assoc($result)) {
      //$rows['branch_id'] = $r['branch_id'];
      $rows['brach_name'] = $r['branch_name']; 
      
      fwrite($fp, json_encode($rows));
    }

    fwrite($fp, "]}");
    fclose($fp);

  }
?>