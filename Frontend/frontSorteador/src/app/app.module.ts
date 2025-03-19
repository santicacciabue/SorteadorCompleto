import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common'; // Importa CommonModule

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { NavComponent } from './shared/nav/nav.component';
import { SolicitudesComponent } from './widgets/solicitudes/solicitudes.component';
import { SorteosComponent } from './widgets/sorteos/sorteos.component';
import { ReemplazosComponent } from './widgets/reemplazos/reemplazos.component';
import { DisponibilidadComponent } from './widgets/disponibilidad/disponibilidad.component';
import { FormsModule } from '@angular/forms';
import { ListaReemplazoComponent } from './vistas/reemplazos/lista-reemplazo/lista-reemplazo.component';
import { ListaPendientesComponent } from './vistas/reemplazos/lista-pendientes/lista-pendientes.component';
import { FilterPipe } from './filter.pipe';
import { MisAsignacionesComponent } from './widgets/mis-asignaciones/mis-asignaciones.component';
import { ProximaAsignacionComponent } from './widgets/proxima-asignacion/proxima-asignacion.component';
import { GestionReemplazosComponent } from './widgets/gestion-reemplazos/gestion-reemplazos.component';
import { PruebaComponent } from './components/prueba/prueba.component';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HeaderComponent,
    FooterComponent,
    DashboardComponent,
    NavComponent,
    SolicitudesComponent,
    SorteosComponent,
    ReemplazosComponent,
    DisponibilidadComponent,
    ListaReemplazoComponent,
    ListaPendientesComponent,
    FilterPipe,
    MisAsignacionesComponent,
    ProximaAsignacionComponent,
    GestionReemplazosComponent,
    PruebaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CommonModule,
    HttpClientModule // Asegúrate de agregar CommonModule aquí
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
