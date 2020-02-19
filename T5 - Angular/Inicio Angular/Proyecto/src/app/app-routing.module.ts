import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AsignaturaComponent } from './components/asignatura/asignatura.component';
import { TecnologiaComponent } from './components/tecnologia/tecnologia.component';


const routes: Routes = [
  {path: 'tecnologias', component:TecnologiaComponent},
  {path: 'asignatura', component:AsignaturaComponent},
  {path: 'asignatura/:parametro', component: AsignaturaComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
