var images =[
             { src: basePath+"/static/avatars/slider1.jpg", ext:"4", width:"280" },
             { src: basePath+"/static/avatars/slider2.jpg", ext:"4", width:"280" }
            ];	

function getRandomImage(arr){		
	var _temp=0,_random=0,_weight,_newArr=[];		
	for (var i=0;i<arr.length;i++){			
		_weight=arr[i].ext?parseInt(arr[i].ext):1; 
		_newArr[i]=[]; 
		_newArr[i].push(_temp); 
		_temp+=_weight; 
		_newArr[i].push(_temp);		
	}		
	_random = Math.ceil(_temp*Math.random());		
	for (var i=0;i<_newArr.length;i++){			
		if(_random>_newArr[i][0]&&_random<=_newArr[i][1]){				
			return arr[i];			
		}		
	}		
}

function getRandomPicNode(){	
	var img = getRandomImage(images);
	var imgNode="<img src='" + img.src + "' class='img-responsive' style='position:absolute;left:5px;top:5px;height:215px;width:280px' />";
	return imgNode;
}