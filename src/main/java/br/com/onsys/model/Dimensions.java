package br.com.onsys.model;



import io.swagger.annotations.*;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Dimensions implements Serializable {
  
 
  private static final long serialVersionUID = 1L;
  
  private Double weight = null;
  private Double length = null;
  private Double width = null;
  private Double height = null;

  
  /**
   * Peso do produto, em quilos. Não pode ser 0 (zero) e deve ter no máximo duas casas decimais
   **/
  @ApiModelProperty(value = "Peso do produto, em quilos. Não pode ser 0 (zero) e deve ter no máximo duas casas decimais")
  @JsonProperty("weight")
  public Double getWeight() {
    return weight;
  }
  public void setWeight(Double weight) {
    this.weight = weight;
  }

  
  /**
   * Comprimento do produto, em metros. Não pode ser 0 (zero) e deve ter no máximo duas casas decimais
   **/
  @ApiModelProperty(value = "Comprimento do produto, em metros. Não pode ser 0 (zero) e deve ter no máximo duas casas decimais")
  @JsonProperty("length")
  public Double getLength() {
    return length;
  }
  public void setLength(Double length) {
    this.length = length;
  }

  
  /**
   * Largura do produto, em metros. Não pode ser 0 (zero) e deve ter no máximo duas casas decimais
   **/
  @ApiModelProperty(value = "Largura do produto, em metros. Não pode ser 0 (zero) e deve ter no máximo duas casas decimais")
  @JsonProperty("width")
  public Double getWidth() {
    return width;
  }
  public void setWidth(Double width) {
    this.width = width;
  }

  
  /**
   * Altura do produto, em metros. Não pode ser 0 (zero) e deve ter no máximo duas casas decimais
   **/
  @ApiModelProperty(value = "Altura do produto, em metros. Não pode ser 0 (zero) e deve ter no máximo duas casas decimais")
  @JsonProperty("height")
  public Double getHeight() {
    return height;
  }
  public void setHeight(Double height) {
    this.height = height;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Dimensions {\n");
    
    sb.append("  weight: ").append(weight).append("\n");
    sb.append("  length: ").append(length).append("\n");
    sb.append("  width: ").append(width).append("\n");
    sb.append("  height: ").append(height).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
