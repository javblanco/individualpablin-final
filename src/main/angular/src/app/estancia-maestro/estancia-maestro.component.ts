import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Estancia } from '../model/estancia';
import { EstanciaService } from '../service/estancia.service';

@Component({
  selector: 'app-estancia-maestro',
  templateUrl: './estancia-maestro.component.html',
  styleUrls: ['./estancia-maestro.component.css']
})
export class EstanciaMaestroComponent implements OnInit {

  estancias: Estancia[] = [];

  filtro = 1;

  filtrado = 1;

  constructor(private service: EstanciaService,
    private location: Location) { }

  ngOnInit(): void {
    this.getEstancias();
    this.service.desactivarSoloLectura();
  }

  getEstancias(): void {
    this.service.getEstancias()
    .subscribe(
      estancias => {
      this.estancias = estancias;
      this.filtrado = 1;
      }
    )
  }

  volver(): void {
    this.location.back();
  }

  ver(): void {
    this.service.activarSoloLectura();
  }

}
