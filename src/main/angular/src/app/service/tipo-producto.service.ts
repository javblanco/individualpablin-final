import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { TipoEstancia } from '../model/tipoEstancia';

@Injectable({
  providedIn: 'root'
})
export class TipoProductoService {

  url = `${environment.host}/tipoEstancia`;

  lectura = false;

  options = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  }

  constructor(private http: HttpClient) { }

  getTipo(id: number): Observable<TipoEstancia> {
    const idUrl = `${this.url}/${id}`;
    
    return this.http.get<TipoEstancia>(idUrl);
  }

  crearTipo(tipo: TipoEstancia): Observable<TipoEstancia> {
    return this.http.post<TipoEstancia>(this.url, tipo, this.options);
  }

  modificarTipo(tipo: TipoEstancia): Observable<any> {
    return this.http.put<any>(this.url, tipo, this.options);
  }

  activarTipo(id: number): Observable<any> {
    const idUrl = `${this.url}/activar/${id}`;

    return this.http.post(idUrl, this.options);
  }

  desactivarTipo(id: number): Observable<any> {
    const idUrl = `${this.url}/desactivar/${id}`;

    return this.http.post(idUrl, this.options);
  }

  activarSoloLectura(): void {
    this.lectura = true;
  }

  desactivarSoloLectura(): void {
    this.lectura = false;
  }

  getTipos(): Observable<TipoEstancia[]> {

    return this.http.get<TipoEstancia[]>(this.url);
  }

  getTiposActivos(): Observable<TipoEstancia[]> {
    const activoUrl = `${this.url}/activo`; //si le quito se ven todos 

    return this.http.get<TipoEstancia[]>(activoUrl);
  }
}
