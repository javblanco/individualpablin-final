import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { TipoProducto } from '../model/tipoProducto';
import { Estancia } from '../model/estancia';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{

  constructor() { }

  createDb() {
    const tipoProducto = [
      {id:1, nombre: 'Vip', descripcion: 'Máquina que hace café en el baño', activo: true},
      {id:2, nombre: 'Africa', descripcion: 'Sirve para respirar ambiente congoleño', activo: true},
      {id:3, nombre: 'Europa', descripcion: 'Sirve para sentirte en Madrid', activo: true},
      {id:4, nombre: 'Presidencial', descripcion: 'Se usa para realizar despedidas de soltero', activo: true},
    ];

    const estancia = [
      {id:1, nombre: 'Noespresso', marca: 'Cafeteras SA', modelo: 'Noespresso 3000', cantidadAlmacen: 10, cantidadTienda: 2, cantidadTotal: 12, idTipoProducto: 1, nombreTipoProducto: 'Cafetera'},

    ]
    return {tipoProducto, estancia}
  }; 

  genId<T extends TipoProducto | Estancia>(tabla: T[]): number {
    return tabla.length > 0 ? Math.max(... tabla.map(t => t.id))+ 1 : 1;
  }
}
