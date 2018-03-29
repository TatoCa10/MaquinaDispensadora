$(document).ready(function () {
    $('#cargar').click(function () {
        $.ajax({
            url: 'ServletCargaLista',
            type: 'get',
            dataType: 'json',
            success: function (data) {
                console.log("DATOS SUCCESS");
                $("#llegada").append("<p>" + data.test + "</p><br>");
            for (var i = 0; i < data.casillas.length; i++) {
                console.log(data.casillas[i].source);
                console.log(data.casillas[i].ubicacion);
                console.log(data.casillas[i].precio);
                console.log("for"+i);
                $('#llegada').append(
                        //"<div style='cursor:pointer' onclick='sendName(" + data.tiendas[i].id + ")'><a href ='seleccionProducto.jsp'><img id='perfil' src=Pictures/" + data.tiendas[i].idfondo + "><p id='titulo_uno'>" + data.tiendas[i].nombre + "</p><p id='descripcion'>Vendedor: " + data.tiendas[i].vendedor + "</p><p id='descripcion2'>Puntuación: " + data.tiendas[i].puntuacion + "</p></a></div>",
                        //"<div class='column nature' style='cursor:pointer' onclick='sendName(" + data.tiendas[i].id + ")' id='res'><a href ='seleccionProducto2.jsp'> <div class='content'> <img src=Pictures/"+ data.tiendas[i].idfondo +" alt='Lights' style='width:100%'> <div class='content2'> <center><div class='empresa'>" + data.tiendas[i].nombre + "</div>        <div class='puntuacion'>Puntuacion: " + data.tiendas[i].puntuacion + "</div> <p class='vendedor'>" + data.tiendas[i].vendedor + "</p> </center>  </div> </div></a> </div>",
                "<div class='module'><img src='"+data.casillas[i].source+"' alt='"+data.casillas[i].precio+"'><div>"+data.casillas[i].ubicacion+"</div></div>"       
                );
           }
            },
            error: function () {
                console.log("ERROR");
            }
        });
    });

});

