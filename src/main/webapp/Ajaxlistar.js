$(document).ready(function () {


    $.ajax({
        url: 'ServletCargaLista',
        type: 'get',
        dataType: 'json',
        success: function (data) {
            console.log("DATOS SUCCESS");

            $("#llegada").append("<div class='module'><img src='aac_3.jpg' alt='Prueba'><div>D4</div></div>");
            $("#llegada").append("<div class='module' style='height:140px'>" + data.test + "<div>D4</div></div>");




        },
        error: function () {
            console.log("ERROR");
        }
    });

});

