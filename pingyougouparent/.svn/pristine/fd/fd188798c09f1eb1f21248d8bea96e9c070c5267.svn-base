 //控制层 
app.controller('goodsController' ,function($scope,$controller,goodsService,uploadService,itemCatService,typeTemplateService){
	
	$controller('baseController',{$scope:$scope});//继承
	
    //读取列表数据绑定到表单中
	$scope.findAll=function(){
		goodsService.findAll().success(
			function(response){
				$scope.list=response;
			}			
		);
	}    
	
	//分页
	$scope.findPage=function(page,rows){			
		goodsService.findPage(page,rows).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}
	
	//查询实体 
	$scope.findOne=function(id){				
		goodsService.findOne(id).success(
			function(response){
				$scope.entity= response;					
			}
		);				
	}
	
	//保存 
	$scope.save=function(){				
		var serviceObject;//服务层对象  				
		if($scope.entity.id!=null){//如果有ID
			serviceObject=goodsService.update( $scope.entity ); //修改  
		}else{
            $scope.entity.goodsDesc.introduction=editor.html();
			serviceObject=goodsService.add( $scope.entity  );//增加 
		}				
		serviceObject.success(
			function(response){
				if(response.success){
					//重新查询 
                    alert("保存成功");
                    $scope.entity={};
                    editor.html('');//清空富文本编辑器
				}else{
					alert(response.message);
				}
			}		
		);				
	}
	
	 
	//批量删除 
	$scope.dele=function(){			
		//获取选中的复选框			
		goodsService.dele( $scope.selectIds ).success(
			function(response){
				if(response.success){
					$scope.reloadList();//刷新列表
					$scope.selectIds=[];
				}						
			}		
		);				
	}
	
	$scope.searchEntity={};//定义搜索对象 
	
	//搜索
	$scope.search=function(page,rows){			
		goodsService.search(page,rows,$scope.searchEntity).success(
			function(response){
				$scope.list=response.rows;	
				$scope.paginationConf.totalItems=response.total;//更新总记录数
			}			
		);
	}

	$scope.uploadFile=function () {
		uploadService.uploadFile().success(
			function (response) {
				if(response.success){
                    $scope.image_entity.url=response.message;

				}else {
					alert(response.message)
				}
            }
		).error(function () {
			alert("上传错误")

        })

    }

    $scope.entity={goods:{},goodsDesc:{itemImages:[] , specificationItems:[]}};
	$scope.add_image=function () {
		$scope.entity.goodsDesc.itemImages.push($scope.image_entity);

    }
    $scope.remove_image=function (index) {
		$scope.entity.goodsDesc.itemImages.splice(index,1)

    }
	$scope.selectItemCatList=function () {

		itemCatService.findByParentId(0).success(
			function (response) {
			 $scope.itemCatList1=response;

        })
    }


    //监控变量
	$scope.$watch('entity.goods.category1Id',function (newValue, oldValue) {
        if(typeof (newValue)=="undefined"){
            newValue = 1 ;

        }
				itemCatService.findByParentId(newValue).success(function (response) {
					$scope.itemCatList2=response ;

                })
        }
    )
		$scope.$watch('entity.goods.category2Id',function (newValue, oldValue) {
			if(typeof (newValue)=="undefined"){
				newValue = 2 ;
            }
            itemCatService.findByParentId(newValue).success(function (response) {
					$scope.itemCatList3=response ;
                })
        }
    )
$scope.$watch('entity.goods.category3Id',function (newValue, oldValue) {
			if(typeof (newValue)=="undefined"){
				newValue = 35 ;

            }
            itemCatService.findOne(newValue).success(function (response) {

                $scope.entity.goods.typeTemplateId=response.typeId;

                })
        }
    );
	$scope.$watch('entity.goods.typeTemplateId',function (newValue, oldValue) {
			if(typeof (newValue)=="undefined"){newValue = 35 ;}
            typeTemplateService.findOne(newValue).success(function (response) {
                $scope.typeTemplateId=response;

                $scope.typeTemplateId.brandIds=JSON.parse(response.brandIds);

                $scope.entity.goodsDesc.customAttributeItems=JSON.parse(response.customAttributeItems);

            });

			typeTemplateService.findSpecList(newValue).success(function (response) {
					$scope.specList =  response ;
            })

        }
        )

	$scope.updateSpecAttibute= function ($event, name, value) {

		var map = $scope.searchMapByList($scope.entity.goodsDesc.specificationItems , "attributeName" ,name);
		if(map!=null){

			//存在该建 判断是否已经被点击
			if($event.target.checked){

                //push进值的集合
              map.attributeValue.push(value);
			}else {
				//splice	移除选项
				map.attributeValue.splice(map.attributeValue.indexOf(value),1);
				//如果全部移除 则移除map
				if(map.attributeValue.length == 0){
                    $scope.entity.goodsDesc.specificationItems.splice($scope.entity.goodsDesc.specificationItems.indexOf(map),1)

				}
			}
		}else {
			//如果为空 新建一个该map
            $scope.entity.goodsDesc.specificationItems.push(
				{"attributeName":name ,"attributeValue" :[value]}
			)

		}

    }

    $scope.createItemList=function () {
		//定义初始集合
        $scope.entity.itemList = [{spec:{},price:0, num: 999,status:0,isDefault:0 }]
        //规格列表
        var items =$scope.entity.goodsDesc.specificationItems;
        //遍历规格
		for(var i=0;i< items.length;i++){

            $scope.entity.itemList =addColumn( $scope.entity.itemList,items[i].attributeName,items[i].attributeValue );
		}
    }
    addColumn = function (list ,columnName  ,conlumnValues ) {
		var newList = [] ;
        for(var i=0;i< list.length;i++){
            var oldRow= list[i];//得到一行
			for(var j=0;j<conlumnValues.length;j++) {//遍历列数
				var newRow= JSON.parse( JSON.stringify( oldRow ));//深克隆
                newRow.spec[columnName]=conlumnValues[j];
				newList.push(newRow);

			}
		}
			return newList;
    }


    
});	
