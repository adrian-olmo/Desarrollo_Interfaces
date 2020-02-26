import { Component, OnInit } from '@angular/core';
import { Tecnologia } from './utils/tecnologia';
import { DatosService } from './services/datos.service';
import { Asignatura } from './utils/asinatura';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  title = 'Proyecto';
  mostrarTecnologias: boolean = true;
  mostrarAsignaturas: boolean = true;
  tecnologias: Tecnologia[];
  asignaturas: Asignatura[];


  constructor(private servicios:DatosService){
  }

  ngOnInit(): void {
    this.tecnologias = this.servicios.getAllTecnologias()
    this.asignaturas = this.servicios.getAllAsignaturas()
    
  }
}
