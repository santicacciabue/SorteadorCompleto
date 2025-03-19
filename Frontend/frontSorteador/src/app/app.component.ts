import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontSorteador';

  constructor(public authService: AuthService, private router: Router) { } // ✅ Inyección correcta

  isLoginPage(): boolean {
    return this.router.url === '/login';
  }
}

