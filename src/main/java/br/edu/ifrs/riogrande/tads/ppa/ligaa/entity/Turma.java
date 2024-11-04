
package br.edu.ifrs.riogrande.tads.ppa.ligaa.entity;

//import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;
//import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
import java.util.UUID;


public class Turma {
    private UUID id;
    private Disciplina disciplina;
    private Professor professor;
    private String semestre;
    private String sala;
    private int vagas;
    private List<Aluno> alunos = new ArrayList<>();   
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private boolean desativado;
    private boolean ativa;
    private String nome;


    public Turma() {
        this.id = UUID.randomUUID();
        this.dataHoraCriacao = LocalDateTime.now();
        this.dataHoraAlteracao = LocalDateTime.now();
        this.desativado = false;
    }
    
     public boolean matricularAluno(Aluno aluno){
        if (alunos.size() < vagas) {
            alunos.add(aluno);
            dataHoraAlteracao = LocalDateTime.now();
            return true;            
        }
        return false;
     }

    

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public LocalDateTime getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(LocalDateTime dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public LocalDateTime getDataHoraAlteracao() {
        return dataHoraAlteracao;
    }

    public void setDataHoraAlteracao(LocalDateTime dataHoraAlteracao) {
        this.dataHoraAlteracao = dataHoraAlteracao;
    }

    public boolean isDesativado() {
        return desativado;
    }

    public void setDesativado(boolean desativado) {
        this.desativado = desativado;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    

    @Override
    public String toString() {
        return "Turma [id=" + id + ", disciplina=" + disciplina + ", professor=" + professor + ", semestre=" + semestre
                + ", sala=" + sala + ", vaga=" + vagas + ", alunos=" + alunos + ", toString()=" + super.toString() + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

     
}
