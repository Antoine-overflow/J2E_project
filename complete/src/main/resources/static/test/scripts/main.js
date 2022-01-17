require.config({
    baseUrl: 'scripts',
    paths: {
        jquery: 'lib/jquery-2.1.3.min'
    }
});

require(['jquery', 'lib/less', 'capitalize-input', 'persist-placeholders', 'validate'], function($, less, capitalizeInput, persistPlaceholders, validate) {
	'use strict';
	// Initialize JS modules with appropriate selectors
	capitalizeInput.init({selector: $('.middle-initial').add('.state')});
	persistPlaceholders.init({container: $('.registration')});
	validate.init({form: $('.registration')});
});
