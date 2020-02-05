export class Tecnologia{
    titulo:string;
    descripcion:string;
    imagen:string;

    constructor(titulo:string, descripcion:string, imagen:string){
        this.titulo = titulo;
        this.descripcion = descripcion
        this.imagen = imagen
    }

    getTitulo():string{
        return this.titulo
    }

    getDescripcion():string{
        return this.descripcion
    }

    getImagen():string{
        return this.imagen
    }
}