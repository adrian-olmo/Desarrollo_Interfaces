import { Component, OnInit } from '@angular/core';
import { Tecnologia } from './utils/Tecnologia';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'CARACHANCLA  ';
  nombre = 'Adrian Olmo';
  rutaimagenpython = '../assets/images/python.jpg'
  
  /*rutaimagenjava = '../assets/images/java.jpg';
  rutaimagenjs = '../assets/images/js.jpg'
  rutaimagenmysql = '../assets/images/mysql.jpg'
  rutaimagenphp = '../assets/images/php.jpg'
  rutaimagenpowershell = '../assets/images/powershell.jpg'
  rutaimagenhtml = '../assets/images/html.jpg'
  rutaimagenxml = '../assets/images/xml.jpg'*/

  objetopython:Tecnologia = new Tecnologia ("Python", "Python.....", this.rutaimagenpython)
  /*objetojava:Tecnologia = new Tecnologia ("Python", "Python.....", this.rutaimagenpython)
  objetojava:Tecnologia = new Tecnologia ("Python", "Python.....", this.rutaimagenpython)
  objetojava:Tecnologia = new Tecnologia ("Python", "Python.....", this.rutaimagenpython)
  objetojava:Tecnologia = new Tecnologia ("Python", "Python.....", this.rutaimagenpython)
  objetojava:Tecnologia = new Tecnologia ("Python", "Python.....", this.rutaimagenpython)
  objetojava:Tecnologia = new Tecnologia ("Python", "Python.....", this.rutaimagenpython)
  objetojava:Tecnologia = new Tecnologia ("Python", "Python.....", this.rutaimagenpython)*/
 
  ngOnInit(): void {
    throw new Error("Method not implemented.");
  }
  
}
