
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
 *         &lt;element name="data_dummy" type="{http://www.tecgurus.net/catService/1.0}baja_datos_dummy"/>
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
    "dataDummy"
})
@XmlRootElement(name = "cat_gral_baja_request")
public class CatGralBajaRequest {

    @XmlElement(name = "data_dummy", required = true)
    protected BajaDatosDummy dataDummy;

    /**
     * Obtiene el valor de la propiedad dataDummy.
     * 
     * @return
     *     possible object is
     *     {@link BajaDatosDummy }
     *     
     */
    public BajaDatosDummy getDataDummy() {
        return dataDummy;
    }

    /**
     * Define el valor de la propiedad dataDummy.
     * 
     * @param value
     *     allowed object is
     *     {@link BajaDatosDummy }
     *     
     */
    public void setDataDummy(BajaDatosDummy value) {
        this.dataDummy = value;
    }

}
