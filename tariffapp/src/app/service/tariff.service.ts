import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Tariff } from '../model/tariff';

@Injectable({
  providedIn: 'root'
})
export class TariffService {
  private host = environment.baseUrl+'/tariff';

  constructor(private http:HttpClient) {}

  getList(): Observable<Tariff[]> {
    return this.http.get<Tariff[]>(`${this.host}`);
  }

  create(tariff:Tariff): Observable<Tariff> {
    return this.http.post<Tariff>(`${this.host}`, tariff);
  }

  delete(id: number): Observable<any> {
    return this.http.delete(`${this.host}/${id}`);
  }

  get(id: number): Observable<Tariff> {
    return this.http.get<Tariff>(`${this.host}/${id}`);
  }

  update(value: any): Observable<Object> {
    return this.http.put(`${this.host}`, value);
  }
}
