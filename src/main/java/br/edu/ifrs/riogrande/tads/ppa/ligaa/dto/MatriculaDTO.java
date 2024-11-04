package br.edu.ifrs.riogrande.tads.ppa.ligaa.dto;

//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
import java.util.UUID;

public class MatriculaDTO {
    private UUID id;
    private UUID alunoId;
    private UUID turmaId;
    private boolean aprovado;

    // Construtor vazio (necessário para frameworks de serialização/deserialização)
    public MatriculaDTO() {
    }

    // Construtor completo
    public MatriculaDTO(UUID id, UUID alunoId, UUID turmaId, boolean aprovado) {
        this.id = id;
        this.alunoId = alunoId;
        this.turmaId = turmaId;
        this.aprovado = aprovado;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(UUID alunoId) {
        this.alunoId = alunoId;
    }

    public UUID getTurmaId() {
        return turmaId;
    }

    public void setTurmaId(UUID turmaId) {
        this.turmaId = turmaId;
    }

    public boolean isAprovado() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado = aprovado;
    }

    @Override
    public String toString() {
        return "MatriculaDTO [id=" + id + ", alunoId=" + alunoId + ", turmaId=" + turmaId + ", aprovado=" + aprovado + "]";
    }
}
