<?php 

	$username = $_GET['username'];
	$password = $_GET['password'];
	

			$fp = fopen('login.json', 'w');
			fwrite($fp, '{"data":[');

			
			$sample['fullname'] = $username ."<space>". $password ;
		

			fwrite($fp, json_encode($sample));
			fwrite($fp, "]}");
			fclose($fp);


echo "HELLO WORLD";
?>