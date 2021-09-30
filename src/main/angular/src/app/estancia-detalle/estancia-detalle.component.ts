import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ModalModificarComponent } from '../modal/modal-modificar/modal-modificar.component';
import { ModalVolverComponent } from '../modal/modal-volver/modal-volver.component';
import { Estancia } from '../model/estancia';
import { ModalAltaComponent } from '../modal/modal-alta/modal-alta.component';
import { ModalBajaComponent } from '../modal/modal-baja/modal-baja.component';
import { TipoEstancia } from '../model/tipoEstancia';
import { EstanciaService } from '../service/estancia.service';
import { TipoEstanciaService } from '../service/tipo-estancia.service';

@Component({
  selector: 'app-estancia-detalle',
  templateUrl: './estancia-detalle.component.html',
  styleUrls: ['./estancia-detalle.component.css']
})
export class EstanciaDetalleComponent implements OnInit {

  estancia = <Estancia>{};

  listaTipos: TipoEstancia[] = [];

  mensaje?: string;

  lectura = false;

  constructor(
    private estanciaService: EstanciaService,
    private tipoService: TipoEstanciaService,
    private router: ActivatedRoute,
    private location: Location,
    private modalService: NgbModal
  ) { }

  ngOnInit(): void {
    this.getListaTipos();
    this.getEstancia();
  }

  getListaTipos(): void {
    this.tipoService.getTiposActivos()
    .subscribe(tipos => this.listaTipos = tipos);
  }

  getEstancia(): void {
    let id = Number(this.router.snapshot.paramMap.get('id'));

    if(id) {
      this.estanciaService.getEstancia(id)
      .subscribe(
        estancia => this.estancia = estancia
      );

      this.lectura = this.estanciaService.lectura;
    } 
  }

  guardar(): void {
    if(this.estancia.id) {
      this.modalService.open(ModalModificarComponent)
      .result.then(
        () => this.modificar()
      );
    } else {
      this.crear();
    }
  }

  volver(): void {
    if(this.lectura) {
      this.location.back();
    } else {
      this.modalService.open(ModalVolverComponent)
      .result.then(
        () => this.location.back()
      );
    }
    
  }

  crear(): void {
    this.estanciaService.crearEstancia(this.estancia)
    .subscribe(
      estancia => {
        this.estancia.id = estancia;
        this.mensaje='Se ha creado la Estancia';
      }
    );
    
  }

  cambiarActivo(): void {
    if(this.estancia.id) {
      if(this.estancia.disponible) {
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
    this.estanciaService.desactivarEstancia(this.estancia.id)
    .subscribe(() => {
      this.estancia.disponible = false;
      this.mensaje = 'Se ha desactivado la Estancia.'
    }) ;    
}

darAlta(): void {
  this.estanciaService.activarEstancia(this.estancia.id)
  .subscribe(() => {
    this.estancia.disponible = true;
    this.mensaje = 'Se ha activado la Estancia.'
  });
  
}

  modificar() :void {
    this.estanciaService.modificarEstancia(this.estancia)
    .subscribe(() => this.mensaje='Se ha modificado la Estancia');
    
  }
}
