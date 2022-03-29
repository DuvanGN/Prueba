import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TipoDocumento } from '../models/TipoDocumento';

const URL = 'http://localhost:8080/api/cliente/';
@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  
  constructor(private http:HttpClient) { }
  
  registrarCliente(tipoDocId: number, numDoc: number, correo: string, celular: number): Observable<string> {
    let address = URL + 'add-new-client';
    let body = { tipoDocId, numDoc, correo, celular}
    return this.http.post<string>(address, body, { responseType: 'text' as 'json' });
  }

  public getTiposDocumentos(): Observable<Array<TipoDocumento>> {
    let address = URL + 'tipos';
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    const options = {
      headers
    }
    return this.http.get<Array<TipoDocumento>>(address, options);
  }
}
