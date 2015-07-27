var userJqGrid = {
		 
	init:function(){ //初始化Grid数据
	    jQuery("#userQueryTable").jqGrid({
	    	url: basePath + "/user/queryList",
			datatype: 'json',
			mtype: 'POST',
	        shrinkToFit:true,
	        width:'100%',
	        height:'100%',
	        colNames:['权限','ID','账号','编号','姓名', '邮箱', '联系方式','岗位', '状态', '用户类型', '创建时间', '创建人', '备注'],
			colModel:[
			    {name:'myac1',index:'', width:60, fixed:true },
			    {name:'id',index:'id', width:60, sorttype:"int", hidden: true, editable: true, editoptions:{size:"25",maxlength:"15"}},
				{name:'name',index:'name', width:120,editable: true,editoptions:{size:"25",maxlength:"25",readonly: 'readonly' },editrules:{required:true} ,formoptions:{elmsuffix:"<span style=\"color:red\">*</span>"}},
				{name:'code',index:'code', width:60, editable: true, editoptions:{size:"25",maxlength:"15"},editrules:{required:true} ,formoptions:{elmsuffix:"<span style=\"color:red\">*</span>"}},
				{name:'cnName',index:'cnName',width:80, editable:true, editoptions:{size:"25",maxlength:"30"},editrules:{required:true} ,formoptions:{elmsuffix:"<span style=\"color:red\">*</span>"}},
				{name:'email',index:'email', width:180, editable:true, editoptions:{size:"25",maxlength:"40"},editrules:{required:true,email:true} ,formoptions:{elmsuffix:"<span style=\"color:red\">*</span>"}},
				{name:'phoneNo',index:'phoneNo', width:100, editable:true, editoptions:{size:"25",maxlength:"25"},editrules:{custom:true, custom_func:checkPhoneNumber} ,formoptions:{elmsuffix:"<span style=\"color:red\">*</span>"}},
				{name:'jobTitle',index:'jobTitle', width:90, editable:true, editoptions:{size:"25",maxlength:"30"}}, 
				{name:'status',index:'status', width:60, editable: true,edittype:"select", editoptions:{value:"1:在职;2:离职"}, formatter: setStatusShow}, 
				{name:'userType',index:'userType', width:70, editable: false,edittype:"select",editoptions:{value:"2:外派"}, formatter: setUserTypeShow}, 
				{name:'createTime',index:'createTime', width:120, editable:false, sorttype:"date",unformat: "pickDate"}, 
				{name:'createUser',index:'createUser', width:90, editable: false}, 
				{name:'remark',index:'remark', width:100, editable: true, edittype:"textarea", editoptions:{rows:"3",cols:"27"}}
			], 
			
			viewrecords : true,
	        rowNum:10,
	        rowList:[10, 20, 30],
	        pager:"#userQueryPager",
	        altRows: true,
			//toppager: true,
			
			multiselect: true,
			//multikey: "ctrlKey",
	        multiboxonly: true,
	        
	        jsonReader:{
	            root:"result",
	            total:"totalpages",
	            page:"currpage",
	            records:"totalrecords",
	            repeatitems:false
	        },
	        sortname:'id',
	        sortorder:"asc",
	        
	        loadComplete : function() {
	        	var dataIds = $(this).jqGrid("getDataIDs");
	        	for (i in dataIds) {
	        		var rowData = $(this).jqGrid("getRowData", dataIds[i]);
	        		if (rowData.userType == "内部") {
	        			$("tr[id='" + dataIds[i] + "'] td[aria-describedby=userQueryTable_cb]").html("");
	        			$("tr[id='" + dataIds[i] + "'] td[aria-describedby=userQueryTable_myac]").html("");
	        		}
	        		if (rowData.status == "在职") {
		        		var view1 = "<i class=\"icon-hand-right green\"></i><a href=\"#user-role-modal-form\" role=\"button\" class=\"blue\" data-toggle=\"modal\" onclick=\"showUserRole('"
		        			+ dataIds[i]+"','"+rowData.name+"','"+rowData.cnName + "');\">分配</a>";
		        		var id="tr[id='" + dataIds[i] + "'] td[aria-describedby=userQueryTable_myac1]";
						$(id).html(view1+$(id).html());
	        		}
	        	}
	        	
				var table = this;
				setTimeout(function(){
					styleCheckbox(table);
					
					updateActionIcons(table);
					updatePagerIcons(table);
					enableTooltips(table);
				}, 0);
			},
			editurl: basePath + "/user/update",
			//caption:"用户信息",
	        autowidth: true
	    }).navGrid('#userQueryPager',
	    	{
		    	edit:true,
		    	editicon : 'icon-pencil blue',
		    	edittext : '编辑',
		    	editfunc :  function (rowid) {
		    		var rowData = $(this).jqGrid('getRowData', rowid);
	    			if (rowData.userType == "内部") {
	    				alert("无法操作内部员工，请重新选择!");
	    				return;
	    			}
		    		$("#userQueryTable").jqGrid('editGridRow', rowid, {closeAfterEdit : true});  
		    	},
		    	add:false,
		    	addicon : 'icon-plus-sign purple',
		    	del:true,
		    	delicon : 'icon-trash red',
		    	deltext : '批量删除',
		    	delfunc : function (rowid) {
		    		if(!confirm("您是否确认删除？")){ 
		    			return;
		    		}
		    		var rowids = [];
		    		for (var i in rowid) {
		    			var rowData = $(this).jqGrid('getRowData', rowid[i]);
		    			if (rowData.userType == "外派") {
		    				rowids.push(rowid[i]);
		    			}
		    		}
		    		
		    		if (rowids.length > 0) {
		    			jQuery.ajax({
		    				type: "POST",
		    				url: basePath + "/user/delete",
		    				dataType : 'json',
		    				data: "userIds="+ rowids ,
		    				
		    				success: function(data){
		    					if(data == null){
									alert("操作失败");
								} else if(data.code==200){
	            					alert("操作成功");
	            					$("#userQueryTable").trigger("reloadGrid"); 
								} else {
	            					alert(data.message);
	            				}
		    				},
		    				
		    				error : function(data) {
		    					if(data == null){
									alert("操作失败");
								} else {
	            					alert(data.message);
								}
		    				}
		    			});
		    		} else {
		    			alert("无法操作内部员工，请重新选择!");
		    		}
		    	},
		    	
		    	search:false,
		    	searchicon : 'icon-search orange',
		    	refresh:true,
		    	refreshicon : 'icon-refresh green',
		    	refreshtext : '刷新'
		    }, 
	    	{closeAfterEdit : true},  // settings for edit 
	    	{closeAfterAdd : true},   // settings for add
	    	{},
	    	{},
	    	{}
	    );	
	}
};

