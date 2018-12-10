package com.apress.projsp;

import java.util.Calendar;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class DateValidator implements Validator {
  public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
    throws ValidatorException {
    Calendar date = Calendar.getInstance();
    date.setTime((Date) arg2);

    Calendar tomorrow = Calendar.getInstance();
    tomorrow.set(Calendar.HOUR, 0);
    tomorrow.set(Calendar.MINUTE, 0);
    tomorrow.set(Calendar.SECOND, 0);

    Calendar oneYear = Calendar.getInstance();
    oneYear.set(Calendar.HOUR, 0);
    oneYear.set(Calendar.MINUTE, 0);
    oneYear.set(Calendar.SECOND, 0);
    oneYear.add(Calendar.YEAR, 1);

    if (date.before(tomorrow) || date.after(oneYear)) {
      FacesMessage message =
        new FacesMessage(
          FacesMessage.SEVERITY_ERROR,
          "Date Error",
          "Date must be between tomorrow and one year from today");
      throw new ValidatorException(message);
    }
  }
}
