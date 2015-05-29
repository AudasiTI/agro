(function() {

	var injectParams = [ '$scope', '$location', 'config' ];

	var ProducaoController = function($scope, $location, config) {
		var vm = this, path = '/';

		$scope.oneAtATime = true;

		$scope.groups = [ {
			title : 'Atividades',
			itens : [ {
				nome : 'Teste',
				url : '/teste'
			}, {
				nome : 'Testando',
				url : '/testando'
			} ]
		}, {
			title : 'Talhões',
			itens : [ {
				nome : 'Listar',
				url : '/talhao'
			} ]
		}, {
			title : 'Safras',
			itens : [ {
				nome : 'Teste',
				url : '/teste'
			} ]
		} ];

		$scope.status = {
			isFirstOpen : true,
			isFirstDisabled : false
		};
	};

	ProducaoController.$inject = injectParams;

	angular.module('agroWebApp').controller('ProducaoController',
			ProducaoController);

}());