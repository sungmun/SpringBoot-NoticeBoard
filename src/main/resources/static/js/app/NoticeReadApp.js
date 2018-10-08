var read={
	init:function(){
		var _this=this;
	},
	commentRead:function(){
		var data={
			num:$('.notice').data('notice')
		};
		
		$.ajax({
			url:'/comment/read',
			type:'get',
			data: data,
			dataType:'json',
			contentType:'application/json; charset=utf-8',
		}).done(function(data){
			console.log(data);
		}).fail(function(error){
			console.log(error);
		});
	},
}
read.init();