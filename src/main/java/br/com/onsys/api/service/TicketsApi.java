package br.com.onsys.api.service;


import java.util.*;


import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.client.Configuration;
import br.com.onsys.model.GetTicketMessagesResponse;
import br.com.onsys.model.NewTicket;
import br.com.onsys.model.NewTicketMessage;
import br.com.onsys.model.TicketAssignee;
import br.com.onsys.model.TicketStatus;
import br.com.onsys.model.Tickets;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class TicketsApi {
  private ApiClient apiClient;

  public TicketsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public TicketsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Operação utilizada para consultar os protocolos
   * &lt;p&gt;Esse serviço permite que as plataformas consigam integrar suas ferramentas de atendimento com o processo de atendimento/pós vendas do Marketplace. Um Ticket representa um atendimento feito ao consumidor final. São diversas possibilidades de atendimento ao consumidor, o consumidor pode iniciar o atendimento através dá página de contato do site do &lt;a href=http://atendimento.extra.com.br/viewclient/faces/pages/contact.xhtml&gt;&lt;strong&gt;Extra&lt;/strong&gt;&lt;/a&gt; .&lt;/p&gt;
   * @param status Utilizado para filtrar os tickets com um status específico. Aberto (opened), Em Monitoramento (attendance), Fechado (closed).
   * @param code Código do protocolo.
   * @param customerName Nome do comprador (ou parte dele).
   * @param createdAt Utilizado para filtrar tickets pela data de criação. É possível passar uma variação de datas separadas por &#39;,&#39;. Ex: 2014-12-15T11:00:00.000-02:00,*.
   * @param closedAt Utilizado para filtrar tickets pela data de fechamento. É possível passar uma variação de datas separada &#39;,&#39;. Ex: 2014-12-15T11:00:00.000-02:00,2014-12-15T23:00:00.00-02:00. É possível também utilizar o caractere &#39;*&#39; para não limitar alguma posição. Ex: 2014-12-14T00:00.000-02:00,*.
   * @param offset Parâmetro utilizado para indicar a posição inicial de consulta. 
   * @param limit Parâmetro utilizado para limitar a quantidade de registros trazidos pela consulta. 
   * @return Tickets
   */
  public Tickets getTickets (String status, String code, String customerName, String createdAt, String closedAt, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getTickets");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getTickets");
    }
    

    // create path and map variables
    String path = "/tickets".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (status != null)
      queryParams.put("status", apiClient.parameterToString(status));
    if (code != null)
      queryParams.put("code", apiClient.parameterToString(code));
    if (customerName != null)
      queryParams.put("customerName", apiClient.parameterToString(customerName));
    if (createdAt != null)
      queryParams.put("createdAt", apiClient.parameterToString(createdAt));
    if (closedAt != null)
      queryParams.put("closedAt", apiClient.parameterToString(closedAt));
    if (offset != null)
      queryParams.put("_offset", apiClient.parameterToString(offset));
    if (limit != null)
      queryParams.put("_limit", apiClient.parameterToString(limit));
    

    

    final String[] accepts = {
      
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
        return (Tickets) apiClient.deserialize(response, "", Tickets.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Cria um novo protocolo
   * &lt;p&gt;Esse serviço irá efetuar a criação de um novo Ticket. Serve para atender as necessidades do lojista entrar em contato com o consumidor final caso necessário.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Todo contato com o comprador, com exceção dos os emails transacionais que já são enviados pelo Marketplace, deve ser realizado através desta API.&lt;/p&gt;
   * @param newTicket Objeto Novo Ticket..
   * @return String
   */
  public String postTicket (NewTicket newTicket) throws ApiException {
    Object postBody = newTicket;
    
    // verify the required parameter 'newTicket' is set
    if (newTicket == null) {
       throw new ApiException(400, "Missing the required parameter 'newTicket' when calling postTicket");
    }
    

    // create path and map variables
    String path = "/tickets".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      
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
      String response = apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
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
   * Operação utilizada para atualizar o responsável pelo atendimento do protocolo
   * &lt;p&gt;Esse serviço permitirá atualizar o responsável pelo atendimento de um Ticket, onde as possibilidades são: Marketplace ou Lojista.&lt;/p&gt;
   * @param code Código do protocolo.
   * @param body Mensagem a ser enviada como descrição da operação.
   * @return String
   */
  public String putTicketAssignee (String code, TicketAssignee body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'code' is set
    if (code == null) {
       throw new ApiException(400, "Missing the required parameter 'code' when calling putTicketAssignee");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling putTicketAssignee");
    }
    

    // create path and map variables
    String path = "/tickets/{code}/assignee".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "code" + "\\}", apiClient.escapeString(code.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json; charset=utf-8"
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
   * Operação utilizada para consultar um protocolo
   * &lt;p&gt;Esse serviço apresenta todo o histórico de mensagens trocadas no Ticket para efetuar o atendimento. Para efetuar uma requisição é necessário passar o code do Ticket desejado no path do serviço.&lt;/p&gt; &lt;p class=&#39;obs&#39;&gt;Só serão exibidos os protocolos que sejam de propriedade do lojista/parceiro que está efetuando a consulta.&lt;/p&gt;
   * @param code Identificador do  protocolo.
   * @param offset Parâmetro utilizado para indicar a posição do registro inicial que será trazido. A primeira posição é sempre zero (0).
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetTicketMessagesResponse
   */
  public GetTicketMessagesResponse getTicketMessagesByCode (String code, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'code' is set
    if (code == null) {
       throw new ApiException(400, "Missing the required parameter 'code' when calling getTicketMessagesByCode");
    }
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getTicketMessagesByCode");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getTicketMessagesByCode");
    }
    

    // create path and map variables
    String path = "/tickets/{code}/messages".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "code" + "\\}", apiClient.escapeString(code.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (offset != null)
      queryParams.put("_offset", apiClient.parameterToString(offset));
    if (limit != null)
      queryParams.put("_limit", apiClient.parameterToString(limit));
    

    

    final String[] accepts = {
      
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
        return (GetTicketMessagesResponse) apiClient.deserialize(response, "", GetTicketMessagesResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação utilizada para criar uma mensagem no protocolo
   * &lt;p&gt;Esse serviço irá criar uma mensagem atrelada ao Ticket em questão. Essa mensagem pode ou não ficar visível para o consumidor final. As mensagens enviadas ficam disponíveis no serviço de Consulta de Mensagens de Ticket.&lt;/p&gt;
   * @param code Identificador do  protocolo.
   * @param ticket Objeto Ticket.
   * @return String
   */
  public String postTicketMessage (String code, NewTicketMessage ticket) throws ApiException {
    Object postBody = ticket;
    
    // verify the required parameter 'code' is set
    if (code == null) {
       throw new ApiException(400, "Missing the required parameter 'code' when calling postTicketMessage");
    }
    
    // verify the required parameter 'ticket' is set
    if (ticket == null) {
       throw new ApiException(400, "Missing the required parameter 'ticket' when calling postTicketMessage");
    }
    

    // create path and map variables
    String path = "/tickets/{code}/messages".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "code" + "\\}", apiClient.escapeString(code.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      
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
      String response = apiClient.invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
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
   * Operação utilizada para atualizar o status dos tickets
   * &lt;p&gt;Esse serviço permitirá que o lojista/plataforma altere o status de um Ticket. Os status permitidos serão: Fechado &lt;strong&gt; (closed) &lt;/strong&gt; e Em Acompanhamento &lt;strong&gt; (attendance).&lt;/strong&gt;&lt;/p&gt;
   * @param code Código do protocólo.
   * @param body Parâmetros para ativação/desativação massiva de produtos
   * @return String
   */
  public String putTicketStatus (String code, TicketStatus body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'code' is set
    if (code == null) {
       throw new ApiException(400, "Missing the required parameter 'code' when calling putTicketStatus");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling putTicketStatus");
    }
    

    // create path and map variables
    String path = "/tickets/{code}/status".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "code" + "\\}", apiClient.escapeString(code.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/json; charset=utf-8"
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
