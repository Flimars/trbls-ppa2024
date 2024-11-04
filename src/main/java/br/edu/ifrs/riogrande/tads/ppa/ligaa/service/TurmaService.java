package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.TurmaDTO;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Turma;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeInativaException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public TurmaDTO createTurma(TurmaDTO turmaDTO) {
        Turma turma = new Turma();
        turma.setId(UUID.randomUUID());
        turma.setNome(turmaDTO.getNome());
        // Defina os outros atributos conforme necessário
        turmaRepository.save(turma);
        return toDTO(turma);
    }

    public TurmaDTO getTurmaById(UUID id) throws EntidadeInativaException {
        Turma turma = turmaRepository.findById(id);
        if (turma == null) {
            throw new EntidadeInativaException();
        }
        return toDTO(turma);
    }

    public TurmaDTO updateTurma(UUID id, TurmaDTO turmaDTO) throws EntidadeInativaException {
        Turma turma = turmaRepository.findById(id);
        if (turma == null) {
            throw new EntidadeInativaException();
        }
        turma.setNome(turmaDTO.getNome());
        // Atualize os outros atributos conforme necessário
        turmaRepository.save(turma);
        return toDTO(turma);
    }

    public List<TurmaDTO> getAllTurmas() {
        return turmaRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteTurma(UUID id) throws EntidadeInativaException {
        Turma turma = turmaRepository.findById(id);
        if (turma == null) {
            throw new EntidadeInativaException();
        }
        turma.setAtiva(false); // Supondo que você tenha um método setAtiva para desativar
        turmaRepository.save(turma);
    }

    private TurmaDTO toDTO(Turma turma) {
        TurmaDTO dto = new TurmaDTO();
        dto.setId(turma.getId());
        dto.setNome(turma.getNome());
        // Converta os outros atributos conforme necessário
        return dto;
    }
}



/*package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

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
//import java.util.Optional;
import java.util.UUID;
//import java.util.function.Function;
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

    public Aluno findAlunoById(UUID id) throws EntidadeInativaException {
        return alunoRepository.findById(id);
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

    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }

    public Disciplina saveDisciplina(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }
    public void deleteTurma(UUID id) {
        Turma turma = turmaRepository.findById(id);
        if (turma != null) {
            turma.setAtiva(false); // Supondo que você tenha um método setAtiva para desativar
            turmaRepository.save(turma); // Salva a turma desativada de volta ao repositório
        } else {
            throw new EntidadeInativaException();
        }
    }
}*/
