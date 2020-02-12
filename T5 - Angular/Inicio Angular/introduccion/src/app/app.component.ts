import { Component, OnInit } from '@angular/core';
import { Tecnologia } from './utils/tecnologia';
import { TecnologiaInt } from './utils/tecnologia_dos';
import { Asignatura } from './utils/asignatura';
import { DatosCiclosService } from './services/datos-ciclos.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  implements OnInit{

  

  title = 'introduccion';
  nombre: string = 'Adrian Olmo';
  mostrartecnologias:boolean = true;
  mostrarCurso:string
  /*-------------------------------------------*/
  tecnologias:Tecnologia[]
  asignatura:Asignatura[]

  constructor(private servicioDatos: DatosCiclosService){

  }

  mandarmensaje(elemento:Tecnologia){
    console.log(elemento.getDescripcion());
      
  }

  cambiarTecnologia(){
    console.log(this.mostrartecnologias);
    this.mostrartecnologias = !this.mostrartecnologias;
      
  }

  cambiarCurso(elemento:string){
    this.mostrarCurso = elemento;
  }

  ngOnInit(): void {
    this.asignatura = this.servicioDatos.getAllAsignaturas()
    this.tecnologias = this.servicioDatos.getAllTecnologias()
  }

}
