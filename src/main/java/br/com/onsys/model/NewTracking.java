package br.com.onsys.model;

import java.util.Date;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class NewTracking  {
  
  private List<String> items = new ArrayList<String>() ;
  private Date occurredAt = null;
  private String url = null;
  private String number = null;
  private String sellerDeliveryId = null;
  private String cte = null;
  private Carrier carrier = null;
  private Invoice invoice = null;

  
  /**
   * Lista de Order IDs dos produtos comprados no pedido e que irão ser atualizados pela operação de tracking
   **/
  @ApiModelProperty(required = true, value = "Lista de Order IDs dos produtos comprados no pedido e que irão ser atualizados pela operação de tracking")
  @JsonProperty("items")
  public List<String> getItems() {
    return items;
  }
  public void setItems(List<String> items) {
    this.items = items;
  }

  
  /**
   * Data da ocorrência
   **/
  @ApiModelProperty(required = true, value = "Data da ocorrência")
  @JsonProperty("occurredAt")
  public Date getOccurredAt() {
    return occurredAt;
  }
  public void setOccurredAt(Date occurredAt) {
    this.occurredAt = occurredAt;
  }

  
  /**
   * Url para consulta na transportadora
   **/
  @ApiModelProperty(required = true, value = "Url para consulta na transportadora")
  @JsonProperty("url")
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }

  
  /**
   * ID do objeto na transportadora
   **/
  @ApiModelProperty(value = "ID do objeto na transportadora")
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }
  public void setNumber(String number) {
    this.number = number;
  }

  
  /**
   * ID de entrega do Lojista. Esse ID deve ser único para um pedido, não podendo haver repetição entre pedidos
   **/
  @ApiModelProperty(required = true, value = "ID de entrega do Lojista. Esse ID deve ser único para um pedido, não podendo haver repetição entre pedidos")
  @JsonProperty("sellerDeliveryId")
  public String getSellerDeliveryId() {
    return sellerDeliveryId;
  }
  public void setSellerDeliveryId(String sellerDeliveryId) {
    this.sellerDeliveryId = sellerDeliveryId;
  }

  
  /**
   * Conhecimento do Transporte Eletrônico
   **/
  @ApiModelProperty(value = "Conhecimento do Transporte Eletrônico")
  @JsonProperty("cte")
  public String getCte() {
    return cte;
  }
  public void setCte(String cte) {
    this.cte = cte;
  }

  
  /**
   * Informações sobre a transportadora
   **/
  @ApiModelProperty(required = true, value = "Informações sobre a transportadora")
  @JsonProperty("carrier")
  public Carrier getCarrier() {
    return carrier;
  }
  public void setCarrier(Carrier carrier) {
    this.carrier = carrier;
  }

  
  /**
   * Informações sobre a Nota Fiscal da compra
   **/
  @ApiModelProperty(required = true, value = "Informações sobre a Nota Fiscal da compra")
  @JsonProperty("invoice")
  public Invoice getInvoice() {
    return invoice;
  }
  public void setInvoice(Invoice invoice) {
    this.invoice = invoice;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewTracking {\n");
    
    sb.append("  items: ").append(items).append("\n");
    sb.append("  occurredAt: ").append(occurredAt).append("\n");
    sb.append("  url: ").append(url).append("\n");
    sb.append("  number: ").append(number).append("\n");
    sb.append("  sellerDeliveryId: ").append(sellerDeliveryId).append("\n");
    sb.append("  cte: ").append(cte).append("\n");
    sb.append("  carrier: ").append(carrier).append("\n");
    sb.append("  invoice: ").append(invoice).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
