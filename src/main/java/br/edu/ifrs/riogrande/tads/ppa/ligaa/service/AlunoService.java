package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;
// new AlunoService()

//import java.time.LocalDateTime;
import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
import java.util.stream.Collectors;

//import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.repository.AlunoRepository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.dto.AlunoDTO;

@Service // qualificando o objeto
public class AlunoService {

    // dependência
    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public void cadastrarAluno(NovoAluno novoAluno) {

        if (alunoRepository.cpfExists(novoAluno.getCpf())) {
            throw new IllegalStateException("CPF já existe: " + novoAluno.getCpf());
        }

        // ONDE FICAM AS REGRAS DE DOMÍNIO
        Aluno aluno = new Aluno();

        aluno.setCpf(novoAluno.getCpf());
        aluno.setNome(novoAluno.getNome());
        aluno.setLogin(novoAluno.getEnderecoEletronico());
        aluno.setEnderecoEletronico(novoAluno.getEnderecoEletronico());

        alunoRepository.save(aluno);        
    }

    public List<AlunoDTO> findAll() {
        return alunoRepository.findAll().stream()
                .map(aluno -> {
                    AlunoDTO dto = new AlunoDTO();
                    dto.setCpf(aluno.getCpf());
                    dto.setNome(aluno.getNome());
                    dto.setEnderecoEletronico(aluno.getEnderecoEletronico());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public AlunoDTO buscarAluno(@NonNull String cpf) {
         Aluno aluno = alunoRepository.findAll().stream()
                .filter(a -> a.getCpf().equals(cpf) && !a.isDesativado())
                .findFirst()
                .orElse(null);
        if (aluno == null) {
            return null;
        }
        AlunoDTO dto = new AlunoDTO();
        dto.setCpf(aluno.getCpf());
        dto.setNome(aluno.getNome());
        dto.setEnderecoEletronico(aluno.getEnderecoEletronico());
        return dto;
    }

}
 

