define(['jquery'],function ($) {    
	'use strict';
	return {
		init: function(opts) {
			var containerClass = (typeof opts.containerClass === 'undefined') ? 'container' : opts.container;
			var selector = opts.selector;

			$(':not(.' + containerClass + ')').children(selector).wrap($('<span class="' + containerClass + '">'));

			return containerClass;
		}
	};
});
