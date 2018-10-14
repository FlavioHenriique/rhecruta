import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Storage } from '@ionic/storage';
import { CandidatoProvider } from '../../providers/candidato/candidato';

@Component({
  selector: 'page-interesse',
  templateUrl: 'interesse.html'
})
export class InteressePage {

  interesses: any = [];
  private candidato: any = {};

  constructor(public navCtrl: NavController, private storage: Storage, private candidatoProvider: CandidatoProvider) {
    this.storage.get('candidato')
      .then((cand) => {
        this.candidato = cand;
      })
  }

  public delete(interesse) {
    this.candidato.interesses = this.candidato.interesses.filter((inter) => {
      return inter.id !== interesse.id;
    });

    this.candidatoProvider.removerInteresse(this.candidato, interesse)
      .then((cand) => {
        console.log(cand);
      })
      .catch((error) => {
        console.log('error', error);
      })

    /* this.candidatoProvider.delete(this.candidato.email)
      .then((cand) => {
        console.log('delete');
        this.candidatoProvider.save(this.candidato)
          .then((cand) => {
            console.log('save', cand)
          })
          .catch((error)  => {
            console.log('error', error);
          })
      })
      .catch((error) => {
        console.log('error', error);
      }) */

  }

}
