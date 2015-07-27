var userJqGrid =
    {
		/**初始化*/
		init:function(){
			//初始化Grid数据
            jQuery("#depQueryTable").jqGrid({
            	url: basePath + "/dep/queryList",
    			datatype: 'json',
    			mtype: 'POST',
                shrinkToFit:true,
                width:'100%',
                height:'100%',
                colNames:['ID','部门编号','部门名称', '上级编号', '是否有效', '最后修改时间'],
    			colModel:[
    				{name:'id',index:'id', width:60, sorttype:"int", hidden: true, sortable: false, editable: false},
    				{name:'code',index:'code', width:300, sortable: false, editable: false},
    				{name:'name',index:'name', width:200, sortable: false, editable: false},
    				{name:'parentNum',index:'parentNum',width:300, sortable: false, editable:false},
    				{name:'effect',index:'effect', width:120, sortable:false,editable: false, editable:false, formatter: setEffectShow},
    				{name:'updateTime',index:'updateTime', width:200, sortable:false, editable:false}, 
    			], 
    			
    			viewrecords : true,
                rowNum:10,
                rowList:[10, 20, 30],
                pager:"#depQueryPager",
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
					var table = this;
					setTimeout(function(){
						styleCheckbox(table);
						
						updateActionIcons(table);
						updatePagerIcons(table);
						enableTooltips(table);
					}, 0);
				},
                
                //caption:"部门信息",
                autowidth: true
            }).navGrid('#depQueryPager',{
            	edit:false,
            	editicon : 'icon-pencil blue',
            	add:false,
            	addicon : 'icon-plus-sign purple',
            	del:false,
            	delicon : 'icon-trash red',
            	search:false,
            	searchicon : 'icon-search orange',
            	refresh:true,
            	refreshicon : 'icon-refresh green'
            });

            $("#searchBtn").click(function () {
            	
            	$("#depQueryTable").jqGrid("setGridParam",
        			{postData: {
            			code: $("#code").val(),
            			name: $("#name").val()
            			//,
            			//effect: $("#effect").val(),
            			//startTime: $("#startTime").val(),
            			//endTime: $("#endTime").val()
        			}}
            	).trigger("reloadGrid",[{page:1}]);
            });
		}
    };

	function setEffectShow(cellvalue, options, rowObject) {
		if (cellvalue == "0") {
			return "无效";
		} else if (cellvalue == "1") {
			return "有效";
		}
	}

	$(document).ready(function () { userJqGrid.init(); });
