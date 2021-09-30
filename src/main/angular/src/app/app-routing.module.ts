import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { EstanciaDetalleComponent } from './estancia-detalle/estancia-detalle.component';
import { EstanciaMaestroComponent } from './estancia-maestro/estancia-maestro.component';
import { TipoEstanciaDetalleComponent } from './tipo-estancia-detalle/tipo-estancia-detalle.component';
import { TipoEstanciaMaestroComponent } from './tipo-estancia-maestro/tipo-estancia-maestro.component';

const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: '', redirectTo: 'index', pathMatch: 'full'},
  {path: 'tipoEstancia/listar', component: TipoEstanciaMaestroComponent},
  {path: 'tipoEstancia', component: TipoEstanciaDetalleComponent},
  {path: 'tipoEstancia/:id', component: TipoEstanciaDetalleComponent},
  {path: 'estancia/listar', component: EstanciaMaestroComponent},
  {path: 'estancia', component: EstanciaDetalleComponent},
  {path: 'estancia/:id', component: EstanciaDetalleComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }