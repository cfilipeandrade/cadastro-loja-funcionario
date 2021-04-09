import { LojaService } from 'src/app/services/loja.service';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CriarLojaComponent } from './pages/criar-loja/criar-loja.component';
import { FormLojaComponent } from './compartilhado/form-loja/form-loja.component';
import { LojasComboComponent } from './compartilhado/lojas-combo/lojas-combo.component';
import { EditarFuncionarioComponent } from './pages/editar-funcionario/editar-funcionario.component';
import { CriarFuncionarioComponent } from './pages/criar-funcionario/criar-funcionario.component';
import { FormFuncionarioComponent } from './compartilhado/form-funcionario/form-funcionario.component';
import { ListaFuncionarioComponent } from './pages/listar-funcionario/listar-funcionario.component';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ErrorMsgComponent } from './compartilhado/error-msg/error-msg.component';

@NgModule({
  declarations: [
    AppComponent,
    ErrorMsgComponent,
    ListaFuncionarioComponent,
    FormFuncionarioComponent,
    CriarFuncionarioComponent,
    EditarFuncionarioComponent,
    LojasComboComponent,
    FormLojaComponent,
    CriarLojaComponent,
    LojaService
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [LojasComboComponent]
})
export class AppModule { }
