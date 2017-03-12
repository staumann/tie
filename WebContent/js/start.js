var settings = {
	'loginUrl': '/tie/Login'	
};

$(function() {
	$(document).on('click', '.login-button', function() {
		var pw = $.trim($('input[name="game-password"]').val());
		var gn = $.trim($('input[name="game-name"]').val());
		postJSON({
			url: settings.loginUrl,
			data : {
				'gameName' : gn,
				'pw': pw
			},
			success: function(data) {
				
				if(data.success) {
					location.href= data.targetUrl;
				}else {
					alert('error');
				}
				

			}
		});
	});
});