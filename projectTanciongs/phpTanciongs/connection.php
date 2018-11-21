<!--database connection-->
 <?php
function getConnection(){
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "dbtanciongs";

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed:" . mysqli_connect_error());
}else{

}
return $conn;
}