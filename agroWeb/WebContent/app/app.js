// URL de acesso ao servidor RESTful
SERVER_URL = "http://localhost:8080/agro";

// Criação ao $app que é o modulo que representa toda a aplicação
$app = angular.module('agroWeb', []);

$app
		.config([
				'$routeProvider',
				'$httpProvider',
				function($routeProvider, $httpProvider) {

					// Configura o route provider
					$routeProvider.when('/', {
						templateUrl : 'app/layout/main.html'
					}).when('/fazenda', {
						templateUrl : 'app/fazenda/main.html',
						controller : 'fazendaController'
					}).when('/fazenda/new', {
						templateUrl : 'app/fazenda/update.html',
						controller : 'fazendaController'
					}).when('/fazenda/:id', {
						templateUrl : 'app/fazenda/update.html',
						controller : 'fazendaController'
					}).otherwise({
						redirectTo : '/'
					});

					// configura o RESPONSE interceptor, usado para exibir o
					// ícone de acesso ao servidor
					// e a exibir uma mensagem de erro caso o servidor retorne
					// algum erro
					$httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
					$httpProvider.interceptors
							.push(function($q, $rootScope) {
								return function(promise) {
									// Always disable loader
									$rootScope.hideLoader();
									return promise
											.then(
													function(response) {
														// do something on
														// success
														return (response);
													},
													function(response) {
														// do something on error
														$data = response.data;
														$error = $data.error;
														console.error($data);
														if ($error
																&& $error.text)
															alert("ERROR: "
																	+ $error.text);
														else {
															if (response.status = 404)
																alert("Erro ao acessar servidor. Página não encontrada. Veja o log de erros para maiores detalhes");
															else
																alert("ERROR! See log console");
														}
														return $q
																.reject(response);
													});
								}
							});
				} ]);

$app.run([ '$rootScope', function($rootScope) {

	// Uma flag que define se o ícone de acesso ao servidor deve estar ativado
	$rootScope.showLoaderFlag = false;

	// Força que o ícone de acesso ao servidor seja ativado
	$rootScope.showLoader = function() {
		$rootScope.showLoaderFlag = true;
	}
	// Força que o ícone de acesso ao servidor seja desativado
	$rootScope.hideLoader = function() {
		$rootScope.showLoaderFlag = false;
	}

	// Método que retorna a URL completa de acesso ao servidor.
	// Evita usar concatenação
	$rootScope.server = function(url) {
		return SERVER_URL + url;
	}

} ]);

// We already have a limitTo filter built-in to angular,
// let's make a startFrom filter
$app.filter('startFrom', function() {
	return function(input, start) {
		if (input == null)
			return null;
		start = +start; // parse to int
		return input.slice(start);
	}
});