var read={
	init:function(){
		var _this=this;
		var token = $("meta[name='_csrf']").attr("content");
		var header = $("meta[name='_csrf_header']").attr("content");
		$(function() {
		    $(document).ajaxSend(function(e, xhr, options) {
		        xhr.setRequestHeader(header, token);
		    });
		});
	},
	commentSave:function(){
		var data={
				notice:$('.notice').data('notice'),
				contents:$('#writeComment').val(),
		}
		$('#writeComment').val('');
		$.ajax({
			url:'/comment/write',
			type:'post',
			dataType:'json',
			contentType:'application/json; charset=utf-8',
			data:JSON.stringify(data)
		}).done(function(data){
			console.log(data);
			var eventTemplate=Handlebars.compile($('#comment-template').html());
			console.log(eventTemplate);
			$('#comment').html($(eventTemplate({
				comment:data
			})));
			
			alert('Comment가 추가 되었습니다.');
		}).fail(function(error){
			console.log(error);
		});
	},
	commentRead:function(){
		var data={
			num:$('.notice').data('notice')
		};
		
		$.ajax({
			url:'/comment/read',
			type:'post',
			data: data,
			dataType:'json',
			contentType:'application/json; charset=utf-8',
		}).done(function(data){
			var eventTemplate=Handlebars.compile($('#comment-template').html());
			$('#comment').html($(eventTemplate(data)));
		}).fail(function(error){
			console.log(error);
		});
	}
}
read.init();