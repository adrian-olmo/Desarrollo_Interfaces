import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BarraSuperiorComponent } from './components/barra-superior/barra-superior.component';
import { CentralComponent } from './components/central/central.component';
import { AsignaturasComponent } from './components/asignaturas/asignaturas.component';
import { TecnologiaHijoComponent } from './components/tecnologia-hijo/tecnologia-hijo.component';

@NgModule({
  declarations: [
    AppComponent,
    BarraSuperiorComponent,
    CentralComponent,
    AsignaturasComponent,
    TecnologiaHijoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
