package br.com.onsys.api.service;




import java.util.*;

import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.client.Configuration;
import br.com.onsys.model.GetSellerItemsResponse;
import br.com.onsys.model.Prices;
import br.com.onsys.model.SellerItem;
import br.com.onsys.model.SellerItemStatus;
import br.com.onsys.model.Stock;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class SellerItemsApi {
  private ApiClient apiClient;

  public SellerItemsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public SellerItemsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Recupera todos os produtos que estão associados ao Lojista
   * Recupera todos os produtos que estão associados ao Lojista, mesmo os que não estão disponíveis para venda.
   * @param site Site do qual deseja consultar o produto. Se o parâmetro não for informado, serão trazidos apenas produtos do Extra. Consulte a lista completa de sites disponíveis no serviço &lt;a href=&#39;#!/sites&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sites&lt;/strong&gt;&lt;/a&gt;
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetSellerItemsResponse
   */
  public GetSellerItemsResponse getSellerItems (String site, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getSellerItems");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getSellerItems");
    }
    

    // create path and map variables
    String path = "/sellerItems".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (site != null)
      queryParams.put("site", apiClient.parameterToString(site));
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
        return (GetSellerItemsResponse) apiClient.deserialize(response, "", GetSellerItemsResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Recupera produtos do Lojista que estão disponíveis para venda
   * Recupera apenas os produtos do Lojista que estão disponíveis para venda, ou seja, que possuem estoque e preço atualizados e imagem(ns) válida(s).
   * @param site Site do qual deseja consultar os produtos. Se o parâmetro não for informado, serão trazidos apenas produtos do Extra. Os possíveis sites são: &#39;EX&#39;, &#39;PF&#39;, &#39;CB&#39;, &#39;EH&#39;, &#39;BT&#39;, &#39;CD&#39;. Consulte a lista completa de sites disponíveis no serviço &lt;a href=&#39;#!/sites&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sites&lt;/strong&gt;&lt;/a&gt;
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta
   * @return GetSellerItemsResponse
   */
  public GetSellerItemsResponse getSellerItemsByStatusActive (String site, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getSellerItemsByStatusActive");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getSellerItemsByStatusActive");
    }
    

    // create path and map variables
    String path = "/sellerItems/status/selling".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (site != null)
      queryParams.put("site", apiClient.parameterToString(site));
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
        return (GetSellerItemsResponse) apiClient.deserialize(response, "", GetSellerItemsResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Recupera detalhes do item do Lojista através do skuSellerId (sku do produto do Lojista) informado
   * Recupera detalhes do item do Lojista através do skuSellerId (sku do produto do Lojista) informado.
   * @param skuSellerId SKU ID do Lojista.
   * @param site Site do qual deseja consultar o produto. Se o parâmetro não for informado, serão trazidos apenas produtos do Extra. Consulte a lista completa de sites disponíveis no serviço &lt;a href=&#39;#!/sites&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sites&lt;/strong&gt;&lt;/a&gt;
   * @return SellerItem
   */
  public SellerItem getSellerItemBySkuSellerId (String skuSellerId, String site) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'skuSellerId' is set
    if (skuSellerId == null) {
       throw new ApiException(400, "Missing the required parameter 'skuSellerId' when calling getSellerItemBySkuSellerId");
    }
    

    // create path and map variables
    String path = "/sellerItems/{skuSellerId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "skuSellerId" + "\\}", apiClient.escapeString(skuSellerId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (site != null)
      queryParams.put("site", apiClient.parameterToString(site));
    

    

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
        return (SellerItem) apiClient.deserialize(response, "", SellerItem.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Atualização de preço do item do Lojista
   * &lt;p&gt;Atualiza o preço &#39;de&#39; e o preço &#39;por&#39; (preço real para venda) do item do Lojista informado.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;&lt;strong&gt;Atenção:&lt;/strong&gt; &lt;br/&gt;Para proteção do lojista, existe uma regra de validação de preços que impede alterações muito grandes em uma única operação. Não é permitido a alteração com valores 50% menores que o valor atual. &lt;br/&gt;Para este tipo de crítica será retornado um Status HTTP &lt;a href=&#39;../apis/index.html#error_codes&#39;&gt;&lt;strong&gt;422&lt;/strong&gt;&lt;/a&gt;, seguido da mensagem: &lt;strong&gt;Alteração não permitida, variação de preço muito grande.&lt;/strong&gt;&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para métodos PUT e DELETE, sendo retornado apenas o Status HTTP 204 - No Content.&lt;/strong&gt;&lt;/p&gt;
   * @param skuSellerId SKU ID do Lojista.
   * @param body Parâmetros para atualização de preço do SKU
   * @return String
   */
  public String putSellerItemPrices (String skuSellerId, Prices body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'skuSellerId' is set
    if (skuSellerId == null) {
       throw new ApiException(400, "Missing the required parameter 'skuSellerId' when calling putSellerItemPrices");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling putSellerItemPrices");
    }
    

    // create path and map variables
    String path = "/sellerItems/{skuSellerId}/prices".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "skuSellerId" + "\\}", apiClient.escapeString(skuSellerId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
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
      String response = apiClient.invokeAPI(path, "PUT", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){
        return (String) apiClient.deserialize(response, "", String.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Ativação/Desativação de produto no Marketplace
   * Atualiza o status do produto no Marketplace. Se setado para false, o produto é desativado e deixa de ser vendido no Marketplace.&lt;p =&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para métodos PUT e DELETE, sendo retornado apenas o Status HTTP 204 - No Content.&lt;/strong&gt;&lt;/p&gt;
   * @param skuSellerId SKU ID do Lojista.
   * @param body Parâmetros para ativação/desativação do SKU.
   * @return String
   */
  public String putSellerItemStatus (String skuSellerId, SellerItemStatus body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'skuSellerId' is set
    if (skuSellerId == null) {
       throw new ApiException(400, "Missing the required parameter 'skuSellerId' when calling putSellerItemStatus");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling putSellerItemStatus");
    }
    

    // create path and map variables
    String path = "/sellerItems/{skuSellerId}/status".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "skuSellerId" + "\\}", apiClient.escapeString(skuSellerId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      "application/json; charset=utf-8"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
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
      String response = apiClient.invokeAPI(path, "PUT", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){
        return (String) apiClient.deserialize(response, "", String.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Atualização de estoque do item do Lojista
   * &lt;p&gt;Atualiza a quantidade disponível para venda do Item do Lojista informado.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;Se atualizado para zero, o item não estará mais disponível para venda.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para métodos PUT e DELETE, sendo retornado apenas o Status HTTP 204 - No Content.&lt;/strong&gt;&lt;/p&gt;
   * @param skuSellerId SKU ID do Lojista.
   * @param body Parâmetros para atualização de estoque do SKU
   * @return String
   */
  public String putSellerItemStock (String skuSellerId, Stock body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'skuSellerId' is set
    if (skuSellerId == null) {
       throw new ApiException(400, "Missing the required parameter 'skuSellerId' when calling putSellerItemStock");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling putSellerItemStock");
    }
    

    // create path and map variables
    String path = "/sellerItems/{skuSellerId}/stock".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "skuSellerId" + "\\}", apiClient.escapeString(skuSellerId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      "application/json"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json"
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
      String response = apiClient.invokeAPI(path, "PUT", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){
        return (String) apiClient.deserialize(response, "", String.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
}
