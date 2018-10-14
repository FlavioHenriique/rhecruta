import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { Storage } from '@ionic/storage';
import { CandidatoProvider } from '../../providers/candidato/candidato';
import Candidato from '../../models/candidato';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  private avaliacoes: any = [];
  private candidato: Candidato;

  constructor(public navCtrl: NavController, private storage:Storage, private candidatoProvider: CandidatoProvider) {
    storage.get('candidato')
      .then((cand) => {
        this.candidato = cand;

        candidatoProvider.readAvaliacoes(this.candidato)
          .then((avali) => {
            console.log(avali);
            this.avaliacoes = avali;
            
          })
          .catch((error) => {            
            console.log('error', error);
          })
      })
      .catch((error) => {
        console.log('error', error);
      })
  }

  public deleteAvaliacao(id: any) {
    this.avaliacoes = this.avaliacoes.filter((avaliacao) => {
      return avaliacao.id !== id;
    })

    console.log('depois do filter', this.avaliacoes);

    this.candidatoProvider.deleteAvaliacao(id)
      .then((avali) => {
        console.log('retorno do delete', avali);
      })
      .catch((error) => {
        console.log('error');
        console.log('error', error);
      })
  }

}
