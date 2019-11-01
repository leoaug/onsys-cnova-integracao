package br.com.onsys.model;



import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class GiftCard  {
  
  private String from = null;
  private String to = null;
  private String message = null;

  
  /**
   * Nome de quem está dando o presente
   **/
  @ApiModelProperty(required = true, value = "Nome de quem está dando o presente")
  @JsonProperty("from")
  public String getFrom() {
    return from;
  }
  public void setFrom(String from) {
    this.from = from;
  }

  
  /**
   * Nome de quem irá receber o presente
   **/
  @ApiModelProperty(required = true, value = "Nome de quem irá receber o presente")
  @JsonProperty("to")
  public String getTo() {
    return to;
  }
  public void setTo(String to) {
    this.to = to;
  }

  
  /**
   * Mensagem que deverá ser enviada no cartão juntamente com o embrulho de presente
   **/
  @ApiModelProperty(required = true, value = "Mensagem que deverá ser enviada no cartão juntamente com o embrulho de presente")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class GiftCard {\n");
    
    sb.append("  from: ").append(from).append("\n");
    sb.append("  to: ").append(to).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
