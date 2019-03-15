/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.Topic;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.jboss.logging.Logger;

/**
 *
 * @author vasil
 */
@Named
@RequestScoped
public class docDAO implements Serializable {

    Logger log = Logger.getLogger(getClass().getName());
    @PersistenceContext
    protected EntityManager em;

    public docDAO() {
        log.info(String.format("%s", "docDAO"));
    }

    public List<Topic> getTopicList() {
        log.info(String.format("em = %s", em));
        TypedQuery<Topic> query = em.createQuery("SELECT c FROM Topic c ORDER BY c.name", Topic.class);
        List<Topic> results = query.getResultList();
        return results;
    }
}
