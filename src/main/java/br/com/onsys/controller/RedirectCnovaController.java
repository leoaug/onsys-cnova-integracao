package br.com.onsys.controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.SessionScope;

import br.com.onsys.constantes.Constantes;
import br.com.onsys.util.RedirectUtil; 

@Named
@Scope("view")
public class RedirectCnovaController  implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String tituloRedirect;
	
	@PostConstruct
	public void init() {
		

		setTituloRedirect("... Autorizando App para o Cnova ...");
		
		try {
		
			new RedirectUtil().redirectCnovaAuth();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getTituloRedirect() {
		return tituloRedirect;
	}

	public void setTituloRedirect(String tituloRedirect) {
		this.tituloRedirect = tituloRedirect;
	}
	
	
	
	
}
