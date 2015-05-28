﻿(function() {

	var injectParams = [ '$http', '$rootScope' ];

	var authFactory = function($http, $rootScope) {
		var serviceBase = 'http://localhost:8080/agro/', factory = {
			loginPath : '/login',
			user : {
				isAuthenticated : false,
				roles : null
			}
		};

		factory.login = function(email, password) {
			return $http.post(serviceBase + 'login', {
				login : email,
				password : password
			}).then(function(results) {
				var loggedIn = results;
				;
				changeAuth(loggedIn);
				return loggedIn;
			});
		};

		factory.logout = function() {
			return $http.post(serviceBase + 'logout').then(function(results) {
				var loggedIn = true; //!results;
				changeAuth(loggedIn);
				return loggedIn;
			});
		};

		factory.redirectToLogin = function() {
			$rootScope.$broadcast('redirectToLogin', null);
		};

		function changeAuth(loggedIn) {
			factory.user.isAuthenticated = loggedIn;
			$rootScope.$broadcast('loginStatusChanged', loggedIn);
		}

		return factory;
	};

	authFactory.$inject = injectParams;

	angular.module('agroWebApp').factory('authService', authFactory);

}());
