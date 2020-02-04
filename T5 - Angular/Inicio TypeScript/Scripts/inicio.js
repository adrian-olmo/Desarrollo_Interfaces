"use strict";
/*console.log("HOLA MUNDO");
console.log("Prueba de linea de codigo");
console.log("Esto es un nuevo cambio");
console.log ("Ejemplo de tsc -w / --watch");*/
var numero = 1;
var nombre = 'Adrian';
var apellido = 'Olmo';
//console.log(nombre+" "+apellido);
console.log(nombre + " " + apellido);
var nota = 5;
/*if (nota>=5) {
    console.log("Has aprobado")
} else if (nota < 5 && nota > 2) {
    console.log("Has suspendido");
} else {
    console.log("FATAL ERROR")
}*/
console.log("------SWITCH------");
switch (nota) {
    case 1:
        console.log("Caso 1");
        break;
    case 2:
        console.log("Caso 2");
        break;
    default:
        console.log("Resto de casos");
        break;
}
console.log("------FOR------");
for (var index = 0; index < 10; index++) {
    console.log("Elemento  " + index);
}
var conjuntoPalabras = ["primero", "segundo", "tercero", "cuarto"];
console.log("------FOR IN------");
for (var key in conjuntoPalabras) {
    console.log(conjuntoPalabras[key]);
}
console.log("------FOR EACH------");
conjuntoPalabras.forEach(function (elemento) {
    console.log(elemento);
});
console.log("------FOR OF------");
for (var _i = 0, conjuntoPalabras_1 = conjuntoPalabras; _i < conjuntoPalabras_1.length; _i++) {
    var iterator = conjuntoPalabras_1[_i];
    console.log(iterator);
}
console.log("------FUNCIONES------");
function funcionInicial(nombre) {
    console.log(nombre);
}
function funcionInicialParametros(nombre, apellido, edad) {
    console.log(nombre + ", " + apellido + ", " + edad);
}
function funcionRetorno(numUno, numDos) {
    return numUno + numDos;
}
function funcionCualquierParametro(params) {
    console.log(params);
}
function funcionParamertrosMultiples(nombre) {
    var nombresMultiples = [];
    for (var _i = 1; _i < arguments.length; _i++) {
        nombresMultiples[_i - 1] = arguments[_i];
    }
    console.log(nombre);
    if (nombresMultiples.length) {
        nombresMultiples.forEach(function (element) {
            console.log(element);
        });
    }
    else {
        console.log("No han pasado parametros multiples");
    }
}
function funcionParametrosOptativos(nombre, apellido, edad) {
    if (edad == null) {
        console.log(nombre + " " + apellido);
    }
    else {
        console.log(nombre + " " + apellido + " " + edad);
    }
}
function funcionValoresDefecto(nombre, apellido) {
    if (apellido === void 0) { apellido = "defecto"; }
    console.log(nombre + ", " + apellido);
}
funcionInicial("MiNombre"); //Saca lo que le pongas entre ()
funcionInicialParametros("Adrian", "Olmo", 20); //Acepta los parametros definidos
console.log(funcionRetorno(44, 53)); //Devuelve el retorno definido en la funcion
funcionCualquierParametro(false); //Acepta cualquier tipo de parametro
funcionParamertrosMultiples('Adri', 'Negro'); //Saca los parametros que le pases, en este caso si hay un parametro saca un mensaje
funcionParametrosOptativos('Adri', 'Negro', 20); //Parametros Optativos
funcionValoresDefecto("Adri"); //Si no estableces el 2º valor saca el defecto
