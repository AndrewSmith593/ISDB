# International Sandwich Database

  ## Description
  A site that allows users to create a sandwich with a multitude of ingredients in a "sandwich visualizer", save it to their account, and come back to their sandwich menu at any time. Users can choose to share their creations on the International Sandwich Database for other users to find and try themselves. Users can explore different sandwiches to try making themselves, or get new sandwich ideas from.
  

  URL: https://andrewsmith593.github.io/ISDB/
  
  
  ## Table of Contents

  <a href='#Languages'>Languages and Tools</a>

  <a href='#User Stories'>User Stories</a>
  
  <a href='#Technical Challenges'>Technical Challenges</a>
  
  <a href='#Deployment'>Deployment</a>

  <a href='#Credits'>Credits</a>

  <a href='#Questions'>Questions</a>
  
  Screenshot of ISDB
  ![ISDB screenshot](./isdb_createpage.png?)


  ## <a id='Languages' style='color:white;'>Languages and Tools</a>
  ISDB was developed with the following languages and tools: Java, Javascript, HTML, CSS, Spring Boot, Thymeleaf, Maven, Ajax, Spring Data JPA using the JpaRepository interface

  ## <a id='User Stories' style='color:white;'>User Stories</a>
Log in and go to the 'Create' page to make your own sandwich. Give it a name, and click 'Save Sandwich'. Navigate to 'My Sandwiches' to view your previously made sandwiches. Click 'Edit' to alter your sandwich, or 'Delete' to get rid of it. The 'Menu' page contains a list of popular sandwiches that you can edit to your liking and save as a new sandwich in your account.

  ## <a id='Technical Challenges' style='color:white;'>Technical Challenges</a>
  
   #### Challenge: 
   Dynamically adding the correct ingredient pictures to the sandwich visualizer when a user selects a specific ingredient. Getting that image to show up 'on top of' the previous ingredients.
  
  #### How I solved it: 
  Onclick functions for each ingredient type (addCheese, addVeggie etc.) that each call an addIngredient function, passing it both an array of that type of ingredient (i.e. cheeseArray, veggieArray etc.). The addIngredient function then sets a let to store a z-index integer equal to the sandwichDetails.length (basically the ingredient list), loops through the specified array, and checks if the corresponding checkboxes on the page are checked for each ingredient in the array. If an ingredient is checked, it calls the function makeIngredient to: create an ingredient div, append that to a div between the two bread slices called 'breadBox', then create an image with a src set to the ingredients's name. All the ingredient images have matching names to the strings in the array, so the correct image src gets added, the z-index is added, and finally the img is appended to the new ingredient div in the breadBox.
  
  #### Challenge: 
  Passing the user's id to the Create Sandwich page in order to save the sandwich with a 'creatorId' field that would connect the sandwich to a specific user.
  
  #### How I solved it: 
  using HttpSession, I set an attribute on the user's session to store the user's id, and added the attribute to a hidden div's innerHTML on the Create page. Then, using my linked javascript, selected that element's innerHTML using getElementById, and used the id as the 'creatorId' field in the Ajax post to the server.
  
  #### Challenge: 
  Implementing a 'Delete' function on the MySandwiches page.
  
  #### How I solved it: 
  Instead of using a button, I created a form element, in order to be able to submit a request to a specific route. Using Thymeleaf, I specified a 'delete' method on the form, and an action attribute that specified the sandwich api route, and took a request parameter of the corresponding sandwich id. 

  ## <a id='Deployment' style='color:white;'>Deployment</a>
ISDB is not currently deployed, however future development plans include full deployment on AWS. I have another, previous version of the project deployed via Github with a pared down version of the Sandwich Creator page that you can try out here: https://andrewsmith593.github.io/SandwichDatabase/creator.html
  
  ## <a id='Credits' style='color:white;'>Credits</a>
  Andrew Smith

  GitHub Username: AndrewSmith593 <br>Github Profile: <a href='https://github.com/AndrewSmith593'>https://github.com/AndrewSmith593</a>

  
  ## <a id='Questions' style='color:white;'>Questions</a>
  Contact Andrew Smith with questions at andrewsmith593@gmail.com.


  <!-- Email: andrewsmith593@gmail.com -->

