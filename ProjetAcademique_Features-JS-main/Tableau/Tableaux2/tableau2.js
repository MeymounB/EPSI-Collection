let courses = [{
    nom: "Tomates",
    prix: 3
}, {
    nom: "Steaks",
    prix: 3
}, {
    nom: "Pâtes",
    prix: 2
}, {
    nom: "Courgettes",
    prix: 10
}]

let list = document.querySelector(".maListe")

function ReadCourses(mesCourses) {
    for (let i = 0; i < courses.length; i++) {
        let produit = mesCourses[i]

        let monLi = document.createElement("li")
        monLi.innerHTML = "nom : " + produit.nom + " - prix : " + produit.prix
        list.appendChild(monLi)
    }
}

ReadCourses(courses)