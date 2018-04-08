
package net.tecgurus.catservice._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="audit_data" type="{http://www.tecgurus.net/catService/1.0}audit_data"/>
 *         &lt;element name="cata_data" type="{http://www.tecgurus.net/catService/1.0}cat_gral_data"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "auditData",
    "cataData"
})
@XmlRootElement(name = "cat_gral_modi_request")
public class CatGralModiRequest {

    @XmlElement(name = "audit_data", required = true)
    protected AuditData auditData;
    @XmlElement(name = "cata_data", required = true)
    protected CatGralData cataData;

    /**
     * Obtiene el valor de la propiedad auditData.
     * 
     * @return
     *     possible object is
     *     {@link AuditData }
     *     
     */
    public AuditData getAuditData() {
        return auditData;
    }

    /**
     * Define el valor de la propiedad auditData.
     * 
     * @param value
     *     allowed object is
     *     {@link AuditData }
     *     
     */
    public void setAuditData(AuditData value) {
        this.auditData = value;
    }

    /**
     * Obtiene el valor de la propiedad cataData.
     * 
     * @return
     *     possible object is
     *     {@link CatGralData }
     *     
     */
    public CatGralData getCataData() {
        return cataData;
    }

    /**
     * Define el valor de la propiedad cataData.
     * 
     * @param value
     *     allowed object is
     *     {@link CatGralData }
     *     
     */
    public void setCataData(CatGralData value) {
        this.cataData = value;
    }

}
