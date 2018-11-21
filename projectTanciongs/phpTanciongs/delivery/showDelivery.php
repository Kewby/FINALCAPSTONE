<?php
    //session start();
    include_once ('..\connection.php');  

     $query = "SELECT DATE_FORMAT(delivery_datetime, '%y-%m-%d') AS 'Date Delivery' ,"
                + "(SELECT product.product_name FROM `product` WHERE delivery.product_id = product.product_id) AS 'Product Name' ,"
                + "delivery_unitprice AS 'Unit Price' ,"
                + "delivery_numberofunits AS 'No of Units' ,"
                + "delivery_unitofmeasure AS 'Unit of Measure' ,"
                + "delivery_totalcostamount AS 'Total Purchase',"
                + "(SELECT supplier.supplier_name FROM `supplier` WHERE delivery.supplier_id = supplier.supplier_id) AS 'Supplier' ,"
                + "(SELECT branch.branch_name FROM `branch` WHERE delivery.branch_id = branch.branch_id) AS 'Branch Delivered' ,"
                + "(SELECT employee.username FROM `employee` WHERE delivery.employee_id = employee.employee_id) AS 'Employee' FROM `delivery` WHERE branch_id=1 AND isAdmin=0 AND deleteStatus=0 ORDER BY delivery_datetime DESC"; */

    //$query = "SELECT * FROM `delivery`";

    if($result=mysqli_query($conn, $query)){

        $fp =  fopen('showDelivery.json', 'w'); 
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