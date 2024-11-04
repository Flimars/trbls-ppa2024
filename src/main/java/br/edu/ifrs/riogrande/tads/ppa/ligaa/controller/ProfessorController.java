package br.edu.ifrs.riogrande.tads.ppa.ligaa.controller;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.ProfessorDTO;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDTO> createProfessor(@RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO createdProfessor = professorService.createProfessor(professorDTO);
        return ResponseEntity.ok(createdProfessor);
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> getAllProfessores() {
        List<ProfessorDTO> professores = professorService.getAllProfessores();
        return ResponseEntity.ok(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getProfessorById(@PathVariable UUID id) {
        ProfessorDTO professor = professorService.getProfessorById(id);
        return ResponseEntity.ok(professor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDTO> updateProfessor(@PathVariable UUID id, @RequestBody ProfessorDTO professorDTO) {
        ProfessorDTO updatedProfessor = professorService.updateProfessor(id, professorDTO);
        return ResponseEntity.ok(updatedProfessor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable UUID id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}

