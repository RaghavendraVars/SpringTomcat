var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$http.get("http://localhost:8181/springtomcatexample/getUsers").success(
			function(data) {
				$scope.users = data;
			});
	$http.get("http://localhost:8181/springtomcatexample/getAliens").success(
			function(data) {
				$scope.aliens = data;
			});			
})
app.controller('usersCtrl', function($scope, $http) {
	$scope.name = "";
	$scope.email = "";
	$scope.sendPost = function() {
		var data = {
			"name" : $scope.name
		}
		$http.post("http://localhost:8181/springtomcatexample/postUser", data)
				.success(function(data, status) {
					$scope.hello2 = data;
				})
	}
})

app.controller('alienCtrl', function($scope, $http) {
	$scope.aName = "";
	$scope.sendPost = function() {
		var data = {
			"aName" : $scope.aName
		}
		$http.post("http://localhost:8181/springtomcatexample/postAlien", data)
				.success(function(data, status) {
					$scope.alienResponse = data;
				})
	}
})

app.controller('footerCtrl', function($scope) {
	$scope.vamshi = "Vamshi Krishna Verkal";
})