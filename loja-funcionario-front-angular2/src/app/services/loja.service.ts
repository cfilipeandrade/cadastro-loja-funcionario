import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Loja } from './../interfaces/loja';

@Injectable({providedIn: 'root'})
export class LojaService {

  constructor(private http: HttpClient) { }

  getListaLojas(): Observable<Loja[]> {
    const url = `${environment.funcionariosApiUrl}/loja`;
    return this.http.get<Loja[]>(url);
  }

  getLoja(id: number): Observable<Loja> {
    const url = `${environment.funcionariosApiUrl}/loja/${id}`;
    return this.http.get<Loja>(url);
  }

  addLoja(loja: Loja): Observable<Loja> {
    const url = `${environment.funcionariosApiUrl}/Loja/`;
    return this.http.post<Loja>(url, loja);
  }

  atualizaLoja(loja: Loja): Observable<Loja> {
    const url = `${environment.funcionariosApiUrl}/Loja/${loja.id}`;
    return this.http.put<Loja>(url, loja);
  }

  deletaLoja(id: number): Observable<Loja> {
    const url = `${environment.funcionariosApiUrl}/Loja/${id}`;
    return this.http.delete<Loja>(url);
  }

}
