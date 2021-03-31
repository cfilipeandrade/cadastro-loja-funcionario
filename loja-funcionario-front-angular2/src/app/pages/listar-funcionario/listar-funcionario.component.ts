import { MetaService } from 'src/app/services/meta.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Funcionario } from '../../interfaces/funcionario';
import { FuncionarioService } from '../../services/funcionario.service';
import { ErrorMsgComponent } from '../../compartilhado/error-msg/error-msg.component';

@Component({
  selector: 'app-lista-funcionario',
  templateUrl: './lista-funcionario.component.html',
  styleUrls: ['./lista-funcionario.component.css']
})
export class ListaFuncionarioComponent implements OnInit {
  public funcionario: Funcionario[];

  public metaDados;

  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;

  constructor(private funcionarioService: FuncionarioService, private metaService: MetaService) { }

  ngOnInit() {
    this.getListaFuncionarios();
    this.getMeta();
  }

  getMeta() {
    this.metaService.getMetaObj().subscribe(dados => {
      this.metaDados = dados;
      console.log(this.metaDados);
    })
  }

  getListaFuncionarios() {
    this.funcionarioService.getListaFuncionarios()
      .subscribe((funcionario: Funcionario[]) => {
        this.funcionario = funcionario;
      }, () => { this.errorMsgComponent.setError('Falha ao buscar funcionario.'); });
  }

  deletaFuncionario(cpf: string) {
    this.funcionarioService.deletaFuncionario(cpf)
      .subscribe(() => {
        this.getListaFuncionarios();
      }, () => { this.errorMsgComponent.setError('Falha ao deletar funcionario.'); });
  }

  existemFuncionarios(): boolean {
    return this.funcionario && this.funcionario.length > 0;
  }

}
