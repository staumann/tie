var settings = {
	'createUrl': '/tie/CreateGame'	
};

$(function() {
	$(document).on('click', '.create-game', function() {
		var pw = $.trim($('input[name="game-password"]').val());
		var pwr = $.trim($('input[name="game-password-rep"]').val());
		var gn = $.trim($('input[name="game-name"]').val());
		if(pw != "" && pwr != "" && gn != "") {
			if(pw === pwr) {
				postJSON({
					url: settings.createUrl,
					data : {
						'gameName' : gn,
						'pw': pw
					},
					success: function() {
						location.href="/tie/Start";
					}
				});
			}else {
				alert('pw not match');
			}
		}else {
			alert('input invalid');
		}
	});
});