import { Component, Input, Output, EventEmitter, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LojaService } from './../../services/loja.service';
import { Loja } from './../../interfaces/loja';
import { Funcionario } from './../../interfaces/funcionario';

@Component({
  selector: 'app-form-funcionario',
  templateUrl: './form-funcionario.component.html',
  styleUrls: ['./form-funcionario.component.css']
})
export class FormFuncionarioComponent implements OnInit{

  public loja:Loja[];
  constructor(private lojaService:LojaService) { }
  @ViewChild('idLoja') idLoja: ElementRef;

  ngOnInit() {
    this.getLoja();
  }
  @Input() funcionario: Funcionario = <Funcionario>{};
  @Output() outputFuncionario: EventEmitter<Funcionario> = new EventEmitter();

  onSubmit(f: NgForm) {
    let idLoja:number = this.idLoja.nativeElement.value;
    this.lojaService.getLoja(idLoja).subscribe(loja => {
      this.funcionario.loja = loja;
      this.outputFuncionario.emit(this.funcionario);
    });
  }

  getLoja(): void {
    this.lojaService.getListaLojas()
      .subscribe(loja => this.loja = loja);
  }

}
