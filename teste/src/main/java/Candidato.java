import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Candidato implements Serializable {

    @Id
    private String matricula;
    private String nome;
    @ElementCollection
    private List<Vaga> interesses;

    public Candidato(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
        interesses = new ArrayList<Vaga>();

    }
    public void add(Vaga v){
        interesses.add(v);
    }

    public Candidato(){

    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Vaga> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<Vaga> interesses) {
        this.interesses = interesses;
    }
}
