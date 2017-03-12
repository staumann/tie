
function getFormData($form) {
	return {
		"techName" : $form.find('input[name="tech-title"]').val(),
		"description" : $form.find('textarea[name="tech-description"]').val(),
		"preconditions": ""
	};
}

$(function() {
	var settings = {
		'buttonSelector': '.save-new-tech',
		'targetUrl': '/tie/SaveTech',
		'form': $('form[name="new-tech-form"]')
	};
	$(document).off('click', settings.buttonSelector).on('click', settings.buttonSelector, function(e){
		e.preventDefault();
		var data = getFormData(settings.form);
		var temp = [];
		
		settings.form.find('input.precondition-cb:checked').each(function() {
			var $this = $(this);
			
			temp.push($this.attr('data-uuid'));
		});

		data.preconditions = temp.join(";");
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