function setStatusShow(cellvalue, options, rowObject) {
	if (cellvalue == "1") {
		return "在职";
	} else if (cellvalue == "2") {
		return "离职";
	}
}

function setUserTypeShow(cellvalue, options, rowObject) {
	if (cellvalue == "1") {
		return "内部";
	} else if (cellvalue == "2") {
		return "外派";
	}
}

function showUserRole(id,name,cnName){
	$("#role_user_id").val(id);
	$("#role_user_info").html("用户： "+cnName+" ("+name+")");
	
	jQuery.ajax({
		type: "POST",
		url: basePath + "/userRole/queryAvailableRoleList",
		dataType : 'json',
		data: "userId=" + id,
		
		success: function(data){
			$("#select1").empty();
			if(data!=null && data.code==200){
				var roleList=data.result;
				if(roleList==null || roleList.length==0){
					return;
				} else {
					for(var i=0;i<roleList.length;i++){
						$("#select1").append($("<option/>").text(roleList[i].name).attr("value",roleList[i].id));
					}
				}
			}
		},
		
		error : function(data) {
			alert("获取可用角色异常");
		}
	});
	
	jQuery.ajax({
		type: "POST",
		url: basePath + "/userRole/queryConfigedRoleList",
		dataType : 'json',
		data: "userId=" + id,
		
		success: function(data){
			$("#select2").empty();
			if(data!=null && data.code==200){
				var roleList=data.result;
				if(roleList==null || roleList.length==0){
					return;
				} else {
					for(var i=0;i<roleList.length;i++){
						$("#select2").append($("<option/>").text(roleList[i].name).attr("value",roleList[i].id));
					}
				}
			}
		}
	});
}

function checkPhoneNumber(value, colname) {
	if (isphone(value) || ismobile(value)){ 
		return [true,""];
	} else {
		return [false,"请输入正确的手机号或固定电话"];
	}
}

$(document).ready(function () { 
	userJqGrid.init(); 
	
	$("#searchBtn").click(function () {
		$("#userQueryTable").jqGrid("setGridParam", {
				postData : {
					code: $("#code").val(),
					name: $("#name").val(),
					cnName: $("#cnName").val(),
					startTime: $("#startTime").val(),
					endTime: $("#endTime").val() 
				}
		}).trigger("reloadGrid",[{page:1}]);
	});

});