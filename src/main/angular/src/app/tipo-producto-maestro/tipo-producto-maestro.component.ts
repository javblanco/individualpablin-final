import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TipoEstancia } from '../model/tipoEstancia';
import { TipoProductoService } from '../service/tipo-producto.service';

@Component({
  selector: 'app-tipo-producto-maestro',
  templateUrl: './tipo-producto-maestro.component.html',
  styleUrls: ['./tipo-producto-maestro.component.css']
})
export class TipoProductoMaestroComponent implements OnInit {

  tipos: TipoEstancia[] = [];

  tiposTodos: TipoEstancia[] = [];

  visible = false;

  //filtro = 1;
  //filtrado = false;

  constructor(private tipoService: TipoProductoService,
    private location: Location) { }

  ngOnInit(): void {
    this.getTipos();
    this.getTiposTodos();
    this.tipoService.desactivarSoloLectura();
  }

  getTipos(): void {
    this.tipoService.getTiposActivos()
    .subscribe(tipos => {
      this.tipos = tipos;
      //this.filtrado = false;
    });
  }

  getTiposTodos(): void {
    this.tipoService.getTipos()
    .subscribe(tiposTodos => {
      this.tiposTodos = tiposTodos;
      //this.filtrado = false;
    });
  }

  volver(): void {
    this.location.back();
  }

  ver(): void {
    this.tipoService.activarSoloLectura();
  }

}
