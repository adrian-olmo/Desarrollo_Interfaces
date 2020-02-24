import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-tecnologia-hijo',
  templateUrl: './tecnologia-hijo.component.html',
  styleUrls: ['./tecnologia-hijo.component.css']
})
export class TecnologiaHijoComponent implements OnInit {

  @Input() miArray:string[]

  constructor() { }

  ngOnInit() {
  }

}
