import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Estancia } from '../model/estancia';

@Injectable({
  providedIn: 'root'
})
export class EstanciaService {

  url = `${environment.host}/estancia`;
  
  lectura = false;

  options = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  }

  constructor(private http: HttpClient) { }

  getEstancias(): Observable<Estancia[]> {
    return this.http.get<Estancia[]>(this.url);
  }

  getEstancia(id: number): Observable<Estancia> {
    let idUrl = `${this.url}/${id}`;

    return this.http.get<Estancia>(idUrl);
  }

  crearEstancia(estancia: Estancia): Observable<number> {
    return this.http.post<number>(this.url, estancia, this.options);
  }

  modificarEstancia(estancia: Estancia): Observable<any> {
    return this.http.put(this.url, estancia, this.options);
  }
  /*
  getEstanciasTipoActivo(): Observable<Estancia[]> {
    const urlActivo = `${this.url}/tipo-activo`;
    
    return this.http.get<Estancia[]>(urlActivo);
  }
  */
  activarSoloLectura(): void {
    this.lectura = true;
  }

  desactivarSoloLectura(): void {
    this.lectura = false;
  }


  activarEstancia(id: number): Observable<any> {
    const idUrl = `${this.url}/activar/${id}`;

    return this.http.post(idUrl, this.options);
  }

  desactivarEstancia(id: number): Observable<any> {
    const idUrl = `${this.url}/desactivar/${id}`;

    return this.http.post(idUrl, this.options);
  }
}
