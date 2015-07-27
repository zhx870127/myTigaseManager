var projectAdd = {
		//初始化
	projectList:function(){
		//初始化Grid数据
        jQuery("#projectGrid").jqGrid({
        	url: basePath + "/record/queryProjectList",
			datatype: 'json',
			mtype: 'POST',
            shrinkToFit:true,
            width:'100%',
            height:'100%',
            colNames:['ID','项目名称','项目域名', '对应组', 'svn地址', '上线成功通知人列表'],
			colModel:[
				{name:'id',index:'id', width:60, sorttype:"int", hidden: true, sortable: false, editable: false},
				{name:'projectName',index:'projectName', width:180, sortable: false, editable: false},
				{name:'projectDomainName',index:'projectDomainName', width:180, sortable: false, editable: false},
				{name:'groupNo',index:'groupNo',width:120, sortable: false, editable:false},
				{name:'svnUrl', index:'svnUrl', width:1,  hidden: true, sortable: false, editable:false},
				{name:'userList', index:'userList', width:1,  hidden: true, sortable: false, editable:false}
			], 
			
			viewrecords : true,
            rowNum:10,
            rowList:[10, 20, 30],
            pager:"#pProjectGrid",
            altRows: true,
            jsonReader:{
                root:"result",
                total:"pageUtil.totalPage",
                page:"pageUtil.curPage",
                records:"pageUtil.totalRow",
                repeatitems:false
            },
            sortable: false,
            
            loadComplete : function() {
				var table = this;
				setTimeout(function(){
					styleCheckbox(table);
					
					updateActionIcons(table);
					updatePagerIcons(table);
					enableTooltips(table);
				}, 0);
			},
            autowidth: true,
            prmNames: {page:"curPage",rows:"pageSize"}
        }).navGrid('#pProjectGrid',{
        	edit:false,
        	add:false,
        	del:false,
        	search:false,
        	refresh:false
        });

        $("#searchProject").click(function () {
        	$("#projectGrid").jqGrid("setGridParam",
    			{postData: {
    				projectName: $("#projectName_Condition").val()
    			}}
        	).trigger("reloadGrid",[{page:1}]);
        });
	},


	//在 打包记录新增界面点击“选择项目” 执行此法
   clearPorjectSel:function(){
	   $("#projectName_Condition").val("");
   },
   clearUserSel:function(type){
	   $("#userSelType").val(type);
	   $("#userConditionSingle_name").val("");
	   $("#userConditionSingle_cn_name").val("");
	   $("#searchUser_single").click();
	   
   },
   //更改"测试类型"触发的事件
   testTypeChange:function(){
		var testTypeDiv = $("input[name=testType]:checked").val();
		if(testTypeDiv == 1){
			$("#testTypeDiv").removeClass().addClass("hidden");
			$("#testerName").val("");
			$("#testerMail").val("");
			$("#testerNo").val("");
		}else{
			$("#testTypeDiv").removeClass().addClass("block");
		}
   },
   //选择项目界面  确定按钮
   projectAddBtn:function(){
	   var id=$("#projectGrid").jqGrid('getGridParam',"selrow");	
	   var selectRow=$("#projectGrid").jqGrid('getRowData',id);
	   $("#projectName").val(selectRow.projectName);
	   $("#projectDomainName").val(selectRow.projectDomainName);
	   $("#groupNo").val(selectRow.groupNo);
	   $("#svnUrl").val(selectRow.svnUrl);
	   $("#userList").val(selectRow.userList);
	   $("#project-modal-form").modal('hide');
   },
   
   /**  初始化人员 */
   userList:function(){
		//初始化Grid数据
	   jQuery("#userGrid_single").jqGrid({
	       url: basePath + "/portal/queryUserList",
	       datatype: 'json',
	       mtype: 'POST',
	       shrinkToFit:true,
	       width:'100%',
	       height:'100%',
	       colNames:['编号','账号','姓名','邮箱', '用户部门'],
	       colModel:[
	                 {name:'id',index:'id', hidden: true, width:1, sortable: false, editable: false},
	                 {name:'name',index:'name', width:150, sortable: false, editable: false},
	                 {name:'cnName',index:'cnName', width:100, sortable: false, editable: false},
	                 {name:'email',index:'email', width:150, sortable: false, editable: false},
	                 {name:'depName',index:'depName',width:130, sortable: false, editable:false},
			], 
			
			viewrecords : true,
            rowNum:10,
            rowList:[10, 20, 30],
            pager:"#pUserGrid_single",
			altRows: true,
			jsonReader:{
				root:"result",
                total:"pageUtil.totalPage",
                page:"pageUtil.curPage",
                records:"pageUtil.totalRow",
                repeatitems:false
			},
			sortable: false,
           
			loadComplete : function() {
				var table = this;
				setTimeout(function(){
					styleCheckbox(table);
					
					updateActionIcons(table);
					updatePagerIcons(table);
					enableTooltips(table);
				}, 0);
			},
           autowidth: true,
           prmNames: {page:"curPage",rows:"pageSize"}
       }).navGrid('#pUserGrid_single',{
       		edit:false,
       		add:false,
       		del:false,
       		search:false,
       		refresh:true
       });

       $("#searchUser_single").click(function () {
       		$("#userGrid_single").jqGrid("setGridParam", { 
       				postData: {
       					name: $("#userConditionSingle_name").val(),
       					cnName: $("#userConditionSingle_cn_name").val()
       				}
       			}).trigger("reloadGrid",[{page:1}]);
       });
	},
	userAddSingleBtn:function(){
		 var id=$("#userGrid_single").jqGrid('getGridParam',"selrow");	
    	 var selectRow=$("#userGrid_single").jqGrid('getRowData',id);
    	 var userSelType = $("#userSelType").val();
    	 if(userSelType == 1){
    		 $("#testerName").val(selectRow.cnName);
	    	   $("#testerMail").val(selectRow.email);
	    	   $("#testerNo").val(selectRow.id);
	    	   $("#user-modal-single-form").modal('hide');
    	 }else if(userSelType == 2){
    		  var users = $("#userList").val();
    		  var mail = selectRow.email;
    		  if(users == "" || users==null){
    			  $("#userList").val(mail);
    		  } else if(users.indexOf(mail)<0){ 
    			  $("#userList").val(users+","+ mail);
    		  }
    	 }
	},
	savePackage:function(saveType){
		var form = $("#add_packagerecord");
		jQuery.ajax({
			type: "POST",
			url: basePath + "/record/savePackage/"+saveType,
			dataType : 'json',
			data: form.serialize(),
			success: function(data){
				if(data == null){
					alert("操作失败");
				} else if(data.code==200){
					alert("操作成功");
					$("#saveReSet").click();
					$("#testTypeDiv").removeClass().addClass("hidden");
					
				} else{
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
	},
	updatePackage:function(updateType){
		var form = $("#add_packagerecord");
		jQuery.ajax({
			type: "POST",
			url: basePath + "/record/updatePackage/"+updateType,
			dataType : 'json',
			data: form.serialize(),
			success: function(data){
				if(data == null){
					alert("操作失败");
				} else if(data.code==200){
					alert("操作成功");
					window.location.href=("/record/list/edit");
				} else{
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
	},
	yanzheng:function(){
		$('#add_packagerecord').validate({
			errorElement:"em",
			errorClass:"red",
			rules: {
				projectDomainName: {required: true},
				projectName: {required: true},
				requestName: {required: true},
				svnUrl: {required: true}
			},
	
			messages: {
				projectDomainName: { required: "请输入项目域名"},
				projectName: { required: "请输入项目名称"},
				requestName: { required: "请输入需求名称"},
				svnUrl: { required: "请输入svn地址"}
			}
		});
	}
		
};

$(document).ready(function () { 
	projectAdd.yanzheng();
	projectAdd.projectList();
	projectAdd.userList();
	//测试类型 radio事件
	$("input[name=testType]").change(function(){
		projectAdd.testTypeChange();
	});
	//选择项目  按钮事件
	$("#selProject").click(function(){
		projectAdd.clearPorjectSel();
	});
	//点击测试人员选择的 “选择人员” 按钮
	$("#selUserSingle").click(function(){
		projectAdd.clearUserSel(1);
	});
	//上线成功通知人列表 的 “选择人员” 按钮
	$("#userListSel").click(function(){
		projectAdd.clearUserSel(2);
	});
	//选择项目界面  确定按钮
	$("#project_add_btn").click(function(){
		projectAdd.projectAddBtn();
	});
	//选择测试人员界面  确定按钮
	$("#user_add_single_btn").click(function(){
		projectAdd.userAddSingleBtn();
	});
	//保存按钮事件
	$("#save_btn").click(function(){
		var form = $("#add_packagerecord");
		if(form.valid()==false){
			return;
		}
		if($("#id").val()!= undefined && $("#id").val() != ""){//表示修改 保存
			projectAdd.updatePackage(1);
		}else{//表示首次 保存
			projectAdd.savePackage(1);
		}
		
	});
	//下一步事件
	$("#next_btn").click(function(){
		var form = $("#add_packagerecord");
		if(form.valid()==false){
			return;
		}
		if($("#id").val()!= undefined && $("#id").val() != ""){// 表示修改 点击下一步
			projectAdd.updatePackage(2);
		}else{//表示首次 点击  下一步
			projectAdd.savePackage(2);
		}
		
	});
});
		