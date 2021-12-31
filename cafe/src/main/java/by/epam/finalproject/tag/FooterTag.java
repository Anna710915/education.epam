package by.epam.finalproject.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class FooterTag extends TagSupport {

    @Override
    public int doStartTag() throws JspTagException{
        try{
            JspWriter out = pageContext.getOut();
            String tagText = "<footer><p class=\"footer\">© 2021-2022 Copyright by Anna Merkul</p></footer>";
            out.write(tagText);
        } catch (IOException e) {
            throw new JspTagException(e);
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
