import { Component, OnInit } from '@angular/core';
import { LojaService } from 'src/app/services/loja.service';
import { Loja } from 'src/app/interfaces/loja';

@Component({
  selector: 'app-Lojas-combo',
  templateUrl: './lojas-combo.component.html',
  styleUrls: ['./lojas-combo.component.css']
})
export class LojasComboComponent implements OnInit {
  public loja:Loja[];
  constructor(private lojaService:LojaService) { }

  ngOnInit() {
    this.getLoja();
  }

  getLoja(): void {
    this.lojaService.getListaLojas()
      .subscribe(loja => this.loja = loja);
  }

}
