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
import rw.jobportal.domain.Category;

/**
 *
 * @author diddy
 */
@ManagedBean(name ="catM")
@RequestScoped
public class CategoryModel {
    
   GeneralDao<Category> dao= new GeneralDao<>(Category.class);
   Category cat=new Category();
  private List<Category> categories;

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
   
   
   public String save(){
        try {
            String info = dao.create(cat);
            FacesMessage msg = new FacesMessage(info);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "catList";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "addCategory";
        }
    }
    
    public List<Category> getAll(){
      categories = dao.findAll();
      return categories;
    }
    
    public String Update(Category cat){
        try {
            String info = dao.update(cat);
            FacesMessage msg = new FacesMessage(info);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "catList";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "updateCategory";
        }
    }
    
    public String Delete(Category cat){
        try {
            String info = dao.delete(cat.getId());
            FacesMessage msg = new FacesMessage(info);
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "catList";
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return "addCategory";
        }
    }
}
