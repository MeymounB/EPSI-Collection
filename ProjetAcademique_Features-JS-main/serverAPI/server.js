async function test() {
	let data = {
		username: "toto",
		password: "p@ssw0rd"
	}

	let response = await fetch("http://localhost/api.php", {
		method: 'POST',
		body: JSON.stringify(data)
	})

	let result = await response.json()
	console.log(result)
}

test();