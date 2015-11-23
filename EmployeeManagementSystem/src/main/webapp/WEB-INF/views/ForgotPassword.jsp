<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Attendance Management System</title>
<script src= "js/ForgotPassword.js"></script>
<script src="ForgotPassword.js"></script>
<link rel="stylesheet" type="text/css" href="css/ForgotPassword.css">
<style>
#div1 {
    width: 650px;
    height: 315px;
    padding: 10px 0px 0px 10px;
   border-radius: 10px;
    background-color:#f0f8ff;
}
</style>
</head>
<body ng-app="myapp" ng-controller="myctrl" id="body" >
<p ><h2><font color="green">{{msg}}</font></h2></p>
<p ><h2><font color="red">{{msg1}}</font></h2></p>
       <div id="div1" ng-hide="hide">
            <div id="div2">
                 <img src="image/Forgot_Password.png" width="90"  height="120">
            </div>
            <div id="div3" >
                  <h2>Forgot your password?</h2>
            </div>
           
            <div id="div4">
                   <form  name="myForm" ng-submit="getPassword()" novalidate>
                   <p>please enter your email and we'll send reset password page link to your email.you can reset your password</p>
                       ENTER EMAIL ADDRESS<br>
                   <p> 
                   <input id="t11" type="email" name="email" ng-model="email" ng-focus="idValidation()" required>
        <span style="color:red" ng-show="myForm.email.$dirty && myForm.email.$invalid">
        <span ng-show="myForm.email.$error.required">Email is required.</span>
           <span ng-show="myForm.email.$error.email">Invalid email address.</span>
          </span>
         </p>
                   <p ><font color="red">{{valid}}</font></p>
            <p>
            <input type="submit" id="btn" 
              ng-disabled="myForm.email.$dirty && myForm.email.$invalid">
              </p>

            </form>

             </div>
           <div id="div5">
                    <a href="" target="_blank">BACK TO LOGIN</a>
           </div>
</div>
</body>
</html>