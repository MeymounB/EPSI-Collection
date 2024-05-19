let input_nom = document.querySelector(".saisie_nom")
let input_prix = document.querySelector(".saisie_prix")
let ajouter = document.querySelector(".ajouter")
let liste = document.querySelector(".liste")
let courses = []

ajouter.addEventListener("click", function () {
    let element = {
        nom: input_nom.value,
        prix: input_prix.value
    }
    courses.push(element)
    ReadCourses(courses)
    input_nom.value = ""
    input_prix.value = ""
})

function ReadCourses(mesCourses) {
    liste.innerHTML = "" //pour refresh
    for (let i = 0; i < courses.length; i++) {
        let produit = mesCourses[i]
        let monLi = document.createElement("li")
        monLi.innerHTML = "nom : " + produit.nom + " - prix : " + produit.prix
        liste.appendChild(monLi)

        let suppr_button =document.createElement("button")
        suppr_button.innerHTML = "Supprimer"
        suppr_button.addEventListener("click", function(){
            RetirerElement(mesCourses, i)
        })
        monLi.appendChild(suppr_button)
    }
}

function RetirerElement(mesCourses, index){
    mesCourses.splice(index, 1)
    ReadCourses(mesCourses)
}