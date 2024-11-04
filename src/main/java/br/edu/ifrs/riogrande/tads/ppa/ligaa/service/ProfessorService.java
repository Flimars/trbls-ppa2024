package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeInativaException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfessorService {

     @Autowired
    private ProfessorRepository professorRepository;

    //private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor findProfessorById(UUID id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new EntidadeInativaException());
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public boolean deleteProfessor(UUID id) {
        return professorRepository.deleteById(id);
    }
    public void deleteById(UUID id) {
        if (!professorRepository.deleteById(id)) {
            throw new EntidadeInativaException();
        }
    }
}
