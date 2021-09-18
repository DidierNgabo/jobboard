/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.jobportal.model;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import rw.jobportal.dao.GeneralDao;
import rw.jobportal.domain.User;

/**
 *
 * @author diddy
 */
@ManagedBean(name = "usM")
@SessionScoped
public class UserModel {
    GeneralDao<User> dao=new GeneralDao<>(User.class);
    User adm=new User();
    List<User> list;
    private String confirmPassword;

    public User getAdm() {
        return adm;
    }

    public void setAdm(User adm) {
        this.adm = adm;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }
    
    
    
     public String register(){
        try {
            if(!confirmPassword.equals(adm.getPassword())){
             FacesMessage msg = new FacesMessage("confirm password must be the same as password");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "register";
            }
            String info = dao.create(adm);
            FacesMessage msg = new FacesMessage(info);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "index.html";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getCause().toString());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "register";
        }
    }
    
    public List<User> getAll(){
      list= dao.findAll();
      return list;
    }
    
    public String Update(User ad){
        try {
            String info = dao.update(ad);
            FacesMessage msg = new FacesMessage(info);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "jobList";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "updateAdmin";
        }
    }
    
    public String Delete(User ad){
        try {
            String info = String.valueOf(dao.delete(ad.getId()));
            FacesMessage msg = new FacesMessage(info);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "jobList";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "addAdmin";
        }
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
}
