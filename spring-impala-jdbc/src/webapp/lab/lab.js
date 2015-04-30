/*impala*/
function impalaCtrl($scope, $http) {
	
    $scope.go = function(keyEvent) {
	if (keyEvent.which == 13) {
   	    $scope.result = '请稍后...(๑•́ ₃ •̀๑)';
	    impalaSelect();
	}
    };
	
    transFn = function(data) {
        return $.param(data);
    };
    postCfg = {
	headers : {'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'},
	transformRequest: transFn
    };

    function impalaSelect() {
	var url = contextPath + '/lab/impala';
	var param = {'sql' : $scope.content};
	$http.post(url, param, postCfg)
	.success(function(response, status) {
	    $scope.result = response;
	})
	.error(function(){
	    $scope.result = '语句执行出错了，请检查一下sql(´Ａ｀。)';
	})
	;
    }
}
