
function getFormData($form) {
	return {
		"raceName" : $form.find('input[name="raceName"]').val(),
		"description" : $form.find('textarea[name="description"]').val(),
		"battleValueCruiser": $form.find('input[name="battleCruiser"]').val(),
		"battleValueDestroyer": $form.find('input[name="battleDestroyer"]').val(),
		"battleValueDreadnought": $form.find('input[name="battleDreadnought"]').val(),
		"battleValueFreighter": $form.find('input[name="battleFreighter"]').val(),
		"battleValueFighter": $form.find('input[name="battleFighter"]').val(),
		"battleValueGroundForce": $form.find('input[name="battlegroundforce"]').val(),
		"battleValuePDS": $form.find('input[name="battlepds"]').val(),
		"battleValueMech": $form.find('input[name="battlemech"]').val(),
		"tradeContract1": $form.find('select[name=trade1]').val(),
		"tradeContract2": $form.find('select[name=trade2]').val(),
		"startingTechs": [],
		"startingUnits": {
			"cruiser": $form.find('input[name="cruiser-input"]').val(),
			"fighter": $form.find('input[name="fighter-input"]').val(),
			"freighter": $form.find('input[name="freighter-input"]').val(),
			"destroyer": $form.find('input[name="destroyer-input"]').val(),
			"dreadnoughts": $form.find('input[name="dreadnought-input"]').val(),
			"warSun": $form.find('input[name="warSun-input"]').val(),
			"groundForces": $form.find('input[name="groundForces-input"]').val(),
			"spaceDocks": $form.find('input[name="spaceDocks-input"]').val(),
			"pds": $form.find('input[name="pds-input"]').val(),
			"spaceDocks": $form.find('input[name="spaceDocks-input"]').val(),
			"mechs": $form.find('input[name="mechs-input"]').val()
		}
	};
}





$(function() {
	var settings = {
		'buttonSelector': '.save-new-race',
		'targetUrl': '/tie/SaveRace',
		'form': $('form[name="new-race-form"]')
	};
	$(document).off('click', settings.buttonSelector).on('click', settings.buttonSelector, function(e){
		e.preventDefault();
		var data = getFormData(settings.form);
		
		var temp = [];
		
		settings.form.find('input.precondition-cb:checked').each(function() {
			var $this = $(this);
			
			temp.push($this.attr('data-uuid'));
		});
		
		data.startingTechs = temp.join(";");
		postJSON({
			url: settings.targetUrl,
			data: data,
			success: function(a) {
				alert('success');
			},
			error: function(a) {
				alert('success');
			}
		});
	});
});
