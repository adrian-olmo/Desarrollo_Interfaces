"use strict";
//export para poder usar la clase en otro fichero
var Alumno = /** @class */ (function () {
    function Alumno(nombre, apellido, edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    Alumno.prototype.getNombre = function () {
        return this.nombre;
    };
    Alumno.prototype.getApellido = function () {
        return this.apellido;
    };
    Alumno.prototype.getEdad = function () {
        return this.edad;
    };
    return Alumno;
}());
var miAlumno = new Alumno("Adrian", "Olmo", 20);
miAlumno.getNombre;
var miTrabajador = { id: 1, nombre: 'Adrian', apellido: 'Olmo' };
/*console.log(miTrabajador.id);
console.log(miTrabajador.nombre);
console.log(miTrabajador.apellido);*/
var trabajadores = [{ id: 1, nombre: 'Adrian', apellido: 'Olmo' },
    { id: 2, nombre: 'Nombre1', apellido: 'Apellido1' },
    { id: 3, nombre: 'Nombre2', apellido: 'Apellido2' }];
console.log(trabajadores[0].apellido);
console.log("" + trabajadores[0].nombre, "" + trabajadores[0].apellido);
