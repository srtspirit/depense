import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {JwtModel} from "../models/jwt.model";

@Injectable({providedIn: 'root'})
export class LoginService {
  public constructor(private http: HttpClient){}
  public login(passedLogin: string, pass: string): Observable<JwtModel> {
    const head = new HttpHeaders().append('login', passedLogin).append('password', pass);
    return this.http.post<JwtModel>(environment.loginUrl, null, {headers: head});
  }
}
