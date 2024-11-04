package br.edu.ifrs.riogrande.tads.ppa.ligaa.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProfessorDTO {
    private UUID id;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private boolean desativado;
    private String nome;
    private String formacao;

    public ProfessorDTO() {}

    public ProfessorDTO(UUID id, LocalDateTime dataHoraCriacao, LocalDateTime dataHoraAlteracao, boolean desativado, String nome, String formacao) {
        this.id = id;
        this.dataHoraCriacao = dataHoraCriacao;
        this.dataHoraAlteracao = dataHoraAlteracao;
        this.desativado = desativado;
        this.nome = nome;
        this.formacao = formacao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "ProfessorDTO [id=" + id + ", dataHoraCriacao=" + dataHoraCriacao + ", dataHoraAlteracao=" + dataHoraAlteracao + ", desativado=" + desativado + ", nome=" + nome + ", formacao=" + formacao + "]";
    }
}

