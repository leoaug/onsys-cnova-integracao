package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class OrderGiftWrap  {
  
  private Boolean available = null;
  private Double value = null;
  private Boolean messageSupport = null;
  private GiftCard giftCard = null;

  
  /**
   * Flag que indica se existe embrulho para presente para o produto
   **/
  @ApiModelProperty(required = true, value = "Flag que indica se existe embrulho para presente para o produto")
  @JsonProperty("available")
  public Boolean getAvailable() {
    return available;
  }
  public void setAvailable(Boolean available) {
    this.available = available;
  }

  
  /**
   * Valor cobrado pelo embrulho
   **/
  @ApiModelProperty(required = true, value = "Valor cobrado pelo embrulho")
  @JsonProperty("value")
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
  }

  
  /**
   * Flag que indica se é possível incluir uma mensagem
   **/
  @ApiModelProperty(value = "Flag que indica se é possível incluir uma mensagem")
  @JsonProperty("messageSupport")
  public Boolean getMessageSupport() {
    return messageSupport;
  }
  public void setMessageSupport(Boolean messageSupport) {
    this.messageSupport = messageSupport;
  }

  
  /**
   * Mensagem que deverá ser enviada juntamente com o embrulho de presente
   **/
  @ApiModelProperty(value = "Mensagem que deverá ser enviada juntamente com o embrulho de presente")
  @JsonProperty("giftCard")
  public GiftCard getGiftCard() {
    return giftCard;
  }
  public void setGiftCard(GiftCard giftCard) {
    this.giftCard = giftCard;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderGiftWrap {\n");
    
    sb.append("  available: ").append(available).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("  messageSupport: ").append(messageSupport).append("\n");
    sb.append("  giftCard: ").append(giftCard).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
