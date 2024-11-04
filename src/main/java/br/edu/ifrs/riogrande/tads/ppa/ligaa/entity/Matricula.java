
package br.edu.ifrs.riogrande.tads.ppa.ligaa.entity;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
import java.util.UUID;

//import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;


public class Matricula {
    private UUID id;
    private Aluno aluno;
    private Turma turma;
    private boolean aprovado;

    public Matricula(Aluno aluno, Turma turma) {
        this.id = UUID.randomUUID();
        this.aluno = aluno;
        this.turma = turma;
        this.aprovado = false;
    }
    
    
    public Matricula() {
        // Construtor padrão vazio, se necessário
    }
    
    public void aprovar(){
        this.aprovado = true;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public UUID getAlunoId() {
        return aluno != null ? aluno.getId() : null;
    }

    public UUID getTurmaId() {
        return turma != null ? turma.getId() : null;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    @Override
    public String toString() {
        return "Matricula [id=" + id + ", aluno=" + aluno + ", turma=" + turma + ", aprovado=" + aprovado
                + ", toString()=" + super.toString() + "]";
    }


}
