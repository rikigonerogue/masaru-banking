import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  deposit(amount: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/deposit`, { amount });
  }

  withdraw(amount: number): Observable<any> {
    return this.http.post(`${this.baseUrl}/withdraw`, { amount });
  }
}



