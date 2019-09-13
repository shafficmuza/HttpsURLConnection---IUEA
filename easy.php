<?php
// including the database connection file
/*******************************************************
// defing database connection parameters
$host = "localhost";
$dbuser = "root";
$dbpassword = "";
$db_name = "iuea";

// connecting to the database
$link = mysql_connect($host,$dbuser,$dbpassword) or die("Cant connect to the server".mysql_error());

// select the mysql database gto use
$dbselect = mysql_select_db($db_name) or die("Failed to select database: ".mysql_error());

**********************************************************/
//include('config.php');

// defing database connection parameters
$host = "localhost";
$dbuser = "smsvibe_admin";
$dbpassword = "Qazxsw@123";
$db_name = "smsvibe_iuea";

// connecting to the database
$link = mysql_connect($host,$dbuser,$dbpassword) or die("Cant connect to the server".mysql_error());

// select the mysql database gto use
$dbselect = mysql_select_db($db_name) or die("Failed to select database: ".mysql_error());


// function to sanitize values
function clean($str) {
    $str = @trim($str);
    $str = htmlspecialchars($str);
    if(get_magic_quotes_gpc()) {
        $str = stripslashes($str);
    }
    return mysql_real_escape_string($str);
}

// calling html form paraters
$name = clean($_POST['name']);
$course = clean($_POST['course']);
$semester = clean($_POST['semester']);
$year = clean($_POST['year']);

// inserting data in the database table

$qry = mysql_query("insert into users (name,course,semester,year) 
values ('$name','$course','$semester','$year')")
or die("Error while inserting data in the table".mysql_error());

if($qry){

echo "Data inserted succesffuly ";
//header("Location: form.php");
}

?>
