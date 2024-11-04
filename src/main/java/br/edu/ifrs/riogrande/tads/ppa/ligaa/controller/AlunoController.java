package br.edu.ifrs.riogrande.tads.ppa.ligaa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.AlunoDTO;
//import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.AlunoService;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.NovoAluno;
//import org.springframework.web.bind.annotation.RequestParam;


// Rotear tudo "que tem a ver" com Aluno

@RestController
@RequestMapping("/api")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/aluno")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void novoAluno(@RequestBody NovoAluno aluno) {
        alunoService.cadastrarAluno(aluno);
    }

    @GetMapping("/alunos/{cpf}")
    public ResponseEntity<AlunoDTO> buscaCpf(@PathVariable("cpf") String cpf) {
        AlunoDTO aluno = alunoService.buscarAluno(cpf);
        if (aluno == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(aluno);
    }

    @GetMapping("/alunos")
    public ResponseEntity<List<AlunoDTO>> buscaTodos() {
        return ResponseEntity.ok(alunoService.findAll());
    }

    // public void novoAlunoV2(NovoAlunoV2 aluno)
}
