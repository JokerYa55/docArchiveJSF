/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author vasil
 */
@Named
@ApplicationScoped
public class users {

    private Long id = new Long("10");
    private String name = "test";

    public users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "users{" + "id=" + id + ", name=" + name + '}';
    }

}
