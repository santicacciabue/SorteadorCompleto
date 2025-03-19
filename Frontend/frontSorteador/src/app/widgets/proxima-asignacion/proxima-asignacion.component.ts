import { Component } from '@angular/core';

@Component({
  selector: 'app-proxima-asignacion',
  templateUrl: './proxima-asignacion.component.html',
  styleUrls: ['./proxima-asignacion.component.css']
})
export class ProximaAsignacionComponent {
  proximaAsignacion = {
    fecha: '20/03/2025',
    hora: '08:00 AM',
    nombre: 'Sorteo Matutino'
  };

  verDetalles() {
    // Lógica para navegar a la página de detalles del próximo sorteo
    console.log('Ver detalles de la próxima asignación');
  }
}
