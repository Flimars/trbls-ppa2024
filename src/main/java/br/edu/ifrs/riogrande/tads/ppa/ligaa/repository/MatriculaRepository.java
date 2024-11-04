package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Matricula;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MatriculaRepository {
    private final Map<UUID, Matricula> matriculaDB = new HashMap<>();

    public Matricula save(Matricula matricula) {
        matriculaDB.put(matricula.getId(), matricula);
        return matricula;
    }

    public Optional<Matricula> findById(UUID id) {
        return Optional.ofNullable(matriculaDB.get(id));
    }

    public List<Matricula> findAll() {
        return new ArrayList<>(matriculaDB.values());
    }

    public void deleteById(UUID id) {
        matriculaDB.remove(id);
    }
}
