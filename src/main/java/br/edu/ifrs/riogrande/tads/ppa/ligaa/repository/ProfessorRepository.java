package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Professor;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeInativaException;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
//import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProfessorRepository implements IRepository<Professor> {

    private final Map<UUID, Professor> mapa = new HashMap<>();

    @Override
    public Professor save(Professor p) {
        LocalDateTime agora = LocalDateTime.now();

        if (p.getId() == null) {
            p.setDataHoraCriacao(agora);
            p.setId(UUID.randomUUID());
            p.setDesativado(false);
        }

        if (p.isDesativado() || (mapa.containsKey(p.getId()) && mapa.get(p.getId()).isDesativado())) {
            throw new EntidadeInativaException();
        }

        p.setDataHoraAlteracao(agora);
        mapa.put(p.getId(), p);
        return p;
    }

    @Override
    public boolean delete(Professor p) {
        if (mapa.containsKey(p.getId()) && !p.isDesativado()) {
            p.setDesativado(true);
            p.setDataHoraAlteracao(LocalDateTime.now());
            mapa.put(p.getId(), p);
            return true;
        }
        return false;
    }

    public boolean deleteById(UUID id) {
        Professor professor = findById(id);
        if (professor != null) {
            professor.setDesativado(true);
            professor.setDataHoraAlteracao(LocalDateTime.now());
            mapa.put(id, professor);
            return true;
        }
        return false;
    }

    @Override
    public List<Professor> findAll() {
        return mapa.values().stream()
                .filter(professor -> !professor.isDesativado())
                .collect(Collectors.toList());
    }

    @Override
    public Professor findById(UUID id) throws EntidadeInativaException {
        Professor professor = mapa.get(id);
        if (professor == null || professor.isDesativado()) {
            throw new EntidadeInativaException();
        }
        return professor;
    }
}
