import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditarFuncionarioComponent } from './pages/editar-funcionario/editar-funcionario.component';
import { CriarFuncionarioComponent } from './pages/criar-loja/criar-loja.component';
import { ListaFuncionarioComponent } from './pages/listar-funcionario/listar-funcionario.component';
import { CriarLojaComponent } from './paginas/criar-loja/criar-loja.component';

const routes: Routes = [
  { path: 'funcionario', component: ListaFuncionarioComponent},
  { path: 'funcionario/criar', component: CriarFuncionarioComponent},
  { path: 'loja/criar', component: CriarLojaComponent},
  { path: 'funcionario/editar/:cpf', component: EditarFuncionarioComponent},
  { path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
