var index={
	init:function(){
		var _this=this;
		
		$('ul li a').on('click',function(){
			_this.pageChange( '?page='+($(this).html().replace(/[^0-9]/g,'')-1));
        });
		
		$('tr').on('click',function(){
			_this.pageChange('/notice?num='+$(this).data('notice'));
		});
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
	},
	pageChangeNum:function(){
		var page=$('ul');
		var nowpage=page.data('nowpage')+1;
		
		$('ul li').remove();
		
		this.pageRange(nowpage,page.data('totalpage')).forEach(function(value,index){
			var li=$('<li/>');
			
			if(value==nowpage)	li.addClass('is-active');
			li.append($('<a/>',{text:value}));
			
			page.append(li);
		});
	},
	pageChange:function(href){
		location=href;
	}
};
index.init();