import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  arraUno: string[] = ["uno",  "dos", "tres", "cuatro", "cinco"]
  arraDos: string[] = ["seis",  "siete", "ocho", "nueve", "diez"]

  constructor() { }


  getArrayUno():string[]{
    return this.arraUno
  }

  getArrayDos():string[]{
    return this.arraDos
  }
}
