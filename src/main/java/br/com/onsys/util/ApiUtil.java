package br.com.onsys.util;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.client.auth.ApiKeyAuth;
import br.com.onsys.constantes.Constantes;

public class ApiUtil {

		public static ApiClient callApi() throws ApiException {
			try {
				
				
				ApiClient apiClient = new ApiClient();
				apiClient.setBasePath("http://sandbox.cnova.com/api/v2");
	
				// Alterar a chave informada com o valor de client_id dispon�vel para sua APP
				((ApiKeyAuth)apiClient.getAuthentication("client_id")).setApiKey(Constantes.CLIENT_ID);
	
				// Alterar a chave informada com o valor de access_token dispon�vel para sua APP
				((ApiKeyAuth)apiClient.getAuthentication("access_token")).setApiKey(Constantes.CLIENT_SECRET);
				
				return apiClient;
			} catch (Exception e) {
				throw e;
			}
		}
}
