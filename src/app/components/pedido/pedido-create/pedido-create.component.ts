import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/models/pedido';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';
import { PedidoService } from 'src/app/services/pedido.service';

@Component({
  selector: 'app-pedido-create',
  templateUrl: './pedido-create.component.html',
  styleUrls: ['./pedido-create.component.css']
})
export class PedidoCreateComponent implements OnInit {

  pedido: Pedido = {
    id:                '',    
    nomeCliente:       '',  
    status:            '',
    descricao:         '',
    endereco:          '',
    cep:               '',
    cidade:            '',
    rg:                '',
    celular:           '',
    valor:             '', 
  }

  constructor(
    private service: PedidoService,
    private toast:    ToastrService,
    private router:          Router,
    ) { }

  ngOnInit(): void { }

  create(): void {
    this.service.create(this.pedido).subscribe(() => {
      this.toast.success('Pedido cadastrado com sucesso', 'Pedido');
      this.router.navigate(['pedidos'])
    }, ex => {
      if(ex.error.errors) {
        ex.error.errors.forEach((element: { message: string | undefined; }) => {
          this.toast.error(element.message);
        });
      } else {
        this.toast.error(ex.error.message);
      }
    })
  }
}
 