import {NgModule} from "@angular/core";
import {AppComponent} from "../app/app.component";
import {CreateReceiptComponent} from "./components/create-receipt/create-receipt.component";
import {CreateExpenseComponent} from "./components/create-expense/create-expense.component";
import {ExpenseItemComponent} from "./components/expense-item/expense-item.component";
import {ExpenseListComponent} from "./components/expense-list/expense-list.component";
import {ArticleListComponent} from "./components/article-list/article-list.component";
import {BrowserModule} from "@angular/platform-browser";
import {FundamentalNgxModule} from "fundamental-ngx";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {ReceiptFacade} from "./facades/receipt.facade";
import {ReceiptService} from "./rest/receipt.service";
import {ExpenseFacade} from "./facades/expense.facade";
import {ArticleFacade} from "./facades/article.facade";
import {DepenseComponent} from "./components/depense-component/depense.component";
import {DepenseRoutingModule} from "./depense-routing.module";

@NgModule({
  declarations: [
    AppComponent,
    CreateReceiptComponent,
    CreateExpenseComponent,
    ExpenseItemComponent,
    ExpenseListComponent,
    ArticleListComponent,
    DepenseComponent
  ],
  imports: [
    BrowserModule,
    DepenseRoutingModule,
    FundamentalNgxModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [ReceiptFacade, ReceiptService, ExpenseFacade, ArticleFacade],
  bootstrap: [DepenseComponent]
})
export class DepenseModule {
}
