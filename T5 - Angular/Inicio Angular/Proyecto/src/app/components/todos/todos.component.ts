import { Component, OnInit } from '@angular/core';
import { Tecnologia } from 'src/app/utils/tecnologia';
import { Asignatura } from 'src/app/utils/asinatura';
import { DatosService } from 'src/app/services/datos.service';

@Component({
  selector: 'app-todos',
  templateUrl: './todos.component.html',
  styleUrls: ['./todos.component.css']
})
export class TodosComponent implements OnInit{
  
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