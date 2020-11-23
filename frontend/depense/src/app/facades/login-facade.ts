import {JwtModel} from "../models/jwt.model";
import {LoginService} from "../rest/login.service";
import {tap} from "rxjs/operators";
import {Observable} from "rxjs";
import {Injectable} from "@angular/core";

@Injectable({providedIn: 'root'})
export class LoginFacade {
  private credentials = new JwtModel();

  public constructor(private loginService: LoginService) {}

  public login(login: string, password: string): Observable<JwtModel> {
    return this.loginService.login(login, password).pipe(
      tap( jwt => {
      this.credentials.jwt = jwt.jwt;
    }));
  }

  public getCredentials(): JwtModel {
    return this.credentials;
  }
}
