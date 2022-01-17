# sample-registration-form
Code sample utilizing jQuery, RequireJS, and LessJS. Uses copious amounts of HTML5 and CSS3. 

## One-Liner Launch Party
  * Mac: `git clone https://github.com/DavidRivers/sample-registration-form; "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome" --allow-file-access-from-files sample-registration-form/index.html`
  * Linux: `git clone https://github.com/DavidRivers/sample-registration-form; chromium -allow-file-access-from-files sample-registration-form/index.html`
  * Windows: `git clone https://github.com/DavidRivers/sample-registration-form & start chrome -allow-file-access-from-files file:///PATH/TO/INDEX.HTML`. Please correct the path so that it points to the downloaded index.html.

## Notes
  * CORS issues (caused by local less and RequireJS assets) requires Chrome/Chromium to be launched as: chromium -allow-file-access-from-files.
  * "First Name"/"Last Name" may not be sensible for names that come from certain cultures
  * Regular expressions used in patterns probably don't work with certain edge cases.

## TODO/Feature Enhancements:
  * Validation breaks with Mac/Chrome autofill
  * Progress bar animation doesn't work in Mac/Chrome
  * Unit testing for JS modules. Should have done TDD, really.
  * Create mixins (or polyfills) to implement unsupported HTML5/CSS3
  * Move script/styles dependency pairs into their own directories? Does RequireJS make this easy/doable?
  * Use browser geolocation API to auto-detect city/state/zip code (and apply style showing these were auto-populated and should be reviewed by the user) https://developers.google.com/maps/documentation/geocoding/
  * Coerce state input into upper-case
  * Autocomplete the "State" input
  * Autocomplete the "Suffix" field with a list of common suffixes
  * Autofill City/State/Zip code fields as soon as possible (by hitting some kind of address verification service)
  * Show progress within step (increment progress bar for each field inputted)
