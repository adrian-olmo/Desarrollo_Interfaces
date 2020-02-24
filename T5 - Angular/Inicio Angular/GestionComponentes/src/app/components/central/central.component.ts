import { Component, OnInit } from '@angular/core';
import { ServicioService } from 'src/app/services/servicio.service';

@Component({
  selector: 'app-central',
  templateUrl: './central.component.html',
  styleUrls: ['./central.component.css']
})
export class CentralComponent implements OnInit {


  miArray: string[]

  constructor(private servicio:ServicioService) { }

  ngOnInit() {

    this.miArray = this.servicio.getArrayUno()
  }

}
