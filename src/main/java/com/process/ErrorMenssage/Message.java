package com.process.ErrorMenssage;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author crixx
 */
public class Message {

    public static void addErrorMessage(String id, String message) {
        FacesContext.getCurrentInstance().addMessage(id,
                new FacesMessage(message));

    }
}
