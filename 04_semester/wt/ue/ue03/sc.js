"use strict";
//create a global variable for the sum(price)
var ges_preis = 0.0;

// function init(){
    let checkbox_array = [document.getElementById("Salami"),document.getElementById("Schinken"),document.getElementById("Ananas"),document.getElementById("Pilze")];

    function order(){
        let cur_Preis = 0.0;
        let calorien = 0;
        let zutaten = "";

        //Check all Checkboxes and add stuff
        for(let item of checkbox_array){
            if(item.checked){
                cur_Preis += 2;
                calorien += 50;
                zutaten += item.name + " <br>";
            }
        }

        if(cur_Preis <= 0){
            alert("Sie muessen wenigsten eine Zutat waehlen!");

        } else {
            //get the size of the pizza by the value of the array element
            let piza_size_o = document.getElementById("select_pizza");
            //parseInt() = string -> int
            let piza_size = parseInt(piza_size_o[piza_size_o.selectedIndex].value);
            
            //add some stuff
            if( piza_size == 15 ){
                calorien += 200;
                cur_Preis += 8;
            } 
            if( piza_size == 30 ) {
                calorien += 400;
                cur_Preis += 10;
            }
            if( piza_size == 45 ) {
                calorien += 600;
                cur_Preis += 15;
            }

            //dataHTML code for a table row with the filled elements
            let dataHtml = `<tr> <td>${piza_size} cm</td> <td>${zutaten}</td> <td>${cur_Preis} €</td> <td>${calorien}</td> </tr>`;

            //get the tableBody Element and add the row
            let tableBody = document.getElementById('tableData');
            tableBody.innerHTML += dataHtml;

            //calculate the sum(price)  
            ges_preis += cur_Preis;

            // write the sum in a lbl
            let lbl_preis = document.getElementById("lbl_preis");
            lbl_preis.innerHTML = "Gesamtpreis: " + ges_preis + " €";

        }

    }
    let btn_bestellen = document.getElementById("btn");
    btn_bestellen.onclick = order;
// }
// //load the function when the 
// window.onload = init;


        // if(document.getElementById("Salami").checked){
        //     cur_Preis += 2;
        //     calorien += 50;
        //     zutaten += "Salami <br>";
        // }

        // if(document.getElementById("Schinken").checked){
        //     cur_Preis += 2;
        //     calorien += 50;
        //     zutaten += "Schinken <br>";
        // }

        // if(document.getElementById("Ananas").checked){
        //     cur_Preis += 2;
        //     calorien += 50;
        //     zutaten += "Ananas <br>";
        // }

        // if(document.getElementById("Pilze").checked){
        //     cur_Preis += 2;
        //     calorien += 50;
        //     zutaten += "Pilze <br>";
        // }
