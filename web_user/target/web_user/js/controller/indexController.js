//首页控制器
app.controller('indexController',function($scope,loginService){
	$scope.showName=function(){
			loginService.showName().success(
					function(response){
						$scope.loginName=response.loginName;
					}
			);
	}


    $scope.findAll=function(){
        loginService.findAll().success(
            function(response){
                $scope.allList=response.loginName;
            }
        );
    }
});