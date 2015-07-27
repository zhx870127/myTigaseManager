var MyPopWindow = {
	openWindow : function(url, width, height){
		JqueryDialog.Open1("自动编译系统",url, width ,height);
	},
	openWindow1 : function(url){
		var width=800;
		var height=600;
		MyPopWindow.openWindow(url, width ,height);
	},
	openWindow2 : function(url){
		var width=600;
		var height=400;
		MyPopWindow.openWindow(url, width ,height);
	},
	
	SubmitCompletedCallback : function(data){
		var msg = data.message;
		var result =false;
		if(data.code== "200"){result=true;}	
		//Jquery Dialog回调函数
		window.parent.JqueryDialog.SubmitCompleted(msg, result, result);
	},
	
	SubmitCompletedCallback2 : function(data,url){
		var alertMsg = data.message;
		if($.trim(alertMsg).length > 0 ){alert(alertMsg);}
		var result = data.code== "200"; 	
		if(result && $.trim(alertMsg).length > 0 ){window.location.href = url;}
	},
	
	ExecutePost : function(msg, url, data) {
		var r = window.confirm(msg);
        if(r == true){
			jQuery.post(url, data,
				function(data) {
					alert(data.message);
					if(data.code == "200"){	
						var queryForm=window.document.forms[0];
						if(typeof(queryForm) != "undefined"){
							queryForm.submit();
						}else{
							window.location.href = window.location.href;
						}	
						window.close();
					}
				}
			);
		}
	},
	
	ExecuteDelete : function(url, data) {
		MyPopWindow.ExecutePost("删除后不能恢复，确定删除该条记录吗？", url, data);
	}
}


var CheckboxUtils = {
	/*设置全选或全不选
	 *<input id="checkAll" type="checkbox" onClick="CheckboxUtils.setCheckedAll('subBox',this.checked);"/>全选
	 *或者 
	 * $("#checkAll").click(function() {
        	CheckboxUtils.setCheckedAll("subBox",this.checked);
   		});
	*/
	setCheckedAll : function(subCheckboxName,checked){
		$("input[name='"+subCheckboxName+"']").each(function(){
			this.checked=checked;
		 });
	},
	
	getAllCheckedValues : function (checkboxName){
   		var arrChk=$("input[name='"+checkboxName+"']:checked");
        var s="";
        $(arrChk).each(function(){
           s=s+this.value+',';                        
        });
        if(s.length>0){
	    	  s = s.substr(0,s.length-1);	          
		}
		return s;
   	} 
}

var FormUtils = {
	//调用方法     
	serializeForm : function (formId) {    
		var elements = FormUtils.getElements(formId);    
		var queryComponents = new Array();    
		
		for (var i = 0; i < elements.length; i++) {    
			var queryComponent = FormUtils.serializeElement(elements[i]);    
			if (queryComponent)    
				queryComponents.push(queryComponent);    
		}    
		
		return queryComponents.join('&');  
	},
	//获取指定form中的所有的<input>对象    
	getElements:function (formId) {    
		var form = document.getElementById(formId);    
		var elements = new Array();    
		var tagElements = form.getElementsByTagName('input');    
		for (var j = 0; j < tagElements.length; j++){  
			elements.push(tagElements[j]);  
		}  
		return elements;    
	},
	
	//获取单个input中的【name,value】数组  
	inputSelector:function (element) {    
		if (element.checked)    
			return [element.name, element.value];    
	},
	
	input:function (element) {    
		switch (element.type.toLowerCase()) {    
			case 'submit':    
			case 'hidden':    
			case 'password':    
			case 'text':    
				return [element.name, element.value];    
			case 'checkbox':    
			case 'radio':    
				return FormUtils.inputSelector(element);    
		}    
		return false;    
	},
	
	//组合URL  
	serializeElement:function (element) {    
		var method = element.tagName.toLowerCase();    
		var parameter = FormUtils.input(element);    
		
		if (parameter) {    
			var key = encodeURIComponent(parameter[0]);    
			if (key.length == 0) return;    
			
			if (parameter[1].constructor != Array)    
				parameter[1] = [parameter[1]];    
			  
			var values = parameter[1];    
			var results = [];    
			for (var i=0; i<values.length; i++) {    
				results.push(key + '=' + encodeURIComponent(values[i]));    
			}    
			return results.join('&');    
		}    
	}
}
