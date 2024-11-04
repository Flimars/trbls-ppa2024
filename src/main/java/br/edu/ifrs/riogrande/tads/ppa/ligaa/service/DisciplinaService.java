package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.DisciplinaDTO;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeNaoEncontradaException;

import java.util.List;
//import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public DisciplinaDTO createDisciplina(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = toEntity(disciplinaDTO);
        disciplina.setId(UUID.randomUUID());
        disciplinaRepository.save(disciplina);
        return toDTO(disciplina);
    }

    public List<DisciplinaDTO> getAllDisciplinas() {
        return disciplinaRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public DisciplinaDTO getDisciplinaById(UUID id) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Disciplina não encontrada"));
        return toDTO(disciplina);
    }

    public DisciplinaDTO updateDisciplina(UUID id, DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Disciplina não encontrada"));

        disciplina.setNome(disciplinaDTO.getNome());
        disciplina.setCargahoraria(disciplinaDTO.getCargaHoraria());
        disciplina.setPrerequisitos(disciplinaDTO.getPreRequisitos());
        disciplina.setAulasSemana(disciplinaDTO.getAulasSemana());
        disciplina.setDataHoraAlteracao(disciplinaDTO.getDataHoraAlteracao());
        disciplina.setDesativado(disciplinaDTO.isDesativado());

        disciplinaRepository.save(disciplina);
        return toDTO(disciplina);
    }

    
    public boolean deleteById(UUID id) {
        return disciplinaRepository.deleteById(id);
    }


    public void deleteDisciplina(UUID id) {
        disciplinaRepository.deleteById(id);
    }

    private DisciplinaDTO toDTO(Disciplina disciplina) {
        return new DisciplinaDTO(
                disciplina.getId(),
                disciplina.getNome(),
                disciplina.getCargahoraria(),
                disciplina.getPrerequisitos(),
                disciplina.getAulasSemana(),
                disciplina.getDataHoraCriacao(),
                disciplina.getDataHoraAlteracao(),
                disciplina.isDesativado()
        );
    }

    private Disciplina toEntity(DisciplinaDTO disciplinaDTO) {
        Disciplina disciplina = new Disciplina();
        disciplina.setId(disciplinaDTO.getId());
        disciplina.setNome(disciplinaDTO.getNome());
        disciplina.setCargahoraria(disciplinaDTO.getCargaHoraria());
        disciplina.setPrerequisitos(disciplinaDTO.getPreRequisitos());
        disciplina.setAulasSemana(disciplinaDTO.getAulasSemana());
        disciplina.setDataHoraCriacao(disciplinaDTO.getDataHoraCriacao());
        disciplina.setDataHoraAlteracao(disciplinaDTO.getDataHoraAlteracao());
        disciplina.setDesativado(disciplinaDTO.isDesativado());
        return disciplina;
    }
}

