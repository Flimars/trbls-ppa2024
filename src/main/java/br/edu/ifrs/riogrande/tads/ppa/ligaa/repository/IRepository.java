package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;

import java.util.List;
import java.util.UUID;

public interface IRepository<ENTIDADE> { // generics
    
    public ENTIDADE save(ENTIDADE e);

    /**
     * Exclui uma determinada Entidade;
     * 
     * @param e a Entidade a ser excluída.
     * @return true se foi excluída e false caso não.
     */
    public boolean delete(ENTIDADE e);
    
    //Optional<T> findById(UUID id);

    public List<ENTIDADE> findAll();
    
    ENTIDADE findById(UUID id);
}


