var app=angular.module('myapp',[]);
app.controller('myctrl',function($scope,$http){
	$scope.getPassword= function(){
		if($scope.email!=null)
			{
			
		 $http({
             method : 'POST',
             url : 'forgotpassword?mail='+$scope.mail
            
            
     }).success(function(data, status, headers, config) {
    	 
    	 $scope.hide=true;
    	 $scope.msg=" We sent reset password page to your email successfully.check your email and reset your password." ;
     }).error(function(data, status, headers, config) {

    	 $scope.hide=true;
  	   $scope.msg1="Some internal problem occured try again.";
     });
			}
		else{
			$scope.valid="Email field should not be empty";
		}
		
	};
	$scope.idValidation=function(){
		$scope.valid="";
	};
	
});

