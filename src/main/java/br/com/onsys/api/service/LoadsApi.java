package br.com.onsys.api.service;



import java.util.*;


import java.util.*;

import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;

import br.com.onsys.api.client.ApiClient;
import br.com.onsys.api.client.ApiException;
import br.com.onsys.api.client.Configuration;
import br.com.onsys.model.Errors;
import br.com.onsys.model.GetOrdersTrackingUpdatingResponse;
import br.com.onsys.model.GetProductWithErrorsResponse;
import br.com.onsys.model.GetProductsResponse;
import br.com.onsys.model.GetSellerItemsPricesUpdatingResponse;
import br.com.onsys.model.GetSellerItemsStatusUpdatingResponse;
import br.com.onsys.model.GetSellerItemsStocksUpdatingResponse;
import br.com.onsys.model.OrdersTrackings;
import br.com.onsys.model.Product;
import br.com.onsys.model.SellerItemPrices;
import br.com.onsys.model.SellerItemStatusUpdate;
import br.com.onsys.model.SellerItemStocks;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class LoadsApi {
  private ApiClient apiClient;

  public LoadsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public LoadsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * Operação utilizada para consultar o status dos produtos enviados
   * &lt;p&gt;Operação utilizada para consultar o status de uma lista de produtos enviados. É possível refinar a consulta utilizando alguns parâmetros não obrigatórios como: STATUS e DATA DE CADASTRO DO PRODUTO&lt;/p&gt;
   * @param createdAt Data de envio do produto. Esse campo aceita um range de datas separados por vírgula, e os formatos aceitos para o campo são os seguintes:&lt;br/&gt;&lt;strong&gt;purchasedAt={data inicial},{data final}&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;purchasedAt={data inicial},*&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;purchasedAt=*,{data final}&lt;/strong&gt;&lt;br/&gt;onde, o &lt;strong&gt;*&lt;/strong&gt; é obrigatório e indica a que todas as datas antes ou depois da outra data passada devem ser consideradas.
   * @param status Status do produto importado.
   * @param offset Parâmetro utilizado para indicar a posição do registro inicial que será trazido. A primeira posição é sempre zero (0)
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta
   * @return GetOrdersTrackingUpdatingResponse
   */
  public GetOrdersTrackingUpdatingResponse getOrdersTrackingDelivered (String createdAt, String status, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getOrdersTrackingDelivered");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getOrdersTrackingDelivered");
    }
    

    // create path and map variables
    String path = "/loads/orders/trackings/delivered".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (createdAt != null)
      queryParams.put("createdAt", apiClient.parameterToString(createdAt));
    if (status != null)
      queryParams.put("status", apiClient.parameterToString(status));
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
        return (GetOrdersTrackingUpdatingResponse) apiClient.deserialize(response, "", GetOrdersTrackingUpdatingResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação utilizada  para atualização de tracking massivo
   * &lt;p&gt;Operação utilizada para atualização de tracking massivo. &lt;/p&gt;&lt;br/&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Devido ao formato JSON, é necessário alterar o &lt;strong&gt;HTTP Header: content-type&lt;/strong&gt; para &lt;strong&gt;application/json&lt;/strong&gt; para o correto funcionamento. &lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br /&gt;O retorno deste serviço é baseado no padrão definido para métodos POST segundo o Status HTTP 201 - Created.&lt;/p&gt;
   * @param ordersTrackings Arquivo em formato &lt;strong&gt;JSON&lt;/strong&gt; cujo conteúdo contêm uma lista de objetos product.
   * @return String
   */
  public String postOrdersTrackingDelivered (OrdersTrackings ordersTrackings) throws ApiException {
    Object postBody = ordersTrackings;
    
    // verify the required parameter 'ordersTrackings' is set
    if (ordersTrackings == null) {
       throw new ApiException(400, "Missing the required parameter 'ordersTrackings' when calling postOrdersTrackingDelivered");
    }
    

    // create path and map variables
    String path = "/loads/orders/trackings/delivered".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      
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
   * Operação utilizada para consultar o status dos produtos enviados
   * &lt;p&gt;Operação utilizada para consultar o status de uma lista de produtos enviados. É possível refinar a consulta utilizando alguns parâmetros não obrigatórios como: STATUS e DATA DE CADASTRO DO PRODUTO.&lt;/p&gt;
   * @param createdAt Data de envio do produto. Esse campo aceita um range de datas separados por vírgula, e os formatos aceitos para o campo são os seguintes:&lt;br/&gt;&lt;strong&gt;purchasedAt={data inicial},{data final}&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;purchasedAt={data inicial},*&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;purchasedAt=*,{data final}&lt;/strong&gt;&lt;br/&gt;onde, o &lt;strong&gt;*&lt;/strong&gt; é obrigatório e indica a que todas as datas antes ou depois da outra data passada devem ser consideradas.
   * @param status Status do produto importado.
   * @param offset Parâmetro utilizado para indicar a posição do registro inicial que será trazido. A primeira posição é sempre zero (0).
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetOrdersTrackingUpdatingResponse
   */
  public GetOrdersTrackingUpdatingResponse getOrdersTrackingSent (String createdAt, String status, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getOrdersTrackingSent");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getOrdersTrackingSent");
    }
    

    // create path and map variables
    String path = "/loads/orders/trackings/sent".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (createdAt != null)
      queryParams.put("createdAt", apiClient.parameterToString(createdAt));
    if (status != null)
      queryParams.put("status", apiClient.parameterToString(status));
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
        return (GetOrdersTrackingUpdatingResponse) apiClient.deserialize(response, "", GetOrdersTrackingUpdatingResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação utilizada para atualização de tracking massivo
   * &lt;p&gt;Operação utilizada para atualização de tracking massivo. &lt;/p&gt;&lt;br/&gt;&lt;p class=&#39;obs obs-danger&#39;&gt; Devido ao formato JSON, é necessário alterar o &lt;strong&gt;HTTP Header: content-type&lt;/strong&gt; para &lt;strong&gt;application/json&lt;/strong&gt; para o correto funcionamento. &lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br /&gt;O retorno deste serviço é baseado no padrão definido para métodos POST segundo o Status HTTP 201 - Created.&lt;/p&gt;
   * @param ordersTrackings Arquivo em formato &lt;strong&gt;JSON&lt;/strong&gt; cujo conteúdo contêm uma lista de objetos de order tracking.
   * @return String
   */
  public String postOrdersTrackingSent (OrdersTrackings ordersTrackings) throws ApiException {
    Object postBody = ordersTrackings;
    
    // verify the required parameter 'ordersTrackings' is set
    if (ordersTrackings == null) {
       throw new ApiException(400, "Missing the required parameter 'ordersTrackings' when calling postOrdersTrackingSent");
    }
    

    // create path and map variables
    String path = "/loads/orders/trackings/sent".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      
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
   * Operação utilizada para consultar o status dos produtos
   * &lt;p&gt;Operação utilizada para consultar o status de uma lista de produtos enviados. É possível refinar a consulta utilizando alguns parâmetros não obrigatórios como: STATUS e DATA DE CADASTRO DO PRODUTO.&lt;/p&gt;
   * @param createdAt Data de envio do produto. Esse campo aceita um range de datas separados por vírgula, e os formatos aceitos para o campo são os seguintes:&lt;br/&gt;&lt;strong&gt;purchasedAt={data inicial},{data final}&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;purchasedAt={data inicial},*&lt;/strong&gt;&lt;br/&gt;&lt;strong&gt;purchasedAt=*,{data final}&lt;/strong&gt;&lt;br/&gt;onde, o &lt;strong&gt;*&lt;/strong&gt; é obrigatório e indica a que todas as datas antes ou depois da outra data passada devem ser consideradas.
   * @param status Status do produto importado.
   * @param offset Parâmetro utilizado para indicar a posição do registro inicial que será trazido. A primeira posição é sempre zero (0).
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetProductsResponse
   */
  public GetProductsResponse getProducts (String createdAt, String status, Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getProducts");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getProducts");
    }
    

    // create path and map variables
    String path = "/loads/products".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (createdAt != null)
      queryParams.put("createdAt", apiClient.parameterToString(createdAt));
    if (status != null)
      queryParams.put("status", apiClient.parameterToString(status));
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
        return (GetProductsResponse) apiClient.deserialize(response, "", GetProductsResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  
  
  public String geCode (String path) throws ApiException {
	    Object postBody = null;
	    
	   

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
	        return response;
	      }
	      else {
	        return null;
	      }
	    } catch (ApiException ex) {
	      throw ex;
	    }
	  }
  
  
  /**
   * Operação utilizada para enviar uma nova carga de produtos (assíncrono)
   * &lt;p class=&#39;obs obs-danger&#39;&gt;Não é possível executar testes com esta operação via API Browser devido ao envio de arquivos, não suportado pela ferramenta.&lt;/p&gt;&lt;p&gt;Operação utilizada para envio de carga contendo novos produtos. Através desta é possível passar, de forma não obrigatória, informações da ficha dos produtos e informações de venda, tais como valor e quantidade.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;Não é objetivo deste serviço o recebimento de informações para atualização de preço e estoque (para isso utilize os serviços existentes no recurso &lt;a href=&#39;#!/sellerItems&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;/sellerItems&lt;/strong&gt;&lt;/a&gt;), nem a atualização da ficha cadastral do produto (não há serviço disponível para essa finalidade, se precisar atualizar a ficha do produto, entre em contato com o time Comercial do Marketplace).&lt;br/&gt;&lt;br/&gt;&lt;strong&gt;IMPORTANTE&lt;/strong&gt;&lt;br/&gt;Caso sua Loja já tenha produtos no Marketplace que não foram enviados através da API (enviados via planilha excel, por exemplo), não os envie novamente em uma nova carga, faça primeiro a consulta de seus produtos através do serviço &lt;a href=&#39;#!/sellerItems/getSellerItems_get_0&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sellerItems&lt;/strong&gt;&lt;/a&gt; e realize o DE-PARA de skus.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt; Devido ao formato JSON, é necessário alterar o &lt;strong&gt;HTTP Header: content-type&lt;/strong&gt; para &lt;strong&gt;application/json&lt;/strong&gt; para o correto funcionamento.&lt;br /&gt; &lt;br /&gt;Clique &lt;a href=&#39;../tutoriais/exemplo_loads_v2.json&#39; target=&#39;_blank&#39;&gt;aqui&lt;/a&gt; para obter um exemplo de conteúdo JSON suportado por essa operação.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt; &lt;strong&gt;Categorias e atributos&lt;/strong&gt;&lt;br /&gt;&lt;br /&gt; &lt;strong&gt;SANDBOX&lt;/strong&gt;&lt;br /&gt;&lt;br/&gt;Para os testes na SANDBOX é obrigatório passar uma categoria fixa chamada &lt;strong&gt;&#39;Teste&gt;API&#39;&lt;/strong&gt;. Caso seja enviada qualquer outra categoria, o produto ficará no status &lt;strong&gt;Pending&lt;/strong&gt; e, em Sandbox, não há tratamento para esse tipo de status. Se isso acontecer, cancele o seu produto com a operação exlusiva de Sandbox &lt;a href=&#39;#!/loads/deleteProducts_delete_2&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;DELETE /loads/products/{skuSellerId}&lt;/strong&gt;&lt;/a&gt;&lt;br /&gt;&lt;br /&gt; &lt;strong&gt;PRODUÇÃO&lt;/strong&gt;&lt;br/&gt;&lt;br/&gt;Em produção, envie a categoria real do produto do lojista, não é necessário fazer o DE-PARA para a árvore de categorias do Marketplace.&lt;br /&gt; Lembre-se apenas de seguir a seguinte regra:&lt;br /&gt; &lt;strong&gt;&#39;Informática&gt;Notebook&#39;&lt;/strong&gt;, onde Informática é a categoria pai e Notebook é a subcategoria e elas devem ser separadas pelo sinal de maior &lt;strong&gt;&#39;&gt;&#39;&lt;/strong&gt;.&lt;br /&gt;Cada categoria da árvore de produtos da Cnova possui um conjunto de atributos opcionais e obrigatórios. Para saber quais são os atributos obrigatórios para a categoria de produtos que serão carregados, por favor consulte o seu contato comercial ou abra uma solicitação através de &lt;a href=&#39;http://suporte-lojistas.extra.com.br&#39;&gt;Suporte-lojistas.&lt;/a&gt; É sempre recomendável o envio do máximo de atributos disponíveis na base de origem para maximizar a qualidade das fichas de produto e os resultados de busca do produto.&lt;br/&gt; &lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt; &lt;strong&gt;Sobre o processo de importação&lt;/strong&gt; &lt;br /&gt;&lt;br/&gt;Esta operação é assíncrona, ou seja, os produtos passam por um processamento em nosso sistema para depois ficarem disponíveis para consulta. Para consultar o status dos produtos enviados, utilize o serviço:&lt;br/&gt;&lt;a href=&#39;#!/loads/getLoadInfo_get_1&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /loads/products&lt;/strong&gt;&lt;/a&gt;.&lt;br/&gt;Caso existam erros, também é possível verificar quais foram os erros para cada produto enviado através do serviço:&lt;br/&gt;&lt;a href=&#39;#!/loads/getLoadInfoSkuOrigin_get_3&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /loads/products/{skuSellerId}&lt;/strong&gt;&lt;/a&gt;&lt;br /&gt; Todos os produtos passam por um processo de aprovação antes da efetiva liberação no Marketplace. Atente-se para o processo de importação de produtos, que é diferente para cada ambiente:&lt;br /&gt;&lt;br/&gt; &lt;strong&gt;SANDBOX&lt;/strong&gt;&lt;br /&gt;&lt;br/&gt; Em Sandbox o processo de aprovação é automático, ou seja, uma vez que as cargas forem enviadas, se os produtos estiverem com a ficha cadastral correta, todos eles serão aprovados (assumirão o status Disponível - AVAILABLE).&lt;br /&gt;Os produtos que forem aprovados automaticamente só estarão disponíveis na consulta de produtos do lojista (&lt;a href=&#39;#!/sellerItems/getSellerItems_get_0&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sellerItems&lt;/strong&gt;&lt;/a&gt;) após assumirem o status &lt;strong&gt;AVAILABLE.&lt;/strong&gt;&lt;br/&gt;&lt;br/&gt; &lt;strong&gt;PRODUÇÃO&lt;/strong&gt;&lt;br /&gt;&lt;br/&gt;Em Produção, antes que os produtos de uma carga sejam efetivamente cadastrados, eles passam por uma validação que fica sob a responsabilidade da Equipe de Cadastro do Marketplace e, por esse motivo, os produtos levam mais tempo para serem ativados no site ao qual você está apto a vender. Isso quer dizer que o produto não irá aparecer no site e nem estará disponível para atualizações de preço/estoque logo que enviado via carga. Consulte a equipe Comercial do Marketplace para informações sobre o prazo médio de cadastro dos produtos.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;&lt;strong&gt;Agrupamento de cargas&lt;/strong&gt;&lt;br/&gt;&lt;br/&gt;Quando uma carga de produtos é enviada, caso, antes da aprovação dos produtos enviado, uma segunda carga seja enviada, e se um produto for enviado nas duas cargas, o que irá valer é o segundo produto enviado, ou seja, se na primeira carga você constatou que o produto estava com algum erro, é possível reenviá-lo com as correções para que ele seja considerado para importação.&lt;br/&gt;Enquanto o novo produto não for aprovado, é possível enviá-lo novamente para atualização da fichal cadastral. &lt;strong&gt;Mas lembre-se:&lt;/strong&gt; para produtos já disponibilizados no Marketplace, esse serviço não realiza atualização da ficha cadastral, conforme mencionado acima.&lt;br/&gt;Outra forma de fazer essa correção unitária de um produto com problema é através do serviço &lt;a href=&#39;#!/loads/getLoadInfoSkuOrigin_put_4&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;PUT /loads/products/{skuSellerId}&lt;/strong&gt;&lt;/a&gt;&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br /&gt;O retorno deste serviço é baseado no padrão definido para métodos POST segundo o Status HTTP 201 - Created.&lt;/p&gt;
   * @param products Arquivo em formato &lt;strong&gt;JSON&lt;/strong&gt; cujo conteúdo contêm uma lista de objetos product.
   * @return String
   */
  public String postProducts (byte[] gzipProducts) throws ApiException {
    Object postBody = gzipProducts;
    
    // verify the required parameter 'products' is set
    if (gzipProducts == null) {
       throw new ApiException(400, "Missing the required parameter 'products' when calling postProducts");
    }
    

    // create path and map variables
    String path = "/loads/products".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      "application/gzip"
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
   * Operação utilizada para enviar uma nova carga de produtos (assíncrono)
   * &lt;p class=&#39;obs obs-danger&#39;&gt;Não é possível executar testes com esta operação via API Browser devido ao envio de arquivos, não suportado pela ferramenta.&lt;/p&gt;&lt;p&gt;Operação utilizada para envio de carga contendo novos produtos. Através desta é possível passar, de forma não obrigatória, informações da ficha dos produtos e informações de venda, tais como valor e quantidade.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;Não é objetivo deste serviço o recebimento de informações para atualização de preço e estoque (para isso utilize os serviços existentes no recurso &lt;a href=&#39;#!/sellerItems&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;/sellerItems&lt;/strong&gt;&lt;/a&gt;), nem a atualização da ficha cadastral do produto (não há serviço disponível para essa finalidade, se precisar atualizar a ficha do produto, entre em contato com o time Comercial do Marketplace).&lt;br/&gt;&lt;br/&gt;&lt;strong&gt;IMPORTANTE&lt;/strong&gt;&lt;br/&gt;Caso sua Loja já tenha produtos no Marketplace que não foram enviados através da API (enviados via planilha excel, por exemplo), não os envie novamente em uma nova carga, faça primeiro a consulta de seus produtos através do serviço &lt;a href=&#39;#!/sellerItems/getSellerItems_get_0&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sellerItems&lt;/strong&gt;&lt;/a&gt; e realize o DE-PARA de skus.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt; Devido ao formato JSON, é necessário alterar o &lt;strong&gt;HTTP Header: content-type&lt;/strong&gt; para &lt;strong&gt;application/json&lt;/strong&gt; para o correto funcionamento.&lt;br /&gt; &lt;br /&gt;Clique &lt;a href=&#39;../tutoriais/exemplo_loads_v2.json&#39; target=&#39;_blank&#39;&gt;aqui&lt;/a&gt; para obter um exemplo de conteúdo JSON suportado por essa operação.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt; &lt;strong&gt;Categorias e atributos&lt;/strong&gt;&lt;br /&gt;&lt;br /&gt; &lt;strong&gt;SANDBOX&lt;/strong&gt;&lt;br /&gt;&lt;br/&gt;Para os testes na SANDBOX é obrigatório passar uma categoria fixa chamada &lt;strong&gt;&#39;Teste&gt;API&#39;&lt;/strong&gt;. Caso seja enviada qualquer outra categoria, o produto ficará no status &lt;strong&gt;Pending&lt;/strong&gt; e, em Sandbox, não há tratamento para esse tipo de status. Se isso acontecer, cancele o seu produto com a operação exlusiva de Sandbox &lt;a href=&#39;#!/loads/deleteProducts_delete_2&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;DELETE /loads/products/{skuSellerId}&lt;/strong&gt;&lt;/a&gt;&lt;br /&gt;&lt;br /&gt; &lt;strong&gt;PRODUÇÃO&lt;/strong&gt;&lt;br/&gt;&lt;br/&gt;Em produção, envie a categoria real do produto do lojista, não é necessário fazer o DE-PARA para a árvore de categorias do Marketplace.&lt;br /&gt; Lembre-se apenas de seguir a seguinte regra:&lt;br /&gt; &lt;strong&gt;&#39;Informática&gt;Notebook&#39;&lt;/strong&gt;, onde Informática é a categoria pai e Notebook é a subcategoria e elas devem ser separadas pelo sinal de maior &lt;strong&gt;&#39;&gt;&#39;&lt;/strong&gt;.&lt;br /&gt;Cada categoria da árvore de produtos da Cnova possui um conjunto de atributos opcionais e obrigatórios. Para saber quais são os atributos obrigatórios para a categoria de produtos que serão carregados, por favor consulte o seu contato comercial ou abra uma solicitação através de &lt;a href=&#39;http://suporte-lojistas.extra.com.br&#39;&gt;Suporte-lojistas.&lt;/a&gt; É sempre recomendável o envio do máximo de atributos disponíveis na base de origem para maximizar a qualidade das fichas de produto e os resultados de busca do produto.&lt;br/&gt; &lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt; &lt;strong&gt;Sobre o processo de importação&lt;/strong&gt; &lt;br /&gt;&lt;br/&gt;Esta operação é assíncrona, ou seja, os produtos passam por um processamento em nosso sistema para depois ficarem disponíveis para consulta. Para consultar o status dos produtos enviados, utilize o serviço:&lt;br/&gt;&lt;a href=&#39;#!/loads/getLoadInfo_get_1&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /loads/products&lt;/strong&gt;&lt;/a&gt;.&lt;br/&gt;Caso existam erros, também é possível verificar quais foram os erros para cada produto enviado através do serviço:&lt;br/&gt;&lt;a href=&#39;#!/loads/getLoadInfoSkuOrigin_get_3&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /loads/products/{skuSellerId}&lt;/strong&gt;&lt;/a&gt;&lt;br /&gt; Todos os produtos passam por um processo de aprovação antes da efetiva liberação no Marketplace. Atente-se para o processo de importação de produtos, que é diferente para cada ambiente:&lt;br /&gt;&lt;br/&gt; &lt;strong&gt;SANDBOX&lt;/strong&gt;&lt;br /&gt;&lt;br/&gt; Em Sandbox o processo de aprovação é automático, ou seja, uma vez que as cargas forem enviadas, se os produtos estiverem com a ficha cadastral correta, todos eles serão aprovados (assumirão o status Disponível - AVAILABLE).&lt;br /&gt;Os produtos que forem aprovados automaticamente só estarão disponíveis na consulta de produtos do lojista (&lt;a href=&#39;#!/sellerItems/getSellerItems_get_0&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sellerItems&lt;/strong&gt;&lt;/a&gt;) após assumirem o status &lt;strong&gt;AVAILABLE.&lt;/strong&gt;&lt;br/&gt;&lt;br/&gt; &lt;strong&gt;PRODUÇÃO&lt;/strong&gt;&lt;br /&gt;&lt;br/&gt;Em Produção, antes que os produtos de uma carga sejam efetivamente cadastrados, eles passam por uma validação que fica sob a responsabilidade da Equipe de Cadastro do Marketplace e, por esse motivo, os produtos levam mais tempo para serem ativados no site ao qual você está apto a vender. Isso quer dizer que o produto não irá aparecer no site e nem estará disponível para atualizações de preço/estoque logo que enviado via carga. Consulte a equipe Comercial do Marketplace para informações sobre o prazo médio de cadastro dos produtos.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;&lt;strong&gt;Agrupamento de cargas&lt;/strong&gt;&lt;br/&gt;&lt;br/&gt;Quando uma carga de produtos é enviada, caso, antes da aprovação dos produtos enviado, uma segunda carga seja enviada, e se um produto for enviado nas duas cargas, o que irá valer é o segundo produto enviado, ou seja, se na primeira carga você constatou que o produto estava com algum erro, é possível reenviá-lo com as correções para que ele seja considerado para importação.&lt;br/&gt;Enquanto o novo produto não for aprovado, é possível enviá-lo novamente para atualização da fichal cadastral. &lt;strong&gt;Mas lembre-se:&lt;/strong&gt; para produtos já disponibilizados no Marketplace, esse serviço não realiza atualização da ficha cadastral, conforme mencionado acima.&lt;br/&gt;Outra forma de fazer essa correção unitária de um produto com problema é através do serviço &lt;a href=&#39;#!/loads/getLoadInfoSkuOrigin_put_4&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;PUT /loads/products/{skuSellerId}&lt;/strong&gt;&lt;/a&gt;&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br /&gt;O retorno deste serviço é baseado no padrão definido para métodos POST segundo o Status HTTP 201 - Created.&lt;/p&gt;
   * @param products Arquivo em formato &lt;strong&gt;JSON&lt;/strong&gt; cujo conteúdo contêm uma lista de objetos product.
   * @return String
   */
  public String postProducts (List<Product> products) throws ApiException {
    Object postBody = products;
    
    // verify the required parameter 'products' is set
    if (products == null) {
       throw new ApiException(400, "Missing the required parameter 'products' when calling postProducts");
    }
    

    // create path and map variables
    String path = "/loads/products".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      
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
   * Operação para consultar um produto enviado
   * &lt;p&gt;Operação para consultar um produto enviado.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Essa operação deve ser utilizada, principalmente, para recuperar a listagem de erros que podem ter ocorrido na importação de produtos. Não utilize esse serviço para recuperar os dados atuais do produto que está sendo vendido (como preço e estoque). Para recuperar informações de venda do produto, utilize o serviço &lt;a href=&#39;#!/sellerItems/getDetailsSellerItemOrigin_get_1&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sellerItems/{skuSellerId}&lt;/strong&gt;&lt;/a&gt;&lt;/p&gt;
   * @param skuSellerId SKU ID do Lojista.
   * @return GetProductWithErrorsResponse
   */
  public GetProductWithErrorsResponse getProduct (String skuSellerId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'skuSellerId' is set
    if (skuSellerId == null) {
       throw new ApiException(400, "Missing the required parameter 'skuSellerId' when calling getProduct");
    }
    

    // create path and map variables
    String path = "/loads/products/{skuSellerId}".replaceAll("\\{format\\}","json")
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
        return (GetProductWithErrorsResponse) apiClient.deserialize(response, "", GetProductWithErrorsResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação para alterar um produto enviado na carga
   * &lt;p&gt;Operação utilizada para alterar um produto enviado na carga.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;O produto só pode ser alterado antes de assumir o status Disponível (AVAILABLE).&lt;br/&gt;Produtos já disponíveis não podem ser alterados através de serviços. Para mais informações, leia a documentação &lt;a href=&#39;#!/loads/loadProducts_post_0&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;POST /loads/products&lt;/strong&gt;&lt;/a&gt;.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para métodos PUT e DELETE, sendo retornado apenas o Status HTTP 204 - No Content.&lt;/strong&gt;&lt;/p&gt;
   * @param skuSellerId SKU do produto do lojista que deverá ser alterado.
   * @param body Parâmetros para alterar um produto enviado na carga.
   * @return String
   */
  public String putProduct (String skuSellerId, Product body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'skuSellerId' is set
    if (skuSellerId == null) {
       throw new ApiException(400, "Missing the required parameter 'skuSellerId' when calling putProduct");
    }
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling putProduct");
    }
    

    // create path and map variables
    String path = "/loads/products/{skuSellerId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "skuSellerId" + "\\}", apiClient.escapeString(skuSellerId.toString()));

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
   * Operação utilizada para cancelar uma lista de produtos enviados (SANDBOX)
   * &lt;p class=&#39;obs obs-danger&#39;&gt;Essa operação está disponível apenas para SANDBOX.&lt;/p&gt;&lt;p&gt;Operação utilizada para cancelar itens de uma carga. Os itens só podem ser cancelados se estiverem com erros de importação ou se os produtos estiverem pendentes (status=PENDING).&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para métodos PUT e DELETE, sendo retornado apenas o Status HTTP 204 - No Content.&lt;/strong&gt;&lt;/p&gt;
   * @param skuSellerId SKU do produto do lojista que deverá ser alterado.
   * @return Errors
   */
  public Errors deleteProduct (String skuSellerId) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'skuSellerId' is set
    if (skuSellerId == null) {
       throw new ApiException(400, "Missing the required parameter 'skuSellerId' when calling deleteProduct");
    }
    

    // create path and map variables
    String path = "/loads/products/{skuSellerId}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "skuSellerId" + "\\}", apiClient.escapeString(skuSellerId.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    

    

    final String[] accepts = {
      
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
      String response = apiClient.invokeAPI(path, "DELETE", queryParams, postBody, headerParams, formParams, accept, contentType, authNames);
      if(response != null){
        return (Errors) apiClient.deserialize(response, "", Errors.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação para consulta de atualização massiva de preços
   * &lt;p&gt;Operação para consulta de status da atualização massiva de preços de produtos enviados.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Essa operação deve ser utilizada, principalmente, para recuperar a listagem de erros que podem ter ocorrido na importação de produtos. Não utilize esse serviço para recuperar os dados atuais do produto que está sendo vendido (como preço e estoque). Para recuperar informações de venda do produto, utilize o serviço &lt;a href=&#39;#!/sellerItems/getDetailsSellerItemOrigin_get_1&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sellerItems/{skuSellerId}&lt;/strong&gt;&lt;/a&gt;&lt;/p&gt;
   * @param offset Parâmetro utilizado para indicar a posição do registro inicial que será trazido. A primeira posição é sempre zero (0).
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetSellerItemsPricesUpdatingResponse
   */
  public GetSellerItemsPricesUpdatingResponse getSellerItemsPricesUpdatingStatus (Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getSellerItemsPricesUpdatingStatus");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getSellerItemsPricesUpdatingStatus");
    }
    

    // create path and map variables
    String path = "/loads/sellerItems/prices".replaceAll("\\{format\\}","json");

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
        return (GetSellerItemsPricesUpdatingResponse) apiClient.deserialize(response, "", GetSellerItemsPricesUpdatingResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação para atualização de preço de produtos em massa
   * &lt;p&gt;Operação utilizada para atualização de preço, de forma massiva, de produtos enviados na carga.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para métodos PUT e DELETE, sendo retornado apenas o Status HTTP 204 - No Content.&lt;/strong&gt;&lt;/p&gt;
   * @param body Parâmetros para ativação/desativação massiva de produtos
   * @return String
   */
  public String putSellerItemsPrices (List<SellerItemPrices> body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling putSellerItemsPrices");
    }
    

    // create path and map variables
    String path = "/loads/sellerItems/prices".replaceAll("\\{format\\}","json");

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
   * Operação para consulta da atualização massiva de status
   * &lt;p&gt;Operação para consulta da atualização massiva de status de produtos enviado.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Essa operação deve ser utilizada, principalmente, para recuperar a listagem de erros que podem ter ocorrido na importação de produtos. Não utilize esse serviço para recuperar os dados atuais do produto que está sendo vendido (como preço e estoque). Para recuperar informações de venda do produto, utilize o serviço &lt;a href=&#39;#!/sellerItems/getDetailsSellerItemOrigin_get_1&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sellerItems/{skuSellerId}&lt;/strong&gt;&lt;/a&gt;&lt;/p&gt;
   * @param offset Parâmetro utilizado para indicar a posição do registro inicial que será trazido. A primeira posição é sempre zero (0).
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetSellerItemsStatusUpdatingResponse
   */
  public GetSellerItemsStatusUpdatingResponse getSellerItemsStatusUpdatingStatus (Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getSellerItemsStatusUpdatingStatus");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getSellerItemsStatusUpdatingStatus");
    }
    

    // create path and map variables
    String path = "/loads/sellerItems/status".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    if (offset != null)
      queryParams.put("_offset", apiClient.parameterToString(offset));
    if (limit != null)
      queryParams.put("_limit", apiClient.parameterToString(limit));
    

    

    final String[] accepts = {
      "application/json; charfset=utf-8"
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
        return (GetSellerItemsStatusUpdatingResponse) apiClient.deserialize(response, "", GetSellerItemsStatusUpdatingResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação para ativação/desativação massiva de produtos
   * &lt;p&gt;Operação utilizada para ativação/desativação massiva de produtos enviados na carga.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para métodos PUT e DELETE, sendo retornado apenas o Status HTTP 204 - No Content.&lt;/strong&gt;&lt;/p&gt;
   * @param body Parâmetros para ativação/desativação massiva de produtos
   * @return String
   */
  public String putSellerItemsStatus (List<SellerItemStatusUpdate> body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling putSellerItemsStatus");
    }
    

    // create path and map variables
    String path = "/loads/sellerItems/status".replaceAll("\\{format\\}","json");

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
   * Operação para consulta do status da atualização massiva de estoque
   * &lt;p&gt;Operação para consulta do status da atualização massiva de estoque de produtos enviados.&lt;/p&gt;&lt;p class=&#39;obs obs-danger&#39;&gt;Essa operação deve ser utilizada, principalmente, para recuperar a listagem de erros que podem ter ocorrido na importação de produtos. Não utilize esse serviço para recuperar os dados atuais do produto que está sendo vendido (como preço e estoque). Para recuperar informações de venda do produto, utilize o serviço &lt;a href=&#39;#!/sellerItems/getDetailsSellerItemOrigin_get_1&#39; target=&#39;_blank&#39;&gt;&lt;strong&gt;GET /sellerItems/{skuSellerId}&lt;/strong&gt;&lt;/a&gt;&lt;/p&gt;
   * @param offset Parâmetro utilizado para indicar a posição do registro inicial que será trazido. A primeira posição é sempre zero (0).
   * @param limit Parâmetro utilizado para indicar a quantidade de registros que deve ser trazido na consulta.
   * @return GetSellerItemsStocksUpdatingResponse
   */
  public GetSellerItemsStocksUpdatingResponse getSellerItemsStocksUpdatingStatus (Integer offset, Integer limit) throws ApiException {
    Object postBody = null;
    
    // verify the required parameter 'offset' is set
    if (offset == null) {
       throw new ApiException(400, "Missing the required parameter 'offset' when calling getSellerItemsStocksUpdatingStatus");
    }
    
    // verify the required parameter 'limit' is set
    if (limit == null) {
       throw new ApiException(400, "Missing the required parameter 'limit' when calling getSellerItemsStocksUpdatingStatus");
    }
    

    // create path and map variables
    String path = "/loads/sellerItems/stocks".replaceAll("\\{format\\}","json");

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
        return (GetSellerItemsStocksUpdatingResponse) apiClient.deserialize(response, "", GetSellerItemsStocksUpdatingResponse.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * Operação para atualização de estoque de produtos em massa
   * &lt;p&gt;Operação utilizada para atualização de estoque, de forma massiva, de produtos enviados na carga.&lt;/p&gt;&lt;p class=&#39;obs&#39;&gt;&lt;strong&gt;Retorno do Serviço&lt;/strong&gt;&lt;br/&gt;O retorno deste serviço é baseado no padrão definido para métodos PUT e DELETE, sendo retornado apenas o Status HTTP 204 - No Content.&lt;/strong&gt;&lt;/p&gt;
   * @param body Parâmetros para atualização massiva de estoque de produtos.
   * @return String
   */
  public String putSellerItemsStocks (List<SellerItemStocks> body) throws ApiException {
    Object postBody = body;
    
    // verify the required parameter 'body' is set
    if (body == null) {
       throw new ApiException(400, "Missing the required parameter 'body' when calling putSellerItemsStocks");
    }
    

    // create path and map variables
    String path = "/loads/sellerItems/stocks".replaceAll("\\{format\\}","json");

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
