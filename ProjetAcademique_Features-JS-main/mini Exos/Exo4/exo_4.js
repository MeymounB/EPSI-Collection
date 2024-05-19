let score_txt = document.querySelector(".score")
let bouton1 = document.querySelector(".Bouton1")
let bouton2 = document.querySelector(".Bouton2")

let score_1 = 0
let score_2 = 0

bouton1.addEventListener("click", function(){
	incrementScore1()
})

function incrementScore1(){
	score_1 = score_1 + 1
	UpdateScoreTxt() 
}

bouton2.addEventListener("click", function(){
	incrementScore2()
})

function incrementScore2(){
	score_2 = score_2 + 1
	UpdateScoreTxt()
}

function UpdateScoreTxt(){
	score_txt.innerHTML = score_1 + "-" + score_2 
}

// let bouton1 = document.querySelector(".Bouton1")
// let i = 0
// let bouton2 = document.querySelector(".Bouton2")
// let j = 0
// Fscore = document.querySelector(".score")

// bouton1.addEventListener("click", function But1() {    
// i = i + 1
// Fscore = i + "-" + j
// 	
// })

// // <<------------------------------------------------<<

// bouton2.addEventListener("click", function But2() {    
// 	let score1return = j + 1
// 	Fscore = i + "-" + j
// })
