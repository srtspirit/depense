import {RouterModule, Routes} from "@angular/router";
import {CreateReceiptComponent} from "./components/create-receipt/create-receipt.component";
import {CreateExpenseComponent} from "./components/create-expense/create-expense.component";
import {ArticleListComponent} from "./components/article-list/article-list.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
  {path: 'receipt/add', component: CreateReceiptComponent},
  {path: 'expense/add', component: CreateExpenseComponent},
  {path: 'article/list', component: ArticleListComponent}
];

const children: Routes = [
  {
    path: 'depense',
    children: routes
  }
];

@NgModule({
  imports: [RouterModule.forRoot(children)],
  exports: [RouterModule]
})
export class DepenseRoutingModule {
}
