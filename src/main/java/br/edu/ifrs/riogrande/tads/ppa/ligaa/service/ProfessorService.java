package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.ProfessorDTO;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;
//import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeNaoEncontradaException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorDTO createProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setId(UUID.randomUUID());
        professor.setNome(professorDTO.getNome());
        professor.setFormacao(professorDTO.getFormacao());
        professor.setDataHoraCriacao(LocalDateTime.now());
        professor.setDataHoraAlteracao(LocalDateTime.now());
        professor.setDesativado(false);
        professorRepository.save(professor);
        return toDTO(professor);
    }

    public List<ProfessorDTO> getAllProfessores() {
        return professorRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProfessorDTO getProfessorById(UUID id) {
        // Chamando findById diretamente, sem orElseThrow
        Professor professor = professorRepository.findById(id);
        return toDTO(professor);
    }

    public ProfessorDTO updateProfessor(UUID id, ProfessorDTO professorDTO) {
        // Chamando findById diretamente, sem orElseThrow
        Professor professor = professorRepository.findById(id);
        professor.setNome(professorDTO.getNome());
        professor.setFormacao(professorDTO.getFormacao());
        professor.setDataHoraAlteracao(LocalDateTime.now());
        professorRepository.save(professor);
        return toDTO(professor);
    }

    public void deleteProfessor(UUID id) {
        // Chamando findById diretamente, sem orElseThrow
        Professor professor = professorRepository.findById(id);
        professor.setDesativado(true); // Marcar como inativo ao invés de deletar
        professor.setDataHoraAlteracao(LocalDateTime.now());
        professorRepository.save(professor);
    }

    private ProfessorDTO toDTO(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setFormacao(professor.getFormacao());
        dto.setDataHoraCriacao(professor.getDataHoraCriacao());
        dto.setDataHoraAlteracao(professor.getDataHoraAlteracao());
        dto.setDesativado(professor.isDesativado());
        return dto;
    }
}



/*package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.ProfessorDTO;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeNaoEncontradaException;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public ProfessorDTO createProfessor(ProfessorDTO professorDTO) {
        Professor professor = new Professor();
        professor.setId(UUID.randomUUID());
        professor.setNome(professorDTO.getNome());
        professor.setFormacao(professorDTO.getFormacao());
        professor.setDataHoraCriacao(LocalDateTime.now());
        professor.setDataHoraAlteracao(LocalDateTime.now());
        professor.setDesativado(false);
        professorRepository.save(professor);
        return toDTO(professor);
    }

    public List<ProfessorDTO> getAllProfessores() {
        return professorRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProfessorDTO getProfessorById(UUID id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException());
        return toDTO(professor);
    }

    public ProfessorDTO updateProfessor(UUID id, ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException());
        professor.setNome(professorDTO.getNome());
        professor.setFormacao(professorDTO.getFormacao());
        professor.setDataHoraAlteracao(LocalDateTime.now());
        professorRepository.save(professor);
        return toDTO(professor);
    }

    public void deleteProfessor(UUID id) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException());
        professor.setDesativado(true); // Marcar como inativo ao invés de deletar
        professor.setDataHoraAlteracao(LocalDateTime.now());
        professorRepository.save(professor);
    }

    private ProfessorDTO toDTO(Professor professor) {
        ProfessorDTO dto = new ProfessorDTO();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setFormacao(professor.getFormacao());
        dto.setDataHoraCriacao(professor.getDataHoraCriacao());
        dto.setDataHoraAlteracao(professor.getDataHoraAlteracao());
        dto.setDesativado(professor.isDesativado());
        return dto;
    }
}*/




/*package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.ProfessorDTO;
//import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeInativaException;
//import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.ProfessorRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.IRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
//import java.util.List;
import java.util.UUID;
//import java.util.stream.Collectors;

@Service
public class ProfessorService {

     @Autowired
    private IRepository<ProfessorDTO> professorRepository;

    public ProfessorDTO createProfessor(ProfessorDTO professorDTO) {
        professorDTO.setId(UUID.randomUUID());
        professorDTO.setDataHoraCriacao(LocalDateTime.now());
        professorDTO.setDataHoraAlteracao(LocalDateTime.now());
        professorDTO.setDesativado(false);
        return professorRepository.save(professorDTO);
    }

    public ProfessorDTO getProfessorById(UUID id) throws EntidadeInativaException {
        return professorRepository.findById(id);
    }

    public ProfessorDTO updateProfessor(UUID id, ProfessorDTO professorDTO) throws EntidadeInativaException {
        ProfessorDTO existingProfessor = professorRepository.findById(id);
        existingProfessor.setNome(professorDTO.getNome());
        existingProfessor.setFormacao(professorDTO.getFormacao());
        existingProfessor.setDataHoraAlteracao(LocalDateTime.now());
        return professorRepository.save(existingProfessor);
    }

    public void deactivateProfessor(UUID id) throws EntidadeInativaException {
        ProfessorDTO professor = professorRepository.findById(id);
        professor.setDesativado(true);
        professor.setDataHoraAlteracao(LocalDateTime.now());
        professorRepository.save(professor);
    }



}*/

