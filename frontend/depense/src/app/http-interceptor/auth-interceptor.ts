import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable, of, throwError} from "rxjs";
import {catchError, tap} from "rxjs/operators";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {Injectable} from "@angular/core";
import {LoginFacade} from "../facades/login-facade";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private router: Router, private loginFacade: LoginFacade) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const jwt = this.loginFacade.getCredentials();
    let request = req;

    if (jwt.jwt) {
      request = req.clone({
        headers: req.headers.append('Authorization', jwt.jwt)
      });
    }

    return next.handle(request)
      .pipe(
        catchError((err: HttpErrorResponse) => {
          console.log(err);
          if (err.status === 403) {
            this.router.navigate(['/login'],
              {
                queryParams: {
                  redirectUrl: this.router.routerState.snapshot.url
                }
              });
          }
          return throwError(err);
        })
      );
  }
}
