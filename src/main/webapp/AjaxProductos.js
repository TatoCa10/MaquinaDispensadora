$(document).ready(function () {

    $('#Aprender').click(function () {


        var Nombre_Producto = $('#Nombre_Producto').val();
        var Precio_Producto = $('#Precio_Producto').val();

        $.ajax({
            url: 'Servlet_Productos',
            type: 'GET',
            data: {Nombre_Producto: Nombre_Producto, Precio_Producto: Precio_Producto},
            dataType: 'json',
            success: function (data) {

                console.log("DATOS SUCCESS");
                $("#return").append("<p>" + data.confirmacion + "</p><br>");
                /*document.getElementById("return").innerHTML = data.confirmacion;*/
            },
            error: function () {
                console.log("ERROR");
            }
        });
    });


});
