import { Funcionario } from '../../interfaces/funcionario';
import { Component, ViewChild } from '@angular/core';
import { ErrorMsgComponent } from '../../compartilhado/error-msg/error-msg.component';
import { FuncionarioService } from 'src/app/services/funcionario.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-criar-funcionario',
  templateUrl: './criar-funcionario.component.html',
  styleUrls: ['./criar-funcionario.component.css']
})
export class CriarFuncionarioComponent {
  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;

  constructor(private funcionarioService: FuncionarioService, private router: Router) { }

  addCliente(funcionario: Funcionario) {
    this.funcionarioService.addFuncionario(funcionario)
      .subscribe(
        () => { this.router.navigateByUrl('/'); },
        () => { this.errorMsgComponent.setError('Falha ao adicionar funcionario.'); });
  }

}
