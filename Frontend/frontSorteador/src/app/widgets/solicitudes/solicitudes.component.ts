import { Component, OnInit } from '@angular/core';
import { ReemplazosService } from 'src/app/services/reemplazos.service';

@Component({
  selector: 'app-solicitudes',
  templateUrl: './solicitudes.component.html',
  styleUrls: ['./solicitudes.component.css']
})
export class SolicitudesComponent implements  OnInit {


  totalReemplazos: number = 0;
  total = 0;

  constructor(private reemplazoService: ReemplazosService) {}

  // Inyeccion del total de los reemplzaos que estan en reemplazos.service
  ngOnInit() {
    this.reemplazoService.totalReemplazos$.subscribe((total: number) => {
      this.totalReemplazos = total;
    });
  }
}
