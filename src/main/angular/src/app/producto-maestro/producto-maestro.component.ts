import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Estancia } from '../model/estancia';
import { ProductoService } from '../service/producto.service';

@Component({
  selector: 'app-producto-maestro',
  templateUrl: './producto-maestro.component.html',
  styleUrls: ['./producto-maestro.component.css']
})
export class ProductoMaestroComponent implements OnInit {

  estancias: Estancia[] = [];

  filtro = 1;

  filtrado = 1;

  constructor(private service: ProductoService,
    private location: Location) { }

  ngOnInit(): void {
    this.getProductos();
    this.service.desactivarSoloLectura();
  }

  getProductos(): void {
    this.service.getProductos()
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
