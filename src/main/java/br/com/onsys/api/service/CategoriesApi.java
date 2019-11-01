package br.com.onsys.api.service;





import java.util.*;


import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.client.Configuration;
import br.com.onsys.model.Category;
import br.com.onsys.model.GetCategoriesResponse;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class CategoriesApi {
  private ApiClient apiClient;

  public CategoriesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public CategoriesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Recupera uma lista de categorias
   * &lt;p&gt;Recupera uma lista de categorias existentes no Marketplace.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Por padrão, o acesso a este serviço está bloqueado e só será liberado para quem irá realizar desduplicação de produtos.&lt;br/&gt;Para mais informações, entre com seu login e senha e abra um Chamado para nossa equipe de suporte.&lt;/p&gt;
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetCategoriesResponse
   */
  public GetCategoriesResponse getCategories (Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getCategories");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getCategories");
    }
    

    // create path and map variables
    String path = "/categories".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (offset != null)
      queryParams.put("_offset", apiClient.parameterToString(offset));
    if (limit != null)
      queryParams.put("_limit", apiClient.parameterToString(limit));
    

    

    final String[] accepts = {
      "application/json; charset=utf-8"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String[] authNames = new String[] { "client_id", "access_token" };
      String response = apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){
        return (GetCategoriesResponse) apiClient.deserialize(response, "", GetCategoriesResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Recupera detalhes de uma categoria informada
   * &lt;p&gt;Recupera detalhes da categoria informada.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Por padrão, o acesso a este serviço está bloqueado e só será liberado para quem irá realizar desduplicação de produtos.&lt;br/&gt;Para mais informações, entre com seu login e senha e abra um Chamado para nossa equipe de suporte.&lt;/p&gt;
   * @param levelId Id da categoria.
   * @return Category
   */
  public Category getCategoryById (String levelId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'levelId' is set
    if (levelId == null) {
       throw new ApiException(400, "Missing the required parameter 'levelId' when calling getCategoryById");
    }
    

    // create path and map variables
    String path = "/categories/{levelId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "levelId" + "\\}", apiClient.escapeString(levelId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      "application/json; charset=utf-8"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String[] authNames = new String[] { "client_id", "access_token" };
      String response = apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){
        return (Category) apiClient.deserialize(response, "", Category.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
}
