<!DOCTYPE html>
<html lang="fr">

<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Inscription WorkShop B2</title>
	<link rel="stylesheet" href="../WorkShop/css/style.css">
	<link rel="stylesheet" href="../WorkShop/css/style_connexion.css">
</head>

<?php

// define variables and set to empty values
$passErr = $emailErr = $pseudoErr = "";
$pass = $email = $pseudo = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	if (empty($_POST["email"])) {
		$emailErr = "L'adresse mail est necessaire";
	      } else {
		$email = test_input($_POST["email"]);
		// check if e-mail address is well-formed
		if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
		  $emailErr = "Le format de l'adresse mail est invalide";
		}
	      }
	if (empty($_POST["pass"])) {
	$passErr = "Le mot de passe est necessaire";
	} else {
	$pass = test_input($_POST["pass"]);
	// check if pass is well-formed
	if (!preg_match("/^[a-zA-Z-' ]*$/", $pass)) {
		$passErr = "Le format du mot de passe est invalide";
	}
	}
	if (empty($_POST["pseudo"])) {
		$pseudoErr = "Le pseudo est necessaire";
		} else {
		$pseudo = test_input($_POST["pseudo"]);
		// check if pseudo is well-formed
		if (!preg_match("/^[a-zA-Z-' ]*$/", $pseudo)) {
			$pseudoErr = "Le format du pseudo est invalide";
		}
		}
}	

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	$pseudo = test_input($_POST["pseudo"]);
	$pass = test_input($_POST["pass"]);
	$email = test_input($_POST["email"]);
	}

	function test_input($data) {
	$data = trim($data);
	$data = stripslashes($data);
	$data = htmlspecialchars($data);
	return $data;
	}

?>

<style>
.error {color: #FF0000;}
</style>

<body>

		<div class="ecran">
		<h1 class="titre">Hello Welcome</h1>

			<p><span class="error">* champs requis</span></p>

			<div id="container_connexion" class="ls-0_5 taille_border">
			<form action="" method="POST">

				<div class="form_container2 taille_border">
						<label for="pseudo" id="text_pass">Entrez votre pseudo : </label>
							<input type="text" name="pseudo" id="pass" placeholder="  Pseudo :" 
							maxlength="40" required
							value ="<?php echo $pseudo;?>"><span class="error">* <?php echo $pseudoErr;?></span>
				</div>

				<div class="form_container1 taille_border">
					<label for="email" id="text_email">Entrez votre adresse e-mail : </label>
						<input type="email" name="email" id="email" placeholder="  Adresse mail :" 
						pattern="[a-z0-9._%+-]+@+[a-z0-9.-]+\.(com|fr)" maxlength="40" required
						value ="<?php echo $email;?>"><span class="error">* <?php echo $emailErr;?></span>
				</div>
				
				<div class="form_container2 taille_border">
					<label for="pass" id="text_pass"> Entrez votre mot de passe : </label>
						<input type="password" name="pass" id="pass" placeholder="  Mot de passe :" minlength="7" 
						required
						value ="<?php echo $pass;?>"><span class="error">* <?php echo $passErr;?></span>
				</div>

				<div class="form_container">
				<input class="connexion_button taille_border" type="submit" value="Inscription">
				</div>
			</form>
		</div>

			<?php
			
			//on inclue un fichier contenant nom_de_serveur, nom_bdd, login et password d'accès à la bdd mysql
			include ("connect.php");

			//on vérifie que le visiteur a correctement saisi puis envoyé le formulaire
			if ((isset($_POST['pseudo']) && !empty($_POST['pseudo'] )) && (isset($_POST['email']) && !empty($_POST['email'])) && (isset($_POST['pass']) && !empty($_POST['pass'])) ) {

			//on se connecte à la bdd
			$bdd = new PDO('mysql:host=localhost;dbname=workshop;charset=utf8', 'root', '');
			if (!$bdd) {echo "LA CONNEXION AU SERVEUR MYSQL A ECHOUE\n"; exit;};

			$requete = $bdd->prepare("INSERT into membres(pseudo, email, pass)
							VALUES(?,?,?)");

			$requete->execute([$_POST['pseudo'],$_POST['email'],$_POST['pass']]);
			header('Location: accueil.php');}

			?> 
	</div>
</body>
</html>