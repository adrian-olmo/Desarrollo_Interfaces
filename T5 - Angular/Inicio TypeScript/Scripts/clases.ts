//export para poder usar la clase en otro fichero
 class Alumno{

    private nombre:string
    private apellido:string
    private edad:number
    constructor(nombre:string, apellido:string, edad:number){
        this.nombre = nombre
        this.apellido = apellido
        this.edad = edad
    }

    getNombre():string{
        return this.nombre
    }

    getApellido():string{
        return this.apellido
    }

    getEdad():number{
        return this.edad
    }
}

let miAlumno:Alumno = new Alumno(`Adrian`, `Olmo`, 20)
miAlumno.getNombre
//console.log(miAlumno.getApellido);


interface Trabajador{
    id:number
    nombre:string
    apellido:string
}
let miTrabajador:Trabajador = {id:1, nombre:'Adrian', apellido:'Olmo'}
/*console.log(miTrabajador.id);
console.log(miTrabajador.nombre);
console.log(miTrabajador.apellido);*/

let trabajadores:Trabajador[] = [{id:1, nombre:'Adrian', apellido:'Olmo'},
{id:2, nombre:'Nombre1', apellido:'Apellido1'}, 
{id:3, nombre:'Nombre2', apellido:'Apellido2'}]


console.log(trabajadores[0].apellido);
console.log(`${trabajadores[0].nombre}`,`${trabajadores[0].apellido}`);



