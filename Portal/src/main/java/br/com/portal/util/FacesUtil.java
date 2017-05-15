package br.com.portal.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {

	public static void msgSucesso(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, facesMessage);
	}

	public static void msgErro(String msg) {
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);

		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, facesMessage);
	}

}
