package com.tirali.eventart.view;

import java.util.ArrayList;  
import java.util.List;  
import javax.faces.application.FacesMessage;  
  
import javax.faces.component.UIComponent;  
import javax.faces.context.FacesContext;  
import javax.faces.convert.Converter;  
import javax.faces.convert.ConverterException;  
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.tirali.eventart.model.Event;
import com.tirali.eventart.model.User;
  


@FacesConverter("user")
public class UserConverter implements Converter {
  
	
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;
	
	
  
    public Object getAsObject(FacesContext facesContext, UIComponent component, String submittedValue) {  
        if (submittedValue.trim().equals("")) {  
            return null;  
        } else {  
            try {  
                long id = Long.parseLong(submittedValue);  
                EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "forge-default" );	
                EntityManager entityManager = entityManagerFactory.createEntityManager();
                //get from JPA
                //return findById(number);
                return  entityManager.find(User.class, id);
                
            } catch(NumberFormatException exception) {  
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid player"));  
            }  
        } 
    }  
    
    
    public String getAsString(FacesContext facesContext, UIComponent component, Object value) {  
        if (value == null || value.equals("")) {  
            return "";  
        } else {  
            return String.valueOf(((User) value).getId());  
        }  
    } 
    
    private User findById(Long id)
    {

       return this.entityManager.find(User.class, id);
    }
}
