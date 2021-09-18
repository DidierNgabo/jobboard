/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rw.jobportal.model;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author diddy
 */
@FacesConverter("rw.jobportal.test.selectConverter")
public class CatConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String submittedValue) {
      if (submittedValue == null || submittedValue.isEmpty()) {
        return null;
    }

    try {
        return submittedValue;
    } catch (NumberFormatException e) {
        throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Category ID"), e);
    }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
       return o.toString();
    }
    
}
