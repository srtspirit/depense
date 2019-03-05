import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateReceiptComponent } from './components/create-receipt/create-receipt.component';
import { FundamentalNgxModule } from 'fundamental-ngx';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ReceiptFacade } from './facades/receipt.facade';
import { ReceiptService } from './rest/receipt.service';
import { HttpClientModule } from '@angular/common/http';
import { CreateExpenseComponent } from './components/create-expense/create-expense.component';
import { ExpenseFacade } from './facades/expense.facade';
import { ExpenseItemComponent } from './components/expense-item/expense-item.component';
import { ExpenseListComponent } from './components/expense-list/expense-list.component';
import { ArticleListComponent } from './components/article-list/article-list.component';
import { ArticleFacade } from './facades/article.facade';

@NgModule({
  declarations: [
    AppComponent,
    CreateReceiptComponent,
    CreateExpenseComponent,
    ExpenseItemComponent,
    ExpenseListComponent,
    ArticleListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FundamentalNgxModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ReceiptFacade, ReceiptService, ExpenseFacade, ArticleFacade],
  bootstrap: [AppComponent]
})
export class AppModule {}
