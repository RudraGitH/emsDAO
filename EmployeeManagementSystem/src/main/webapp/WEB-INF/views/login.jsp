<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html ng-app="myApp">
<script src="angularJs/angular.js"></script>
<link rel="stylesheet" type="text/css" href="css/alert.css">
<script src="js/alert.js"></script>
<script src="js/loginForm.js"></script>
<link rel="stylesheet" type="text/css" href="css/loginForm.css">
<body ng-controller="ValidController">

	<div id="mainDiv">
          <div id="logoDiv"></div>
		<form id="logForm" name="myForm" ng-submit="redirect(empId)"
			method="post" novalidate align="center">

			<div id="enterMsgDiv">
				<p id="enter" ng-model="employeeIdLength">Enter Employee ID</p>
			</div>
			<div id="textBoxDiv">
				<input ng-class="cssClass" type="text" name="empId" ng-model="empId"
					ng-keyup="validateData()" maxlength="6"
					placeholder="Please Enter Employee ID" required>
			</div>
			<div id="msgDiv">
				<p id="msg" ng-show="showInvalidMsg" ng-bind="invalidMsg">invalid
					msg</p>
			</div>
			<div id="buttonDiv">
				<Button id="loginButton" ng-disabled="buttonDisable">{{buttonText}}</Button>
			</div>

		</form>


		<div id="timeDiv" ng-controller="timeController">

			<p id="dateText">Date and Time</p>
			<p id="dateTime" my-current-time="format"></p>

		</div>

		<div id="messageDiv">

			<p id="message" ng-bind="successMessage">success msg</p>

		</div>

		<div id="AdminDiv">

			<Button id="AdminButton" ng-click="AdminButton()">Admin
				sign-in</Button>
		</div>
		<!-- all empIds:
		<p>{{jsondata}}</p>
		Loggedin empIds :
		<p>{{loggedInIds}}</p>
		LoggedOut empIds :
		<p>{{jsonLoggedOut}}</p> -->
	</div>


</body>

</html>