<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <i style="margin-right: 10px;font-size:large" class="fas fa-hamburger"></i>
          <a class="navbar-brand" href="index.html">ISDB</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
              <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="creator.html">Create</a>
              </li>
              <li class="nav-item">
                <a class="nav-link" href="menu.html">Sandwich Menu</a>
              </li>
              <!-- <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Dropdown
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="#">Action</a></li>
                  <li><a class="dropdown-item" href="#">Another action</a></li>
                  <li><hr class="dropdown-divider"></li>
                  <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
              </li>
              <li class="nav-item">
                <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
              </li>
            </ul>
            <form class="d-flex">
              <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
              <button id="searchBtn" class="btn btn-outline-success" type="submit">Search</button>
            </form> -->
          </div>
        </div>
      </nav>

<!-- <h1  style="text-align: center;">ISDB</h1> -->
<div id="homepage-container">

<h1 style="font-size: 50px;">Welcome to the International Sandwich Database!</h1>
<h1 style="font-family: 'Playball', cursive;font-size: 50px;">We hope you're hungry.</h1>

  <form id="login-box">
    <h1>User Login</h1>
    <div class="formInput">
      <label for="user">Username:</label>
      <input id="user" type="text" placeholder="Username" /><br />
    </div>
    <div class="formInput">
      <label for="pass">Password:</label>
      <input id="pass" type="password" placeholder="Password" /><br />
    </div>
    <input id="loginButton" type="submit" value="Login" />
  </form>
</div>

</body>
</html>