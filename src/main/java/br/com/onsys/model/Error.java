package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Error  {
  
  private String code = null;
  private String httpStatus = null;
  private String type = null;
  private String message = null;
  private String skuSellerId = null;

  
  /**
   * Código de retorno da aplicação
   **/
  @ApiModelProperty(required = true, value = "Código de retorno da aplicação")
  @JsonProperty("code")
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  
  /**
   * Código de retorno do protocólo HTTP
   **/
  @ApiModelProperty(value = "Código de retorno do protocólo HTTP")
  @JsonProperty("httpStatus")
  public String getHttpStatus() {
    return httpStatus;
  }
  public void setHttpStatus(String httpStatus) {
    this.httpStatus = httpStatus;
  }

  
  /**
   * Tipo do erro
   **/
  @ApiModelProperty(required = true, value = "Tipo do erro")
  @JsonProperty("type")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  
  /**
   * Descrição do erro
   **/
  @ApiModelProperty(required = true, value = "Descrição do erro")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  
  /**
   * Identificador do seller item que originou o problema
   **/
  @ApiModelProperty(value = "Identificador do seller item que originou o problema")
  @JsonProperty("skuSellerId")
  public String getSkuSellerId() {
    return skuSellerId;
  }
  public void setSkuSellerId(String skuSellerId) {
    this.skuSellerId = skuSellerId;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  httpStatus: ").append(httpStatus).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
