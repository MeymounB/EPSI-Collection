let monBouton = document.querySelector(".monBouton")
let nom_input = document.querySelector(".nom")
let prix_input = document.querySelector(".prix")

let list = document.querySelector(".maListe")
let courses = [];

let saved_txt = window.localStorage.getItem("courses_saved")
if (saved_txt) {
	let saved_obj = JSON.parse(saved_txt)
	courses = saved_obj
	RefreshCourses()
}

monBouton.addEventListener("click", function () {
	AddElement()
})

function AddElement() {
	let produit = {
		nom: nom_input.value,
		prix: prix_input.value
	}
	courses.push(produit)

	nom_input.value = ""
	prix_input.value = ""

	RefreshCourses();
}

function RefreshCourses() {
	list.innerHTML = ""
	for (let i = 0; i < courses.length; i++) {
		let li = document.createElement("li")
		li.className = "monLi"
		li.innerHTML = "Produit : " + courses[i].nom + " - Prix : " + courses[i].prix + "€"
		list.appendChild(li)

		let delete_btn = document.createElement("button")
		delete_btn.className = "delete_btn"
		delete_btn.innerHTML = "SUPPRIMER"
		li.appendChild(delete_btn)
		delete_btn.addEventListener("click", function () {
			RemoveElement(i)
		})
	}

	let texte = JSON.stringify(courses)
	window.localStorage.setItem("courses_saved", texte)
}

function RemoveElement(index) {
	courses.splice(index, 1)
	RefreshCourses()
}