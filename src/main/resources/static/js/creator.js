

let sandwichDetails = [];


const sauceArray = ["mayo", "mustard", "sriracha", "butter", "cranberrysauce", "gravy", "hummus", "jelly",
	"ketchup", "marinara", "chimichurri", "marshmallowcreme", "oilandvinegar", "peanutbutter",
	"russiandressing", "tartarsauce", "barbecuesauce"];

const proteinArray = ["ham", "turkey", "roastbeef", "bacon", "beefpatty", "bologna", "chicken",
	"friedchicken", "friedegg", "hardboiledeggs", "scrambledeggs", "friedfish", "friedshrimp", "lobstersalad",
	"lox", "meatballs", "mortadella", "capicola", "prosciutto", "salami", "schnitzel", "shreddedpork",
	"sloppyjoemeat", "taylorham", "tunasalad"];

const cheeseArray = ["cheddar", "swiss", "provolone", "americancheese", "briecheese", "creamcheese", "goudacheese",
	"gruyerecheese", "mozzarella"];

const veggieArray = ["lettuce", "tomato", "onion", "avocado", "cucumber", "freshbasil", "friedonions",
	"jalapenos", "pickles", "bananapeppers", "sauerkraut", "spinach"];

const otherArray = ["capers", "appleslices", "bananaslices", "frenchfries", "gardiniera", "olivesalad", "powderedsugar", "stuffing", "gravy", "mashedpotatoes"]


function makeIngredient(container, ingredientType, ingredientName) {
	let ingredient = document.createElement("INGREDIENT");
	ingredient.classList.add(ingredientType, "ingredient");
	ingredient.setAttribute("id", ingredientName)
	//ingredient.innerHTML += ingredientName;
	document.querySelector("#" + container).appendChild(ingredient);
	sandwichDetails.push(ingredientName);
	return ingredient;

}

function addBread() {
	var breadType = document.getElementById("bread-select").value;
	makeIngredient("sandwichBox", "bread", breadType)
	let breadBox = document.createElement("div")
	breadBox.setAttribute("id", "breadBox")
	document.querySelector("#sandwichBox").appendChild(breadBox);
	makeIngredient("sandwichBox", "bread", breadType)

	var topBreadImg = document.createElement("img");
	topBreadImg.src = "./images/ingredients/whitebread.png";
	topBreadImg.classList.add("ingredImg", "topBread")

	var bottomBreadImg = document.createElement("img");
	bottomBreadImg.src = "./images/ingredients/whitebread.png";
	bottomBreadImg.classList.add("ingredImg", "bottomBread")

	var breadElems = document.getElementsByClassName("bread")

	breadElems[0].appendChild(topBreadImg);
	breadElems[1].appendChild(bottomBreadImg);
}



//addIngredient takes the ingredient array and type, then creates the ingredient element,
//adds the corresponding image to it, and puts it in the breadBox

function addIngredient(ingredientArray, ingredientType) {
	let zIndex = (sandwichDetails.length)
	
	// Loop through the ingredient array
	for (i = 0; i < ingredientArray.length; i++) {
		let ingredient = ingredientArray[i];
		console.log(ingredient)
		
		//if a certain ingredient checkbox is checked, and that ingredient isn't already on the sandwich...
		if (document.getElementById(ingredient).checked && !sandwichDetails.includes(ingredient)) {
			console.log("you chose " + ingredient)
			//then make that ingredient element, append it to breadBox
			let newIngredient = makeIngredient("breadBox", ingredientType, ingredient)

			breadBox.prepend(newIngredient)
			//then make an image, set the src to the corresponding ingredient image, add ingredImg class
			var ingredImage = document.createElement("img");
			ingredImage.style.zIndex = zIndex;
			ingredImage.src = "./images/ingredients/" + ingredient + ".png";
			ingredImage.classList.add("ingredImg");
			
			//and append the image to the ingredient element
			//var ingredElem = document.getElementById(ingredient);
			//var ingredElems = document.getElementsByClassName("sauce");

			newIngredient.appendChild(ingredImage);
			return;
		}
	}
}


function addSauce() {
	addIngredient(sauceArray, "sauce");
}

function addProtein() {
	addIngredient(proteinArray, "protein");
}

function addCheese() {
	addIngredient(cheeseArray, "cheese");
}

function addVeggie() {
	addIngredient(veggieArray, "veggie");
}

function addOther() {
addIngredient(otherArray, "other");
}

function uppercase(str) {
	var array1 = str.split(',');
	var newarray1 = [];

	for (var x = 0; x < array1.length; x++) {
		newarray1.push(array1[x].charAt(0).toUpperCase() + array1[x].slice(1));
	}
	return newarray1.join(', ');
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

console.log(sandwichDetails)

	let ingredientString = sandwichDetails.slice(1).join(",");

	let formattedIngreds = uppercase(ingredientString);

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
			"ingredients": formattedIngreds,
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
