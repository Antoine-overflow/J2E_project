define(['jquery'],function ($) {    
	'use strict';
	return {
		init: function(opts) {
			var selector = opts.selector;
			selector.keyup(function() {
				$(this).val($(this).val().toUpperCase());
			});
		}
	};
});
