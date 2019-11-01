package br.com.onsys.model;



import java.util.Date;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Tracking  {
  
  private List<ItemTracking> items = new ArrayList<ItemTracking>() ;
  private String controlPoint = null;
  private String description = null;
  private Date occurredAt = null;
  private String url = null;
  private String number = null;
  private String sellerDeliveryId = null;
  private String cte = null;
  private Carrier carrier = null;
  private Invoice invoice = null;

  
  /**
   * Lista de itens alterados pela operação de tracking
   **/
  @ApiModelProperty(required = true, value = "Lista de itens alterados pela operação de tracking")
  @JsonProperty("items")
  public List<ItemTracking> getItems() {
    return items;
  }
  public void setItems(List<ItemTracking> items) {
    this.items = items;
  }

  
  /**
   * Status do pedido. Veja o serviço <a href='#!/orders/getOrderByIdV2_get_0' target='_blank'><strong>GET /orders/{orderId}</strong></a> para consultar todos os controlPoits existentes.
   **/
  @ApiModelProperty(required = true, value = "Status do pedido. Veja o serviço <a href='#!/orders/getOrderByIdV2_get_0' target='_blank'><strong>GET /orders/{orderId}</strong></a> para consultar todos os controlPoits existentes.")
  @JsonProperty("controlPoint")
  public String getControlPoint() {
    return controlPoint;
  }
  public void setControlPoint(String controlPoint) {
    this.controlPoint = controlPoint;
  }

  
  /**
   * Descrição adicional sobre tracking
   **/
  @ApiModelProperty(value = "Descrição adicional sobre tracking")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
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
  @ApiModelProperty(value = "Url para consulta na transportadora")
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
   * ID único da entrega para o lojista no parceiro, não pode haver repetição deste ID
   **/
  @ApiModelProperty(required = true, value = "ID único da entrega para o lojista no parceiro, não pode haver repetição deste ID")
  @JsonProperty("sellerDeliveryId")
  public String getSellerDeliveryId() {
    return sellerDeliveryId;
  }
  public void setSellerDeliveryId(String sellerDeliveryId) {
    this.sellerDeliveryId = sellerDeliveryId;
  }

  
  /**
   * Conhecimento de Transporte Eletrônico
   **/
  @ApiModelProperty(value = "Conhecimento de Transporte Eletrônico")
  @JsonProperty("cte")
  public String getCte() {
    return cte;
  }
  public void setCte(String cte) {
    this.cte = cte;
  }

  
  /**
   * Informações sobre transportadora
   **/
  @ApiModelProperty(required = true, value = "Informações sobre transportadora")
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
    sb.append("class Tracking {\n");
    
    sb.append("  items: ").append(items).append("\n");
    sb.append("  controlPoint: ").append(controlPoint).append("\n");
    sb.append("  description: ").append(description).append("\n");
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
