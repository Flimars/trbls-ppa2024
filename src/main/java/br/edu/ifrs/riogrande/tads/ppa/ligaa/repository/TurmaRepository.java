
package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Turma;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeInativaException;

@Repository 
public class TurmaRepository implements IRepository <Turma>{
    
    private Map<UUID, Turma> mapa = new HashMap<>();

    @Override
    public Turma save(Turma t){
        LocalDateTime agora = LocalDateTime.now();

        if(t.getId() == null) {
            t.setDataHoraCriacao(agora);
            t.setId(UUID.randomUUID());
            t.setDesativado(false);
        }

        if (t.isDesativado() || (mapa.containsKey(t.getId()) && mapa.get(t.getId()).isDesativado())) {
            throw new EntidadeInativaException();
        }
        

        t.setDataHoraAlteracao(agora);
        mapa.put(t.getId(), t);

        return t;
    }

    @Override
    public boolean delete(Turma t) {
        Turma turma = mapa.get(t.getId());
        if (turma != null && !turma.isDesativado()) {
            turma.setDesativado(true);
            turma.setDataHoraAlteracao(LocalDateTime.now());
            mapa.put(turma.getId(), turma);
            return true;
        }
        return false;
    }

    @Override
    public List<Turma> findAll() {
        List<Turma> turmasAtivas = new ArrayList<>();
        for (Turma turma : mapa.values()) {
            if (!turma.isDesativado()) {
                turmasAtivas.add(turma);
            }
        }
        return turmasAtivas;
    }

    @Override
    public Turma findById(UUID id) {
        Turma turma = mapa.get(id);
        if (turma != null && !turma.isDesativado()) {
            return turma;
        }
        return null;
    }
    
}
