import { Component, OnInit } from '@angular/core';
import { Tecnologia } from './utils/tecnologia';
import { TecnologiaInt } from './utils/tecnologia_dos';
import { Asignatura } from './utils/asignatura';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'introduccion';
  nombre: string = 'Adrian Olmo';
  mostrartecnologias:boolean = true;
  mostrarCurso:string
  /*-------------------------------------------*/
  rutaImagen: string = '../assets/images/java.png';
  objetoJava: Tecnologia = new Tecnologia('Java', 'Multiplataforma desarrollado por Oracle', '../assets/images/java.png');
  objetoPs: Tecnologia = new Tecnologia('Powershell', 'Desarrollado para la administración de SO', '../assets/images/powershell.png');
  objetoHtml: Tecnologia = new Tecnologia('HTML', 'DEsarrollado para el desarrollo de paginas webs', '../assets/images/html.jpeg');
  objetoMysql: Tecnologia = new Tecnologia('Mysql', 'Desarrollado para base de datos', '../assets/images/mysql.jpg');
  objetoPhp: Tecnologia = new Tecnologia('PHP', 'Desarrollado para webs dinámicas', '../assets/images/php.png');
  objetoPy: Tecnologia = new Tecnologia('Python', 'Desarrollado para backend y ia', '../assets/images/python.jpg');
  objetoAn: Tecnologia = new Tecnologia('Angular', 'Multiplataforma desarrollado por google', '../assets/images/angular-icon.svg');
  objetoJs: Tecnologia = new Tecnologia('JavaScript', 'BackEnd y FrontEnd', '../assets/images/js.jpg');
  elementos: Tecnologia[] = [this.objetoJava, this.objetoPs, this.objetoHtml, this.objetoMysql, this.objetoPhp, this.objetoPy, 
    this.objetoAn, this.objetoJs];

    asignaturasDAM1:Asignatura[] = [
      {
        nombre: "Lenguaje de Marcas",
        ciclo: "DAM1",
        siglas: "LM",
        tecnologias:[this.objetoHtml, this.objetoJs],
        conocimientos:["Wordpress", "XML", "CSS"]
      
      },
      {
        nombre: "Base de datos",
        ciclo: "DAM1",
        siglas: "BBDD",
        tecnologias:[this.objetoJava, this.objetoMysql],
        conocimientos:["Relaciones", "SQL", "Tuplas"]
      
      }
    ]
    asignaturasDAM2:Asignatura[] = [
      {
        nombre: "Desarrollo de Interfaces",
        ciclo: "DAM2",
        siglas: "DI",
        tecnologias:[this.objetoJava, this.objetoAn],
        conocimientos:["Utilidad", "Interfaces", "Multiplataforma"]
      
      },

      {
        nombre: "Programacion Multimedia y Dispositivos Moviles",
        ciclo: "DAM2",
        siglas: "PMDM",
        tecnologias:[this.objetoJava, this.objetoJs],
        conocimientos:["Utilidad", "Android", "Multiplataforma"]
      
      },

      {
        nombre: "Programacion Servicios y Procesos",
        ciclo: "DAM2",
        siglas: "PSP",
        tecnologias:[this.objetoJava],
        conocimientos:["Hilos", "Procesos", "Seguridad"]
      
      }
    ]


    mandarmensaje(elemento:Tecnologia){
      console.log(elemento.getDescripcion());
      
    }

    cambiarTecnologia(){
      console.log(this.mostrartecnologias);
      this.mostrartecnologias = !this.mostrartecnologias;
      
    }
    cambiarCurso(elemento:string){
      this.mostrarCurso = elemento;
    }

}
