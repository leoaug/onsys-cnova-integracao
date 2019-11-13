package br.com.onsys.util;
 
import java.io.IOException;

import javax.faces.context.FacesContext;
import br.com.onsys.constantes.Constantes;


public class RedirectUtil {


	
	public void redirectCnovaAuth() throws Exception {
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(Constantes.URL_AUTHORIZE);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
		
	}
}
