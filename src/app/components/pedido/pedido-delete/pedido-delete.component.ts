import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/models/pedido';
import { PedidoService } from 'src/app/services/pedido.service';
import { ToastrService } from 'ngx-toastr';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pedido-delete',
  templateUrl: './pedido-delete.component.html',
  styleUrls: ['./pedido-delete.component.css']
})
export class PedidoDeleteComponent implements OnInit {

  pedido: Pedido = {
    id:                '',
    dataPedido:        '',
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
    private route:   ActivatedRoute,
    ) { }

  ngOnInit(): void {
    this.pedido.id = this.route.snapshot.paramMap.get('id');
    this.findById();
   }

  findById(): void {
    this.service.findById(this.pedido.id).subscribe(resposta => {     
      this.pedido = resposta;
    })
  }

  delete(): void {
    this.service.delete(this.pedido.id).subscribe(() => {
      this.toast.success('Pedido deletado com sucesso', 'Delete');
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
