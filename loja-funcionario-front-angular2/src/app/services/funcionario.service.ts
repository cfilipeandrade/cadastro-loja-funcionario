import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';
import { Funcionario } from '../interfaces/funcionario';

@Injectable({provideIn: 'root'})
export class FuncionarioService {

  constructor(private http: HttpClient) { }

  getListaFuncionarios(): Observable<Funcionario[]> {
    const url = `${environment.funcionariosApiUrl}/funcionario`;
    return this.http.get<Funcionario[]>(url);
  }

  getFuncionario(cpf: string): Observable<Funcionario> {
    const url = `${environment.funcionariosApiUrl}/funcionario/${cpf}`;
    return this.http.get<Funcionario>(url);
  }

  addFuncionario(cliente: Funcionario): Observable<Funcionario> {
    const url = `${environment.funcionariosApiUrl}/funcionario/`;
    return this.http.post<Funcionario>(url, cliente);
  }

  atualizaFuncionario(cliente: Funcionario): Observable<Funcionario> {
    const url = `${environment.funcionariosApiUrl}/funcionario`;
    return this.http.post<Funcionario>(url, cliente);
  }

  deletaFuncionario(cpf: string): Observable<Funcionario> {
    const url = `${environment.funcionariosApiUrl}/funcionario/`+cpf;
    return this.http.delete<Funcionario>(url);
  }

}
