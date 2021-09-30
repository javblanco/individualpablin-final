import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { ProductoDetalleComponent } from './producto-detalle/producto-detalle.component';
import { ProductoMaestroComponent } from './producto-maestro/producto-maestro.component';
import { TipoProductoDetalleComponent } from './tipo-producto-detalle/tipo-producto-detalle.component';
import { TipoProductoMaestroComponent } from './tipo-producto-maestro/tipo-producto-maestro.component';

const routes: Routes = [
  {path: 'index', component: IndexComponent},
  {path: '', redirectTo: 'index', pathMatch: 'full'},
  {path: 'tipoEstancia/listar', component: TipoProductoMaestroComponent},
  {path: 'tipoEstancia', component: TipoProductoDetalleComponent},
  {path: 'tipoEstancia/:id', component: TipoProductoDetalleComponent},
  {path: 'estancia/listar', component: ProductoMaestroComponent},
  {path: 'estancia', component: ProductoDetalleComponent},
  {path: 'estancia/:id', component: ProductoDetalleComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
