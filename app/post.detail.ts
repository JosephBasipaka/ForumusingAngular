import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { post } from './Post';


@Injectable({
  providedIn: 'root',
})
export class PostService {
  private baseUrl = 'http://localhost:8080/api'; 

  constructor(private http: HttpClient) {}

  getPostById(id: number): Observable<post> {
    return this.http.get<post>(`${this.baseUrl}/post/${id}`);
  }
 
}
