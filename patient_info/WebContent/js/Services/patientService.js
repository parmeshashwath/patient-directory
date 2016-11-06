App.factory('patientService',['$http',function($http){
	
	var factory={};
	factory.insert=function(obj)
	{	
			return $http.post('rest/patient/insert',obj)
		
	};
	factory.get=function()
	{	
			return $http.get('rest/patient/get')
		
	};
	
	
	
	return factory;
}])
