var settings = {
	'addUrl' : '/tie/AddPlayer'
};

$(function() {
	$(document).off('click', '.add-player-button').on('click','.add-player-button', function() {
		
		var container = $('.add-player-box');
		
		if(container.css('display') === 'none') {
			container.show(500);
		}else {
			container.hide(500);
		}
		
		
	});
	
	$(document).off('click', '.add-player-link').on('click', '.add-player-link', function() {
	
		var playerInput = $('input[name="player-name"]'),
			raceSelect = $('select[name="player-race"]'),
			data = {
				'playerName': playerInput.val(),
				'raceId': raceSelect.val()
			};
		
		postJSON({
			'url' : settings.addUrl,
			'data' : data,
			'success' : function(data) {
				if(data.success) {
					playerInput.val("");
				}
			}
		});
	});
});