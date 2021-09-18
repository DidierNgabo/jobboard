/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.jobportal.model;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import rw.jobportal.dao.GeneralDao;
import rw.jobportal.domain.Job;

/**
 *
 * @author diddy
 */
@ManagedBean(name ="jobM")
@RequestScoped
public class JobModel {
    GeneralDao<Job> dao=new GeneralDao<>(Job.class);
    Job jb=new Job();
    private List<Job> jobs;

    public Job getCl() {
        return jb;
    }

    public void setCl(Job cl) {
        this.jb = cl;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    
    
    
    public String save(){
        try {
            
            String info = dao.create(jb);
            FacesMessage msg = new FacesMessage(info);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "jobList";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "addJob";
        }
    }
    
    public List<Job> getAll(){
      jobs = dao.findAll();
      return jobs;
    }
    
    public String Update(){
        try {
            String info = dao.update(jb);
            FacesMessage msg = new FacesMessage(info);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "jobList";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "updateJob";
        }
    }
    
    public String Delete(Job job){
        try {
            String info = dao.delete(job.getId());
            FacesMessage msg = new FacesMessage(info);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "jobList";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "addJob";
        }
    }
}
