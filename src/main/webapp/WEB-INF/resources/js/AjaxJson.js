function postAjaxRequest(requestURL,ajaxrequestdata,callbackfunctionName) {
	$.ajax({
		async: true,
//		async: false,
		type: "POST", 
		url: requestURL,
		data: ajaxrequestdata, //+ "&reqType=AJAX",
		contentType: "application/json",
//		dataType: 'json',
		success: function(r){
//			console.log(r);
//			jsonResponse = eval('('+$.trim(r)+')');
			try {
//				callbackfunctionName(jsonResponse);
				callbackfunctionName(r);
			} catch (e) {}
		},
		error: function(r){
			alert(JSON.stringify(r));
			console.log(JSON.stringify(r));
		}
	});
}

function getAjaxRequest(requestURL,ajaxrequestdata,callbackfunctionName) {
	$.ajax({
		async: true,
		type: 'GET', 
		url: requestURL,
		data: ajaxrequestdata, //+ "&reqType=AJAX",
		contentType: "application/json",
		success: function(r){
//			console.log(r);
//			jsonResponse = eval('('+$.trim(r)+')');
			try {
//				callbackfunctionName(jsonResponse);
				callbackfunctionName(r);
			} catch (e) {}
		},
		error: function(r){
			console.log(JSON.stringify(r));
		}
	});
}

function putAjaxRequest(requestURL,ajaxrequestdata,callbackfunctionName) {
	$.ajax({
		async: true,
		type: 'PUT', 
		url: requestURL,
		data: ajaxrequestdata, //+ "&reqType=AJAX",
		contentType: "application/json",
		success: function(r){
//			console.log(r);
//			jsonResponse = eval('('+$.trim(r)+')');
			try {
//				callbackfunctionName(jsonResponse);
				callbackfunctionName(r);
			} catch (e) {}
		},
		error: function(r){
			console.log(JSON.stringify(r));
		}
	});
}

$.fn.serializeObject = function()
{
   var o = {};
   var a = this.serializeArray();
   $.each(a, function() {
       if (o[this.name]) {
           if (!o[this.name].push) {
               o[this.name] = [o[this.name]];
           }
           o[this.name].push(this.value || '');
       } else {
           o[this.name] = this.value || '';
       }
   });
   return o;
};
