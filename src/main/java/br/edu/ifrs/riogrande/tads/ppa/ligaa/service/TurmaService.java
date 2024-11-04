package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Turma;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeInativaException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.DisciplinaRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.TurmaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    private final DisciplinaRepository disciplinaRepository;

    public TurmaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public Aluno findAlunoById(UUID id) {
        return alunoRepository.findById(id)
                .orElseThrow(() -> new EntidadeInativaException());
    }

    public Disciplina findDisciplinaById(UUID id) {
        return disciplinaRepository.findById(id)
                .orElseThrow(() -> new EntidadeInativaException());
    }

    public List<Aluno> findAllAlunosAtivos() {
        return turmaRepository.findAll().stream()
                .filter(Turma::isAtiva)
                .flatMap(turma -> turma.getAlunos().stream())
                .filter(Aluno::isAtivo)
                .collect(Collectors.toList());
    }

    public Disciplina saveDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }
    public void deleteTurma(UUID id) {
        Optional<Turma> optionalTurma = turmaRepository.findById(id);
        if (optionalTurma.isPresent()) {
            Turma turma = optionalTurma.get();
            turma.setAtiva(false); // Supondo que você tenha um método setAtiva para desativar
            turmaRepository.save(turma); // Salva a turma desativada de volta ao repositório
        } else {
            throw new EntidadeInativaException();
        }
    }
}
