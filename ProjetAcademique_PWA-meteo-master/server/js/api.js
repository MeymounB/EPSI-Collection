navigator.geolocation.getCurrentPosition(function (position) {
	var latitude = position.coords.latitude;
	var longitude = position.coords.longitude;

	var xhr = new XMLHttpRequest();
	xhr.open("GET", "https://api.meteo-concept.com/api/forecast/daily?token=&lat=" + latitude + "&lon=" + longitude, true);
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var response = JSON.parse(xhr.responseText);
			var temperature = response.forecast[0].tmax;
			document.getElementById("temperature").innerHTML = temperature;
		}
	};
	xhr.send();
});
