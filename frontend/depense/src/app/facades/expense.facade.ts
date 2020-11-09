import { ReceiptService } from '../rest/receipt.service';
import { Injectable } from '@angular/core';
import { Expense, Receipt } from '../models';
import { Observable } from 'rxjs';

@Injectable()
export class ExpenseFacade {
  constructor(private receiptService: ReceiptService<Expense>) {}

  createExpense(expense: Expense): Observable<Expense> {
    return this.receiptService.createReceipt(expense);
  }
}
