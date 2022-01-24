/**
 * Function that add event on each input to detect change
 */
function addFormEvent () {
    // Add event on change for each imput
    document.querySelectorAll(".input").forEach(e => {
        e.addEventListener('change', checkValueInput);
    });
}

function checkValueInput(e) {
    // Get id, type and value of the input
    var id = e.currentTarget.id;
    var type = id.split("input-")[1];
    var value = e.currentTarget.value;

    console.log(type);
}