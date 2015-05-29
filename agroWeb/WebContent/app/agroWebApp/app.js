(function() {

	var app = angular.module('agroWebApp', [ 'ngRoute', 'ngAnimate',
			'wc.directives', 'ui.bootstrap', 'breeze.angular' ]);

	app.config([ '$routeProvider', function($routeProvider) {
		var viewBase = '/fazendadigital/app/agroWebApp/views/';

		$routeProvider.when('/producao', {
			controller : 'ProducaoController',
			templateUrl : viewBase + 'producao/producao.html',
			controllerAs : 'vm',
			secure : true
		}).when('/fazendas', {
			controller : 'FazendaController',
			templateUrl : viewBase + 'fazendas/fazendas.html',
			controllerAs : 'vm',
			secure : true
		}).when('/login/:redirect*?', {
			controller : 'LoginController',
			templateUrl : viewBase + 'login.html',
			controllerAs : 'vm'
		}).otherwise({
			redirectTo : '/'
		});

	} ]);

	app.run([
			'$rootScope',
			'$location',
			'authService',
			function($rootScope, $location, authService) {

				// Client-side security. Server-side framework MUST add it's
				// own security as well since client-based security is easily
				// hacked
				$rootScope.$on("$routeChangeStart", function(event, next,
						current) {
					if (next && next.$$route && next.$$route.secure) {
						if (!authService.user.isAuthenticated) {
							$rootScope.$evalAsync(function() {
								authService.redirectToLogin();
							});
						}
					}
				});

			} ]);

}());
