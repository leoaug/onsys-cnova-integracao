package br.com.onsys.model;


import java.util.*;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class OrderItem  {
  
  private String id = null;
  private String skuSellerId = null;
  private String name = null;
  private Double salePrice = null;
  private Boolean sent = null;
  private Freight freight = null;
  private OrderGiftWrap giftWrap = null;
  private List<Promotion> promotions = new ArrayList<Promotion>() ;

  
  /**
   * ID do item de Pedido
   **/
  @ApiModelProperty(required = true, value = "ID do item de Pedido")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * SKU ID do produto do Lojista
   **/
  @ApiModelProperty(required = true, value = "SKU ID do produto do Lojista")
  @JsonProperty("skuSellerId")
  public String getSkuSellerId() {
    return skuSellerId;
  }
  public void setSkuSellerId(String skuSellerId) {
    this.skuSellerId = skuSellerId;
  }

  
  /**
   * Nome do produto
   **/
  @ApiModelProperty(required = true, value = "Nome do produto")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   * Preço de venda unitário
   **/
  @ApiModelProperty(required = true, value = "Preço de venda unitário")
  @JsonProperty("salePrice")
  public Double getSalePrice() {
    return salePrice;
  }
  public void setSalePrice(Double salePrice) {
    this.salePrice = salePrice;
  }

  
  /**
   * Flag que indica se o produto já foi enviado
   **/
  @ApiModelProperty(required = true, value = "Flag que indica se o produto já foi enviado")
  @JsonProperty("sent")
  public Boolean getSent() {
    return sent;
  }
  public void setSent(Boolean sent) {
    this.sent = sent;
  }

  
  /**
   * Informações sobre o frete do produto
   **/
  @ApiModelProperty(required = true, value = "Informações sobre o frete do produto")
  @JsonProperty("freight")
  public Freight getFreight() {
    return freight;
  }
  public void setFreight(Freight freight) {
    this.freight = freight;
  }

  
  /**
   * Informações de embrulho para presente
   **/
  @ApiModelProperty(value = "Informações de embrulho para presente")
  @JsonProperty("giftWrap")
  public OrderGiftWrap getGiftWrap() {
    return giftWrap;
  }
  public void setGiftWrap(OrderGiftWrap giftWrap) {
    this.giftWrap = giftWrap;
  }

  
  /**
   * Lista de Promoções
   **/
  @ApiModelProperty(value = "Lista de Promoções")
  @JsonProperty("promotions")
  public List<Promotion> getPromotions() {
    return promotions;
  }
  public void setPromotions(List<Promotion> promotions) {
    this.promotions = promotions;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  skuSellerId: ").append(skuSellerId).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  salePrice: ").append(salePrice).append("\n");
    sb.append("  sent: ").append(sent).append("\n");
    sb.append("  freight: ").append(freight).append("\n");
    sb.append("  giftWrap: ").append(giftWrap).append("\n");
    sb.append("  promotions: ").append(promotions).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
