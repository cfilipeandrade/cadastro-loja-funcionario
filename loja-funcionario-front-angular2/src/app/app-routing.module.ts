import { CriarLojaComponent } from './pages/criar-loja/criar-loja.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditarFuncionarioComponent } from './pages/editar-funcionario/editar-funcionario.component';
import { CriarFuncionarioComponent } from './pages/criar-funcionario/criar-funcionario.component';
import { ListaFuncionarioComponent } from './pages/listar-funcionario/listar-funcionario.component';


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
