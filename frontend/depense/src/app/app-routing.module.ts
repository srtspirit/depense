import {RouterModule, Routes} from "@angular/router";
import {CreateReceiptComponent} from "../depense_module/components/create-receipt/create-receipt.component";
import {CreateExpenseComponent} from "../depense_module/components/create-expense/create-expense.component";
import {ArticleListComponent} from "../depense_module/components/article-list/article-list.component";
import {NgModule} from "@angular/core";
import {DepenseComponent} from "../depense_module/components/depense-component/depense.component";
import {TestComponent} from "../test-module/test.component";
import {LoginComponent} from "./components/login-component/login.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'depense', component: DepenseComponent },
  { path: 'test', component: TestComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
