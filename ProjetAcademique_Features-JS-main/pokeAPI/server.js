// let url = "https://pokeapi.co/api/v2/pokemon/"

// // function RecupPokemon1() {
// // fetch(url)
// //     .then((response) => response.json())
// //     .then((result) => console.log(result))
// // }

// async function RecupPokemon2() {
// 	let response = await fetch(url)
// 	let result = await response.json()
// 	console.log(result)
// }

// // RecupPokemon1()
// RecupPokemon2()

let input = document.querySelector(".input")
let btn = document.querySelector(".btn")
let pokemon_name = document.querySelector(".pokemon_name")
let pokemon_type = document.querySelector(".pokemon_type")
let img = document.querySelector(".image")

btn.addEventListener("click", function () {
	RecupPokemon()
})

async function RecupPokemon() {
	let url = "https://pokeapi.co/api/v2/pokemon/" + input.value

	let response = await fetch(url)
	let result = await response.json()
	console.log(result)
	let nom = result.name
	let type = result.types[0].type.name
	let image_url = result.sprites.front_default
	AfficherPokemonInfos(nom, type, image_url)
}

function AfficherPokemonInfos(nom, type, image_url) {
	console.log(nom, type, image_url)
	pokemon_name.innerHTML = nom
	pokemon_type.innerHTML = type
	img.src = image_url
}