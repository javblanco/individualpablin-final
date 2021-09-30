import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Estancia } from '../model/estancia';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  url = `${environment.host}/estancia`;
  
  lectura = false;

  options = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  }

  constructor(private http: HttpClient) { }

  getProductos(): Observable<Estancia[]> {
    return this.http.get<Estancia[]>(this.url);
  }

  getProducto(id: number): Observable<Estancia> {
    let idUrl = `${this.url}/${id}`;

    return this.http.get<Estancia>(idUrl);
  }

  crearProducto(estancia: Estancia): Observable<number> {
    return this.http.post<number>(this.url, estancia, this.options);
  }

  modificarProducto(estancia: Estancia): Observable<any> {
    return this.http.put(this.url, estancia, this.options);
  }

  getProductosTipoActivo(): Observable<Estancia[]> {
    const urlActivo = `${this.url}/tipo-activo`;
    
    return this.http.get<Estancia[]>(urlActivo);
  }
  activarSoloLectura(): void {
    this.lectura = true;
  }

  desactivarSoloLectura(): void {
    this.lectura = false;
  }

  getProductosAlmacen(): Observable<Estancia[]> {
    let almacenUrl = `${this.url}/almacen`;
    return this.http.get<Estancia[]>(almacenUrl);
  }

  getProductosTienda(): Observable<Estancia[]> {
    let tiendaUrl = `${this.url}/tienda`;
    return this.http.get<Estancia[]>(tiendaUrl);
  }
}
