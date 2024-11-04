package br.edu.ifrs.riogrande.tads.ppa.ligaa.controller;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.TurmaDTO;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public ResponseEntity<TurmaDTO> createTurma(@RequestBody TurmaDTO turmaDTO) {
        TurmaDTO createdTurma = turmaService.createTurma(turmaDTO);
        return ResponseEntity.ok(createdTurma);
    }

    @GetMapping
    public ResponseEntity<List<TurmaDTO>> getAllTurmas() {
        List<TurmaDTO> turmas = turmaService.getAllTurmas();
        return ResponseEntity.ok(turmas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurmaDTO> getTurmaById(@PathVariable UUID id) {
        TurmaDTO turma = turmaService.getTurmaById(id);
        return ResponseEntity.ok(turma);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TurmaDTO> updateTurma(@PathVariable UUID id, @RequestBody TurmaDTO turmaDTO) {
        TurmaDTO updatedTurma = turmaService.updateTurma(id, turmaDTO);
        return ResponseEntity.ok(updatedTurma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable UUID id) {
        turmaService.deleteTurma(id);
        return ResponseEntity.noContent().build();
    }
}
