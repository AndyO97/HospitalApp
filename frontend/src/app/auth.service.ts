import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';
import { HttpClient, HttpResponse } from '@angular/common/http';
import {Router} from '@angular/router'
import { shareReplay, tap } from 'rxjs/Operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  globalUserId: string;

  constructor(private webService: WebRequestService, private router: Router, private http: HttpClient ) {
    this.globalUserId ='';
   }

  login(username: string, password: string){
    return this.webService.login(username, password)
      .pipe(
      shareReplay(),
      tap((res: HttpResponse<any>) => {
        this.setSession(res.body.id, res.body.username);
        console.log("LOGGED IN!");
        console.log(res);
      })
    )
  }

  signup(email: string, password: string) {
    return this.webService.signup(email, password).pipe(
      shareReplay(),
      tap((res: HttpResponse<any>) => {
        this.setSession(res.body.id, res.body.username);
        console.log("Successfully signed up and now logged in!");
      })
    )
  }

  private setSession(userId: string, username: string){
    localStorage.setItem('user-id', userId);
    localStorage.setItem('username', username);
    this.globalUserId =username;
  }

  logout(){
    this.removeSession();

    this.router.navigate(['/login']);
  }

  private removeSession(){
    localStorage.removeItem('user-id');
    localStorage.removetem('username');
  }

  getUserId(){
    return localStorage.getItem('user-id')
  }
  getUserUsername(){
    return localStorage.getItem('username')
  }

}
