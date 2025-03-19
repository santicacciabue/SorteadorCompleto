import { Component, OnInit } from '@angular/core';
import { ApiService } from '../../services/api.service';

@Component({
  selector: 'app-prueba',
  templateUrl: './prueba.component.html',
  styleUrls: ['./prueba.component.css']
})
export class PruebaComponent implements OnInit{
  usuarios: string[] = [];

  constructor(private apiService: ApiService) {}

  ngOnInit() {
    this.apiService.listarIntegrantes().subscribe(data => {
      console.log('Usuarios recibidos:', data);
      this.usuarios = data;
    }, error => {
      console.error('Error al conectar con el backend:', error);
    });
  }
}
