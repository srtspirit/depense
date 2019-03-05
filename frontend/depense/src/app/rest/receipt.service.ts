import { Observable } from 'rxjs';
import { Receipt, Entity } from '../models';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const URL = 'http://localhost:8080/';

@Injectable()
export class ReceiptService<T extends Entity> {
  constructor(private http: HttpClient) {}
  createReceipt(entity: T): Observable<T> {
    return this.http.post<T>(URL + entity.entityName, entity);
  }

  getAll(name: string): Observable<T[]> {
    return this.http.get<T[]>(URL + name);
  }
}
