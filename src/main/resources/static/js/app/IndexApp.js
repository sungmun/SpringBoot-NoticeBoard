var index={
	init:function(){
		var _this=this;
	},
	pageRange:function(nowpage,totalpage){
		var minpage=nowpage-4;
		var maxpage=nowpage+4;
		
		if(minpage<=0) minpage=1;
		if(maxpage>=totalpage) maxpage=totalpage;
		
		var range=[];
		for(;minpage<=maxpage;minpage++){
			range.push(minpage);
		}
		
		return range;
	}
};
index.init();