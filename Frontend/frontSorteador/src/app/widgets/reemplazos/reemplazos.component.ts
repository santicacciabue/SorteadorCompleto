import { Component,  OnInit } from '@angular/core';
import { ListaReemplazoComponent } from 'src/app/vistas/reemplazos/lista-reemplazo/lista-reemplazo.component';
import { ReemplazosService } from 'src/app/services/reemplazos.service';

@Component({
  selector: 'app-reemplazos',
  templateUrl: './reemplazos.component.html',
  styleUrls: ['./reemplazos.component.css']
})
export class ReemplazosComponent implements OnInit{

  totalPendientes: number = 0;

  constructor(private reemplazoService : ReemplazosService){}

  ngOnInit() {
    this.reemplazoService.totalPendientes$.subscribe(total => {
      this.totalPendientes = total;
    });

}
}
