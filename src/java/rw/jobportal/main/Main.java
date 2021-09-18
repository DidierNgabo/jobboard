/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.jobportal.main;

import rw.jobportal.dao.GeneralDao;
import rw.jobportal.domain.Job;
import rw.jobportal.domain.User;
import rw.jobportal.util.DbUtil;

/**
 *
 * @author diddy
 */
public class Main {
    public static void main(String[] args) {
        GeneralDao<User> dao =new GeneralDao<>(User.class);
        
        
     boolean valid=   dao.validate("diddy@gmail.com", "clement");
     
     if(valid){
         System.out.println("user found");
     }else{
         System.out.println("user not found");
     }
    }
}
