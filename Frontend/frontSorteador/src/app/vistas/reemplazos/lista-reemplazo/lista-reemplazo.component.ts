import { Component } from '@angular/core';
import { ReemplazosService } from 'src/app/services/reemplazos.service';

@Component({
  selector: 'app-lista-reemplazo',
  templateUrl: './lista-reemplazo.component.html',
  styleUrls: ['./lista-reemplazo.component.css']
})
export class ListaReemplazoComponent {

  // Pedir datos al service 
  reemplazos = [
    {
      id: 1,
      solicitante: 'Juan Pérez',
      fechaSolicitud: '09/03/2024',
      fechaReemplazo: '14/03/2024',
      reemplazoPropuesto: 'Carlos Torres',
      estado: 'Pendiente',
      rolSolicitante: 'Auxiliar',
      motivo: 'No puede asistir',
      rolReemplazo: 'Auxiliar',
      fechaDevolucion: '16/03/2024',
      categoria: 'SORTEO',
      grupo: 'GRUPO A'
    },
    {
      id: 2,
      solicitante: 'Ana Gómez',
      fechaSolicitud: '10/03/2024',
      fechaReemplazo: '15/03/2024',
      reemplazoPropuesto: 'Luis Martínez',
      estado: 'Aprobado',
      rolSolicitante: 'Supervisor',
      motivo: 'Reunión importante',
      rolReemplazo: 'Supervisor',
      fechaDevolucion: '17/03/2024',
      categoria: 'ADMIN',
      grupo: 'GRUPO B'
    },
    {
      id: 3,
      solicitante: 'Pedro Rodríguez',
      fechaSolicitud: '11/03/2024',
      fechaReemplazo: '16/03/2024',
      reemplazoPropuesto: 'María Fernández',
      estado: 'Rechazado',
      rolSolicitante: 'Operativo',
      motivo: 'Problemas personales',
      rolReemplazo: 'Operativo',
      fechaDevolucion: '18/03/2024',
      categoria: 'SORTEO',
      grupo: 'GRUPO C'
    },
    {
      id: 4,
      solicitante: 'Laura Díaz',
      fechaSolicitud: '12/03/2024',
      fechaReemplazo: '17/03/2024',
      reemplazoPropuesto: 'Jorge Ruiz',
      estado: 'Pendiente',
      rolSolicitante: 'Auxiliar',
      motivo: 'Vacaciones',
      rolReemplazo: 'Auxiliar',
      fechaDevolucion: '19/03/2024',
      categoria: 'ADMIN',
      grupo: 'GRUPO A'
    },
    {
      id: 5,
      solicitante: 'Luis Hernández',
      fechaSolicitud: '13/03/2024',
      fechaReemplazo: '18/03/2024',
      reemplazoPropuesto: 'Isabel González',
      estado: 'Aprobado',
      rolSolicitante: 'Gerente',
      motivo: 'Capacitación',
      rolReemplazo: 'Gerente',
      fechaDevolucion: '20/03/2024',
      categoria: 'SORTEO',
      grupo: 'GRUPO B'
    },
    {
      id: 6,
      solicitante: 'Laura Díaz',
      fechaSolicitud: '12/03/2024',
      fechaReemplazo: '17/03/2024',
      reemplazoPropuesto: 'Jorge Ruiz',
      estado: 'Pendiente',
      rolSolicitante: 'Auxiliar',
      motivo: 'Vacaciones',
      rolReemplazo: 'Auxiliar',
      fechaDevolucion: '19/03/2024',
      categoria: 'ADMIN',
      grupo: 'GRUPO A'
    },
    {
      id: 7,
      solicitante: 'Franco Díaz',
      fechaSolicitud: '12/03/2024',
      fechaReemplazo: '17/03/2024',
      reemplazoPropuesto: 'Jorge Ruiz',
      estado: 'Pendiente',
      rolSolicitante: 'Auxiliar',
      motivo: 'Vacaciones',
      rolReemplazo: 'Auxiliar',
      fechaDevolucion: '19/03/2024',
      categoria: 'ADMIN',
      grupo: 'GRUPO A'
    }
  ];


  selectedReemplazo: any = null; // Almacena el reemplazo seleccionado
  isModalOpen = false; // Para abrir y cerrar el modal

  getEstadoClass(estado: string): string {
    switch (estado.toLowerCase()) {
      case 'aprobado':
        return 'estado-aprobado';
      case 'rechazado':
        return 'estado-rechazado';
      case 'pendiente':
        return 'estado-pendiente';
      case 'cancelado':
        return 'estado-cancelado';
      case 'confirmado':
        return 'estado-confirmado';
      default:
        return '';
    }
  }

  openModal(reemplazo: any): void {
    this.selectedReemplazo = reemplazo; // Asigna el reemplazo seleccionado al modal
    this.isModalOpen = true; // Abre el modal
  }

  closeModal(): void {
    this.isModalOpen = false; // Cierra el modal
    this.selectedReemplazo = null; // Limpia el reemplazo seleccionado
  }

  trackById(index: number, item: any): number {
    return item.id;
  }

  // Cambiar el estado del reemplazo
  changeEstado(nuevoEstado: string): void {
    if (this.selectedReemplazo) {
      this.selectedReemplazo.estado = nuevoEstado; // Actualiza el estado
    }
    this.closeModal(); // Cierra el modal después de cambiar el estado
  }

 getTotalRemplazos(): number {
  return this.reemplazos.length;
 }
}
