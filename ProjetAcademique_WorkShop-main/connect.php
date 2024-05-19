<?php
try {
	// Sous WAMP
$bdd = new PDO('mysql:host=localhost;dbname=workshop;charset=utf8', 'root', '');
}
catch(Exception $e)
{
	die('Erreur : ' . $e->getMessage());
}

?>;