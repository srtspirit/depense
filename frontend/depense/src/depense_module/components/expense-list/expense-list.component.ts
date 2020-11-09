import { Expense } from '../../models';
import { Input, Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-expense-list',
  templateUrl: './expense-list.component.html'
})
export class ExpenseListComponent {
  @Input()
  expenses: Expense[];
}
