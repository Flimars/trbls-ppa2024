package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
//import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeInativaException;

@Repository // infraestrutura
public class AlunoRepository implements IRepository<Aluno> {

    private Map<UUID, Aluno> mapa = new HashMap<>();

    @Override
    public Aluno save(Aluno a) { // a id=f1323, desativado=true

        LocalDateTime agora = LocalDateTime.now();
        
        if (a.getId() == null) { // não é persistente
            a.setDataHoraCriacao(agora);
            a.setId(UUID.randomUUID()); // atribuir um ID
            a.setDesativado(false);
        }
        
        if (a.isDesativado() || (mapa.containsKey(a.getId()) && mapa.get(a.getId()).isDesativado())) {
            throw new EntidadeInativaException();
        }
        
        a.setDataHoraAlteracao(agora);
        
        mapa.put(a.getId(), a);
        
        return a;
    }

    public boolean cpfExists(String cpf) {
        return mapa.values().stream()
            // qualquer um coincide o CPF?
            .anyMatch(aluno -> cpf.equals(aluno.getCpf()));
    }


    @Override
    public boolean delete(Aluno e) {
        if (e == null || e.getId() == null || !mapa.containsKey(e.getId())) {
            return false;
        }

        Aluno aluno = mapa.get(e.getId());
        if (aluno.isDesativado()) {
            throw new EntidadeInativaException();
        }

        aluno.setDesativado(true);
        aluno.setDataHoraAlteracao(LocalDateTime.now());
        mapa.put(aluno.getId(), aluno);
        return true;
    }

    @Override
    public List<Aluno> findAll() {
        List<Aluno> alunosAtivos = new ArrayList<>();
        for (Aluno aluno : mapa.values()) {
            if (!aluno.isDesativado()) {
                alunosAtivos.add(aluno);
            }
        }
        return alunosAtivos;
        
    }
    
    @Override
    public Aluno findById(UUID id) {
        Aluno aluno = mapa.get(id);
        // Retorna o aluno apenas se ele estiver ativo
        if (aluno != null && !aluno.isDesativado()) {
            return aluno;
        }
        return null; // Retorna null se o aluno está desativado ou não existe
    }

}
