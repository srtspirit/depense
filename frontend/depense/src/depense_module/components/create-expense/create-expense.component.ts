import { Expense } from '../../models';
import { Component } from '@angular/core';
import { ExpenseFacade } from '../../facades/expense.facade';

@Component({
  selector: 'app-create-expense',
  templateUrl: './create-expense.component.html'
})
export class CreateExpenseComponent {
  newExpense: Expense;

  constructor(private facade: ExpenseFacade) {
    this.newExpense = new Expense();
  }

  createExpense() {
    this.facade
      .createExpense(this.newExpense)
      .subscribe(res => console.log(res));
  }
}
