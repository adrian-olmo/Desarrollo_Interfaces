import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BarraSuperiorComponent } from './components/barra-superior/barra-superior.component';
import { AsignaturaComponent } from './components/asignatura/asignatura.component';

@NgModule({
  declarations: [
    AppComponent,
    BarraSuperiorComponent,
    AsignaturaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
