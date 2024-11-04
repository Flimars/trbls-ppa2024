package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.MatriculaDTO;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Matricula;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Turma;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.MatriculaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.TurmaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.NoSuchElementException;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    public MatriculaDTO createMatricula(MatriculaDTO matriculaDTO) {
       Aluno aluno = alunoRepository.findById(matriculaDTO.getAlunoId());
       if (aluno == null) {
        throw new NoSuchElementException("Aluno não encontrado");
    }
        Turma turma = turmaRepository.findById(matriculaDTO.getTurmaId());
        if (turma == null) {
            throw new NoSuchElementException("Turma não encontrada");
        }

        Matricula matricula = new Matricula();
        matricula.setId(UUID.randomUUID());
        matricula.setAprovado(matriculaDTO.isAprovado());

        matriculaRepository.save(matricula);
        return toDTO(matricula);
    }

    public List<MatriculaDTO> getAllMatriculas() {
        return matriculaRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public MatriculaDTO getMatriculaById(UUID id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Matrícula não encontrada"));
        return toDTO(matricula);
    }

    public MatriculaDTO updateMatricula(UUID id, MatriculaDTO matriculaDTO) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Matrícula não encontrada"));

        Aluno aluno = alunoRepository.findById(matriculaDTO.getAlunoId());
        if (aluno == null) {
            throw new EntidadeNaoEncontradaException("Aluno não encontrado");
        }
        Turma turma = turmaRepository.findById(matriculaDTO.getTurmaId());
        if (turma == null) {
            throw new EntidadeNaoEncontradaException("Turma não encontrada");
        }

        matricula.setAluno(aluno);
        matricula.setTurma(turma);
        matricula.setAprovado(matriculaDTO.isAprovado());

        matriculaRepository.save(matricula);
        return toDTO(matricula);
    }

    public void deleteMatricula(UUID id) {
        matriculaRepository.deleteById(id);
    }

    private MatriculaDTO toDTO(Matricula matricula) {
        MatriculaDTO dto = new MatriculaDTO();
        dto.setId(matricula.getId());
        dto.setAlunoId(matricula.getAlunoId());
        dto.setTurmaId(matricula.getTurmaId());
        dto.setAprovado(matricula.isAprovado());
        return dto;
    }
}
