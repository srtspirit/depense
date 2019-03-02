import { Observable } from 'rxjs';
import { Receipt, Entity } from '../models';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const URL = 'http://localhost:8080/';

@Injectable()
export class ReceiptService {
  constructor(private http: HttpClient) {}
  createReceipt<T extends Entity>(entity: T): Observable<T> {
    return this.http.post<T>(URL + entity.entityName, entity);
  }
}
