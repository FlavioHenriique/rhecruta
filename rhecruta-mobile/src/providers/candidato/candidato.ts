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
  private urlBase1: String = 'http://localhost:8081/rhecruta/api/avaliacao';

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

  save(candidato: any) {

    let url: any = this.urlBase;

    let headers = new Headers();
    headers.append('content-type', 'application/json');
    let options = new RequestOptions({ headers: headers });

    return new Promise((resolve, reject) => {
      this.http.post(url, candidato, options)
        .subscribe(
          (result: any) => {
            resolve(result.json());
          },
          (error: any) => {
            reject(error);
          });
    });
  }

  readAvaliacoes(candidato: any) {
    let url = `${this.urlBase1}/candidato/${candidato.email}`;

    let headers = new Headers();
    headers.append('content-type', 'application/json');
    let options = new RequestOptions({ headers: headers });

    return new Promise((resolve, reject) => {
      this.http.get(url, options)
        .subscribe(
          (result: any) => {
            resolve(result.json());
          },
          (error: any) => {
            reject(error);
          });
    });
  }

  update(candidato: any) {

    let url: any = this.urlBase;

    let headers = new Headers();
    headers.append('content-type', 'application/json');
    let options = new RequestOptions({ headers: headers });

    return new Promise((resolve, reject) => {
      this.http.put(url, candidato, options)
        .subscribe(
          (result: any) => {
            resolve(result.json());
          },
          (error: any) => {
            reject(error);
          });
    });
  }

  removerInteresse(candidato: any, vaga: any) {

    let url = `${this.urlBase}/${candidato.email}/removerInteresse`;

    let headers = new Headers();
    headers.append('content-type', 'application/json');
    let options = new RequestOptions({ headers: headers });

    return new Promise((resolve, reject) => {
      this.http.put(url, vaga, options)
        .subscribe(
          (result: any) => {
            resolve(result.json());
          },
          (error: any) => {
            reject(error);
          });
    });
  }

  delete(email: any) {

    let url = `${this.urlBase}/${email}`;

    return new Promise((resolve, reject) => {
      this.http.delete(url)
        .subscribe(
          (result: any) => {
            console.log(result);
            resolve(result.json());
          },
          (error: any) => {
            reject(error);
          });
    });
  }

  deleteAvaliacao(id: any) {

    let url = `${this.urlBase1}/${id}`;

    console.log(url, 'URL UTILIZADA');

    return new Promise((resolve, reject) => {
      this.http.delete(url)
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
