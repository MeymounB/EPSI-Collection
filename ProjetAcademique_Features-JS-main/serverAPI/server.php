<?php
$content = trim(file_get_contents("php://input"));
$decoded = json_decode($content, true);

$username = $decoded["username"];
$password = $decoded["password"];

$result = array();
if ($username == "toto" && $password == "p@ssw0rd") {
    $result["result"] = "OK";
} else {
    $result["result"] = "NOT OK";
}

echo json_encode($result);

?>