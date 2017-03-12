var settings = {
	'raceUrl': '/tie/GetRaces',
	'techUrl': '/tie/GetTechs',
	'gameUrl': '/tie/GetGames',
	'removeGamesUrl' : '/tie/RemoveGames'
};

$(function() {
	$('.acc-container').accordion({
		beforeActivate: function(event, ui) {
			
			if(!ui.newHeader.hasClass('ready')) {
				var type = ui.newHeader.attr('data-type');
				var container = $('.acc-container').find('.' + type + '-container');
				var template = $('.' + type + '-mustache').text();
				postJSON({
					'url': settings[type + 'Url'],
					'success': function(data) {
						container.html(Mustache.render(template,data));
						ui.newHeader.addClass('ready');
						container.removeClass('loader');
					}
					
				});
			}
			
		},
		collapsible : true,
		active : false,
		heightStyle: 'content'
	});
	
	$(document).on('click', '.more-infos', function() {
		$(this).siblings('.race-body','.tech-body','.game-body').toggleClass('show');
	});
	
	$(document).off('click', '.delete-game-button').on('click', '.delete-game-button', function() {
		
		var games = [];
		
		$('.game-checkbox:checked').each(function() {
			games.push($(this).val());
		});
		
		postJSON({
			'url' : settings.removeGamesUrl,
			'data' : games,
			'success' : function(data) {
				var container = $('.game-container');
				var template = $('.game-mustache').text();
				container.html(Mustache.render(template,data));
			},
			'error' : function() {
				alert('Scheiße Fehler!');
			}
		});
	});
});