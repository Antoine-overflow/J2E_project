var obj_csv = {
    size:0,
    dataFile:[]
};
 
function readImage(input) {
    console.log("event triggered")
    console.log(input)
 if (input.files && input.files[0]) {
 let reader = new FileReader();
        reader.readAsBinaryString(input.files[0]);
 reader.onload = function (e) {
 console.log(e);
 obj_csv.size = e.total;
 obj_csv.dataFile = e.target.result
            console.log(obj_csv.dataFile)
            parseData(obj_csv.dataFile)
            
 }
 }
}
 
function parseData(data){
    let csvData = [];
    let lbreak = data.split("\n");
    lbreak.forEach(res => {
       // csvData.push(res.split(","));
        csvData.push(res.split(";"));
    });
    console.table(csvData);
}

// var csvData = document.getElementById('uploadfile')
// csvData.addEventListener('click', readImage(this));