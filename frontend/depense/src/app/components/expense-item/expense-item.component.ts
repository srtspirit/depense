import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { Expense } from '../../models';
import { ControlValueAccessor } from '@angular/forms';

@Component({
  selector: 'app-expense-item',
  templateUrl: './expense-item.component.html'
})
export class ExpenseItemComponent {
  @Input()
  expense: Expense;
  initialCalendarDate = { date: new Date() };

  changeExpenseDate(dateWrapper: any): void {
    this.expense.date = dateWrapper.date;
  }
}
