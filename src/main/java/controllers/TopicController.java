/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.docDAO;
import beans.Topic;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.jboss.logging.Logger;

/**
 *
 * @author vasil
 */
@Named(value = "topicController")
@RequestScoped
public class TopicController {

    Logger log = Logger.getLogger(getClass().getName());
    private List<Topic> topicList;

    @Inject
    docDAO doc_dao;

    /**
     * Creates a new instance of TopicController
     */
    public TopicController() {
        log.info("Constructor");
    }

    @PostConstruct
    private void postConstruct() {
        log.info("postConstruct");
        log.info("doc_dao = " + doc_dao);
        topicList = doc_dao.getTopicList();
    }

    public String test() {

        //doc_dao.getTopicList();
        return "test";
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public void buttonAction(Long p_topic_id) {
        log.info("buttonAction = " + p_topic_id);
        addMessage("topic id = " + p_topic_id);
    }

    public void addMessage(String message) {
        log.info("addMessage = " + message);
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Successful", "Your message: " + message));
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));

    }

}
