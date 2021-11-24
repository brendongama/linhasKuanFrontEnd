import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/models/pedido';
import { PedidoService } from 'src/app/services/pedido.service';
import { ToastrService } from 'ngx-toastr';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pedido-update',
  templateUrl: './pedido-update.component.html',
  styleUrls: ['./pedido-update.component.css']
})
export class PedidoUpdateComponent implements OnInit {

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
  
    update(): void {
      this.service.update(this.pedido).subscribe(() => {
        this.toast.success('Pedido atualizado com sucesso', 'Update');
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
