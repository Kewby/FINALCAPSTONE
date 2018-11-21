<?php
    //session start();
    include_once ('..\connection.php'); 

    /*$query = "SELECT delivery_datetime AS 'Date Delivery' , "
                + "(SELECT product.product_name FROM `product` WHERE delivery.product_id = product.product_id) AS 'Product Name' , "
                + "delivery_unitprice AS 'Unit Price' , "
                + "delivery_numberofunits AS 'Number of Units' , "
                + "delivery_unitofmeasure AS 'Unit of Measure' , "
                + "delivery_totalcostamount AS 'Total Cost' ,  "
                + "(SELECT supplier.supplier_name FROM `supplier` WHERE delivery.supplier_id = supplier.supplier_id) AS 'Suppler' , "
                + "(SELECT branch.branch_name FROM `branch` WHERE delivery.branch_id = branch.branch_id) AS 'Branch Delivered' , "
                + "(SELECT employee.username FROM `employee` WHERE delivery.employee_id = employee.employee_id) AS 'Received by' "
                + "FROM `delivery` WHERE DATE_FORMAT(delivery_datetime, '%y-%m-%d') = DATE_FORMAT(CURRENT_TIMESTAMP, '%y-%m-%d') AND deleteStatus = 0";*/

    $query = "SELECT * FROM `delivery`";


    if($result=mysqli_query($conn, $query)){

        $fp =  fopen('currentDelivery.json', 'w'); 
        fwrite($fp, '{"data":[');

        while ($r = mysqli_fetch_assoc($result)) {
            $rows['delivery_id'] = $r['delivery_id'];
            $rows['delivery_datetime'] = $r['delivery_datetime'];
            $rows['product_id'] = $r['product_id'];
            $rows['delivery_unitprice'] = $r['delivery_unitprice'];
            $rows['delivery_numberofunits'] = $r['delivery_numberofunits'];
            $rows['delivery_unitofmeasure'] = $r['delivery_unitofmeasure'];
            $rows['delivery_totalcostamount'] = $r['delivery_totalcostamount'];
            $rows['supplier_id'] = $r['supplier_id'];
            $rows['branch_id'] = $r['branch_id'];
            $rows['employee_id'] = $r['employee_id'];
            $rows['deleteStatus'] = $r['deleteStatus'];


            fwrite($fp, json_encode($rows));
        }

        fwrite($fp, "]}");
        fclose($fp);
    }


    ?>