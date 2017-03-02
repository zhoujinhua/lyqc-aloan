$(function(){
	$(".sidebar-nav,#content").height($(window).height()-$(".navbar-static-top").height()-120);
	$.ajax({
		  type: 'post',
		  url: contextPath + '/permset/getMenuJson',
		  success: function(data){
			  var html = '';
			  $.each(data,function(i){
				  html += '<li class=\"accordion\"><a href=\"javascript:;\"><i class=\"'+data[i].menuIcon+'\"></i><span class=\"arrow\"> '+data[i].menuTitle+'</span></a><ul class=\"nav nav-pills nav-stacked sub-menu\">';
				  $.each(data[i].items,function(j){
					  html += '<li data-toggle=\"tooltip\" data-placement=\"right\" title=\"'+data[i].items[j].itemTitle+'\"><a href=\"javascript:;" data-url=\"'+data[i].items[j].itemLocation+'\" data-id='+data[i].items[j].itemId+' data-name='+data[i].items[j].itemTitle+' class="menu-item"><i class=\"'+data[i].items[j].itemIcon+'\"></i><span class=\"arrow\"> '+data[i].items[j].itemTitle+'</span></a></li>';
				  });
				  html += '</ul></li>';
			  });
			  $(".main-menu").append(html);
		  },
		  dataType: 'json'
	});
	$("#modify-info").click(function(){
		var url = contextPath + "/user/modify?juid="+juid;
		$("#sub-content").attr("src",url);
	});
	$("#modify-pwd").click(function(){
		var url = contextPath + "/view/system/user/modifyPwd.jsp?juid="+juid;
		$("#sub-content").attr("src",url);
	});
	$(".nav-header").click(function(){
		$(".active").removeClass("active");
		if($(this).hasClass("ul-colspan-on")){
			$(".nav-header").removeClass("ul-colspan-on").addClass("ul-colspan-off");
			$(".nav-header").find(".glyphicon-hand-left").removeClass("glyphicon-hand-left").addClass("glyphicon-hand-right");
			$("#menu").css("width","3%");
			$(".arrow").css("display","none");
			$("#content").css("width","97%");
		} else {
			$(".nav-header").removeClass("ul-colspan-off").addClass("ul-colspan-on");
			$(".nav-header").find(".glyphicon-hand-right").removeClass("glyphicon-hand-right").addClass("glyphicon-hand-left");
			$("#menu").css("width","16%");
			$(".arrow").css("display","inline");
			$("#content").css("width","84%");
		}
	});
	$(document).delegate('.menu-item','click',function() {
		$("iframe").addClass("hide").hide();
		$(".page-tabs").find(".active").removeClass("active");
		var itemId = $(this).attr("data-id");
		if(itemId && itemId != undefined){
			$(".page-tabs").removeClass("hide").show();
			$("#sub-content").addClass("hide").hide();
			if($("#sub-content-"+itemId).length!=0){
				$("#li-"+itemId).addClass("active");
				$("#sub-content-"+itemId).removeClass("hide").show();
			} else {
				var activeId = $(".page-tabs").find(".active").find("a").attr("data-id");
				if(activeId && activeId != undefined){
					$(".page-tabs").find(".active").removeClass("active");
					$(activeId).addClass("hide").hide();
				}
				
				var url = $(this).attr("data-url");
				var title = $(this).attr("data-name");
				var html = '<li class="active" id="li-'+itemId+'"><a class="page-tabs-task" href="javascript:;" data-id="#sub-content-'+itemId+'">'+title+'<i class="glyphicon glyphicon-remove-sign yellow" style="font-size:12px;"></i></a></li>';
				$(".page-tabs").append(html);
				
				if (!url || url == '') {
		            return;
		        }
		        url = conver_url(url);
		        showDiv();
				var frame = '<iframe id="sub-content-'+itemId+'" onreadystatechange=stateChangeIE(this) onload=stateChangeFirefox(this) src="'+url+'?juid='+juid+'" style="width: 100%;height: 96%;border:none;" frameborder="0"></iframe>';
				$("#content").append(frame);
			}
		} else {
			$(".page-tabs").addClass("hide").hide();
			$("#sub-content").addClass("hide").hide();
		}
	});
	$(document).delegate('.page-tabs-task','click',function() {
		var frameId = $(this).attr("data-id");
		var activeId = $(".page-tabs").find(".active").find("a").attr("data-id");
		if(activeId && activeId != undefined && activeId != frameId){
			$(".page-tabs").find(".active").removeClass("active");
			$(activeId).addClass("hide").hide();
		}
		$(this).parent().addClass("active");
		$(frameId).removeClass("hide").show();
	});
	$(document).delegate('.page-tabs-task .glyphicon-remove-sign','click',function(e) {
		$(".page-tabs").find(".active").removeClass("active");
		$("iframe").addClass("hide").hide();
		var preId = $(this).parent().parent().prev("li").find("a").attr("data-id");
		var nextId = $(this).parent().parent().next("li").find("a").attr("data-id");
		var frameId = $(this).parent().attr("data-id");
		$(this).parent().parent().prev().addClass("active");
		$(frameId).remove();
		
		if(preId && preId != undefined){
			$(this).parent().parent().prev().find("a").click();
		} else {
			if(nextId && nextId != undefined){
				$(this).parent().parent().next().find("a").click();
			} else {
				$(".page-tabs").addClass("hide").hide();
				$("#sub-content").removeClass("hide").show();
			}
		}
		$(this).parent().parent().remove();
		e.stopPropagation();
	});
});
var conver_url = function(url) {
    var contextPath = "/";
    if (url.charAt(0) == '/') {
        if (url.substr(0, contextPath.length) == contextPath) {
            return url;
        } else {
            return contextPath + url;
        }
    } else {
        return url;
    }
}
function showDiv() {
	document.getElementById('popWindow').style.display = 'inline';
	document.getElementById('maskLayer').style.display = 'inline';
}
function closeDiv() {
	document.getElementById('popWindow').style.display = 'none';
	document.getElementById('maskLayer').style.display = 'none';
}
function stateChangeIE (_iframe) {
    if(_iframe.readyState == "complete") 
    	closeDiv();
}
function stateChangeFirefox (_iframe) {
    	closeDiv();
}
function logout() {
	if(confirm("您确定要退出系统吗?")){
    	location.href = contextPath + "/logout?juid="+juid;
    }
}