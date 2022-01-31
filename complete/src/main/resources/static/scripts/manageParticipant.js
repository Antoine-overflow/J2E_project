function editParticipant(e){
    // get id
    var id = e.currentTarget.parentNode.id;
    
    // go to the edit page
    window.location.href = "/editParticipant?id="+id;
}

function deleteParticipant(e){
    // get id
    var id = e.currentTarget.parentNode.id;
    
    // go to the edit page
    window.location.href = "/deleteParticipant?id="+id;
}

function addEventListenerManageParticipant(){
    // Add event listener to each edit button
    document.querySelectorAll(".row-participant-edit").forEach(row => {
        row.addEventListener('click' , editParticipant);
    })

    // Add event listener to each edit button
    document.querySelectorAll(".row-participant-delete").forEach(row => {
        row.addEventListener('click' , deleteParticipant);
    })
}


// Algo
// Add every participant
addEventListenerManageParticipant();

