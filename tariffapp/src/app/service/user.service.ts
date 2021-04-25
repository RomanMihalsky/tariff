import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Auth } from '../model/auth';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private host = environment.baseUrl;
  private loggedIn:boolean = false;

  constructor(private http:HttpClient) { }

  login(auth :Auth): Observable<Auth> {
    return this.http.post<Auth>(`${this.host}/users/login`,auth);
  }

  setLoggedIn(loggedIn:boolean){
    this.loggedIn = loggedIn;
  }

  isLoggedIn(): boolean{
    return this.loggedIn;
  }
}
