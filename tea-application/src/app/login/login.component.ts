import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  rememberPwd = false;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  register(): void {
    this.router.navigate(['/register']);
  }

  submit(): void {
    console.log('1111111');
  }
}
