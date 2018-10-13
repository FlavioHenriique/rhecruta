import { Http, Headers, RequestOptions } from '@angular/http';
import { Injectable } from '@angular/core';


/*
  Generated class for the CandidatoProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class CandidatoProvider {

  private urlBase: String = 'http://localhost:8081/rhecruta/api/candidato';

  constructor(public http: Http) {
    console.log('Hello CandidatoProvider Provider');
  }

  login(dados: any) {

    let url = `${this.urlBase}/login`;

    let headers = new Headers();
    headers.append('content-type', 'application/json');
    let options = new RequestOptions({ headers: headers });

    return new Promise((resolve, reject) => {
      this.http.post(url, dados, options)
        .subscribe(
          (result: any) => {
            resolve(result.json());
          },
          (error: any) => {
            reject(error);
          });
    });
  }

}
