import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ThrowStmt } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Tema } from '../model/Tema';

@Injectable({
  providedIn: 'root'
})
export class TemaService {

  constructor(private http: HttpClient) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  getAlltema(): Observable<Tema[]>{
    return this.http.get<Tema[]>('http://localhost:8090/tema', this.token)
  }

  getByIdTema(id: number): Observable<Tema> {
    return this.http.get<Tema>(`http://localhost:8090/tema/${id}`, this.token)


  }

  postTema(tema: Tema): Observable<Tema> {
    return this.http.post<Tema>('http://localhost:8090/tema', tema, this.token)

  }

  putTema(tema: Tema): Observable<Tema> {
    return this.http.put<Tema>('http://localhost:8090/tema/put', tema, this.token)
  }

  deleteTema(id: number) {
    return this.http.delete(`http://localhost:8090/tema/del/${id}`, this.token)

  }
}
