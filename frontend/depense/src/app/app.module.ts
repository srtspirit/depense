import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {DepenseModule} from '../depense_module/depense.module';
import {AppRoutingModule} from "./app-routing.module";
import {TestModule} from "../test-module/test.module";
import {LoginComponent} from "./components/login-component/login.component";
import {HTTP_INTERCEPTORS, HttpClient} from "@angular/common/http";
import {AuthInterceptor} from "./http-interceptor/auth-interceptor";
import {Router} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {LoginFacade} from "./facades/login-facade";
import {LoginService} from "./rest/login.service";

@NgModule({
  declarations: [LoginComponent],
  imports: [
    AppRoutingModule,
    DepenseModule,
    TestModule,
    FormsModule
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true},
  LoginFacade, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
