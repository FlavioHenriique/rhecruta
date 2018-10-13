import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Storage } from '@ionic/storage';
import { TabsPage } from '../tabs/tabs';
import { CandidatoProvider } from '../../providers/candidato/candidato';
import Candidato from '../../models/candidato';

/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  private candidato: Candidato;
  loginDados: any = {};

  constructor(public navCtrl: NavController, public navParams: NavParams, private storage:Storage, private candidatoProvider: CandidatoProvider) {
    this.candidato = new Candidato();
  }

  public logar() {
    this.candidatoProvider.login(this.loginDados)
      .then((cand) => {
        this.candidato.email = cand['email'];
        this.candidato.curriculo = cand['curriculo'];
        this.candidato.interesses = cand['interesses'];
        this.candidato.nome = cand['nome'];
        this.candidato.senha = cand['senha'];
        this.candidato.vagas = cand['vagas'];

        this.storage.set('candidato', this.candidato);
        
        this.navCtrl.setRoot(TabsPage);
      })
      .catch((error) => {
        console.log('error', error);
      })
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }

}
