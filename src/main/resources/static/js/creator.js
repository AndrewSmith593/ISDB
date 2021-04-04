/**
 * 
 */

let sandwichDetails = [];


function makeIngredient(container, ingredientCategory, ingredientName) {
	let ingredient = document.createElement("INGREDIENT");
	ingredient.classList.add(ingredientCategory, "ingredient");
	//ingredient.innerHTML += ingredientName;
	document.querySelector("#" + container).appendChild(ingredient);
	sandwichDetails.push(ingredientName);
	return ingredient;
	//TEST comment for GIT
}

function addBread() {
	var breadType = document.getElementById("bread-select").value;
	makeIngredient("sandwichBox", "bread", breadType)
	let breadBox = document.createElement("div")
	breadBox.setAttribute("id", "breadBox")
	document.querySelector("#sandwichBox").appendChild(breadBox);
	makeIngredient("sandwichBox", "bread", breadType)

	var topBreadImg = document.createElement("img");
	topBreadImg.src = "./images/whitebread.png";
	topBreadImg.classList.add("ingredImg", "topBread")

	var bottomBreadImg = document.createElement("img");
	bottomBreadImg.src = "./images/whitebread.png";
	bottomBreadImg.classList.add("ingredImg", "bottomBread")

	var breadElems = document.getElementsByClassName("bread")

	breadElems[0].appendChild(topBreadImg);
	breadElems[1].appendChild(bottomBreadImg);
}

function addSauce() {
	let breadBox = document.getElementById("breadBox")
	if (
		document.getElementById("mayo").checked &&
		!sandwichDetails.includes("Mayo")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "sauce", "mayo"))
	} else if (
		document.getElementById("mustard").checked &&
		!sandwichDetails.includes("Mustard")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "sauce", "Mustard"))
	} else if (
		document.getElementById("sriracha").checked &&
		!sandwichDetails.includes("Sriracha")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "sauce", "Sriracha"))
	}
	
	console.log(sandwichDetails[2])
	
	var sauceImg = document.createElement("img");
	sauceImg.src = "./images/" + sandwichDetails[2] + ".png";
	sauceImg.classList.add("ingredImg");
	var sauceElem = document.getElementsByClassName("sauce");
	sauceElem[0].appendChild(sauceImg);
	
}


function addProtein() {
	let breadBox = document.getElementById("breadBox")
	if (
		document.getElementById("ham").checked &&
		!sandwichDetails.includes("Ham")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "protein", "Ham"))
	} else if (
		document.getElementById("turkey").checked &&
		!sandwichDetails.includes("Turkey")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "protein", "Turkey"))
	} else if (
		document.getElementById("roastBeef").checked &&
		!sandwichDetails.includes("Roast Beef")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "protein", "Roast Beef"))
	}
}

function addCheese() {
	let breadBox = document.getElementById("breadBox")
	if (
		document.getElementById("cheddar").checked &&
		!sandwichDetails.includes("Cheddar")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "cheese", "Cheddar"))
	} else if (
		document.getElementById("swiss").checked &&
		!sandwichDetails.includes("Swiss")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "cheese", "Swiss"))
	} else if (
		document.getElementById("provolone").checked &&
		!sandwichDetails.includes("Provolone")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "cheese", "Provolone"))
	}
}

function addVeggies() {
	let breadBox = document.getElementById("breadBox")
	if (
		document.getElementById("lettuce").checked &&
		!sandwichDetails.includes("Lettuce")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "veggies", "Lettuce"))
	} else if (
		document.getElementById("tomato").checked &&
		!sandwichDetails.includes("Tomato")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "veggies", "Tomato"))
	} else if (
		document.getElementById("onion").checked &&
		!sandwichDetails.includes("Onion")
	) {
		breadBox.appendChild(makeIngredient("breadBox", "veggies", "Onion"))
	}
}



function saveSandwich() {

	let currentUserId = document.getElementById("currentUserId").innerHTML
	console.log(currentUserId)
	sandwichDetails[0] = document.getElementById(`sandwich-name`).value;

	if (document.getElementById("sharebox").checked) {
		sandwichDetails.splice(1, true)
		console.log("sandwich shared")
	} else {
		sandwichDetails.splice(1, false)
		console.log("sandwich NOT shared")
	}

	let ingredientString = sandwichDetails.slice(2).join(",");

	let ingredientCount = 0;

	for (let i = 0; i < sandwichDetails.length; i++) {
		ingredientCount += sandwichDetails[i].split(" ").length - 1;
		if (sandwichDetails[i].includes("Roast Beef")) {
			ingredientCount -= 1;
		}
	}

	document.getElementById(
		"sandwich-description"
	).innerHTML = `Mmmm... the ${sandwichDetails[0]}, a sandwich made with ${sandwichDetails[1]}, some ${sandwichDetails[2]}, hearty ${sandwichDetails[3]}, ${sandwichDetails[4]}, and finally some ${sandwichDetails[5]}. Sounds Delicious! You used ${ingredientCount} ingredients.`;

	/*
  when an ingredient is added, it will receive an ingredient number
  the ingredient numbers will start from the bottom of the sandwich
  when save button is clicked, the appropriate css class to position the ingredient will be applied
  there will be a function that loops ingredient Count times
	  this function will, 
  */

	// Animation stuff:
	let ingredientDiv = document.getElementsByClassName("ingredient")[0];
	let ingredientDiv2 = document.getElementsByClassName("ingredient")[1];
	// let proteinDiv3 = document.getElementsByClassName("protein")[2]

	ingredientDiv.classList.add("bounce-1");
	ingredientDiv2.classList.add("bounce-2");
	// proteinDiv3.classList.add("bounce-1");



	//AJAX call to server, sending sandwich post request
	$.ajax({
		headers: {
			'Accept': 'application/json',
			'Content-Type': 'application/json'
		},
		"type": "POST",
		"url": "/api/v1/sandwich",
		"data": JSON.stringify({
			"name": `${sandwichDetails[0]}`,
			"ingredients": ingredientString,
			"creatorId": currentUserId,
			"shared": true,
			"sTypeId": 3
		}),
		"datatype": "json",
		"success": function(response, status) {
			console.log("Response: " + response + "\nStatus: " + status);
		}
	});

	console.log(document.getElementById("sandwich-description").innerHTML);
}
