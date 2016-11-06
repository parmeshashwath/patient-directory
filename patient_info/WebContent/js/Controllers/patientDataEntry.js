App.controller('patientDataEntry',['$scope','patientService', function($scope,patientService) {

	$scope.showLoader=false
	$scope.form={'gender':'Male'}
	 $scope.popup1 = {
		    opened: false
		  };

	$scope.open1 = function() {
	    $scope.popup1.opened = true;
	  };
	$scope.submitForm=function()
	{
		$scope.showLoader=true
		console.log($scope.form.dob_string)
		
		var timestamp = $scope.form.dob_string.getTime();
		$scope.form.dob=timestamp
		delete $scope.form.dob_string;
		console.log($scope.form)
		patientService.insert($scope.form).success(function(data){
			console.log(data)
			$scope.showLoader=false
			$scope.form={'gender':'Male'}
		}).error(function(){
			$scope.showLoader=false
			$scope.form={'gender':'Male'}
			console.log("inserting data failed")
		})
	}
	
}]);