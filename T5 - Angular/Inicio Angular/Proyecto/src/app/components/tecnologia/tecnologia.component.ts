import { Component, OnInit } from '@angular/core';
import { Tecnologia } from 'src/app/utils/tecnologia';
import { DatosService } from 'src/app/services/datos.service';

@Component({
  selector: 'app-tecnologia',
  templateUrl: './tecnologia.component.html',
  styleUrls: ['./tecnologia.component.css']
})
export class TecnologiaComponent implements OnInit {

  tecnologias: Tecnologia[]

  constructor(private servicios:DatosService){
  }

  ngOnInit(): void {
    this.tecnologias = this.servicios.getAllTecnologias()
    //this.asignaturas = this.servicios.getAllAsignaturas()
    
  }
  

}
