import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {DepenseModule} from '../depense_module/depense.module';
import {AppRoutingModule} from "./app-routing.module";
import {TestModule} from "../test-module/test.module";

@NgModule({
  declarations: [],
  imports: [
    AppRoutingModule,
    DepenseModule,
    TestModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
