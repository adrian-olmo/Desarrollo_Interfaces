import { Component, OnInit, Input } from '@angular/core';
import { Tecnologia } from 'src/app/utils/tecnologia';

@Component({
  selector: 'app-detalle-tecnologia',
  templateUrl: './detalle-tecnologia.component.html',
  styleUrls: ['./detalle-tecnologia.component.css']
})
export class DetalleTecnologiaComponent implements OnInit {

  @Input() ArrayTecnologias:Tecnologia[]

  constructor() { }

  ngOnInit() {
  }

}
