
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
 *         &lt;element name="response_dummy" type="{http://www.tecgurus.net/catService/1.0}baja_datos_response_dummy"/>
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
    "responseDummy"
})
@XmlRootElement(name = "cat_gral_baja_response")
public class CatGralBajaResponse {

    @XmlElement(name = "response_dummy", required = true)
    protected BajaDatosResponseDummy responseDummy;

    /**
     * Obtiene el valor de la propiedad responseDummy.
     * 
     * @return
     *     possible object is
     *     {@link BajaDatosResponseDummy }
     *     
     */
    public BajaDatosResponseDummy getResponseDummy() {
        return responseDummy;
    }

    /**
     * Define el valor de la propiedad responseDummy.
     * 
     * @param value
     *     allowed object is
     *     {@link BajaDatosResponseDummy }
     *     
     */
    public void setResponseDummy(BajaDatosResponseDummy value) {
        this.responseDummy = value;
    }

}
