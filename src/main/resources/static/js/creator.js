

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

/*
Make a function that takes an array of strings. These strings will be identical to the 
file names of the ingredient pictures minus the ".png".

The function will perform the logic that addSauce performs on each hard coded ingredient
but it will apply the logic to each string passed in via a loop over the ingredient array.

The logic it will apply to each ingredient inside the loop is:
-an if statement determining if the element (checkbox) of id equal 
to the ingredient string has already been checked AND if the sandwichDetails array
does not include the ingredient string
	-if these statements are both true, makeIngredient will be called with "breadBox",
	the name of the ingredient type ("sauce"), and the ingredient string,
		-makeIngredient with these arguments passed to it will be appended as a child
		to the breadBox
		
	Then create an img element, assigns the most recently added ingredient name
		as the image source, adds the class "ingredImg" to the img
		then, selects all the elements with class "sauce"
		then, selects the first element in the sauceElem array, and appends the image
		as a child to the element
		
		**I want to change this part of the method, so that when I am using the loop based
			ingredient adding method, there will be and ID assigned to the element equal to 
			the name of the ingredient string,
			then, instead of selecting all elements with the class "sauce" and then selecting
			the first of that array to append the image to,
			I will select the element with the ID equal to the ingredient string, and
			append the image to that element
			
	var sauceImg = document.createElement("img");
	sauceImg.src = "./images/ingredients/" + sandwichDetails[2] + ".png";
	sauceImg.classList.add("ingredImg");
	var sauceElem = document.getElementsByClassName("sauce");
	sauceElem[0].appendChild(sauceImg);
	
		
*/

//addIngredient takes the ingredient array and type, then creates the ingredient element,
//adds the corresponding image to it, and puts it in the breadBox
function addIngredient(ingredientArray, ingredientType) {
	let zIndex = (sandwichDetails.length) * -1
	console.log("addIngredient went off")
	// Loop through the ingredient array
	for (i = 0; i < ingredientArray.length; i++) {
		let ingredient = ingredientArray[i];
		console.log(ingredient)
		//if a certain ingredient checkbox is checked, and that ingredient isn't already on the sandwich...
		if (document.getElementById(ingredient).checked && !sandwichDetails.includes(ingredient)) {
			console.log("you chose " + ingredient)
			//then make that ingredient element, append it to breadBox
			let newIngredient = makeIngredient("breadBox", ingredientType, ingredient)

			breadBox.appendChild(newIngredient)
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

/*function addSauce() {
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
	sauceImg.src = "./images/ingredients/" + sandwichDetails[2] + ".png";
	sauceImg.classList.add("ingredImg");
	var sauceElem = document.getElementsByClassName("sauce");
	sauceElem[0].appendChild(sauceImg);

}*/


/*function addProtein() {
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
}*/

/*function addCheese() {
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
}*/

/*function addVeggies() {
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
}*/

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

	let ingredientString = sandwichDetails.slice(2).join(",");

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
