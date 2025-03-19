import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter' // Nombre que utilizarás en el template
})
export class FilterPipe implements PipeTransform {

  // El pipe filtrará el arreglo 'items' según el estado
  transform(items: any[], estado: string): any[] {
    if (!items) return [];
    if (!estado) return items;
    return items.filter(item => item.estado === estado); // Filtra por estado
  }
}
