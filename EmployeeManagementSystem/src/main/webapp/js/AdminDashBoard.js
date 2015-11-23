
/*this file name: AdminDashBoard.js */

var app = angular.module('AdminDashBoard', []);

app.controller('AdminDashBoardController', function($scope, $http, $window) {
	
	/*creating variables */
	var file=null;
	var allowedFileExtension1="xlsx";
	var allowedFileExtension2="xls";
	
	/*fonction to set default values*/
	function setDefaultValues(){
		
		$scope.showAddEmployeeMainDiv=false;	
		$scope.showExcelDiv = false;
		$scope.showManuallyEnterDiv=false;
		$scope.fileUploadSuccessMsg="";
	}
	
	/*function call to set default values*/
	setDefaultValues();
	
	
	/*function to show add Employee Details division */
	$scope.addEmployeeDetails=function(){
		console.log("in addEmployeeDetails()()");
		$scope.showAddEmployeeMainDiv= !$scope.showAddEmployeeMainDiv;
		console.log("show add user div: "+$scope.showAddEmployeeMainDiv);
	};
	/*function to show add emplyee manually div*/
	$scope.showAddEmployeeDiv=function(){
		console.log("called");
		$scope.showManuallyEnterDiv=!$scope.showManuallyEnterDiv;
		$scope.showExcelDiv=false;
	};
	
	/* function to show Add employees By Excel file division */
	$scope.showFromExcelDiv = function() {
		
		console.log("in showFromExcelDiv()");
		$scope.fileUploadSuccessMsg="";
		$scope.showExcelDiv = !$scope.showExcelDiv;
		$scope.showManuallyEnterDiv	=false;

	};
	/*function for file_change()*/
	$scope.file_changed = function(element) {		
		file=element.files[0];
	    element=null;
		console.log("file extension:: "+ getFileExtension(file));
	    	
	};
	/*function to get file extension*/
	function getFileExtension(fileObject){
		
		return fileObject.name.split('.').pop();
		
	};
	
	/*function to check file extension*/
	function checkFileExtension(extensionName){
		
		return ((extensionName == allowedFileExtension1) ||(extensionName == allowedFileExtension2) )? true: false ;
		
	};
	/*function to upload file*/
	$scope.uploadFile=function (){	
		if(file != null){
		   if(checkFileExtension(getFileExtension(file))){
		
		      var formData=new FormData();
	          formData.append("file",file);
	          console.log("file:  "+file);
	          $http.post('/EmployeeManagementSystem/uploadEmployeeDetailsExcelFile.do', formData, {
	                transformRequest: function(data, headersGetterFunction) {
	                    return data;
	                },
	                headers: { 'Content-Type': undefined }
	                }).success(function(data, status) {                       
	                    console.log("Success ... " + data);
	                    if(data == "00")
	                	    $scope.fileUploadSuccessMsg="uploaded success fully";
	                    else
	                	    $scope.fileUploadSuccessMsg="In excel file RowNumber:"+data.charAt(0)+" column Number:"+data.charAt(1)+" DOB is wrong";
	                }).error(function(data, status) {
	                    console.log("Error ... " + status);
	                    $scope.fileUploadSuccessMsg="Problem ocuured!";
	            });
		   }
		   else{
			   $scope.fileUploadSuccessMsg="file Extension must be ."+allowedFileExtension1+" or ."+allowedFileExtension2;
			   $scope.excelFilePath="";
		   }
		}
		else{
			$scope.fileUploadSuccessMsg="Please select file ";
		}
		 
		
	};
	/*function to set employee default details*/
	function employeeDefaultDetails(){
		
		$scope.empId="";
		$scope.empFirstName="";
		$scope.empLastName="";
		/*$scope.DOB=new Date();*/
		
	}
	
	/*function call to set employee default values*/
	employeeDefaultDetails();
	
	/*function to add single employee details*/
	$scope.addEmployee=function(){
		console.log("condition: "+($scope.empId.length >= 4 && $scope.empFirstName.length > 2 && $scope.empLastName.length > 2 ));
		console.log("too long: "+($scope.empId.length < 20 && $scope.empFirstName.length < 30 && $scope.empLastName.length < 30));
		if($scope.empId.length > 4 && $scope.empFirstName.length > 2 && $scope.empLastName.length > 2 ){
			if($scope.empId.length < 20 && $scope.empFirstName.length < 30 && $scope.empLastName.length < 30 ){
				
				console.log("emp data: "+$scope.empId+" "+$scope.empFirstName+" "+$scope.empLastName+" "+$scope.DOB);
				$scope.addEmployeeSuccessMsg="ok";
			}
			else{
				
				console.log("bad request");
				$scope.addEmployeeSuccessMsg="Request too long !";
			}
			
		}
		else{
			
			console.log("invalid employee details");
			$scope.addEmployeeSuccessMsg="Invalid employee details";
		}
			
		/*$scope.empFirstName="fn";
		$scope.empLastName="ln";
		$scope.DOB=new Date();*/
		
		console.log("manually add emp : add emp()");
		
	};
	
	/*function to logout button*/
	$scope.logout=function(){
		
		console.log("in logout()");
		$window.location.href = '/EmployeeManagementSystem/adminLogout.do';
		
	};
	
});//end app.controlller