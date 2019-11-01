package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class NewTicket  {
  
  private String to = null;
  private String body = null;

  
  /**
   * Email do consumidor retornado no pedido
   **/
  @ApiModelProperty(required = true, value = "Email do consumidor retornado no pedido")
  @JsonProperty("to")
  public String getTo() {
    return to;
  }
  public void setTo(String to) {
    this.to = to;
  }

  
  /**
   * Texto da mensagem
   **/
  @ApiModelProperty(required = true, value = "Texto da mensagem")
  @JsonProperty("body")
  public String getBody() {
    return body;
  }
  public void setBody(String body) {
    this.body = body;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewTicket {\n");
    
    sb.append("  to: ").append(to).append("\n");
    sb.append("  body: ").append(body).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
