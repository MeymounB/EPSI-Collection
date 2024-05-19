let nomPoke = document.querySelector(".nomPoke")
let typePoke = document.querySelector(".typePoke")
let imgPoke = document.querySelector(".imgPoke")
let button = document.querySelector(".button")
let pokeLib = document.querySelector(".pokeLib")
let pokemon = []

let savedPokeLib = window.localStorage.getItem("savePokeLib")
if (savedPokeLib) {
	let savedPoke = JSON.parse(savedPokeLib)
	pokemon = savedPoke
	ReadPokedex(pokemon)
}


button.addEventListener("click", function () {
	let informations = {
		nom: nomPoke.value,
		type: typePoke.value.toLowerCase(),
		image: imgPoke.value
	}
	pokemon.push(informations)
	nomPoke.value = ""
	typePoke.value = ""
	imgPoke.value = ""
	ReadPokedex(pokemon)
})

function ReadPokedex(mespokemon) {

	pokeLib.innerHTML = ""

	for (let i = 0; i < mespokemon.length; i++) {
		let pokeDiv = document.createElement("div")
		pokeDiv.innerHTML = "<p class=" + "ptb" + " style=" + "margin-top:10px" + ">Pokemon : " + mespokemon[i].nom + "</p>" + "<p class=" + "ptb-10" + ">Type : " + mespokemon[i].type + "</p>"
		let img_poke = document.createElement("img")
		img_poke.src = mespokemon[i].image;
		pokeDiv.appendChild(img_poke)
		pokeLib.appendChild(pokeDiv)



		let supp = document.createElement("button")
		supp.innerHTML = "Supprimer le pokemon"
		pokeDiv.appendChild(supp)
		supp.classList.add("button")

		supp.addEventListener("click", function () {
			mespokemon.splice(i, 1)
			ReadPokedex(mespokemon)
		})

		let saverPoke = JSON.stringify(pokemon)
		window.localStorage.setItem("savePokeLib", saverPoke)
		pokeDiv.classList.add(mespokemon[i].type)
		pokeDiv.classList.add("flexability", "ls-1", "ptb-10", "plr-10")
	}
}