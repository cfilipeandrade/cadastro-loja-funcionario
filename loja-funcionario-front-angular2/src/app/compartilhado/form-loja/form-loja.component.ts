import { Component, Input, Output, EventEmitter, OnInit, ViewChild, ElementRef } from '@angular/core';
import { LojaService } from '../../services/loja.service';
import { Loja } from '../../interfaces/loja';

@Component({
  selector: 'app-form-loja',
  templateUrl: './form-loja.component.html',
  styleUrls: ['./form-loja.component.css']
})
export class FormLojaComponent implements OnInit{
  public loja:Loja[];
  constructor(private lojaService:LojaService) { }
  @ViewChild('idLoja') idLoja: ElementRef;

  ngOnInit() {
    this.getLoja();
  }
  @Input()
  private _loja: Loja = <Loja>{};
  public get_loja(): Loja {
    return this._loja;
  }
  public set_loja(value: Loja) {
    this._loja = value;
  }
  @Output() outputLoja: EventEmitter<Loja> = new EventEmitter();


  getLoja(): void {
    this.lojaService.getListaLojas()
      .subscribe(loja => this.loja = loja);
  }

}
