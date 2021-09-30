import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { TipoEstancia } from '../model/tipoEstancia';
import { TipoEstanciaService } from '../service/tipo-estancia.service';

@Component({
  selector: 'app-tipo-estancia-maestro',
  templateUrl: './tipo-estancia-maestro.component.html',
  styleUrls: ['./tipo-estancia-maestro.component.css']
})
export class TipoEstanciaMaestroComponent implements OnInit {

  tipos: TipoEstancia[] = [];

  tiposTodos: TipoEstancia[] = [];

  visible = false;

  //filtro = 1;
  //filtrado = false;

  constructor(private tipoService: TipoEstanciaService,
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
