import Vaga from "./vaga";

export default class Candidato {

    email: String;
    senha: String;
    curriculo: String;
    nome: String;
    vagas: Array<Number>;
    interesses: Array<Vaga>;

    constructor() {
    }
}