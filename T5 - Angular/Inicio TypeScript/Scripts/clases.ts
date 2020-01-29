//export para poder usar la clase en otro fichero
export class Alumno{

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
console.log(miAlumno.getApellido);
