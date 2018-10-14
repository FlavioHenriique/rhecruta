package br.edu.ifpb.dacrhecruta.dao;

import br.edu.ifpb.dacrhecruta.dao.interfaces.CandidatoDaoIF;
import br.edu.ifpb.dacrhecruta.domain.Candidato;
import br.edu.ifpb.dacrhecruta.domain.Vaga;
import br.edu.ifpb.dacrhecruta.pyjobs.BuscaPyJobs;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.io.FileUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@Stateless
public class CandidatoDao implements CandidatoDaoIF {

    @PersistenceContext
    EntityManager em;
    @Inject
    private BuscaPyJobs jobs;

    @Override
    public void salvar(Candidato obj) {
        em.persist(obj);
    }

    @Override
    public List<Candidato> buscar() {
        List<Candidato> candidatos = em.createQuery("SELECT c FROM Candidato c")
                .getResultList();

        return candidatos;
    }

    @Override
    public Candidato buscar(String email) {
        Candidato c = em.find(Candidato.class, email);
        c.setContent(getCurriculo(c.getCurriculo()));
        return c;
    }

    @Override
    public Candidato buscar(Candidato obj) {
        Candidato candidato = em.find(Candidato.class, obj.getEmail());
        if (candidato != null) {
            candidato.setInteresses(
                    jobs.interessesCandidato(candidato.getVagas())
            );
            candidato.setContent(getCurriculo(candidato.getCurriculo()));
        }
        return candidato;
    }

    @Override
    public void deletar(Candidato obj) {
        em.remove(buscar(obj));
    }

    @Override
    public Candidato atualizar(Candidato obj) {
        em.merge(obj);
        return this.buscar(obj);
    }

    @Override
    public Candidato removerInteresse(Candidato obj, Vaga v) {
        obj.removerInteresse(v);
        return this.atualizar(obj);
    }

    @Override
    public Candidato autenticar(String email, String senha) {
        Candidato c = new Candidato();
        c.setEmail(email);
        c = buscar(c);

        if (c != null && c.getSenha().equals(senha)) {
            return c;
        }
        return null;
    }

    @Override
    public List<Candidato> buscaPorVagas(int id) {
        List<Candidato> lista = em
                .createQuery("SELECT c FROM Candidato c INNER JOIN"
                        + " Avaliacao a WHERE a.codVaga = :id "
                        + "AND c.email = a.candidato.email")
                .setParameter("id", id)
                .getResultList();

        lista.forEach(c -> c.setContent(getCurriculo(c.getCurriculo())));
        return lista;
    }

    @Override
    public StreamedContent getCurriculo(String curriculo) {
        File file = new File("curriculo.pdf");
        if (curriculo != null) {
            byte[] bytes = Base64.getDecoder().decode(curriculo);
            try {
                FileUtils.writeByteArrayToFile(file, bytes);
                StreamedContent content = new DefaultStreamedContent(
                        new FileInputStream(file),
                        "application/pdf",
                        "curriculo.pdf"
                );

                return content;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}
