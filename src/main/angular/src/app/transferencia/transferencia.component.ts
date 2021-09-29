import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ModalDevolverComponent } from '../modal/modal-devolver/modal-devolver.component';
import { ModalReponerComponent } from '../modal/modal-reponer/modal-reponer.component';
import { ModalTransferirComponent } from '../modal/modal-transferir/modal-transferir.component';
import { ModalVolverComponent } from '../modal/modal-volver/modal-volver.component';
import { Estancia } from '../model/estancia';
import { ProductoService } from '../service/producto.service';
import { TransferenciaService } from '../service/transferencia.service';

@Component({
  selector: 'app-transferencia',
  templateUrl: './transferencia.component.html',
  styleUrls: ['./transferencia.component.css']
})
export class TransferenciaComponent implements OnInit {

  accion: string;
  estancias: Estancia[] = [];

  cantidad: number;

  estanciaT = <Estancia>{};

  estanciaSeleccionado = <Estancia>{};

  invalido = false;

  constructor(private estanciaService: ProductoService,
    private transferenciaService: TransferenciaService,
    private modalService: NgbModal,
    private location: Location,
    private routes: ActivatedRoute ) { 
    this.accion = this.routes.snapshot.url[0].toString();
    this.cantidad = 0;
  }

  ngOnInit(): void {
    this.listarProductos();
  }

  listarProductos(): void {
    if(this.accion !== 'reponer') {
      this.estanciaService.getProductos()
      .subscribe(estancias => this.estancias = estancias);
    } else {
      this.estanciaService.getProductosTipoActivo()
      .subscribe(estancias => this.estancias = estancias);
    }
    
  }

  volver() : void {
    this.modalService.open(ModalVolverComponent)
    .result.then(
      () => this.location.back()
    );
  }

  cargarProducto(estancia: Estancia) {
    this.estanciaT = estancia;
  }

  transferir(invalido: boolean | null) : void {
    if(invalido) {
      this.invalido = true;
    } else {
      this.ejecutarAccion();
    }
    
  }

  ejecutarAccion(): void {
    if(this.accion === 'transferir') {
      this.crearModal(ModalTransferirComponent).result.then(
        () => this.transferenciaService.transferir(this.estanciaT.id, this.cantidad)
        .subscribe(() =>  {
          this.seleccionarProducto();
          this.estanciaT= <Estancia>{};
          this.estanciaSeleccionado= <Estancia>{};
        })
      );
      
    } else if(this.accion === 'devolver') {
      this.crearModal(ModalDevolverComponent).result.then(
        () => this.transferenciaService.devolver(this.estanciaT.id, this.cantidad)
        .subscribe(() => {
          this.seleccionarProducto();
          this.estanciaT= <Estancia>{};
          this.estanciaSeleccionado= <Estancia>{};
        })
      );

    } else if(this.accion === 'reponer') {
      this.crearModal(ModalReponerComponent).result.then(
        () => this.transferenciaService.reponer(this.estanciaT.id, this.cantidad)
        .subscribe(() =>  {
          this.seleccionarProducto();
          this.estanciaT= <Estancia>{};
          this.estanciaSeleccionado= <Estancia>{};
        })
      );
    }
  }

crearModal(modal: any): NgbModalRef {
  let modalRef = this.modalService.open(modal);
  modalRef.componentInstance.cantidad = this.cantidad;
  modalRef.componentInstance.nombre = this.estanciaT.nombre;

  return modalRef;
}
  seleccionarProducto(): void {
    this.estanciaService.getProducto(this.estanciaT.id)
    .subscribe(estancia =>{ 
      this.listarProductos();
      this.estanciaT = estancia;
      this.estanciaSeleccionado = estancia;
      this.cantidad = 0;
    });

    this.invalido = false;
  }
}
