package com.bozidar.labas.dagger2github.model;

/**
 * Created by Bozidar on 07.11.2015..
 */
public class Repository {
    public String name;
    public int openIssues;
    public int watchers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOpenIssues() {
        return openIssues;
    }

    public void setOpenIssues(int openIssues) {
        this.openIssues = openIssues;
    }

    public int getWatchers() {
        return watchers;
    }

    public void setWatchers(int watchers) {
        this.watchers = watchers;
    }
}
