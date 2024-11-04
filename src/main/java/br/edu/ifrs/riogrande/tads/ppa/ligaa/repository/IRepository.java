package br.edu.ifrs.riogrande.tads.ppa.ligaa.repository;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.exception.EntidadeInativaException;

import java.util.List;
import java.util.UUID;

public interface IRepository<ENTIDADE> {
    ENTIDADE save(ENTIDADE e);

    /**
     * Exclui uma determinada Entidade;
     * 
     * @param e a Entidade a ser excluída.
     * @return true se foi excluída e false caso não.
     */
    boolean delete(ENTIDADE e);

    List<ENTIDADE> findAll();

    /**
     * Encontra uma entidade pelo seu ID.
     * 
     * @param id o ID da entidade.
     * @return a entidade encontrada.
     * @throws EntidadeInativaException se a entidade não for encontrada ou estiver desativada.
     */
    ENTIDADE findById(UUID id) throws EntidadeInativaException;
}
