
package net.tecgurus.catservice._1;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="cat_gral_info" type="{http://www.tecgurus.net/catService/1.0}cat_gral_data" maxOccurs="unbounded"/>
 *         &lt;element name="status" type="{http://www.tecgurus.net/catService/1.0}status_response"/>
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
    "catGralInfo",
    "status"
})
@XmlRootElement(name = "cat_gral_response")
public class CatGralResponse {

    @XmlElement(name = "cat_gral_info", required = true)
    protected List<CatGralData> catGralInfo;
    @XmlElement(required = true)
    protected StatusResponse status;

    /**
     * Gets the value of the catGralInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the catGralInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCatGralInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CatGralData }
     * 
     * 
     */
    public List<CatGralData> getCatGralInfo() {
        if (catGralInfo == null) {
            catGralInfo = new ArrayList<CatGralData>();
        }
        return this.catGralInfo;
    }

    /**
     * Obtiene el valor de la propiedad status.
     * 
     * @return
     *     possible object is
     *     {@link StatusResponse }
     *     
     */
    public StatusResponse getStatus() {
        return status;
    }

    /**
     * Define el valor de la propiedad status.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusResponse }
     *     
     */
    public void setStatus(StatusResponse value) {
        this.status = value;
    }

}
