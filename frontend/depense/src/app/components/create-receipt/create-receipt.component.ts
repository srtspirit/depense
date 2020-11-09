import {
  Component,
  OnChanges,
  SimpleChanges,
  ViewChild,
  ElementRef
} from '@angular/core';
import { Receipt, Expense } from '../../models';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ReceiptFacade } from '../../facades/receipt.facade';

@Component({
  selector: 'app-create-receipt',
  templateUrl: './create-receipt.component.html'
})
export class CreateReceiptComponent {
  newReceipt: Receipt = new Receipt();
  initialCalendarDate = { date: new Date() };

  constructor(private receiptFacade: ReceiptFacade) {}

  createReceipt() {
    this.receiptFacade
      .createReceipt(this.newReceipt)
      .subscribe(res => console.log(res));
  }

  addExpense(): void {
    this.newReceipt.expenses.push(new Expense());
  }

  changeReceiptDate(dateWrapper: any) {
    this.newReceipt.date = dateWrapper.date;
  }
}
