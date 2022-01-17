define(['jquery', 'contain'],function ($, contain) {    
	'use strict';
	return {
		init: function(opts) {
			var containerClass = contain.init({selector: '.registration input:not(:submit)'});

			var container = opts.container;
			$(function() {
				// Populate input's container with .persisted-placeholder
				$(container).find('input[placeholder]').each(function(i, el) {
					var text = $(el).attr('placeholder');
					$(el).parent('.' + containerClass).prepend('<span class="persisted-placeholder">' + text + '</span>');
				});

				// Toggle .persisted-placeholder based on whether value is blank
				$(container).find('input[placeholder]').keyup(function(event) {
					var persistedPlaceholder = $(event.target).parent('.' + containerClass).find('.persisted-placeholder');
					if ($(event.target).val() === '') {
						persistedPlaceholder.hide();
						$(event.target).removeClass('make-way');
					} else {
						persistedPlaceholder.show();
						$(event.target).addClass('make-way');
					}
				});
			});
		}
	};
});
