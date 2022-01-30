function editEvent(e){
    // get id
    var id = e.currentTarget.parentNode.id;
    
    // go to the edit page
    window.location.href = "/editEvent?id="+id;
}

function deleteEvent(e){
    // get id
    var id = e.currentTarget.parentNode.id;
    
    // go to the edit page
    window.location.href = "/deleteEvent?id="+id;
}

function addEventListenerManageparticipant(){
    // Add event listener to each edit button
    document.querySelectorAll(".row-event-edit").forEach(row => {
        row.addEventListener('click' , editEvent);
    })

    // Add event listener to each edit button
    document.querySelectorAll(".row-event-delete").forEach(row => {
        row.addEventListener('click' , deleteEvent);
    })
}


// Algo
// Add every participant
addEventListenerManageparticipant();

