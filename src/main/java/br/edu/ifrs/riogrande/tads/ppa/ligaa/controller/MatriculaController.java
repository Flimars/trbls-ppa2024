package br.edu.ifrs.riogrande.tads.ppa.ligaa.controller;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.MatriculaDTO;
//import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Matricula;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @PostMapping
    public ResponseEntity<MatriculaDTO> createMatricula(@RequestBody MatriculaDTO matriculaDTO) {
        MatriculaDTO createdMatricula = matriculaService.createMatricula(matriculaDTO);
        return ResponseEntity.ok(createdMatricula);
    }

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> getAllMatriculas() {
        List<MatriculaDTO> matriculas = matriculaService.getAllMatriculas();
        return ResponseEntity.ok(matriculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatriculaDTO> getMatriculaById(@PathVariable UUID id) {
        MatriculaDTO matricula = matriculaService.getMatriculaById(id);
        return ResponseEntity.ok(matricula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatriculaDTO> updateMatricula(@PathVariable UUID id, @RequestBody MatriculaDTO matriculaDTO) {
        MatriculaDTO updatedMatricula = matriculaService.updateMatricula(id, matriculaDTO);
        return ResponseEntity.ok(updatedMatricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatricula(@PathVariable UUID id) {
        matriculaService.deleteMatricula(id);
        return ResponseEntity.noContent().build();
    }
}
