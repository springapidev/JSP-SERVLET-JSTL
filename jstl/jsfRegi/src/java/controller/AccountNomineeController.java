package controller;

import entity.AccountNominee;
import controller.util.JsfUtil;
import controller.util.JsfUtil.PersistAction;
import entity.AccountNomineeFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("accountNomineeController")
@SessionScoped
public class AccountNomineeController implements Serializable {

    @EJB
    private entity.AccountNomineeFacade ejbFacade;
    private List<AccountNominee> items = null;
    private AccountNominee selected;

    public AccountNomineeController() {
    }

    public AccountNominee getSelected() {
        return selected;
    }

    public void setSelected(AccountNominee selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
        selected.setAccountNomineePK(new entity.AccountNomineePK());
    }

    private AccountNomineeFacade getFacade() {
        return ejbFacade;
    }

    public AccountNominee prepareCreate() {
        selected = new AccountNominee();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AccountNomineeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AccountNomineeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AccountNomineeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AccountNominee> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public AccountNominee getAccountNominee(entity.AccountNomineePK id) {
        return getFacade().find(id);
    }

    public List<AccountNominee> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AccountNominee> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AccountNominee.class)
    public static class AccountNomineeControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AccountNomineeController controller = (AccountNomineeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "accountNomineeController");
            return controller.getAccountNominee(getKey(value));
        }

        entity.AccountNomineePK getKey(String value) {
            entity.AccountNomineePK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entity.AccountNomineePK();
            key.setAccountId(Long.parseLong(values[0]));
            key.setNomineeId(Long.parseLong(values[1]));
            return key;
        }

        String getStringKey(entity.AccountNomineePK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getAccountId());
            sb.append(SEPARATOR);
            sb.append(value.getNomineeId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof AccountNominee) {
                AccountNominee o = (AccountNominee) object;
                return getStringKey(o.getAccountNomineePK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AccountNominee.class.getName()});
                return null;
            }
        }

    }

}
