package br.com.onsys.util;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.client.auth.ApiKeyAuth;
import br.com.onsys.api.client.auth.Authentication;
import br.com.onsys.api.service.LoadsApi;
import br.com.onsys.constantes.Constantes;

public class ApiUtil {

		public static ApiClient callApi() throws ApiException {
			try {
				
				
				
				
				String sandbox =  "https://sandbox-mktplace.viavarejo.com.br/api/v2";
				
				//String orders = "https://desenvolvedores.cnova.com/api-portal/proxy/api/v2";
				//String products =  "https://desenvolvedores.extra.com.br/api-portal/proxy";
				
				ApiClient apiClient = new ApiClient();
				apiClient.setBasePath(sandbox);
				
				//LoadsApi loadsApi = new LoadsApi();
				//String resultado = loadsApi.geCode(Constantes.URL_AUTHORIZE);
				
				//System.out.println(resultado);
				
	
				// Alterar a chave informada com o valor de client_id disponível para sua APP
				((ApiKeyAuth)apiClient.getAuthentication("client_id")).setApiKey(Constantes.CLIENT_ID_2);
	
				// Alterar a chave informada com o valor de access_token disponível para sua APP
				((ApiKeyAuth)apiClient.getAuthentication("access_token")).setApiKey(Constantes.TOKEN_2);
				
				return apiClient;
			} catch (Exception e) {
				throw e;
			}
		}
}
