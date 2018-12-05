package be.thomasmore.travelmore.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="ViewController")
@SessionScoped
public class ViewController {

    public ViewController(){}

    private String activeTab;

    public String getActiveTab() {
        return activeTab;
    }
    public void setActiveTab(String activeTab) {
        this.activeTab = activeTab;
    }

    git ad
}
