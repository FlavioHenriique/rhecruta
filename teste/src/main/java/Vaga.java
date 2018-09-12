import javax.persistence.Embeddable;

@Embeddable
public class Vaga {

    private String nome;
    private String a;
    private String b;
    private int id;

    public Vaga(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Vaga() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
