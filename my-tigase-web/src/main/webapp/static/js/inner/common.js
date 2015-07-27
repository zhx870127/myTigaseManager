var format_date="yyyy-mm-dd";
var format_time="hh:ii";
var format_date_time="yyyy-mm-dd hh:ii:ss";

function setDatePicker(clazz){
	$("."+clazz).datetimepicker({format: format_date, autoclose:true, todayBtn:1, todayHighlight:true, language:'zh-CN',minView: "month" });
}
function setTimePicker(clazz){
	$("."+clazz).datetimepicker({format: format_time, autoclose:true, todayBtn:1, todayHighlight:true, language:'zh-CN',startView:1 });
}
function setDateTimePicker(clazz){
	$("."+clazz).datetimepicker({format: format_date_time, autoclose:true, todayBtn:1, todayHighlight:true, language:'zh-CN' });
}

function timeLessThan(t1id,t2id){
	var time1=$("#"+t1id).val();
	var time2=$("#"+t2id).val();
	if(time1==null || time1=="" || time2==null || time2==""){
		return true;
	}
	var t1=new Date(time1.replace("-", "/").replace("-", "/"));
	var t2=new Date(time2.replace("-", "/").replace("-", "/"));
	return t1 < t2;
}

//固定电话验证
function isphone (value) {
     var length = value.length;   
     var phone = /^(((0+)|\+)?\d{2,}-)?\d{3,4}-\d{7,8}(-\d{3,})?$/; 
     return (length >=11 && phone.exec(value))? true:false;
 } 
//手机号码验证
function ismobile (value) {
     var length = value.length;   
     var mobile = /^1[3,5,7,8]{1}\d{9}$/;   
     return (length == 11 && mobile.exec(value))? true:false;
}

jQuery.validator.addMethod("phone", function(value, element, params) { 
            return  this.optional(element)|| isphone(value) || ismobile(value);
        },
        '联系方式格式不正确,正确格式:010-88886666或11位手机号'
);