let input = document.querySelector(".input")
let btn = document.querySelector(".btn")
let txt = document.querySelector(".txt")

let prenom = window.localStorage.getItem("prenom_enregistre")
if (prenom) {
	txt.innerHTML = prenom
}
btn.addEventListener("click", function () {
	SavePrenom()
})

function SavePrenom() {
	prenom = input.value
	txt.innerHTML = prenom
	window.localStorage.setItem("prenom_enregistre", prenom)
}