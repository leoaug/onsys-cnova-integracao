package br.com.onsys.api.service;

import java.util.*;



import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.client.Configuration;
import br.com.onsys.model.GetOrdersResponse;
import br.com.onsys.model.GetOrdersStatusNewResponse;
import br.com.onsys.model.NewTracking;
import br.com.onsys.model.Order;
import br.com.onsys.model.OrderItem;
import br.com.onsys.model.OrderSandbox;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class OrdersApi {
  private ApiClient apiClient;

  public OrdersApi() {
    this(Configuration.getDefaultApiClient());
  }

  public OrdersApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Recupera detalhes de todos os pedidos
   * &lt;p&gt;Operação utilizada para retornar informações de todos os pedidos, independente do status em que se encontram os mesmos.&lt;/p&gt;&lt;p&gt;Observação:&lt;br/&gt;Os campos retornados dependem do status do pedido, por exemplo, no status new, as informações de entrega são suprimidas para evitar a entrega antes da confirmação do pagamento. Nesta documentação estão presentes todos os campos de Pedido. Para saber quais campos são retornados para cada status do pedido, basta consultar a documentação de cada um dos métodos de consulta de pedidos por status.&lt;/p&gt;
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetOrdersResponse
   */
  public GetOrdersResponse getOrders (Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getOrders");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getOrders");
    }
    

    // create path and map variables
    String path = "/orders".replaceAll("\\{format\\}","json");

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
        return (GetOrdersResponse) apiClient.deserialize(response, "", GetOrdersResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação para criar um pedido
   * &lt;p&gt;Operação que cria um pedido.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39; &gt;Esta operação só está disponível em ambiente de Sandbox para que seja possível executar todo o fluxo de testes da aplicação.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;É necessário aguardar cerca de 30 minutos para que o pedido seja indexado. Após esse período será possível consultar os pedidos através do serviço &lt;a href=&#39;#!/orders/getOrdersByStatusNew_get_2&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /orders/status/new&lt;/strong&gt;&lt;/a&gt;. O Pedido só pode ser aprovado após aparecer com status &lt;strong&gt;NEW&lt;/strong&gt;.&lt;br/&gt;&lt;br/&gt;Clique &lt;a href=&#39;../tutoriais/exemplo_orders_v2.json&#39; target=&#39;_blank&#39;&gt;aqui&lt;/a&gt; para obter um exemplo de conteúdo JSON suportado por esse serviço.&lt;/p&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para método POST, sendo retornado apenas o Status HTTP 201 - Created.&lt;/strong&gt;&lt;/p&gt;
   * @param order Objeto para criação do pedido.
   * @return String
   */
  public String postOrder (OrderSandbox order) throws ApiException {
    Object postBody = order;
    
    // verify the required parameter 'order' is set
    if (order == null) {
       throw new ApiException(400, "Missing the required parameter 'order' when calling postOrder");
    }
    

    // create path and map variables
    String path = "/orders".replaceAll("\\{format\\}","json");

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
   * Recupera uma lista de pedidos Aprovados
   * &lt;p&gt;Recupera uma lista de pedidos com status Aprovado que estão relacionados com o token do lojista informado. Este serviço irá retornar um ou mais pedidos que já possua pagamento aprovado, ou seja, são pedidos que podem ter o processo de entrega iniciado de imediato.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Obs.: Os emails transacionais que reportam o status do pedido para os clientes devem ser desabibilitados. Esse tipo de email já é enviado pelo Marketplace.&lt;/p&gt;
   * @param approvedAt Data de aprovação. Esse campo aceita um range de datas separados por vírgula, e os formatos aceitos para o campo são os seguintes:&lt;br/&gt;&lt;strong&gt;approvedAt={data inicial},{data final}&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;approvedAt={data inicial},*&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;approvedAt=*,{data final}&lt;/strong&gt;&lt;br/&gt;onde, o &lt;strong&gt;*&lt;/strong&gt; é obrigatório e indica a que todas as datas antes ou depois da outra data passada devem ser consideradas.
   * @param customerName Nome do Cliente.
   * @param customerDocumentNumber Documento do Cliente.
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetOrdersResponse
   */
  public GetOrdersResponse getOrdersByStatusApproved (String approvedAt, String customerName, String customerDocumentNumber, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getOrdersByStatusApproved");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getOrdersByStatusApproved");
    }
    

    // create path and map variables
    String path = "/orders/status/approved".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (approvedAt != null)
      queryParams.put("approvedAt", apiClient.parameterToString(approvedAt));
    if (customerName != null)
      queryParams.put("customer.name", apiClient.parameterToString(customerName));
    if (customerDocumentNumber != null)
      queryParams.put("customer.documentNumber", apiClient.parameterToString(customerDocumentNumber));
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
        return (GetOrdersResponse) apiClient.deserialize(response, "", GetOrdersResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação para realizar a aprovação de um pedido (SANDBOX)
   * &lt;p class=&#39;obs obs-danger&#39;&gt;Essa operação está disponível apenas para SANDBOX.&lt;/p&gt;&lt;p&gt;Operação para realizar a aprovação de um pedido.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para métodos PUT e DELETE, sendo retornado apenas o Status HTTP 204 - No Content.&lt;/strong&gt;&lt;/p&gt;
   * @param orderId ID do pedido.
   * @return String
   */
  public String putSellerItemsStatusApproved (String orderId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
       throw new ApiException(400, "Missing the required parameter 'orderId' when calling putSellerItemsStatusApproved");
    }
    

    // create path and map variables
    String path = "/orders/status/approved/{orderId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "orderId" + "\\}", apiClient.escapeString(orderId.toString()));

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
   * Retorna uma lista de pedidos Cancelados
   * &lt;p&gt;Retorna uma lista de pedidos Cancelados que estão relacionados com o token do lojista informado.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Obs.: Os emails transacionais que reportam o status do pedido para os clientes devem ser desabibilitados. Esse tipo de email já é enviado pelo Marketplace.&lt;/p&gt;
   * @param canceledAt Data de cancelemento. Esse campo aceita um range de datas separados por vírgula, e os formatos aceitos para o campo são os seguintes:&lt;br/&gt;&lt;strong&gt;canceledAt={data inicial},{data final}&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;canceledAt={data inicial},*&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;canceledAt=*,{data final}&lt;/strong&gt;&lt;br/&gt;onde, o &lt;strong&gt;*&lt;/strong&gt; é obrigatório e indica a que todas as datas antes ou depois da outra data passada devem ser consideradas.
   * @param customerName Nome do Cliente.
   * @param customerDocumentNumber Documento do Cliente.
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetOrdersResponse
   */
  public GetOrdersResponse getOrdersByStatusCanceled (String canceledAt, String customerName, String customerDocumentNumber, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getOrdersByStatusCanceled");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getOrdersByStatusCanceled");
    }
    

    // create path and map variables
    String path = "/orders/status/canceled".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (canceledAt != null)
      queryParams.put("canceledAt", apiClient.parameterToString(canceledAt));
    if (customerName != null)
      queryParams.put("customer.name", apiClient.parameterToString(customerName));
    if (customerDocumentNumber != null)
      queryParams.put("customer.documentNumber", apiClient.parameterToString(customerDocumentNumber));
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
        return (GetOrdersResponse) apiClient.deserialize(response, "", GetOrdersResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Recupera uma lista de pedidos Entregues
   * &lt;p&gt;Recupera uma lista de pedidos Entregues que estão relacionados com o token do lojista informado. Este estado representa os pedidos cujos itens foram todos entregues.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Obs.: Os emails transacionais que reportam o status do pedido para os clientes devem ser desabibilitados. Esse tipo de email já é enviado pelo Marketplace.&lt;/p&gt;
   * @param deliveredAt Data de entrega. Esse campo aceita um range de datas separados por vírgula, e os formatos aceitos para o campo são os seguintes:&lt;br/&gt;&lt;strong&gt;deliveredAt={data inicial},{data final}&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;deliveredAt={data inicial},*&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;deliveredAt=*,{data final}&lt;/strong&gt;&lt;br/&gt;onde, o &lt;strong&gt;*&lt;/strong&gt; é obrigatório e indica a que todas as datas antes ou depois da outra data passada devem ser consideradas.
   * @param customerName Nome do Cliente.
   * @param customerDocumentNumber Documento do Cliente.
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetOrdersResponse
   */
  public GetOrdersResponse getOrdersByStatusDelivered (String deliveredAt, String customerName, String customerDocumentNumber, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getOrdersByStatusDelivered");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getOrdersByStatusDelivered");
    }
    

    // create path and map variables
    String path = "/orders/status/delivered".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (deliveredAt != null)
      queryParams.put("deliveredAt", apiClient.parameterToString(deliveredAt));
    if (customerName != null)
      queryParams.put("customer.name", apiClient.parameterToString(customerName));
    if (customerDocumentNumber != null)
      queryParams.put("customer.documentNumber", apiClient.parameterToString(customerDocumentNumber));
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
        return (GetOrdersResponse) apiClient.deserialize(response, "", GetOrdersResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Recupera uma lista de pedidos Novos
   * &lt;p&gt;Recupera uma lista de pedidos com status Novo que estão relacionados com o token do lojista informado. Este estado representa os pedidos fechados que ainda não foram aprovados, ou seja, pedidos que ainda não devem ser entregues, pois estão aguardado o pagamento. Alguns campos não serão enviados, para evitar a entrega antes da confirmação do pagamento.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Obs.: Os emails transacionais que reportam o status do pedido para os clientes devem ser desabibilitados. Esse tipo de email já é enviado pelo Marketplace.&lt;/p&gt;
   * @param purchasedAt Data de compra. Esse campo aceita um range de datas separados por vírgula, e os formatos aceitos para o campo são os seguintes:&lt;br/&gt;&lt;strong&gt;purchasedAt={data inicial},{data final}&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;purchasedAt={data inicial},*&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;purchasedAt=*,{data final}&lt;/strong&gt;&lt;br/&gt;onde, o &lt;strong&gt;*&lt;/strong&gt; é obrigatório e indica a que todas as datas antes ou depois da outra data passada devem ser consideradas.
   * @param customerName Nome do Cliente.
   * @param customerDocumentNumber Documento do Cliente.
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetOrdersStatusNewResponse
   */
  public GetOrdersStatusNewResponse getOrdersByStatusNew (String purchasedAt, String customerName, String customerDocumentNumber, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getOrdersByStatusNew");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getOrdersByStatusNew");
    }
    

    // create path and map variables
    String path = "/orders/status/new".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (purchasedAt != null)
      queryParams.put("purchasedAt", apiClient.parameterToString(purchasedAt));
    if (customerName != null)
      queryParams.put("customer.name", apiClient.parameterToString(customerName));
    if (customerDocumentNumber != null)
      queryParams.put("customer.documentNumber", apiClient.parameterToString(customerDocumentNumber));
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
        return (GetOrdersStatusNewResponse) apiClient.deserialize(response, "", GetOrdersStatusNewResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Retorna uma lista de pedidos Parcialmente Entregues
   * &lt;p&gt;Retorna uma lista de pedidos Parcialmente Entregues que estão relacionados com o token do lojista informado.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt; Os pedidos ficam nesse estado apenas quando ocorreu quebra de entrega e alguns produtos da lista completa já foram sinalizados como Entregues pelo serviço &lt;a href=&#39;#!/orders/persistTracking_post_10&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;POST /orders/{orderId}/trackings/delivered&lt;/strong&gt;&lt;/a&gt;&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Obs.: Os emails transacionais que reportam o status do pedido para os clientes devem ser desabibilitados. Esse tipo de email já é enviado pelo Marketplace.&lt;/p&gt;
   * @param sentAt Data de envio. Esse campo aceita um range de datas separados por vírgula, e os formatos aceitos para o campo são os seguintes:&lt;br/&gt;&lt;strong&gt;sentAt={data inicial},{data final}&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;sentAt={data inicial},*&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;sentAt=*,{data final}&lt;/strong&gt;&lt;br/&gt;onde, o &lt;strong&gt;*&lt;/strong&gt; é obrigatório e indica a que todas as datas antes ou depois da outra data passada devem ser consideradas.
   * @param customerName Nome do Cliente.
   * @param customerDocumentNumber Documento do Cliente.
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetOrdersResponse
   */
  public GetOrdersResponse getOrdersByStatusPartiallyDelivered (String sentAt, String customerName, String customerDocumentNumber, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getOrdersByStatusPartiallyDelivered");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getOrdersByStatusPartiallyDelivered");
    }
    

    // create path and map variables
    String path = "/orders/status/partiallyDelivered".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (sentAt != null)
      queryParams.put("sentAt", apiClient.parameterToString(sentAt));
    if (customerName != null)
      queryParams.put("customer.name", apiClient.parameterToString(customerName));
    if (customerDocumentNumber != null)
      queryParams.put("customer.documentNumber", apiClient.parameterToString(customerDocumentNumber));
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
        return (GetOrdersResponse) apiClient.deserialize(response, "", GetOrdersResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Retorna uma lista de pedidos Parcialmente Enviados
   * &lt;p&gt;Retorna uma lista de pedidos Parcialmente Enviados que estão relacionados com o token do lojista informado. Ocorre quando um ou mais itens foram enviados, porém ainda existem itens que não foram enviados.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt; Os pedidos ficam nesse estado apenas quando ocorreu quebra de entrega e alguns produtos da lista completa já foram sinalizados como Enviados pelo serviço &lt;a href=&#39;#!/orders/persistTracking_post_9&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;POST /orders/{orderId}/trackings/sent&lt;/strong&gt;&lt;/a&gt;&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Obs.: Os emails transacionais que reportam o status do pedido para os clientes devem ser desabibilitados. Esse tipo de email já é enviado pelo Marketplace.&lt;/p&gt;
   * @param sentAt Data de envio. Esse campo aceita um range de datas separados por vírgula, e os formatos aceitos para o campo são os seguintes:&lt;br/&gt;&lt;strong&gt;sentAt={data inicial},{data final}&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;sentAt={data inicial},*&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;sentAt=*,{data final}&lt;/strong&gt;&lt;br/&gt;onde, o &lt;strong&gt;*&lt;/strong&gt; é obrigatório e indica a que todas as datas antes ou depois da outra data passada devem ser consideradas.
   * @param customerName Nome do Cliente.
   * @param customerDocumentNumber Documento do Cliente.
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetOrdersResponse
   */
  public GetOrdersResponse getOrdersByStatusPartiallySent (String sentAt, String customerName, String customerDocumentNumber, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getOrdersByStatusPartiallySent");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getOrdersByStatusPartiallySent");
    }
    

    // create path and map variables
    String path = "/orders/status/partiallySent".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (sentAt != null)
      queryParams.put("sentAt", apiClient.parameterToString(sentAt));
    if (customerName != null)
      queryParams.put("customer.name", apiClient.parameterToString(customerName));
    if (customerDocumentNumber != null)
      queryParams.put("customer.documentNumber", apiClient.parameterToString(customerDocumentNumber));
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
        return (GetOrdersResponse) apiClient.deserialize(response, "", GetOrdersResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Recupera uma lista de pedidos Enviados
   * &lt;p&gt;Recupera uma lista de pedidos com status Enviado, que estão relacionados com o token do lojista informado. Este estado representa os pedidos cujos itens foram todos entregues.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Obs.: Os emails transacionais que reportam o status do pedido para os clientes devem ser desabibilitados. Esse tipo de email já é enviado pelo Marketplace.&lt;/p&gt;
   * @param sentAt Data de envio. Esse campo aceita um range de datas separados por vírgula, e os formatos aceitos para o campo são os seguintes:&lt;br/&gt;&lt;strong&gt;sentAt={data inicial},{data final}&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;sentAt={data inicial},*&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;sentAt=*,{data final}&lt;/strong&gt;&lt;br/&gt;onde, o &lt;strong&gt;*&lt;/strong&gt; é obrigatório e indica a que todas as datas antes ou depois da outra data passada devem ser consideradas
   * @param customerName Nome do Cliente
   * @param customerDocumentNumber Documento do Cliente
   * @param offset Parâmetro utilizado para indicar a posição inicial da consulta. O registro inicial tem índice zero (0), ou seja, para trazer os 10 primeiros registros, informa 0 para _offset e 10 para _limit.
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta
   * @return GetOrdersResponse
   */
  public GetOrdersResponse getOrdersByStatusSent (String sentAt, String customerName, String customerDocumentNumber, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getOrdersByStatusSent");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getOrdersByStatusSent");
    }
    

    // create path and map variables
    String path = "/orders/status/sent".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (sentAt != null)
      queryParams.put("sentAt", apiClient.parameterToString(sentAt));
    if (customerName != null)
      queryParams.put("customer.name", apiClient.parameterToString(customerName));
    if (customerDocumentNumber != null)
      queryParams.put("customer.documentNumber", apiClient.parameterToString(customerDocumentNumber));
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
        return (GetOrdersResponse) apiClient.deserialize(response, "", GetOrdersResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Recupera detalhes do pedido informado
   * &lt;p&gt;Recupera detalhes do pedido informado.&lt;/p&gt;&lt;p&gt;Observação:&lt;br/&gt;Os campos retornados dependem do status do pedido, por exemplo, no status new, as informações de entrega são suprimidas para evitar a entrega antes da confirmação do pagamento. Nesta documentação estão presentes todos os campos de Pedido. Para saber quais campos são retornados para cada status do pedido, basta consultar a documentação de cada um dos métodos de consulta de pedidos por status.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;Deve ser informado um pedido válido.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Abaixo seguem os valores possíveis para o tipo de pagamento (paymentType)&lt;table class=&#39;table&#39;&gt;&lt;tr&gt;&lt;th&gt;Código&lt;/th&gt;&lt;th&gt;Descrição&lt;/th&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;1&lt;/td&gt;&lt;td&gt;Cartão de Crédito&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;2&lt;/td&gt;&lt;td&gt;Boleto&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;4&lt;/td&gt;&lt;td&gt;Cupom&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;5&lt;/td&gt;&lt;td&gt;Transferência&lt;/td&gt;&lt;/tr&gt;&lt;/table&gt;&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Segue abaixo a lista de Status existentes para pedidos. Os status representam a situação consolidada do pedido:&lt;br/&gt;&lt;table class = &#39;table&#39;&gt;&lt;tr&gt;&lt;th&gt;Código&lt;/th&gt;&lt;th&gt;Descrição&lt;/th&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;NEW&lt;/td&gt;&lt;td&gt;Novo&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;GDE&lt;/td&gt;&lt;td&gt;Entregas geradas&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;PEN&lt;/td&gt;&lt;td&gt;Pagamento pendente&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;PAY&lt;/td&gt;&lt;td&gt;Pagamento aprovado&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;SHP&lt;/td&gt;&lt;td&gt;Enviado&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;DLV&lt;/td&gt;&lt;td&gt;Entregue&lt;/td&gt;&lt;/tr&gt;&lt;/table&gt;&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Segue abaixo a lista de Control Points existentes. Os Control Points estão presentes em cada operação de tracking e representam o status de cada operação realizada no pedido:&lt;br/&gt;&lt;table class = &#39;table&#39;&gt;&lt;tr&gt;&lt;th&gt;Código&lt;/th&gt;&lt;th&gt;Sequência / ordem&lt;/th&gt;&lt;th&gt;Descrição&lt;/th&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AAP&lt;/td&gt;&lt;td&gt;1&lt;/td&gt;&lt;td&gt;Aguardando a confirmação do pagamento&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ACR&lt;/td&gt;&lt;td&gt;2&lt;/td&gt;&lt;td&gt;Análise de dados&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ADT&lt;/td&gt;&lt;td&gt;3&lt;/td&gt;&lt;td&gt;Data de entrega ajustada&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AEG&lt;/td&gt;&lt;td&gt;4&lt;/td&gt;&lt;td&gt;Aguardando entregas pagamento&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AES&lt;/td&gt;&lt;td&gt;5&lt;/td&gt;&lt;td&gt;Disponibilidade de estoque&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AGR&lt;/td&gt;&lt;td&gt;6&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AMC&lt;/td&gt;&lt;td&gt;7&lt;/td&gt;&lt;td&gt;Análise de dados&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AR1&lt;/td&gt;&lt;td&gt;8&lt;/td&gt;&lt;td&gt;Aviso de Entrega 1&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AR2&lt;/td&gt;&lt;td&gt;9&lt;/td&gt;&lt;td&gt;Aviso de Entrega 2&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ARE&lt;/td&gt;&lt;td&gt;10&lt;/td&gt;&lt;td&gt;Aguardando Retirada&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ARL&lt;/td&gt;&lt;td&gt;11&lt;/td&gt;&lt;td&gt;Disponível para Entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ATR&lt;/td&gt;&lt;td&gt;12&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AU1&lt;/td&gt;&lt;td&gt;13&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AU2&lt;/td&gt;&lt;td&gt;14&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AU3&lt;/td&gt;&lt;td&gt;15&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;AVA&lt;/td&gt;&lt;td&gt;16&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;CAN&lt;/td&gt;&lt;td&gt;17&lt;/td&gt;&lt;td&gt;Entrega Cancelada&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;CAP&lt;/td&gt;&lt;td&gt;18&lt;/td&gt;&lt;td&gt;Análise de dados concluída&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;DAE&lt;/td&gt;&lt;td&gt;19&lt;/td&gt;&lt;td&gt;Data de Entrega Ajustada&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;DIV&lt;/td&gt;&lt;td&gt;20&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;DNE&lt;/td&gt;&lt;td&gt;21&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;EA1&lt;/td&gt;&lt;td&gt;22&lt;/td&gt;&lt;td&gt;Destinatário Ausente - 1ª tentativa&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;EAR&lt;/td&gt;&lt;td&gt;23&lt;/td&gt;&lt;td&gt;Entrega em andamento&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;END&lt;/td&gt;&lt;td&gt;24&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ENL&lt;/td&gt;&lt;td&gt;25&lt;/td&gt;&lt;td&gt;Endereço não localizado&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ENT&lt;/td&gt;&lt;td&gt;26&lt;/td&gt;&lt;td&gt;Entrega concluída&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;EPR&lt;/td&gt;&lt;td&gt;27&lt;/td&gt;&lt;td&gt;Entrega em andamento&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ETR&lt;/td&gt;&lt;td&gt;28&lt;/td&gt;&lt;td&gt;Entrega em andamento&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;EXT&lt;/td&gt;&lt;td&gt;29&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;FEL&lt;/td&gt;&lt;td&gt;30&lt;/td&gt;&lt;td&gt;Entrega em andamento&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;FIS&lt;/td&gt;&lt;td&gt;31&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;IED&lt;/td&gt;&lt;td&gt;32&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;INS&lt;/td&gt;&lt;td&gt;33&lt;/td&gt;&lt;td&gt;Produto instalado&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;LIF&lt;/td&gt;&lt;td&gt;34&lt;/td&gt;&lt;td&gt;Entrega em andamento&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;MDS&lt;/td&gt;&lt;td&gt;35&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;MPA&lt;/td&gt;&lt;td&gt;36&lt;/td&gt;&lt;td&gt;Aguardando a confirmação do pagamento&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;NFS&lt;/td&gt;&lt;td&gt;37&lt;/td&gt;&lt;td&gt;Nota Fiscal emitida&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;OCO&lt;/td&gt;&lt;td&gt;38&lt;/td&gt;&lt;td&gt;Entrega concluída&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;PAP&lt;/td&gt;&lt;td&gt;39&lt;/td&gt;&lt;td&gt;Pagamento aprovado&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;PEI&lt;/td&gt;&lt;td&gt;40&lt;/td&gt;&lt;td&gt;Pedido incluso&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;PNA&lt;/td&gt;&lt;td&gt;41&lt;/td&gt;&lt;td&gt;Pagamento não aprovado&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;PRE&lt;/td&gt;&lt;td&gt;42&lt;/td&gt;&lt;td&gt;Pedido recusado pelo Cliente&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;REC&lt;/td&gt;&lt;td&gt;43&lt;/td&gt;&lt;td&gt;Análise de dados não confirmada&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;RED&lt;/td&gt;&lt;td&gt;44&lt;/td&gt;&lt;td&gt;Entrega em andamento&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;REO&lt;/td&gt;&lt;td&gt;45&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;REV&lt;/td&gt;&lt;td&gt;46&lt;/td&gt;&lt;td&gt;Pagamento não aprovado&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;RIE&lt;/td&gt;&lt;td&gt;47&lt;/td&gt;&lt;td&gt;Impossibilidade de entrega do produto&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ROT&lt;/td&gt;&lt;td&gt;48&lt;/td&gt;&lt;td&gt;Entrega em andamento&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;ROU&lt;/td&gt;&lt;td&gt;49&lt;/td&gt;&lt;td&gt;Dificuldade na entrega&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;RTD&lt;/td&gt;&lt;td&gt;50&lt;/td&gt;&lt;td&gt;Em rota de devolução&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;VES&lt;/td&gt;&lt;td&gt;51&lt;/td&gt;&lt;td&gt;Disponibilidade de estoque&lt;/td&gt;&lt;/tr&gt;&lt;tr&gt;&lt;td&gt;WMS&lt;/td&gt;&lt;td&gt;52&lt;/td&gt;&lt;td&gt;Separação e embalagem&lt;/td&gt;&lt;/tr&gt;&lt;/table&gt;&lt;/p&gt;
   * @param orderId ID do pedido.
   * @return Order
   */
  public Order getOrderById (String orderId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
       throw new ApiException(400, "Missing the required parameter 'orderId' when calling getOrderById");
    }
    

    // create path and map variables
    String path = "/orders/{orderId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "orderId" + "\\}", apiClient.escapeString(orderId.toString()));

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
        return (Order) apiClient.deserialize(response, "", Order.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Recupera detalhes de um item específico do pedido
   * &lt;p&gt;Recupera detalhes de um item específico do pedido.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;Deve ser informado um pedido e um item do pedido válidos.&lt;/p&gt;
   * @param orderId ID do pedido.
   * @param skuSellerId SKU Seller ID do item de pedido.
   * @return OrderItem
   */
  public OrderItem getOrderByIdAndSkuSllerId (String orderId, String skuSellerId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
       throw new ApiException(400, "Missing the required parameter 'orderId' when calling getOrderByIdAndSkuSllerId");
    }
    
    // verify the required parameter 'skuSellerId' is set
    if (skuSellerId == null) {
       throw new ApiException(400, "Missing the required parameter 'skuSellerId' when calling getOrderByIdAndSkuSllerId");
    }
    

    // create path and map variables
    String path = "/orders/{orderId}/items/{skuSellerId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "orderId" + "\\}", apiClient.escapeString(orderId.toString()))
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
        return (OrderItem) apiClient.deserialize(response, "", OrderItem.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação para confirmar o cancelamento de um item de pedido
   * &lt;p&gt;Operação utilizada para confirmar o cancelamento de um item de pedido que foi aberto pelo cliente (via protocolo) ou cancelamento acionado pelo lojista.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Quebra de envio&lt;/strong&gt;&lt;br/&gt;No caso de quebra de envio, passe apenas os itens e a quantidade que serão enviados.&lt;br/&gt;O controle de quais itens foram enviados deverá ser realizado pela sua Aplicação.&lt;br/&gt;&lt;br/&gt;Para notificar o envio de todos os produtos, passe a lista contendo todos os itens e quantidade total.&lt;br/&gt;&lt;br/&gt;Clique &lt;a href=&#39;../tutoriais/exemplo_tracking_sent_v2.json&#39; target=&#39;_blank&#39;&gt;aqui&lt;/a&gt; para obter um exemplo de conteúdo JSON suportado por esse serviço.&lt;/p&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para método POST, sendo retornado apenas o Status HTTP 201 - Created.&lt;/strong&gt;&lt;/p&gt;
   * @param body 
   * @param orderId ID do pedido.
   * @return String
   */
  public String postOrderTrackingCancelation (NewTracking body, String orderId) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling postOrderTrackingCancelation");
    }
    
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
       throw new ApiException(400, "Missing the required parameter 'orderId' when calling postOrderTrackingCancelation");
    }
    

    // create path and map variables
    String path = "/orders/{orderId}/trackings/cancel".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "orderId" + "\\}", apiClient.escapeString(orderId.toString()));

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
   * Registra uma nova operação de tracking de entrega
   * &lt;p&gt;Registra uma nova operação de tracking de Entrega para os itens do pedido.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Quebra de envio&lt;/strong&gt;&lt;br/&gt;No caso de quebra de envio, passe apenas os itens e a quantidade que foram entregues.&lt;br/&gt;O controle de quais itens foram enviados deverá ser realizado pela sua Aplicação.&lt;br/&gt;&lt;br/&gt;Para notificar a entrega de todos os produtos, passe a lista contendo todos os itens e quantidade total.&lt;br/&gt;&lt;br/&gt;Clique &lt;a href=&#39;../tutoriais/exemplo_tracking_delivered_v2.json&#39; target=&#39;_blank&#39;&gt;aqui&lt;/a&gt; para obter um exemplo de conteúdo JSON suportado por esse serviço.&lt;/p&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para método POST, sendo retornado apenas o Status HTTP 201 - Created.&lt;/strong&gt;&lt;/p&gt;
   * @param body 
   * @param orderId ID do pedido.
   * @return String
   */
  public String postOrderTrackingDelivered (NewTracking body, String orderId) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling postOrderTrackingDelivered");
    }
    
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
       throw new ApiException(400, "Missing the required parameter 'orderId' when calling postOrderTrackingDelivered");
    }
    

    // create path and map variables
    String path = "/orders/{orderId}/trackings/delivered".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "orderId" + "\\}", apiClient.escapeString(orderId.toString()));

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
   * Operação para confirmar a troca de um item de um pedido
   * &lt;p&gt;Operação utilizada para confirmar a troca de um item de pedido aberto pelo cliente (via protocolo).&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Quebra de envio&lt;/strong&gt;&lt;br/&gt;No caso de quebra de envio, passe apenas os itens e a quantidade que serão enviados.&lt;br/&gt;O controle de quais itens foram enviados deverá ser realizado pela sua Aplicação.&lt;br/&gt;&lt;br/&gt;Para notificar o envio de todos os produtos, passe a lista contendo todos os itens e quantidade total.&lt;br/&gt;&lt;br/&gt;Clique &lt;a href=&#39;../tutoriais/exemplo_tracking_sent_v2.json&#39; target=&#39;_blank&#39;&gt;aqui&lt;/a&gt; para obter um exemplo de conteúdo JSON suportado por esse serviço.&lt;/p&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para método POST, sendo retornado apenas o Status HTTP 201 - Created.&lt;/strong&gt;&lt;/p&gt;
   * @param body 
   * @param orderId ID do pedido.
   * @return String
   */
  public String postOrderTrackingExchange (NewTracking body, String orderId) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling postOrderTrackingExchange");
    }
    
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
       throw new ApiException(400, "Missing the required parameter 'orderId' when calling postOrderTrackingExchange");
    }
    

    // create path and map variables
    String path = "/orders/{orderId}/trackings/exchange".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "orderId" + "\\}", apiClient.escapeString(orderId.toString()));

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
   * Operação para confirmar devolução (reembolso) de item do pedido
   * &lt;p&gt;Operação utilizada para confirmação de devolução (reembolso) de item do pedido através de protocolo aberto pelo cliente.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Quebra de envio&lt;/strong&gt;&lt;br/&gt;No caso de quebra de envio, passe apenas os itens e a quantidade que serão enviados.&lt;br/&gt;O controle de quais itens foram enviados deverá ser realizado pela sua Aplicação.&lt;br/&gt;&lt;br/&gt;Para notificar o envio de todos os produtos, passe a lista contendo todos os itens e quantidade total.&lt;br/&gt;&lt;br/&gt;Clique &lt;a href=&#39;../tutoriais/exemplo_tracking_sent_v2.json&#39; target=&#39;_blank&#39;&gt;aqui&lt;/a&gt; para obter um exemplo de conteúdo JSON suportado por esse serviço.&lt;/p&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para método POST, sendo retornado apenas o Status HTTP 201 - Created.&lt;/strong&gt;&lt;/p&gt;
   * @param body 
   * @param orderId ID do pedido.
   * @return String
   */
  public String postOrderTrackingReturn (NewTracking body, String orderId) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling postOrderTrackingReturn");
    }
    
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
       throw new ApiException(400, "Missing the required parameter 'orderId' when calling postOrderTrackingReturn");
    }
    

    // create path and map variables
    String path = "/orders/{orderId}/trackings/return".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "orderId" + "\\}", apiClient.escapeString(orderId.toString()));

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
   * Registra uma nova operação de tracking de envio
   * &lt;p&gt;Registra uma nova operação de tracking de Envio para os itens do pedido.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Quebra de envio&lt;/strong&gt;&lt;br/&gt;No caso de quebra de envio, passe apenas os itens e a quantidade que serão enviados.&lt;br/&gt;O controle de quais itens foram enviados deverá ser realizado pela sua Aplicação.&lt;br/&gt;&lt;br/&gt;Para notificar o envio de todos os produtos, passe a lista contendo todos os itens e quantidade total.&lt;br/&gt;&lt;br/&gt;Clique &lt;a href=&#39;../tutoriais/exemplo_tracking_sent_v2.json&#39; target=&#39;_blank&#39;&gt;aqui&lt;/a&gt; para obter um exemplo de conteúdo JSON suportado por esse serviço.&lt;/p&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para método POST, sendo retornado apenas o Status HTTP 201 - Created.&lt;/strong&gt;&lt;/p&gt;
   * @param body 
   * @param orderId ID do pedido.
   * @return String
   */
  public String postOrderTrackingSent (NewTracking body, String orderId) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling postOrderTrackingSent");
    }
    
    // verify the required parameter 'orderId' is set
    if (orderId == null) {
       throw new ApiException(400, "Missing the required parameter 'orderId' when calling postOrderTrackingSent");
    }
    

    // create path and map variables
    String path = "/orders/{orderId}/trackings/sent".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "orderId" + "\\}", apiClient.escapeString(orderId.toString()));

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
  
}
