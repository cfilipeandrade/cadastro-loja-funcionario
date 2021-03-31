import { LojaService } from '../../services/loja.service';
import { Loja } from '../../interfaces/loja';
import { Component, ViewChild } from '@angular/core';
import { ErrorMsgComponent } from '../../compartilhado/error-msg/error-msg.component';
import { Router } from '@angular/router';


@Component({
  selector: 'app-criar-loja',
  templateUrl: './criar-loja.component.html',
  styleUrls: ['./criar-loja.component.css']
})
export class CriarLojaComponent {
  @ViewChild(ErrorMsgComponent) errorMsgComponent: ErrorMsgComponent;

  constructor(private funcionarioService: LojaService, private router: Router) { }

  addCliente(loja: Loja) {
    this.funcionarioService.addLoja(loja)
      .subscribe(
        () => { this.router.navigateByUrl('/'); },
        () => { this.errorMsgComponent.setError('Falha ao adicionar loja.'); });
  }

}
