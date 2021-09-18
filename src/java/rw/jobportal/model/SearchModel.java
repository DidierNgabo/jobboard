/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.jobportal.model;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import rw.jobportal.dao.GeneralDao;
import rw.jobportal.domain.Job;

/**
 *
 * @author diddy
 */
@ManagedBean
@RequestScoped
public class SearchModel {
    private String jobTitle;
    private String jobCategory;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }
    
    GeneralDao<Job> dao = new GeneralDao<>(Job.class);
    
    public List<Job> getByCategory(){
       return dao.findByCategory(jobCategory);
    }
    
    public List<Job> getByName(){
      return dao.findByName(jobTitle);
    }
}
