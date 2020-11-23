import {Component, OnInit} from "@angular/core";
import {LoginFacade} from "../../facades/login-facade";
import {ActivatedRoute, Router} from "@angular/router";
import {map, mergeMap} from "rxjs/operators";

@Component({
  selector: 'app-login',
  template: `<input type="text" [(ngModel)]="loginString">
                <input type="text" [(ngModel)]="passwordString">
  <button type="button" (click)="login()">submit</button>`
})
export class LoginComponent {
  public loginString: string;
  public passwordString: string;

  constructor(private loginFacade: LoginFacade, private activatedRoute: ActivatedRoute, private router: Router){}

  public login() {
    this.activatedRoute.params.subscribe(console.log);
    this.loginFacade.login(this.loginString, this.passwordString)
      .pipe(
        mergeMap(res => this.activatedRoute.queryParamMap)
      )
      .subscribe(params => {
      if(params.get('redirectUrl')){
        this.router.navigate([params.get('redirectUrl')]);
      }
    });
  }
}
