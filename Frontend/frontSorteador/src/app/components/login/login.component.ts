import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username = '';
  password = '';

  constructor(private authService: AuthService, private router: Router) { }

  login(): void {
    if (this.authService.login(this.username, this.password)) {
      this.router.navigate(['/dashboard']);  // Redirige después de login
    } else {
      alert('Credenciales incorrectas');
    }
  }
}
