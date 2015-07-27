var userJqGrid =
    {
		/**初始化*/
		init:function(){
			//初始化Grid数据
            jQuery("#sysLogQueryTable").jqGrid({
            	url: basePath + "/sysLog/queryList",
    			datatype: 'json',
    			mtype: 'POST',
                shrinkToFit:true,
                width:'100%',
                height:'100%',
                colNames:['操作人','资源名称', '访问地址', '访问内容',' 访问IP', '创建时间'],
    			colModel:[
    				{name:'userId',index:'userId', width:150, editable: false},
    				{name:'rname',index:'rname',width:300, editable:false},
    				{name:'url',index:'url', width:500, editable: false},
    				{name:'content',index:'content', width:300, editable: false},
    				{name:'ip',index:'ip', width:180, sortable:false, editable:false}, 
    				{name:'createTime',index:'createTime', width:180, editable:false, sorttype:"date"}
    			], 
    			
    			viewrecords : true,
                rowNum:10,
                rowList:[10, 20, 30],
                pager:"#sysLogQueryPager",
                altRows: true,
    			//toppager: true,
    			
    			multiselect: false,
    			//multikey: "ctrlKey",
    	        multiboxonly: true,
    	        
                jsonReader:{
                    root:"result",
                    total:"totalpages",
                    page:"currpage",
                    records:"totalrecords",
                    repeatitems:false
                },
                sortable: false,
                
                loadComplete : function() {
                	var dataIds = $(this).jqGrid("getDataIDs");
	            	for (i in dataIds) {
	            		var rowData = $(this).jqGrid("getRowData", dataIds[i]);
	            		$("tr[id='" + dataIds[i] + "'] td[aria-describedby=sysLogQueryTable_cb]").html("");
	            		$("tr[id='" + dataIds[i] + "'] td[aria-describedby=sysLogQueryTable_myac]").html("");
	            	}
					var table = this;
					setTimeout(function(){
						styleCheckbox(table);
						
						updateActionIcons(table);
						updatePagerIcons(table);
						enableTooltips(table);
					}, 0);
				},
                //caption:"系统日志",
                autowidth: true
            }).navGrid('#sysLogQueryPager',{
            	edit:false,
            	add:false,
            	del:false,
            	search:false,
            	refresh:true,
            	refreshicon : 'icon-refresh blue'
            },
            {closeAfterEdit : true},  // settings for edit 
            {closeAfterAdd : true},   // settings for add
            {} // settings for del
            );
            
            $("#searchBtn").click(function () {
        		if(!timeLessThan("startTime","endTime")){
        	        alert("开始时间必须早于于结束时间！"); 
        			return;
        	    }
				$("#sysLogQueryTable").jqGrid("setGridParam",
					{postData: {
						userId: $("#userId").val(),
						url: $("#url").val(),
						rName: $("#rName").val(),
						content: $("#content").val(),
						startTime: $("#startTime").val(),
						endTime: $("#endTime").val()
					}}
				).trigger("reloadGrid",[{page:1}]);
			});
		}
    }
   
    $(document).ready(function () { userJqGrid.init(); });
