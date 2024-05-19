let input_nom = document.querySelector(".saisie_nom")
let input_prix = document.querySelector(".saisie_prix")
let ajouter = document.querySelector(".ajouter")
let courses = []

ajouter.addEventListener("click", function () {
    let element = {
        nom: input_nom.value,
        prix: input_prix.value
    }
    courses.push(element)
    console.log(courses)
    input_nom.value = ""
    input_prix.value = ""
})