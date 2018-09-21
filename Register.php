<?php
    $con = mysqli_connect("localhost", "id7213647_jpmo_77", "qwerty", "id7213647_weightlossapp");
    
    $name = $_POST["name"];
    $age = $_POST["age"];
    $username = $_POST["username"];
    $weight = $_POST["weight"];
	$height = $_POST["height"];
	$password = $_POST["password"];
	

    $statement = mysqli_prepare($con, "INSERT INTO User (name, username, age, weight, height, password) VALUES (?, ?, ?, ?, ?, ?)");
    mysqli_stmt_bind_param($statement, "ssidds", $name, $username, $age, $weight, $height, $password);
    mysqli_stmt_execute($statement);
    
    $response = array();
    $response["success"] = true;  
    
    echo json_encode($response);
?>
