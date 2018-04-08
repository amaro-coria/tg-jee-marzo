
package net.tecgurus.catservice._1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para cat_gral_data complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="cat_gral_data">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_cat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id_est_cat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="desc_cort" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="desc_comp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cat_gral_data", propOrder = {
    "idCat",
    "idEstCat",
    "descCort",
    "descComp"
})
public class CatGralData {

    @XmlElement(name = "id_cat")
    protected int idCat;
    @XmlElement(name = "id_est_cat")
    protected int idEstCat;
    @XmlElement(name = "desc_cort", required = true)
    protected String descCort;
    @XmlElement(name = "desc_comp", required = true)
    protected String descComp;

    /**
     * Obtiene el valor de la propiedad idCat.
     * 
     */
    public int getIdCat() {
        return idCat;
    }

    /**
     * Define el valor de la propiedad idCat.
     * 
     */
    public void setIdCat(int value) {
        this.idCat = value;
    }

    /**
     * Obtiene el valor de la propiedad idEstCat.
     * 
     */
    public int getIdEstCat() {
        return idEstCat;
    }

    /**
     * Define el valor de la propiedad idEstCat.
     * 
     */
    public void setIdEstCat(int value) {
        this.idEstCat = value;
    }

    /**
     * Obtiene el valor de la propiedad descCort.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescCort() {
        return descCort;
    }

    /**
     * Define el valor de la propiedad descCort.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescCort(String value) {
        this.descCort = value;
    }

    /**
     * Obtiene el valor de la propiedad descComp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescComp() {
        return descComp;
    }

    /**
     * Define el valor de la propiedad descComp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescComp(String value) {
        this.descComp = value;
    }

}
