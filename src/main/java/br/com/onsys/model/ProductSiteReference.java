package br.com.onsys.model;


import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ProductSiteReference  {
  
  private String id = null;
  private String href = null;
  private String site = null;

  
  /**
   * ID do produto
   **/
  @ApiModelProperty(required = true, value = "ID do produto")
  @JsonProperty("id")
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  
  /**
   * Link do produto no site
   **/
  @ApiModelProperty(required = true, value = "Link do produto no site")
  @JsonProperty("href")
  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }

  
  /**
   * Site no qual o produto está disponível. Os possíveis sites são: 'EX', 'PF', 'CB', 'EH', 'BT', 'CD'. Consulte a lista completa de sites disponíveis no serviço <a href='#!/sites' target='_blank'><strong>GET /sites</strong></a>
   **/
  @ApiModelProperty(required = true, value = "Site no qual o produto está disponível. Os possíveis sites são: 'EX', 'PF', 'CB', 'EH', 'BT', 'CD'. Consulte a lista completa de sites disponíveis no serviço <a href='#!/sites' target='_blank'><strong>GET /sites</strong></a>")
  @JsonProperty("site")
  public String getSite() {
    return site;
  }
  public void setSite(String site) {
    this.site = site;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductSiteReference {\n");
    
    sb.append("  id: ").append(id).append("\n");
    sb.append("  href: ").append(href).append("\n");
    sb.append("  site: ").append(site).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
