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
  rutaimagenjava ='../assets/images/java.png'

  objetopython:Tecnologia = new Tecnologia ("Python", "Python.....", this.rutaimagenpython)
  objetojava:Tecnologia = new Tecnologia ("Java", "Java.....", this.rutaimagenjava)

  elementos:Tecnologia[] = [this.objetojava, this.objetopython];

 
  ngOnInit(): void {
    throw new Error("Method not implemented.");
  }
  
}
