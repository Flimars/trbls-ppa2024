package br.edu.ifrs.riogrande.tads.ppa.ligaa.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class DisciplinaDTO {
    private UUID id;
    private String nome;
    private int cargaHoraria;
    private String preRequisitos;
    private int aulasSemana;
    private LocalDateTime dataHoraCriacao;
    private LocalDateTime dataHoraAlteracao;
    private boolean desativado;

    // Construtor vazio (necessário para frameworks de serialização/deserialização)
    public DisciplinaDTO() {}

    // Construtor completo
    public DisciplinaDTO(UUID id, String nome, int cargaHoraria, String preRequisitos, int aulasSemana, LocalDateTime dataHoraCriacao, LocalDateTime dataHoraAlteracao, boolean desativado) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.preRequisitos = preRequisitos;
        this.aulasSemana = aulasSemana;
        this.dataHoraCriacao = dataHoraCriacao;
        this.dataHoraAlteracao = dataHoraAlteracao;
        this.desativado = desativado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getPreRequisitos() {
        return preRequisitos;
    }

    public void setPreRequisitos(String preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public int getAulasSemana() {
        return aulasSemana;
    }

    public void setAulasSemana(int aulasSemana) {
        this.aulasSemana = aulasSemana;
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

    @Override
    public String toString() {
        return "DisciplinaDTO [id=" + id + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + ", preRequisitos=" + preRequisitos + ", aulasSemana=" + aulasSemana + ", dataHoraCriacao=" + dataHoraCriacao + ", dataHoraAlteracao=" + dataHoraAlteracao + ", desativado=" + desativado + "]";
    }
}
