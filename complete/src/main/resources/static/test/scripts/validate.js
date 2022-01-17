define(['jquery', 'contain'],function ($, contain) {    
	'use strict';
	return {
		init: function(opts) {
			var containerClass = contain.init({selector: '.registration input:not(:submit)'});

			var form = opts.form;
			var inputs = form.find('input:not(:submit)');
			$(function() {
				inputs.parent('.' + containerClass).append('<span class="check-mark">&nbsp;&#10003;&nbsp;</span>');

				// Initialize validatable inputs with .validate class after user starts using form
				// Necessary in order to not cause :validate and :invalidate styles to trigger before user has had a chance to type in any inputs
				inputs.blur(function(event) {
					$(event.target).addClass('validate');
				});

				form.find(':submit').click(function() {
					inputs.addClass('validate');
				});
			});
		}
	};
});
