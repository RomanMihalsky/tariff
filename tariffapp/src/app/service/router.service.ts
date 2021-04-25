import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RouterR } from '../model/router';

@Injectable({
  providedIn: 'root'
})
export class RouterService {
  private host = environment.baseUrl+'/router';

  constructor(private http:HttpClient) {}

  getList(): Observable<RouterR[]> {
    return this.http.get<RouterR[]>(`${this.host}`);
  }

  create(router:RouterR): Observable<RouterR> {
    return this.http.post<RouterR>(`${this.host}`, router);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.host}/${id}`);
  }

  get(id: number): Observable<RouterR> {
    return this.http.get<RouterR>(`${this.host}/${id}`);
  }

  update(value: any): Observable<Object> {
    return this.http.put(`${this.host}`, value);
  }
}
