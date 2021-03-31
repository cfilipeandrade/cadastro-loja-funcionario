import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({providedIn: 'root'})
export class MetaService {

  constructor(private http: HttpClient) { }

  getMetaObj(){
    const url = `${environment.funcionariosApiUrl}/meta`;
    return this.http.get(url);
  }
}
