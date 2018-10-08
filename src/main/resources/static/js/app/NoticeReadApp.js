var read={
	init:function(){
		var _this=this;
	},
	commentSave:function(){
		var data={
				contents:$('#writeComment').html(),
				notice:'{{notice}}',
				member:'tjdans174',//테스트 유저
		}
		$.ajax({
			url:'/comment/write',
			type:'post',
			dataType:'json',
			contentType:'application/json; charset=utf-8',
		}).done(function(){
			alert('Comment가 추가 되었습니다.');
			location.reload();
		}).fail(function(error){
			alert(error);
		});
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