let bouton = document.querySelector(".bouton")
let button = document.querySelector(".button") 
let body = document.querySelector("body")
let slider = document.querySelector(".slider")

let darkMode = false

button.addEventListener("click", function() { 

    if (darkMode == false){
        bouton.classList.add("activated")
        body.classList.add("black")
        slider.classList.add("reverse")

        darkMode = true
    }
    else if(darkMode == true){

        bouton.classList.remove("activated")
        body.classList.remove("black")
        slider.classList.remove("reverse")
        darkMode = false
    }
})