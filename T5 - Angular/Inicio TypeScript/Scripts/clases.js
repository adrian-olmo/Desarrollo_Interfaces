"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
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
exports.Alumno = Alumno;
var miAlumno = new Alumno("Adrian", "Olmo", 20);
miAlumno.getNombre;
console.log(miAlumno.getApellido);
