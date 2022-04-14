function read(){
    let xhttp = new XMLHttpRequest();
    
    xhttp.onreadystatechange = function(){
        let test = JSON.parse(this.responseText);
        console.log(test);
    };

    xhttp.open("GET", "api/demo", true);
    xhttp.send();
};