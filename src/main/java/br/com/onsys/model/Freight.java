package br.com.onsys.model;


import java.util.Date;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Freight  {
  
  private Double actualAmount = null;
  private Double chargedAmount = null;
  private Integer transitTime = null;
  private Integer crossDockingTime = null;
  private String additionalInfo = null;
  public enum TypeEnum {
     NOR,  EXP,  AGE, 
  };
  private TypeEnum type = null;
  private Date scheduledAt = null;
  public enum ScheduledPeriodEnum {
     MANHÃ,  TARDE,  NOITE, 
  };
  private ScheduledPeriodEnum scheduledPeriod = null;

  
  /**
   * Valor nominal do frete (sem descontos e abatimentos, com margem comercial)
   **/
  @ApiModelProperty(required = true, value = "Valor nominal do frete (sem descontos e abatimentos, com margem comercial)")
  @JsonProperty("actualAmount")
  public Double getActualAmount() {
    return actualAmount;
  }
  public void setActualAmount(Double actualAmount) {
    this.actualAmount = actualAmount;
  }

  
  /**
   * Valor cobrado pelo frete
   **/
  @ApiModelProperty(required = true, value = "Valor cobrado pelo frete")
  @JsonProperty("chargedAmount")
  public Double getChargedAmount() {
    return chargedAmount;
  }
  public void setChargedAmount(Double chargedAmount) {
    this.chargedAmount = chargedAmount;
  }

  
  /**
   * Prazo de transporte para entrega do produto em dias úteis
   **/
  @ApiModelProperty(required = true, value = "Prazo de transporte para entrega do produto em dias úteis")
  @JsonProperty("transitTime")
  public Integer getTransitTime() {
    return transitTime;
  }
  public void setTransitTime(Integer transitTime) {
    this.transitTime = transitTime;
  }

  
  /**
   * Tempo de preparação/fabricação do produto em dias. Esse tempo é incluído no cálculo de frete.
   **/
  @ApiModelProperty(required = true, value = "Tempo de preparação/fabricação do produto em dias. Esse tempo é incluído no cálculo de frete.")
  @JsonProperty("crossDockingTime")
  public Integer getCrossDockingTime() {
    return crossDockingTime;
  }
  public void setCrossDockingTime(Integer crossDockingTime) {
    this.crossDockingTime = crossDockingTime;
  }

  
  /**
   * Informações adicionais sobre a entrega. Pode ser utilizado para informar o nome da transportadora, por exemplo
   **/
  @ApiModelProperty(required = true, value = "Informações adicionais sobre a entrega. Pode ser utilizado para informar o nome da transportadora, por exemplo")
  @JsonProperty("additionalInfo")
  public String getAdditionalInfo() {
    return additionalInfo;
  }
  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  
  /**
   * Tipo de frete
   **/
  @ApiModelProperty(value = "Tipo de frete")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

  
  /**
   * Data de agendamento da entrega
   **/
  @ApiModelProperty(value = "Data de agendamento da entrega")
  @JsonProperty("scheduledAt")
  public Date getScheduledAt() {
    return scheduledAt;
  }
  public void setScheduledAt(Date scheduledAt) {
    this.scheduledAt = scheduledAt;
  }

  
  /**
   * Período que a entrega foi agendada
   **/
  @ApiModelProperty(value = "Período que a entrega foi agendada")
  @JsonProperty("scheduledPeriod")
  public ScheduledPeriodEnum getScheduledPeriod() {
    return scheduledPeriod;
  }
  public void setScheduledPeriod(ScheduledPeriodEnum scheduledPeriod) {
    this.scheduledPeriod = scheduledPeriod;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Freight {\n");
    
    sb.append("  actualAmount: ").append(actualAmount).append("\n");
    sb.append("  chargedAmount: ").append(chargedAmount).append("\n");
    sb.append("  transitTime: ").append(transitTime).append("\n");
    sb.append("  crossDockingTime: ").append(crossDockingTime).append("\n");
    sb.append("  additionalInfo: ").append(additionalInfo).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  scheduledAt: ").append(scheduledAt).append("\n");
    sb.append("  scheduledPeriod: ").append(scheduledPeriod).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
