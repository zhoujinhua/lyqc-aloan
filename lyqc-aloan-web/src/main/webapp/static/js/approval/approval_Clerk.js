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
    var html = '<a data-id='+data+' href="javascript:audit(\''+data+'\')">审批</a>';
    return data=html;
}

function audit(appCode){
    location.href = '/caappapproval/findCaApp?operate=carloanapproval/approval/approval_Clerk_Detail&code='+appCode+"&juid="+juid;
}



