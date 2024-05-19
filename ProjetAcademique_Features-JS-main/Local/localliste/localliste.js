let courses = [{
	nom: "Tomates",
	prix: 3
}, {
	nom: "Courgettes",
	prix: 4
}]

console.log(courses)
courses_json = JSON.stringify(courses)
console.log(courses_json)
courses_from_json = JSON.parse(courses_json)
console.log(courses_from_json)