import { Component, OnInit } from '@angular/core';
import { DatosService } from 'src/app/services/datos.service';
import { Tecnologia } from 'src/app/utils/tecnologia';
import { Asignatura } from 'src/app/utils/asinatura';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-asignatura',
  templateUrl: './asignatura.component.html',
  styleUrls: ['./asignatura.component.css']
})
export class AsignaturaComponent implements OnInit {


  asignaturas: Asignatura[];
  parametro: string[]

  constructor(private servicio:DatosService, private rutas:ActivatedRoute) { }

  ngOnInit() {
    this.asignaturas = this.servicio.getAllAsignaturas()
    this.rutas.params.subscribe(param =>{
      console.log(param);
      
    });

    //this.asignaturas = this.servicio.getArrayAsignaturas()
  }

}
