$(document).ready(function () {

    $('#pedir').click(function () {
        console.log("pedir.click");
        var ubicacion = $('#text').val();
        var denominaciones = $('#arreglo').val();
        $.ajax({
            url: 'ServletTest',
            type: 'get',
            data: {ubicacion: ubicacion, denominaciones: denominaciones},
            dataType: 'json',
            success: function (data) {
                $("#log").append("<p>" + data.confirmacion + "</p><br>");
                if (data.confirmacion === "ACK") {
                    console.log("DATOS SUCCESS");
                    alert("Tienda creada exitosamente");
                }
                console.log("DATOS SUCCESS");
            }, error(){
                console.log("CAGADO");
            }

        });
    });

});