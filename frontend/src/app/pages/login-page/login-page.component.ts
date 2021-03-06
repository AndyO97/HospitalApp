import { Component, OnInit } from '@angular/core';
import {AuthService} from 'src/app/auth.service'
import { HttpClient, HttpResponse } from '@angular/common/http';
import {Router} from '@angular/router'

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  onLoginButtonClicked(username: string, password: string) {
    this.authService.login(username, password).subscribe((res: HttpResponse<any>) => {
      if (res.status === 200) {
        // we have logged in successfully
        this.router.navigate(['/main']);
      }
      console.log(res);
      
    });
  }

}
