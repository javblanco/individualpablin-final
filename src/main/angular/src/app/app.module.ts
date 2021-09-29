import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { InMemoryDataService } from './service/in-memory-data.service';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';



import { TipoProductoMaestroComponent } from './tipo-producto-maestro/tipo-producto-maestro.component';
import { TipoProductoDetalleComponent } from './tipo-producto-detalle/tipo-producto-detalle.component';
import { ProductoMaestroComponent } from './producto-maestro/producto-maestro.component';
import { ProductoDetalleComponent } from './producto-detalle/producto-detalle.component';
import { ModalModificarComponent } from './modal/modal-modificar/modal-modificar.component';
import { ModalVolverComponent } from './modal/modal-volver/modal-volver.component';
import { ModalBajaComponent } from './modal/modal-baja/modal-baja.component';
import { ModalAltaComponent } from './modal/modal-alta/modal-alta.component';
import { IndexComponent } from './index/index.component';
import { ModalTransferirComponent } from './modal/modal-transferir/modal-transferir.component';
import { ModalDevolverComponent } from './modal/modal-devolver/modal-devolver.component';
import { ModalReponerComponent } from './modal/modal-reponer/modal-reponer.component';
import { ValidacionTransferenciaDirective } from './validacion-transferencia.directive';

@NgModule({
  declarations: [
    AppComponent,
    TipoProductoMaestroComponent,
    TipoProductoDetalleComponent,
    ProductoMaestroComponent,
    ProductoDetalleComponent,
    ModalModificarComponent,
    ModalVolverComponent,
    ModalBajaComponent,
    ModalAltaComponent,
    IndexComponent,
    ModalTransferirComponent,
    ModalDevolverComponent,
    ModalReponerComponent,
    ValidacionTransferenciaDirective,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
