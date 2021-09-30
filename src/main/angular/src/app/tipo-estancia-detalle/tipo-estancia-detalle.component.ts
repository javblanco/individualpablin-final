import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalAltaComponent } from '../modal/modal-alta/modal-alta.component';
import { ModalBajaComponent } from '../modal/modal-baja/modal-baja.component';
import { ModalModificarComponent } from '../modal/modal-modificar/modal-modificar.component';
import { ModalVolverComponent } from '../modal/modal-volver/modal-volver.component';
import { TipoEstancia } from '../model/tipoEstancia';
import { TipoEstanciaService } from '../service/tipo-estancia.service';
import { TipoEstanciaMaestroComponent } from '../tipo-estancia-maestro/tipo-estancia-maestro.component';

@Component({
  selector: 'app-tipo-estancia-detalle',
  templateUrl: './tipo-estancia-detalle.component.html',
  styleUrls: ['./tipo-estancia-detalle.component.css']
})
export class TipoEstanciaDetalleComponent implements OnInit {

  tipo = <TipoEstancia>{};

  mensaje?: string;

  lectura = false;

  creacion = true;
  


  constructor(private tipoService: TipoEstanciaService,
    private location: Location,
    private routes: ActivatedRoute,
    private modalService: NgbModal) { }

  ngOnInit(): void {
    this.getTipo();
  }


  getTipo(): void {
    let id = Number(this.routes.snapshot.paramMap.get('id'));

    if(id) {
      this.tipoService.getTipo(id)
      .subscribe(tipo => this.tipo = tipo);
      this.lectura = this.tipoService.lectura;
      this.creacion = false;
    }
  }

  volver(): void {
    if(this.lectura) {
      this.location.back();
    } else {
      this.modalService.open(ModalVolverComponent).result.then(() => this.location.back());
    }
  }

  guardar(): void {
    if(this.tipo.id) {
      this.modalService.open(ModalModificarComponent).result.then(() => this.modificar());
    } else {
      this.crear();
    }
  }

  crear(): void {
    this.tipoService.crearTipo(this.tipo)
    .subscribe(tipo => {
      this.tipo.id = tipo.id;
      this.mensaje = 'Se ha creado el Modelo';
      this.tipo.activo = true;
    });
    
  }

  modificar(): void {
    this.tipoService.modificarTipo(this.tipo)
    .subscribe(() => {
      this.mensaje = 'Se ha modificado el Modelo'
    });
    ;
  }

  cambiarActivo(): void {
    if(this.tipo.id) {
      if(this.tipo.activo) {
        this.modalService.open(ModalBajaComponent).result.then(
          () => this.darBaja()
        );
      } else {
        this.modalService.open(ModalAltaComponent).result.then(
          () => this.darAlta()
        )       
      }
    }
  }

  darBaja(): void {
      this.tipoService.desactivarTipo(this.tipo.id)
      .subscribe(() => {
        this.tipo.activo = false;
        this.mensaje = 'Se ha dado de baja el Modelo.'
      }) ;    
  }

  darAlta(): void {
    this.tipoService.activarTipo(this.tipo.id)
    .subscribe(() => {
      this.tipo.activo = true;
      this.mensaje = 'Se ha dado  de alta el Modelo'
    });
    
  }
 
}
