package br.com.onsys.model;


import java.util.Date;
import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class OrderStatusNew  {
  
  private String id = null;
  private String orderSiteId = null;
  private String site = null;
  private Integer paymentType = null;
  private Date purchasedAt = null;
  private Date approvedAt = null;
  private Date updatedAt = null;
  private String status = null;
  private Double totalAmount = null;
  private Double totalDiscountAmount = null;
  private BillingAddress billing = null;
  private Customer customer = null;
  private Freight freight = null;
  private List<OrderItem> items = new ArrayList<OrderItem>() ;
  private List<Tracking> trackings = new ArrayList<Tracking>() ;
  private Seller seller = null;

  
  /**
   * ID do pedido gerado para o lojista
   **/
  @ApiModelProperty(required = true, value = "ID do pedido gerado para o lojista")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * ID do pedido gerado no site e que é passado ao cliente
   **/
  @ApiModelProperty(required = true, value = "ID do pedido gerado no site e que é passado ao cliente")
  @JsonProperty("orderSiteId")
  public String getOrderSiteId() {
    return orderSiteId;
  }
  public void setOrderSiteId(String orderSiteId) {
    this.orderSiteId = orderSiteId;
  }

  
  /**
   * Site para o qual o pedido foi criado. Consulte a lista completa de sites disponíveis no serviço <a href='#!/sites' target='_blank'><strong>GET /sites</strong></a>
   **/
  @ApiModelProperty(required = true, value = "Site para o qual o pedido foi criado. Consulte a lista completa de sites disponíveis no serviço <a href='#!/sites' target='_blank'><strong>GET /sites</strong></a>")
  @JsonProperty("site")
  public String getSite() {
    return site;
  }
  public void setSite(String site) {
    this.site = site;
  }

  
  /**
   * Código do meio de pagamento. Consulte todos os tipos de pagamento disponíveis em <a href='#!/orders/getOrderByIdV2_get_0' target='_blank'><strong>GET /orders/{orderId}</strong></a>
   **/
  @ApiModelProperty(required = true, value = "Código do meio de pagamento. Consulte todos os tipos de pagamento disponíveis em <a href='#!/orders/getOrderByIdV2_get_0' target='_blank'><strong>GET /orders/{orderId}</strong></a>")
  @JsonProperty("paymentType")
  public Integer getPaymentType() {
    return paymentType;
  }
  public void setPaymentType(Integer paymentType) {
    this.paymentType = paymentType;
  }

  
  /**
   * Data da compra
   **/
  @ApiModelProperty(required = true, value = "Data da compra")
  @JsonProperty("purchasedAt")
  public Date getPurchasedAt() {
    return purchasedAt;
  }
  public void setPurchasedAt(Date purchasedAt) {
    this.purchasedAt = purchasedAt;
  }

  
  /**
   * Data de aprovação de pagamento do pedido
   **/
  @ApiModelProperty(value = "Data de aprovação de pagamento do pedido")
  @JsonProperty("approvedAt")
  public Date getApprovedAt() {
    return approvedAt;
  }
  public void setApprovedAt(Date approvedAt) {
    this.approvedAt = approvedAt;
  }

  
  /**
   * Última data de atualização do pedido
   **/
  @ApiModelProperty(required = true, value = "Última data de atualização do pedido")
  @JsonProperty("updatedAt")
  public Date getUpdatedAt() {
    return updatedAt;
  }
  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  
  /**
   * Status atual do pedido
   **/
  @ApiModelProperty(required = true, value = "Status atual do pedido")
  @JsonProperty("status")
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  
  /**
   * Total do pedido
   **/
  @ApiModelProperty(required = true, value = "Total do pedido")
  @JsonProperty("totalAmount")
  public Double getTotalAmount() {
    return totalAmount;
  }
  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  
  /**
   * Total de descontos do pedido
   **/
  @ApiModelProperty(required = true, value = "Total de descontos do pedido")
  @JsonProperty("totalDiscountAmount")
  public Double getTotalDiscountAmount() {
    return totalDiscountAmount;
  }
  public void setTotalDiscountAmount(Double totalDiscountAmount) {
    this.totalDiscountAmount = totalDiscountAmount;
  }

  
  /**
   * Informações de cobrança
   **/
  @ApiModelProperty(required = true, value = "Informações de cobrança")
  @JsonProperty("billing")
  public BillingAddress getBilling() {
    return billing;
  }
  public void setBilling(BillingAddress billing) {
    this.billing = billing;
  }

  
  /**
   * Informações do cliente
   **/
  @ApiModelProperty(required = true, value = "Informações do cliente")
  @JsonProperty("customer")
  public Customer getCustomer() {
    return customer;
  }
  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  
  /**
   * Informações de frete do pedido
   **/
  @ApiModelProperty(required = true, value = "Informações de frete do pedido")
  @JsonProperty("freight")
  public Freight getFreight() {
    return freight;
  }
  public void setFreight(Freight freight) {
    this.freight = freight;
  }

  
  /**
   * Lista de itens do pedido
   **/
  @ApiModelProperty(required = true, value = "Lista de itens do pedido")
  @JsonProperty("items")
  public List<OrderItem> getItems() {
    return items;
  }
  public void setItems(List<OrderItem> items) {
    this.items = items;
  }

  
  /**
   * Informações de tracking do pedido
   **/
  @ApiModelProperty(required = true, value = "Informações de tracking do pedido")
  @JsonProperty("trackings")
  public List<Tracking> getTrackings() {
    return trackings;
  }
  public void setTrackings(List<Tracking> trackings) {
    this.trackings = trackings;
  }

  
  /**
   * Informações de venda
   **/
  @ApiModelProperty(value = "Informações de venda")
  @JsonProperty("seller")
  public Seller getSeller() {
    return seller;
  }
  public void setSeller(Seller seller) {
    this.seller = seller;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderStatusNew {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  orderSiteId: ").append(orderSiteId).append("\n");
    sb.append("  site: ").append(site).append("\n");
    sb.append("  paymentType: ").append(paymentType).append("\n");
    sb.append("  purchasedAt: ").append(purchasedAt).append("\n");
    sb.append("  approvedAt: ").append(approvedAt).append("\n");
    sb.append("  updatedAt: ").append(updatedAt).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  totalAmount: ").append(totalAmount).append("\n");
    sb.append("  totalDiscountAmount: ").append(totalDiscountAmount).append("\n");
    sb.append("  billing: ").append(billing).append("\n");
    sb.append("  customer: ").append(customer).append("\n");
    sb.append("  freight: ").append(freight).append("\n");
    sb.append("  items: ").append(items).append("\n");
    sb.append("  trackings: ").append(trackings).append("\n");
    sb.append("  seller: ").append(seller).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
