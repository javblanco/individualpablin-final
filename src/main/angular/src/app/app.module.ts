import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';



import { TipoEstanciaMaestroComponent } from './tipo-estancia-maestro/tipo-estancia-maestro.component';
import { TipoEstanciaDetalleComponent } from './tipo-estancia-detalle/tipo-estancia-detalle.component';
import { EstanciaMaestroComponent } from './estancia-maestro/estancia-maestro.component';
import { EstanciaDetalleComponent } from './estancia-detalle/estancia-detalle.component';
import { ModalModificarComponent } from './modal/modal-modificar/modal-modificar.component';
import { ModalVolverComponent } from './modal/modal-volver/modal-volver.component';
import { ModalBajaComponent } from './modal/modal-baja/modal-baja.component';
import { ModalAltaComponent } from './modal/modal-alta/modal-alta.component';
import { IndexComponent } from './index/index.component';
@NgModule({
  declarations: [
    AppComponent,
    TipoEstanciaMaestroComponent,
    TipoEstanciaDetalleComponent,
    EstanciaMaestroComponent,
    EstanciaDetalleComponent,
    ModalModificarComponent,
    ModalVolverComponent,
    ModalBajaComponent,
    ModalAltaComponent,
    IndexComponent,
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
