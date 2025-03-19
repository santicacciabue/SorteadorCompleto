import { Component } from '@angular/core';

@Component({
  selector: 'app-mis-asignaciones',
  templateUrl: './mis-asignaciones.component.html',
  styleUrls: ['./mis-asignaciones.component.css']
})
export class MisAsignacionesComponent {
  asignaciones = [
    {
      sorteo: 'Sorteo de productos',
      fecha: '17/03/2025',
      hora: '09:00 AM',
      estado: 'Confirmado'
    },
    {
      sorteo: 'Sorteo de servicios',
      fecha: '18/03/2025',
      hora: '10:00 AM',
      estado: 'Pendiente'
    },
    {
      sorteo: 'Sorteo de productos',
      fecha: '19/03/2025',
      hora: '12:00 PM',
      estado: 'Reemplazo solicitado'
    }
  ];

  verDetalles(asignacion: any) {
    // Lógica para navegar a la página de detalles de la asignación
    console.log('Ver detalles de la asignación:', asignacion);
  }
}
