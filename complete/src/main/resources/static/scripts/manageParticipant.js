function editGuest(e){
    // get id
    var id = e.currentTarget.parentNode.id.split('user_')[1];
    
    // go to the edit page
    window.location.href = "/editGuest?id="+id;
}

function deleteGuest(e){
    // get id
    var id = e.currentTarget.parentNode.id.split('user_')[1];
    
    // go to the edit page
    window.location.href = "/deleteGuest?id="+id;
}

function addEventListenerManageGuest(){
    // Add event listener to each edit button
    document.querySelectorAll(".row-guest-edit").forEach(row => {
        row.addEventListener('click' , editGuest);
    })

    // Add event listener to each edit button
    document.querySelectorAll(".row-guest-delete").forEach(row => {
        row.addEventListener('click' , deleteGuest);
    })
}


function displayTableParticipant(){

    // get the div
    var container = document.getElementById("manage-guest-container");

    // <div class="row-guest" id="user_1">
    //     <div  class="row-guest-contain">
    //         <div class="row-guest-text"><p>First Name</p></div>
    //         <div class="row-guest-text"><p>Las Name</p></div>
    //         <div class="row-guest-text"><p>Birth</p></div>
    //         <div class="row-guest-text"><p>Company</p></div>
    //         <div class="row-guest-text"><p>Email</p></div>
    //     </div>
    //     <div class="row-guest-edit">
    //         <p>+</p>
    //     </div>
    //     <div class="row-guest-delete">
    //         <p>x</p>
    //     </div>
    // </div>

    fetch('/').then(a => a.json()).then(a => {
        console.log(a);
    });

    // Add event listener on each row
    addEventListenerManageGuest();
}




// Algo
// Add every participant
displayTableParticipant();

