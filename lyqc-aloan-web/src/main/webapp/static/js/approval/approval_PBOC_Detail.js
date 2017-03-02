$(document).ready(function(){
    $( "#accordion_approval" ).accordion({collapsible: true,active:0, heightStyle: 'content'});
    $( "#accordion_caappinfo" ).accordion({collapsible: true,active:0, heightStyle: 'content'});
    $( "#accordion_history" ).accordion({collapsible: true,active:0, heightStyle: 'content'});

    //重置
    $("#fn-btn-reset").click(function() {
        $("#remarks").val("");
        $("input[name='type']:checked").attr("checked",false); //清空选择
        $("input[name='userId']:checked").attr("checked",false); //清空选择
        $("#cancel_type").val("");
        $("#cancel_reason").val("");
    });
})



