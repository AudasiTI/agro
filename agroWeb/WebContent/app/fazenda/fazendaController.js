//function clientesController($scope,$http,$routeParams,$location)
$app.controller('fazendaController', function($scope, $http, $routeParams,
		$location) {
	// lista de fazendas
	$scope.rows = null;

	// um cliente
	$scope.row = null;

	// Pagination
	$scope.currentPage = 0;
	$scope.pageSize = 15;

	$scope.numberOfPages = function() {
		return Math.ceil($scope.rows.length / $scope.pageSize);
	}

	$scope.loadAll = function() {
		$scope.showLoader();
		$http.get($scope.server("/fazenda")).success(function(data) {
			$scope.rows = data;
			$scope.hideLoader();
		});
	}

	$scope.loadRow = function() {
		if ($routeParams.id != null) {
			$scope.showLoader();
			$http.get($scope.server("/fazenda/" + $routeParams.id)).success(
					function(data) {
						$scope.row = data;
						$scope.row.isUpdate = true;
						$scope.hideLoader();
					});
		} else {
			$scope.row = {}
			$scope.row.id = null;
			$scope.row.isUpdate = false;
			$scope.hideLoader();
		}
	}

	$scope.save = function() {
		$scope.showLoader();
		$http.post($scope.server("/fazenda/"), $scope.row).success(function(data) {
			alert("Salvo com sucesso");
			$scope.row.isUpdate = true;
			$scope.hideLoader();
		});
	}

	$scope.del = function() {
		if (confirm("Deseja excluir " + $scope.row.id + "?")) {
			$http.post($scope.server("/fazenda/" + $routeParams.id)).success(
					function(s) {
						$scope.hideLoader();
						alert("Excluído com sucesso");
						$location.path("/fazenda");
					});
		}

	}

});