$(document).ready(function () {


    $.ajax({
        url: 'Servlet_Transacciones',
        type: 'get',
        dataType: 'json',
        success: function (data) {

            for (var i = 0; i < data.base.length; i++) {
                console.log(data.base[i].Producto);
                console.log(data.base[i].Valor_Ingresado);
                console.log(data.base[i].Vueltas);
                console.log(data.base[i].Fecha);
                console.log(data.base[i].Operacion);

                $('#lista5').append(
                        //"<div style='cursor:pointer' onclick='sendName(" + data.tiendas[i].id + ")'><a href ='seleccionProducto.jsp'><img id='perfil' src=Pictures/" + data.tiendas[i].idfondo + "><p id='titulo_uno'>" + data.tiendas[i].nombre + "</p><p id='descripcion'>Vendedor: " + data.tiendas[i].vendedor + "</p><p id='descripcion2'>Puntuación: " + data.tiendas[i].puntuacion + "</p></a></div>",
                        //"<div class='column nature' style='cursor:pointer' onclick='sendName(" + data.tiendas[i].id + ")' id='res'><a href ='seleccionProducto2.jsp'> <div class='content'> <img src=Pictures/" + data.tiendas[i].idfondo + " alt='Lights' style='width:100%'> <div class='content2'> <center><div class='empresa'>" + data.tiendas[i].nombre + "</div>        <div class='puntuacion'>Puntuacion: " + data.tiendas[i].puntuacion + "</div> <p class='vendedor'>" + data.tiendas[i].vendedor + "</p> </center>  </div> </div></a> </div>",
                        //"<li><div style='width: 200px'><span style='float: left;'><b>Producto: </b></span>"+data.base[i].Producto+"<br><b>Valor Ingresado: </b>"+data.base[i].Valor_Ingresado+"<br><b>Vueltas: </b>"+data.base[i].Vueltas+"<br><b>Fecha: </b>"+data.base[i].Fecha+"<br><b>Resultado De Operacion: </b>"+data.base[i].Operacion+" </li>"
                        "<li><div style='width: 300px'><span style='float: left;'><b>Producto: </b></span>"+data.base[i].Producto+"<br><span style='float: left;'><b>Valor Ingresado: </b></span>"+data.base[i].Valor_Ingresado+"<br><span style='float: left;'><b>Vueltas: </b></span>"+data.base[i].Vueltas+"<br><span style='float: left;'><b>Fecha: </b></span>"+data.base[i].Fecha+"<br><span style='float: left;'><b>Resultado De Operacion: </b></span>"+data.base[i].Operacion+" </div></li>"
                        );
            }
        },
        error: function () {
            console.log("Error X")
        }
    });
});


