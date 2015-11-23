<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html ng-app="AdminDashBoard">
<head>

<script type="text/javascript" src="angularJs/angular.js"></script>
<script type="text/javascript" src="js/AdminDashBoard.js"></script>
<link rel="stylesheet" href="css/ADminDashBoard.css">
<link rel="stylesheet" href="css/Admin_addEmployeeDetails.css">
<title>Admin Dash Board</title>
</head>

<body ng-controller="AdminDashBoardController">
<div id="container">
 <div id="header">
  <h1>Admin Dashboard</h1>
 </div>

 <div id="nav">
  <li>
  Manage Employee
   <nav id="nav1">
   <ul id="manageUserList">
    <a href="" ng-click="addEmployeeDetails()">Add Employee</a><br><br>
    <a href="" ng-click="hi()">view user</a>
   </ul>
   </nav>
  </li>
  <li>Reports</li>
  <li><a href="">All</a></li>
   <nav id="nav1">
    <li>Single User</li>
     <nav id="nav1">
      <ul>
      <a href="">daily</a><br>
      <a href="">weekly</a>
      <a href="">monthly</a>
      <a href="">yearly</a>
      </ul>
      <li><button ng-click="logout()">Sign-out</button></li>
     </nav>
   </nav>  
 </div>
</div>

<div id="section" ng-show="showAddEmployeeMainDiv">
         <div id="importEmployeeDataDiv">
              <p id="AddEmpText" >Add Employee(s)</p>              
              <Button id="excelbutton" ng-click="showFromExcelDiv()">From Excel File</Button>
              <Button id="manualButton" ng-click="showAddEmployeeDiv()">By Single User</Button>
                
        </div>
        <div id="fromExcelDiv" ng-show="showExcelDiv">
        
              <p id="excelDivText">Select Excel File Location</p>
              <input type="file" ng-model="excelFilePath" onchange="angular.element(this).scope().file_changed(this)" id="excelFile" value="Browse" />              
              <button id="uploadButton" ng-click="uploadFile()">Upload</button>
              <p id="EmployeeSuccessMsg">{{fileUploadSuccessMsg}}</p>
        </div>
         <div id="ManuallyEnterDiv" ng-show="showManuallyEnterDiv">
             <p id="excelDivText">Enter Employee Details</p>
             <form id="addEmployeeForm">
             
                 <label id="empText">Employee Id:</label><br><input type="text" id="empTextBox" autocomplete="off" ng-model="empId" required><span id="star">*</span><br>
                 <label id="empText">First Name:</label><br><input type="text" id="empTextBox" ng-model="empFirstName" required><span id="star">*</span><br>
                 <label id="empText">Last Name:</label><br><input type="text" id="empTextBox" ng-model="empLastName" required><span id="star">*</span><br>
                 <label id="empText">Date of Birth:</label><br><input type="date" id="empTextBox" ng-model="DOB" required><span id="star">*</span><br>
                 <label id="empText">Mobile No:</label><br><input type="text" id="empTextBox" ng-model="mobile" required><span id="star">*</span><br>
                 <label id="empText">Email ID:</label><br><input type="email" id="empTextBox" ng-model="emailId" required><span id="star">*</span><br>
                 <label id="empText">Designation:</label><br><input type="text" id="empTextBox" ng-model="designation" required><br>
                 <label id="empText">Role ID:</label><br><input type="text" id="empTextBox" ng-model="roleId" required><br>
                 <label id="empText">Department ID:</label><br><input type="text" id="empTextBox" ng-model="deptId" required><span id="star">*</span><br>
                 
                 <button id="submitButton" ng-click="addEmployee()">Add Employee</button>
             </form>
             <span id="EmployeeSuccessMsg">{{addEmployeeSuccessMsg}}</span></div>
        </div>
        <p>{{adminStatus}}</p>
<!-- <center>SingleUser<input type="RADIO" name="userChoice" id="navRadio01" onclick="window.location='file:///D:/Testings/SingleUserTest.html'"> &nbsp; &nbsp;
 Through Excel<input type="RADIO" name="userChoice" id="navRadio01" onclick="window.location='file:///D:/Testings/ThroughExcelTest.html'"> -->
</div>

<div id="footer">
Copyright © caprusit.com
</div>
</div>
</body>
</html>