// if ('geolocation' in navigator) {
// 	// Si la géolocalisation est prise en charge par le navigateur, affiche une boîte de dialogue de confirmation
// 	navigator.geolocation.getCurrentPosition(
// 		// Succès
// 		function (position) {
// 			console.log('Position acquise avec succès', position);
// 		},
// 		// Erreur
// 		function (error) {
// 			console.warn('Impossible d\'acquérir la position', error);
// 		}
// 	);
// } else {
// 	// Si la géolocalisation n'est pas prise en charge par le navigateur, affiche un message d'erreur
// 	console.error('La géolocalisation n\'est pas prise en charge par ce navigateur.');
// }

if ('geolocation' in navigator) {
	// Si la géolocalisation est prise en charge par le navigateur, demande la permission de localisation
	navigator.geolocation.getCurrentPosition(
		// Succès
		function (position) {
			// Récupérer les coordonnées de la position actuelle
			const { latitude, longitude } = position.coords;

			// Appel à l'API Google Maps pour récupérer la ville actuelle
			fetch(`https://maps.googleapis.com/maps/api/geocode/json?latlng=${latitude},${longitude}&`)
				.then(response => response.json())
				.then(data => {
					if (data.results.length > 0 && data.results[0].hasOwnProperty('address_components')) {
						// Récupérer la ville à partir des résultats de l'API Google Maps
						var ville = data.results[0].address_components.find(component => component.types.includes('locality')).long_name;

						document.getElementById("ville").innerHTML = ville;
					}
				})
				.catch(error => {
					console.error('Une erreur est survenue lors de l\'appel à l\'API Google Maps', error);
				});
		},
		// Erreur
		function (error) {
			console.warn('Impossible d\'acquérir la position', error);
		}
	);
} else {
	// Si la géolocalisation n'est pas prise en charge par le navigateur, affiche un message d'erreur
	console.error('La géolocalisation n\'est pas prise en charge par ce navigateur.');
}

// function afficherLocalisationVille() {
// 	if ('geolocation' in navigator) {
// 		// Si la géolocalisation est prise en charge par le navigateur, affiche une boîte de dialogue de confirmation
// 		navigator.geolocation.getCurrentPosition(
// 			// Succès
// 			function (position) {
// 				// Récupérer la latitude et la longitude
// 				const latitude = position.coords.latitude;
// 				const longitude = position.coords.longitude;

// 				// Créer une requête pour l'API de géocodage inversé de Google
// 				const requestUrl = `https://maps.googleapis.com/maps/api/geocode/json?latlng=${latitude},${longitude}&key=`;

// 				// Envoyer la requête avec fetch()
// 				fetch(requestUrl)
// 					.then(function (response) {
// 						return response.json();
// 					})
// 					.then(function (data) {
// 						// Récupérer la ville à partir des résultats de géocodage inversé
// 						const ville = data.results[0].address_components.find(function (component) {
// 							return component.types.includes('locality');
// 						}).long_name;

// 						// Afficher la ville dans une balise HTML
// 						const villeElement = document.getElementById('ville');
// 						villeElement.innerHTML = `Vous êtes à ${ville}.`;
// 					})
// 					.catch(function (error) {
// 						console.error('Une erreur s\'est produite lors de la récupération de la ville :', error);
// 					});
// 			},
// 			// Erreur
// 			function (error) {
// 				console.warn('Impossible d\'acquérir la position', error);
// 			}
// 		);
// 	} else {
// 		// Si la géolocalisation n'est pas prise en charge par le navigateur, affiche un message d'erreur
// 		console.error('La géolocalisation n\'est pas prise en charge par ce navigateur.');
// 	}
// }
