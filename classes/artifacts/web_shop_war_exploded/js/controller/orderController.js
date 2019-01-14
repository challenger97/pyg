 //控制层 
app.controller('orderController' ,function($scope,$controller,$location,typeTemplateService ,itemCatService,uploadService ,orderService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中  
	$scope.findAll=function(){
		orderService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		orderService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

    // 显示状态
    $scope.status = ["全部","未付款","已付款","未发货","已发货","交易成功","交易关闭","待评价"];

    $scope.itemCatList = [];
    // 显示分类:
    $scope.findItemCatList = function(){
        itemCatService.findAll().success(function(response){
            for(var i=0;i<response.length;i++){
                $scope.itemCatList[response[i].id] = response[i].name;
            }
        });
    }

});	
