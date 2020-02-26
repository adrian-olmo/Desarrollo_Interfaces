import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BarraSuperiorComponent } from './components/barra-superior/barra-superior.component';
import { AsignaturaComponent } from './components/asignatura/asignatura.component';
import { TecnologiaComponent } from './components/tecnologia/tecnologia.component';
import { DetalleTecnologiaComponent } from './components/detalle-tecnologia/detalle-tecnologia.component';
import { DetalleAsignaturaComponent } from './components/detalle-asignatura/detalle-asignatura.component';
import { TodosComponent } from './components/todos/todos.component';

@NgModule({
  declarations: [
    AppComponent,
    BarraSuperiorComponent,
    AsignaturaComponent,
    TecnologiaComponent,
    DetalleTecnologiaComponent,
    DetalleAsignaturaComponent,
    TodosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
