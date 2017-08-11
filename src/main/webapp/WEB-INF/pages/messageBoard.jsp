<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MessageBoard</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1 style="color:blue;">唱 说 天 下 贴 吧</h1>
			<p>钟鑫，I love you</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn
					more</a>
			</p>
		</div>
		<div class="row">

			<div class="input-group">
				<input type="text" class="form-control" placeholder="put into you thinking..."
					id="content"> <span class="input-group-btn">
					<button class="btn btn-default" type="button" id="btn">留言</button>
				</span>
			</div>
		</div>
		<table class="table" id="tab">

		</table>

	</div>
</body>
<script type="text/javascript">
	$("#btn").click(function() {

		
		 $.ajax({
			type : "get",
			url:"/SSMmessageBoard/insert",
			data : {
				"content" : $("#content").val()
			},
			success : function(res) {
				
				if(res.errorrCode==0){
					var r=res.result
					 createTable(r.id ,r.content, r.up, r.down)	
				}
				else{
					alert(res.msg);
				}	
			}
		});
		 $("#content").val("");
	}) 
	function getallMessage(){
	
	 $.ajax({
		 type:"get",
		 url:"/SSMmessageBoard/findAll",
	     success:function(res){
	    	 
	    	 for(var i=0;i<res.length;i++){
	    		 
	    		 
	    		 createTable(res[i].id, res[i].content, res[i].up, res[i].down)
	    		 
	    	 }   	 
	     }
	 });
	 }
	
	function createTable(id, content, up, down) {
		var tdLeft = $("<td></td>").html("<p>"+content+"</p>")
		var tdRight = $("<td></td>")
		$("<a href='###'   class='btn btn-success'>顶 ：</a>").appendTo(tdRight).click(turnUp).attr("upNum",id)
		
		$("<a href=###></a>").html(up).appendTo(tdRight).attr("id","a"+id)
		$("<a href='###'  class='btn btn-warning'>踩 ：</a>").appendTo(tdRight).click(turndown).attr("dwonNum",id)
		
		
		$("<a href=###></a>").html(down).appendTo(tdRight).attr("id","adown"+id)
		/* $("<a href=### onclick='del(this)'>删除</a>").appendTo(tdRight) */
		$("<a href='###'  class='btn btn-danger'>删除</a>").appendTo(tdRight).click(del).attr("num",id)

		/* $("<a href='###'  num="+id+" num=2>删除</a>")    .atrr(num,2)*/
		var tob = $("<tr></tr>").append(tdLeft).append(tdRight).attr("id", "tr"+id)
		$("#tab").prepend(tob)

	}
	/*  function del(btn){
		 
		 btn.parentNode.parentNode.remove();
		
	 } */ 
	 var del=function (){
		 var aid=$(this).attr("num")
		 console.log(aid);
		 /* this.parentNode.parentNode.remove();   */
		  $.ajax({
			 url:"/SSMmessageBoard/deletone",
			 data:{
				 msdid:aid
			 },
			 success:function(res){
				 $("#tr" + res.obj).remove(); 
			 }
		 })   
	 }
	 getallMessage()
	
	 var turnUp=function(){
		 var uid=$(this).attr("upNum")
		 $.ajax({
			 url:"/SSMmessageBoard/up",
			 data:{
				 upId:uid
			 },
			 success:function(res){	 
				 console.log(res.message.up);
				 
				 $("#a"+res.message.id).html(res.message.up); 
			 } 
		 })
	 } 
	 
	 
	 var turndown=function(){
		var did =$(this).attr("downNum")
		console.log("===============");
		$.ajax({
			
			url:"/SSMmessageBoard/down",
			data:{
				downId:did
			},
			success:function(res){
				
				
				$("#adown"+did).html(res.res.down);	
			}

		})
		 
		 
		 
		 
	 }
	 
</script>
</html>