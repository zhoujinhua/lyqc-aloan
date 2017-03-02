$(document).delegate('#fn-btn-search','click',function() {
    reload("data-table");
});
$(document).delegate('#fn-btn-add','click',function() {
    location.href="${path}/view/dealer/company/add.jsp?juid="+juid;
});

/**
 * Created by Administrator on 2017/2/13.
 */
function radioFn(data, type, full, meta){
    var html = '<input type="radio" name="appCode" value="'+data+'"></input>';
    return	data=html;
}

function operator(data, type, full, meta){
    var html = '<a data-id='+data+' href="javascript:accept(\''+data+'\')">领单</a>';
    return data=html;
}

function accept(appCode){
    var status = $("input[name=status]").val();
    $.ajax({
        type : 'POST',
        url : '/caappapproval/accept',
        data : {'appCode' : appCode,'status' : status},
        success : function(data){
            $.alert(data.responseMsg);
            reload("data-table");
        },
        dataType : 'json'
    });
}

