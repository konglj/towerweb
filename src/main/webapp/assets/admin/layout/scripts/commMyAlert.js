function myAlert(ms){
	$("#myModalLabel2").html("提示");
	$(".modal-body #info").html(ms);
	$("#myAlert").trigger("click");
}
function myAlertClose(){
	$('#myModal2').modal('hide');
	 $('.modal-backdrop fade in').remove();
}

function myAlert(ms,fn){
	$("#myModalLabel2").html("提示");
	$(".modal-body #info").html(ms);
	$("#alert_btn_submit").unbind('click').bind("click",fn);
	$("#myAlert").trigger("click");
}

function myConfirm(ms,fn){
	$("#myModalLabel3").html("提示");
	$("#btn_submit").unbind('click').bind("click",fn);
	$(".modal-body #myConfirmInfo").html(ms);
	$("#myConfirm").trigger("click");
	
}
function myWarning(ms){
   $("#myWarningLabel3").html("<font color='red'>提示</font>");
   $(".modal-body #myWarningInfo").html("<font color='red' size='4'>"+ ms + "</font>");
   $("#myWarning").trigger("click");
}
function myWarningClose(){
	$('#warning').modal('hide');
}