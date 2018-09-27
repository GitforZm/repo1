//服务层
app.service('loginService',function ($http) {
    this.getName=function () {
        return $http.get('../login/getLoginName.do');
    }

});