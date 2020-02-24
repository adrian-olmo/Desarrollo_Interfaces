import { Component, OnInit } from "@angular/core";
import { ActivatedRoute } from "@angular/router";
import { ServicioService } from 'src/app/services/servicio.service';

@Component({
  selector: "app-asignaturas",
  templateUrl: "./asignaturas.component.html",
  styleUrls: ["./asignaturas.component.css"]
})
export class AsignaturasComponent implements OnInit {
  parametro: string;
  miArrayDos: string[]

  constructor(private rutas: ActivatedRoute, private servicio:ServicioService) {}

  ngOnInit() {
    this.rutas.params.subscribe(param => {
        console.log(param)
    });
    console.log(`Elemento pasado por parámetros ${this.parametro}`);

    this.miArrayDos = this.servicio.getArrayDos()
  }
}
