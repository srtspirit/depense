import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateReceiptComponent } from './components/create-receipt/create-receipt.component';
import { CreateExpenseComponent } from './components/create-expense/create-expense.component';

const routes: Routes = [
  { path: 'receipt/add', component: CreateReceiptComponent },
  { path: 'expense/add', component: CreateExpenseComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
