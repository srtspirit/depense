import { ReceiptService } from '../rest/receipt.service';
import { Injectable } from '@angular/core';
import { Expense } from '../models';
import { Observable } from 'rxjs';

@Injectable()
export class ExpenseFacade {
  constructor(private receiptService: ReceiptService) {}

  createExpense(expense: Expense): Observable<Expense> {
    return this.receiptService.createReceipt(expense);
  }
}
