var app=angular.module("MyApp",['ui.router']);
//les routes 

app.config(function($stateProvider,$urlRouterProvider){
	$stateProvider.state('home',{
		url:'/home',
		templateUrl:'views/home.html',
		controller:'HomeController'
	});
	$stateProvider.state('chercher',{
		url:'/chercher',
		templateUrl:'views/chercher.html',
		controller:'MyController'
	});
	$stateProvider.state('newProduit',{
		url:'/newProduit',
		templateUrl:'views/NewProduit.html',
		controller:'NewProduitController'
	});
	
	
});
app.controller('HomeController',function($scope,$http){
	
});

app.controller('NewProduitController',function($scope,$http){

	$scope.produit={};
	$scope.saveProduit=function(){
		$http.post('http://localhost:8080/produits',$scope.produit)
		.success(function(data){
			alert(data)
		})
		.error(function(err){
			console.log(err);
		});
	}
});
	

//définition controller
app.controller("MyController",function($scope,$http){
	$scope.pageProduits=null;
	$scope.motCle="";
	$scope.pageCourante=0;
	$scope.size=4;
	$scope.pages=[];
	$scope.chercherProduits=function(){
		$http.get("http://localhost:8080/chercherProduits?mc="
				+$scope.motCle+"&page="+$scope.pageCourante+"&size="+$scope.size)
		.success(function(data, status, headers, config) {
			$scope.pageProduits=data;
			$scope.pages=new Array(data.totalPages);
			console.log("-----------total pages "+data.totalPages);
		})
		.error(function(err){
		console.log(err);
	});	
	}
	$scope.getPage=function(){
		$scope.pageCourante=0;
		$scope.chercherProduits();
	}
	$scope.gotoPage=function(p){
		$scope.pageCourante=p;
		$scope.chercherProduits();
	}
});