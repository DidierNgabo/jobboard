/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.jobportal.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author diddy
 */
@Entity
@Table(name="jobs")
public class Job implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer id;
  private String title;
  private String description;
  private String category;
  private int positions;


    public Job() {
    }

    public Job( String title, String description, String category, int positions) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.positions = positions;
    }
  
  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPositions() {
        return positions;
    }

    public void setPositions(int positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", title=" + title + ", description=" + description + ", category=" + category + ", positions=" + positions + '}';
    }
  
  
}
