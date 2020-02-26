import { Component, OnInit } from '@angular/core';
import { DatosService } from 'src/app/services/datos.service';
import { Tecnologia } from 'src/app/utils/tecnologia';
import { Asignatura } from 'src/app/utils/asinatura';

@Component({
  selector: 'app-asignatura',
  templateUrl: './asignatura.component.html',
  styleUrls: ['./asignatura.component.css']
})
export class AsignaturaComponent implements OnInit {

  mostrarTecnologias: boolean = true;
  mostrarCurso: string;
  tecnologias: Tecnologia[];
  asignaturas: Asignatura[];

  constructor(private servicio:DatosService) { }

  ngOnInit() {

    this.servicio.getAllAsignaturas
   // this.servicio.getAllTecnologias
  }

}
