App.controller('patientDataView',['$scope','patientService', function($scope,patientService) {

	$scope.showLoader=true
	$scope.patients=[]
	patientService.get().success(function(data){
		console.log(data)
		
		$.each(data,function(key,value){
			console.log(value.dob/1000)
			var date=new Date(value.dob)
			value.dob=(date.getMonth()+1)+"/"+(date.getDate())+"/"+(date.getFullYear())
			$scope.patients.push(value)
		})
		
	}).error(function(){
		$scope.showLoader=false
		console.log("inserting data failed")
	})
	
	
}]);