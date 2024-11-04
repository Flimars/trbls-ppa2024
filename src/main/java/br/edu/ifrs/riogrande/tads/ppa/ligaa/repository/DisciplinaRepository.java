package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Disciplina;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class DisciplinaRepository {

    private final Map<UUID, Disciplina> disciplinaDB = new HashMap<>();

    public Disciplina save(Disciplina disciplina) {
        disciplinaDB.put(disciplina.getId(), disciplina);
        return disciplina;
    }

    public Optional<Disciplina> findById(UUID id) {
        return Optional.ofNullable(disciplinaDB.get(id));
    }

    public boolean delete(Disciplina disciplina) {
        return deleteById(disciplina.getId());
    }

    public List<Disciplina> findAll() {
        return new ArrayList<>(disciplinaDB.values());
    }

    public boolean deleteById(UUID id) {
        return disciplinaDB.remove(id) != null;
    }
}
