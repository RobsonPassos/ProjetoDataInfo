package br.com.robson.bean;

import br.com.robson.entity.SalvadadosxmlEntity;
import jakarta.annotation.Resource;
import jakarta.ejb.Local;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

import java.util.List;

@Stateless
@Local
public class MeuEJB {

    @Resource
    @PersistenceContext(unitName = "ProjetoDataInfo")
    private EntityManager entityManager;

    @TransactionAttribute
    public void salvarTagsXML(List<String> tagContents) {
        System.out.println("Chegou aqui salvarTagsXML: " + tagContents);
        for (String content : tagContents) {
            if (content == null)
                continue;
            SalvadadosxmlEntity entity = new SalvadadosxmlEntity();
            entity.setTagsxml(content);
            entityManager.persist(entity);
        }
    }

    public List<SalvadadosxmlEntity> listarDados() {
        Query query = entityManager.createQuery("SELECT s FROM SalvadadosxmlEntity s", SalvadadosxmlEntity.class);
        return query.getResultList();
    }
}