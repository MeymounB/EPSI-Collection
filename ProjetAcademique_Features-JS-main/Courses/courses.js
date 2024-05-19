let liste = document.querySelector(".liste")
let moninput = document.querySelector(".saisie")
let button = document.querySelector(".button")
let monLi = document.querySelector("monLi")

button.addEventListener("click", function(){  
    Add()
})

function Add(){

    let monNouvelElement = document.createElement("li")
    monNouvelElement.className = "monLi"
    liste.appendChild(monNouvelElement)
    monNouvelElement.innerHTML = moninput.value
    moninput.value = ""

    let button_supp = document.createElement("button")
    button_supp.className = "Suppr"
    button_supp.innerHTML = "Supprimer"
    monNouvelElement.appendChild(button_supp)

    button_supp.addEventListener("click", function(){
        RetirerElement(monNouvelElement)
    })
}

function RetirerElement(element_a_suppr){
    liste.removeChild(element_a_suppr)
}