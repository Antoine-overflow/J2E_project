define(['jquery'],function ($) {    
	$('input[placeholder]').each(function() {
		var text = $(this).attr('placeholder');
		var id = $(this).attr('placeholder').replace(' ', '');

		if ($(this).id !== '') {
			$(this)[0].id = id;
			$(this).insertBefore('<label for="' + id + '">' + text + '</label>');
		}
	});
});
