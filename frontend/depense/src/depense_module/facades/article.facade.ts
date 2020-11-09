import { ReceiptService } from '../rest/receipt.service';
import { Injectable } from '@angular/core';
import { Expense, Article } from '../models';
import { Observable } from 'rxjs';

@Injectable()
export class ArticleFacade {
  constructor(private receiptService: ReceiptService<Article>) {}
  getArticles(): Observable<Article[]> {
    return this.receiptService.getAll('article');
  }
}
