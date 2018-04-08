package net.tecgurus.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.sql.Timestamp;
import java.text.MessageFormat;
import java.util.Calendar;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created by Amaro on 02/06/2017.
 */
public class GenericMB {
    private ResourceBundle rb;

    /**
     * Default constructor. Finds the related resource bundle
     */
    public GenericMB() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        rb = facesContext.getApplication().getResourceBundle(facesContext, "msg");
    }

    /**
     * Finds the message based on its id
     * @param messageID
     * @return
     */
    protected String getBundleMessage(String messageID){
        try{
            return rb.getString(messageID);
        }catch (MissingResourceException e) {
            return "text = ?? key " + messageID + " not found ??";
        }
    }


    /**
     * Returns the faces context
     */
    public FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Set an info message in the Faces Context with parameters
     *
     * @param messageID
     *            message id
     * @param params
     *            message parameters
     */
    protected void addInfoMessage(String messageID, Object[] params) {
        addMessage(FacesMessage.SEVERITY_INFO, messageID, params);
    }

    /**
     * Set an info message in the Faces Context
     *
     * @param messageID
     *            message id
     */
    protected void addInfoMessage(String messageID) {
        addMessage(FacesMessage.SEVERITY_INFO, messageID);
    }

    /**
     * Adds info message
     * @param summary
     * @param detail
     */
    protected void addInfoMessage(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    }

    /**
     * Set an info message in the Faces Context with parameters
     *
     * @param messageID
     *            message id
     * @param params
     *            message parameters
     */
    protected void addWarningMessage(String messageID, Object[] params) {
        addMessage(FacesMessage.SEVERITY_WARN, messageID, params);
    }

    /**
     * Set an info message in the Faces Context
     *
     * @param messageID
     *            message id
     */
    protected void addWarningMessage(String messageID) {
        addMessage(FacesMessage.SEVERITY_WARN, messageID);
    }

    /**
     * Adds warning message
     * @param summary
     * @param detail
     */
    protected void addWarningMessage(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_WARN, summary, detail);
    }

    /**
     * Set an error message with parameters in the Faces Context
     *
     * @param messageID
     * @param params
     */
    protected void addErrorMessage(String messageID, Object[] params) {
        addMessage(FacesMessage.SEVERITY_ERROR, messageID, params);
    }

    /**
     * Adds error message
     * @param summary
     * @param detail
     */
    protected void addErrorMessage(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
    }

    /**
     * Set an error message without parameters in the Faces Context
     *
     * @param messageID
     */
    protected void addErrorMessage(String messageID) {
        addMessage(FacesMessage.SEVERITY_ERROR, messageID);
    }

    /**
     * Adds message
     * @param severidad
     * @param summary
     * @param detail
     */
    private void addMessage(FacesMessage.Severity severidad, String summary, String detail) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(severidad);
        String summary_ = getBundleMessage(summary);
        message.setSummary(summary_);
        String detail_ = getBundleMessage(detail);
        message.setDetail(detail_);
        getFacesContext().addMessage(null, message);
    }

    /**
     * Adds message
     * @param severidad
     * @param messageID
     */
    private void addMessage(FacesMessage.Severity severidad, String messageID) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(severidad);
        String summary_ = getBundleMessage(messageID);
        message.setSummary(summary_);
        getFacesContext().addMessage(null, message);
    }

    /**
     * Add message in Faces Context
     *
     * @param severidad
     * @param messageID
     * @param params
     */
    private void addMessage(FacesMessage.Severity severidad, String messageID,
                            Object[] params) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(severidad);
        String summary_ = getMessage(messageID, params);
        message.setSummary(summary_);
        getFacesContext().addMessage(null, message);
    }

    /**
     *
     * Add Message in Faces Context only summary and detail
     *
     * @param messageSummary
     * @param messageDetail
     */
    protected void addMesage(String messageSummary, String messageDetail){
        getFacesContext().addMessage(null,
                new FacesMessage(messageSummary, messageDetail));
    }


    /**
     * Get message value from bundle resources without parameters
     *
     * @param messageID
     * @return
     */
    protected String getMessage(String messageID) {
        return getMessage(messageID, null);
    }

    /**
     * Get message value from bundle resources with parameters
     *
     * @param messageId
     * @param params
     * @return
     */
    public String getMessage(String messageId, Object[] params) {

        String text;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            text = rb.getString(messageId);

            if (params != null) {
                MessageFormat mf = new MessageFormat(text, context
                        .getViewRoot().getLocale());
                text = mf.format(params, new StringBuffer(), null).toString();
            }

        } catch (MissingResourceException e) {
            text = "?? key " + messageId + " not found ??";
        }
        return text;
    }

    /**
     * Return a class loader. A class loader is an object that is responsible
     * for loading classes.
     *
     * @param defaultObject
     * @return
     */
    protected static ClassLoader getCurrentClassLoader(Object defaultObject) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = defaultObject.getClass().getClassLoader();
        }
        return loader;
    }


    /**
     * Returns the timestamp according to the current timezone
     * @return
     */
    protected Timestamp now(){
        return new Timestamp(Calendar.getInstance().getTime()
                .getTime());
    }


    /**
     * @return the rb
     */
    public ResourceBundle getRb() {
        return rb;
    }
    /**
     * @param rb the rb to set
     */
    public void setRb(ResourceBundle rb) {
        this.rb = rb;
    }


}