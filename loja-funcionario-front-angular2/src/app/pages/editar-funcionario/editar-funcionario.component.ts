import { Component, ViewChild } from '@angular/core';
import { ErrorMsgComponent } from '../../compartilhado/error-msg/error-msg.component';
import { FuncionarioService } from '../../services/funcionario.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Funcionario } from '../../interfaces/funcionario';

@Component({
  selector: 'app-editar-cliente',
  templateUrl: './editar-cliente.component.html',
  styleUrls: ['./editar-cliente.component.css']
})
export class EditarFuncionarioComponent {
  public funcionario: Funcionario = <Funcionario>{};
  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;

  constructor(private funcionarioService: FuncionarioService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {
      this.getFuncionario(this.activatedRoute.snapshot.params.id);
    }

    getFuncionario(cpf: string) {
      this.funcionarioService.getFuncionario(cpf)
        .subscribe((funcionario: Funcionario) => {
          this.funcionario = funcionario;
        }, () => { this.errorMsgComponent.setError('Falha ao buscar funcionario.'); });
    }

    atualizaFuncionario(funcionario: Funcionario) {
      this.funcionarioService.atualizaFuncionario(funcionario)
        .subscribe(
          () => { this.router.navigateByUrl('/'); },
          () => { this.errorMsgComponent.setError('Falha ao atualizar funcionario.'); });
    }

}
