import {RouterModule, Routes} from "@angular/router";
import {CreateReceiptComponent} from "../depense_module/components/create-receipt/create-receipt.component";
import {CreateExpenseComponent} from "../depense_module/components/create-expense/create-expense.component";
import {ArticleListComponent} from "../depense_module/components/article-list/article-list.component";
import {NgModule} from "@angular/core";

const routes: Routes = [
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
export class TestRoutingModule {
}
