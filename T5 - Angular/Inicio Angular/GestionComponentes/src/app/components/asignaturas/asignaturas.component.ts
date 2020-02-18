import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-asignaturas',
  templateUrl: './asignaturas.component.html',
  styleUrls: ['./asignaturas.component.css']
})
export class AsignaturasComponent implements OnInit {

  parametro:string

  constructor(private rutas:ActivatedRoute) { }

  ngOnInit() {

  this.parametro = this.rutas.snapshot.params['parametro']
  console.log(`Elemento pasado por parametros ${this.parametro}`);
  
  }

}
