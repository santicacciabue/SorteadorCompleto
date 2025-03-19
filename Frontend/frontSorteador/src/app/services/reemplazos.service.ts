import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReemplazosService {

  constructor() { }
  private  reemplazos = [
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

  private totalReemplazosSubject = new BehaviorSubject<number>(this.reemplazos.length);
  totalReemplazos$: Observable<number> = this.totalReemplazosSubject.asObservable();

  private totalPendientesSubject = new BehaviorSubject<number>(this.getTotalPendientes());
  totalPendientes$: Observable<number> = this.totalPendientesSubject.asObservable();

  getReemplazos(): any[] {
    return this.reemplazos;
  }

  getTotalReemplazos(): number {
    return this.reemplazos.length;
  }

  getTotalPendientes(): number {
    return this.reemplazos.filter(r => r.estado.toLowerCase() === 'pendiente').length;
  }

  actualizarTotal() {
    this.totalReemplazosSubject.next(this.getTotalReemplazos());
    this.totalPendientesSubject.next(this.getTotalPendientes());
  }
}

