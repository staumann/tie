
function init() {
	$(document).off('click', '.logout-button').on('click', '.logout-button', function(e) {
		e.preventDefault();
		
		postJSON({
			"url": "/tie/Logout",
			"data" : {},
			"success" : function() {
				location.href = "/tie/Start";
			}
		});
	});
}

function postJSON(settings) {
	 $.ajax({
		 url: settings.url,
	     method: "POST",
	     type: "POST",
	     async: !0,
	     accepts: 'application/json',
	     data: JSON.stringify(settings.data),
	     dataType: "json",
	     contentType: "application/json; charset\x3dutf-8",
	     processData: !1,
	     beforeSend: settings.beforeSend,
	     complete: settings.complete,
	     success: function(b, c, d) {
	         "function" === typeof settings.success && settings.success(b, c, d)
	     },
	     error: function(b) {
	     	 "function" === typeof settings.error && settings.error(b.status, b.responseText, b)
	     }
	 });
}

$(function() {
	init();
});