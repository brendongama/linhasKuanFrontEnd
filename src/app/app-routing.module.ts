import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './components/home/home.component';
import { PedidoListComponent } from './components/pedido/pedido-list/pedido-list.component';
import { PedidoCreateComponent } from './components/pedido/pedido-create/pedido-create.component';
import { PedidoUpdateComponent } from './components/pedido/pedido-update/pedido-update.component';
import { PedidoDeleteComponent } from './components/pedido/pedido-delete/pedido-delete.component';

const routes: Routes = [
  {
    path: '', component: NavComponent, children: [
      { path: 'home', component: HomeComponent },

      { path: 'pedidos',            component:   PedidoListComponent },
      { path: 'pedidos/create',     component: PedidoCreateComponent },
      { path: 'pedidos/update/:id', component: PedidoUpdateComponent },
      { path: 'pedidos/delete/:id', component: PedidoDeleteComponent },
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
