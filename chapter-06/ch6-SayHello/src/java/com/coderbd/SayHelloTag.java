package com.coderbd;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SayHelloTag extends SimpleTagSupport {
    
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();        
        getJspContext().getOut().write("Hello, How Are you?");
    }
    
}
