function check_auth1(auth){
	$.ajax({
        			url: "updatevisible.html?", // 方法名 delete
        			data: {
        				towerids:towerids,
        				state:0
        			},
        			dataType: "json",
        			type: "POST",
        			cache: false,
        			success: function(data) {
        				if (data.result.error) {
        					myAlert(data.result.errorMessage);
        					jump(1);
        				} else {
        					myAlert("删除成功");
        					jump(1);
        					$('#sample_1').dataTable().fnDraw();
        				}
        			},
     });
}


function check_auth(auths,auth){
	if(auths==''){
		
	   return 0;
	  }
	 if(auths.indexOf(auth)>0)
	   return 1;
	return 0;
}

/**
 * 倒计时，运行关闭提示窗口
 * count=1
 */
function jump(count) { 
    window.setTimeout(function(){ 
        count--; 
        if(count > 0) { 
            jump(count); 
        } else {
        	myAlertClose();
        } 
    }, 3000); 
} 