app.controller("contentController",function ($scope,contentService) {
    $scope.contentList=[];
    $scope.findByCategoryId=function (id) {
        contentService.findByCategoryId(id).success(function (response) {
            $scope.contentList[id]=response;


        })
    }

})