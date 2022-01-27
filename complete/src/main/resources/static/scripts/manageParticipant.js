function editparticipant(e){
    // get id
    var id = e.currentTarget.parentNode.id;
    
    // go to the edit page
    window.location.href = "/editParticipant?id="+id;
}

function deleteparticipant(e){
    // get id
    var id = e.currentTarget.parentNode.id;
    
    // go to the edit page
    window.location.href = "/deleteParticipant?id="+id;
}

function addEventListenerManageparticipant(){
    // Add event listener to each edit button
    document.querySelectorAll(".row-participant-edit").forEach(row => {
        row.addEventListener('click' , editparticipant);
    })

    // Add event listener to each edit button
    document.querySelectorAll(".row-participant-delete").forEach(row => {
        row.addEventListener('click' , deleteparticipant);
    })
}


function displayTableParticipant(){

    // get the div
    var container = document.getElementById("manage-participant-container");

    // <div class="row-participant" id="user_1">
    //     <div  class="row-participant-contain">
    //         <div class="row-participant-text"><p>First Name</p></div>
    //         <div class="row-participant-text"><p>Las Name</p></div>
    //         <div class="row-participant-text"><p>Birth</p></div>
    //         <div class="row-participant-text"><p>Company</p></div>
    //         <div class="row-participant-text"><p>Email</p></div>
    //     </div>
    //     <div class="row-participant-edit">
    //         <p>+</p>
    //     </div>
    //     <div class="row-participant-delete">
    //         <p>x</p>
    //     </div>
    // </div>

    // Add event listener on each row
    addEventListenerManageparticipant();
}




// Algo
// Add every participant
displayTableParticipant();

