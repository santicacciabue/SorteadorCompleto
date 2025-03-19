import { Component, OnInit } from '@angular/core';

export interface SolicitudReemplazo {
  id: number;
  estado: "Pendiente" | "Aceptado" | "Rechazado" | "Modificada";
  motivo: string;
  fecha: string;
  reemplazoPropuesto?: string; // Nombre del reemplazo propuesto
  estadoReemplazo?: "Pendiente" | "Aceptado" | "Rechazado"; // Estado del reemplazo
}

@Component({
  selector: 'app-gestion-reemplazos',
  templateUrl: './gestion-reemplazos.component.html',
  styleUrls: ['./gestion-reemplazos.component.css']
})
export class GestionReemplazosComponent implements OnInit {
  // Datos locales simulados
  solicitudes: SolicitudReemplazo[] = [];
  nuevaSolicitud: SolicitudReemplazo = { id: 0, estado: 'Pendiente', motivo: '', fecha: '', reemplazoPropuesto: '', estadoReemplazo: 'Pendiente' };
  solicitudModificada: SolicitudReemplazo | null = null;
  idCounter: number = 1;

  // Aquí puedes establecer el nombre del empleado que está viendo las solicitudes
  empleadoNombre: string = 'Juan Pérez'; // Ejemplo de empleado

  constructor() { }

  ngOnInit(): void {
    // Cargar datos locales simulados
    this.solicitudes = [
      { id: 1, estado: 'Pendiente', motivo: 'Enfermedad', fecha: '2025-03-20', reemplazoPropuesto: 'Juan Pérez', estadoReemplazo: 'Pendiente' },
      { id: 2, estado: 'Aceptado', motivo: 'Vacaciones', fecha: '2025-03-22', reemplazoPropuesto: 'Ana García', estadoReemplazo: 'Aceptado' },
      { id: 3, estado: 'Rechazado', motivo: 'Emergencia familiar', fecha: '2025-03-21', reemplazoPropuesto: 'Juan Pérez', estadoReemplazo: 'Rechazado' }
    ];
  }

  // Métodos para crear, modificar y cancelar solicitudes
  agregarSolicitud(): void {
    this.nuevaSolicitud.id = this.idCounter++;
    this.nuevaSolicitud.estado = 'Pendiente';
    this.solicitudes.push({ ...this.nuevaSolicitud });
    this.nuevaSolicitud = { id: 0, estado: 'Pendiente', motivo: '', fecha: '', reemplazoPropuesto: '', estadoReemplazo: 'Pendiente' }; // Resetear formulario
  }

  modificarSolicitud(solicitud: SolicitudReemplazo): void {
    this.solicitudModificada = { ...solicitud };
  }

  cancelarSolicitud(solicitud: SolicitudReemplazo): void {
    this.solicitudes = this.solicitudes.filter(s => s.id !== solicitud.id);
  }

  // Método para guardar la solicitud modificada
  guardarModificacion(): void {
    if (this.solicitudModificada) {
      const index = this.solicitudes.findIndex(s => s.id === this.solicitudModificada!.id);
      if (index !== -1) {
        this.solicitudes[index] = { ...this.solicitudModificada };
      }
      this.solicitudModificada = null;
    }
  }

  // Método para filtrar solicitudes basadas en el reemplazo propuesto al empleado
  obtenerSolicitudesDeReemplazo(): SolicitudReemplazo[] {
    return this.solicitudes.filter(solicitud => solicitud.reemplazoPropuesto === this.empleadoNombre);
  }
}
