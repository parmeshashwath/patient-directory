var App=angular.module('PatientInfo',[ "ui.router","ui.bootstrap", "oc.lazyLoad", "ngSanitize","angularjs-datetime-picker"])


App.controller('HeaderController', [ '$scope',
                                  		function($scope) {
                                  			
}])

App.controller('FooterController', [ '$scope', function($scope) {
	
} ]);

App
.config([
		'$stateProvider',
		'$urlRouterProvider',
		function($stateProvider, $urlRouterProvider) {
			// Redirect any unmatched url
			$urlRouterProvider.otherwise("/dashboard");

			$stateProvider

					// Dashboard
					.state(
							'dashboard',
							{
								url : "/dashboard",
								templateUrl : "views/dashboard.html",
								data : {
									pageTitle : 'PatientInfo'
								}
							})
							.state(
							'dashboard.entry',
							{
								url : "/entry",
								templateUrl : "views/dashboard.entry.html",
								data : {
									pageTitle : 'PatientInfo'
								}
							})
							.state(
							'dashboard.view',
							{
								url : "/view",
								templateUrl : "views/dashboard.view.html",
								data : {
									pageTitle : 'PatientInfo'
								}
							})
		}])