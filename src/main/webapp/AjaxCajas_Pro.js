$(document).ready(function () {

    $('#Cargar_Dinero').click(function () {


        var moneda50 = $('#moneda50').val();
        var moneda100 = $('#moneda100').val();
        var moneda200 = $('#moneda200').val();
        var moneda500 = $('#moneda500').val();
        var moneda1000 = $('#moneda1000').val();
        var billete2000 = $('#billete2000').val();
        var billete5000 = $('#billete5000').val();
        var billete10000 = $('#billete10000').val();
        var billete20000 = $('#billete20000').val();
        var billete50000 = $('#billete50000').val();
        $.ajax({
            url: 'ServletCajas',
            type: 'GET',
            data: {moneda50: moneda50, moneda100: moneda100, moneda200: moneda200, moneda500: moneda500, moneda1000: moneda1000, billete2000: billete2000, billete5000: billete5000, billete10000: billete10000, billete20000: billete20000, billete50000: billete50000},
            dataType: 'json',
            success: function (data) {

                console.log("DATOS SUCCESS");
                /*$("#return").append("<p>" + data.confirmacion + "</p><br>");*/
                document.getElementById("return").innerHTML = data.confirmacion;
            },
            error: function () {
                console.log("ERROR");
            }
        });
    });


});
