/**
 * Function that add event on each input to detect change
 */
function addFormEvent () {
    // Add event on change for each imput
    document.querySelectorAll(".input").forEach(e => {
        e.addEventListener('change', checkValueInput);
    });
}

/**
 * Function that check if the content of a certain input is correct
 * @param {Event || Element} e 
 */
function checkValueInput(e) {
    // Get id, type and value of the input
    var id = e.currentTarget.id || e.id;
    var type = id.split("input-")[1];
    var value = e.currentTarget.value || e.value;

    // Debug
    console.log({id, type, value});

    // Check First Name
    if (type == "first-name") {
        if (value == "" || value == undefined) {
            e.currentTarget.style.borderColor = "red";
            e.currentTarget.style.color = "red";
            return;
        } else {
            e.currentTarget.style.borderColor = "#B1D2DB";
            e.currentTarget.style.color = "#B1D2DB";
            return;
        }
    }

    // Check Last Name
    if (type == "last-name") {
        if (value == "" || value == undefined) {
            e.currentTarget.style.borderColor = "red";
            e.currentTarget.style.color = "red";
            return;
        } else {
            e.currentTarget.style.borderColor = "#B1D2DB";
            e.currentTarget.style.color = "#B1D2DB";
            return;
        }
    }


    // Check Email
    if (type == "mail") {
        if (value == "" || value == undefined || value.split("@").length != 2 || value.split("@")[1].split(".").length != 2) {
            e.currentTarget.style.borderColor = "red";
            e.currentTarget.style.color = "red";
            return;
        } else {
            e.currentTarget.style.borderColor = "#B1D2DB";
            e.currentTarget.style.color = "#B1D2DB";
            return;
        }
    }


    // Check Birth Date
    if (type == "birth") {
        // Get current date
        var today = Date.now();
        var min = Date.parse("1900-01-01");
        var birth = Date.parse(value);

        if (value == "" || value == undefined || birth < min || birth > today) {
            e.currentTarget.style.borderColor = "red";
            e.currentTarget.style.color = "red";
            return;
        } else {
            e.currentTarget.style.borderColor = "#B1D2DB";
            e.currentTarget.style.color = "#B1D2DB";
            return;
        }
    }

    // Check Company
    if (type == "company") {
        if (value == "" || value == undefined) {
            e.currentTarget.style.borderColor = "red";
            e.currentTarget.style.color = "red";
            return;
        } else {
            e.currentTarget.style.borderColor = "#B1D2DB";
            e.currentTarget.style.color = "#B1D2DB";
            return;
        }
    }


}