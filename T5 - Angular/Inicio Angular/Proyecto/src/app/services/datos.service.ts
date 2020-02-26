import { Injectable } from '@angular/core';
import { Tecnologia } from '../utils/tecnologia';
import { Asignatura } from '../utils/asinatura';
import { element } from 'protractor';

@Injectable({
  providedIn: 'root'
})
export class DatosService {

  objJava:Tecnologia = {titulo:"Java", descripcion:"Lenguaje de programación multiplataforma dedicado tanto a la parte de servido como a la parte de cliente", imagen:"../assets/images/java.png"}
  objPowerShell:Tecnologia = {titulo:"PowerShell", descripcion:"Lenguaje de programación destinado a la automaticación de tareas y la administración de sistemas operativos", imagen:"../assets/images/powershell.png"}
  objAngular:Tecnologia = {titulo:"Angular", descripcion:"Framework de programación multiplataforma dedicado sobre todo a la parte del FrontEnd", imagen:"../assets/images/anguar.jpeg"}
  objJS:Tecnologia = {titulo:"JS", descripcion:"Lenguaje de programación destinado a la automaticación de tareas y la administración de sistemas operativos", imagen:"../assets/images/js.jpg"}
  objHTML:Tecnologia = {titulo:"HTML/CSS", descripcion:"Lenguaje de programación destinado a la automaticación de tareas y la administración de sistemas operativos", imagen:"../assets/images/html.jpeg"}
  objXML:Tecnologia = {titulo:"XML", descripcion:"XML", imagen:"../assets/images/xml.jpg"}
  objSQL:Tecnologia = {titulo:"SQL", descripcion:"Lenguaje de programación destinado a la automaticación de tareas y la administración de sistemas operativos", imagen:"../assets/images/mysql.jpg"}
  objPython:Tecnologia = {titulo:"Python", descripcion:"Lenguaje de programación destinado a la automaticación de tareas y la administración de sistemas operativos", imagen:"../assets/images/python.jpg"}
  tecnologias:Tecnologia[] = [this.objJava, this.objPowerShell, this.objAngular,this.objJS, this.objHTML, this.objXML, this.objSQL, this.objPython]

  asignaturasDAM: Asignatura[] = [
    {nombre: "Programación",ciclo: "DAM1",siglas: "PRO",tecnologias: [this.objJava],conocimientos: ["Programación", "Herencia", 'Polimorfismo']}, 
    {nombre: "Sistemas",ciclo: "DAM1",siglas: "SI",tecnologias: [this.objJS],conocimientos: ['Sistemas Operativos', 'Windows', 'Linux']}, 
    {nombre: "Lenguaje de marcas",ciclo: "DAM1",siglas: "LM",tecnologias: [this.objJS, this.objHTML],conocimientos: ['XML', 'Webs', 'Wordpress']},
    {nombre: "Desarrollo de interfaces",ciclo: "DAM2",siglas: "DI",tecnologias: [this.objJava, this.objAngular],conocimientos: ["Utilizadad ", "Interfaces", " Multiplataforma"]}, 
    {nombre: "Programación multimedia",ciclo: "DAM2",siglas: "PMDM",tecnologias: [this.objJava, this.objAngular],conocimientos: ['Android', ' Moviles', ' XML']}, 
    {nombre: "Programación de procesos",ciclo: "DAM2",siglas: "PSP",tecnologias: [this.objJava, this.objAngular],conocimientos: ['Hilos', ' Procesos', ' Comunicaciones']}
  ];

  constructor() { }

  cartasTecnologias:Tecnologia[]
  cartasDAM:Asignatura[]
  //cartasDAM2:string[] = ["once",  "doce", "trece", "catorce", "quince"]

  getAllAsignaturas(): Asignatura[] {
    return this.asignaturasDAM;
  }

  getAllTecnologias(): Tecnologia[] {
    return this.tecnologias;
  }

  getAsignaturaDAM(ciclo:string):Asignatura[]{
    let asignaturasDAM:Asignatura[] = []
    this.asignaturasDAM.forEach(element => {
      if (element.ciclo == ciclo) {
        this.asignaturasDAM.push(element)
      }
    })
    return this.asignaturasDAM;

  }

  getArrayTecnologias():Tecnologia[]{
    return this.cartasTecnologias
  }

  getArrayAsignaturas():Asignatura[]{
    return this.cartasDAM
  }
}
