package br.edu.ifrs.riogrande.tads.ppa.ligaa.controller;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.DisciplinaDTO;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @PostMapping
    public ResponseEntity<DisciplinaDTO> createDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
        DisciplinaDTO createdDisciplina = disciplinaService.createDisciplina(disciplinaDTO);
        return ResponseEntity.ok(createdDisciplina);
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaDTO>> getAllDisciplinas() {
        List<DisciplinaDTO> disciplinas = disciplinaService.getAllDisciplinas();
        return ResponseEntity.ok(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> getDisciplinaById(@PathVariable UUID id) {
        DisciplinaDTO disciplina = disciplinaService.getDisciplinaById(id);
        return ResponseEntity.ok(disciplina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaDTO> updateDisciplina(@PathVariable UUID id, @RequestBody DisciplinaDTO disciplinaDTO) {
        DisciplinaDTO updatedDisciplina = disciplinaService.updateDisciplina(id, disciplinaDTO);
        return ResponseEntity.ok(updatedDisciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplina(@PathVariable UUID id) {
        disciplinaService.deleteDisciplina(id);
        return ResponseEntity.noContent().build();
    }
}
