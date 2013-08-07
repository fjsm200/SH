package com.seeyon.v3x.common.taglibs;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.cafuc.mvc.domain.People;

public class TableTag extends TagSupport{
	private People user;

	 

    @Override

    public int doStartTag() throws JspException {

        try {

            JspWriter out = this.pageContext.getOut();

            if(user == null) {

                out.println("No People Found...");

                return SKIP_BODY;

            }

            out.println("<table width='500px' border='1' align='center'>");

            out.println("<tr>");

            out.println("<td width='20%'>Username:</td>");

            out.println("<td>" + user.getName() + "</td>");

            out.println("</tr>");

            out.println("<tr>");

            out.println("<td>passwd:</td>");

            out.println("<td>" + user.getPassword() + "</td>");

            out.println("</tr>");

            out.println("</table>");

        } catch(Exception e) {

            throw new JspException(e.getMessage());

        }

        return SKIP_BODY;

    }

   

    @Override

    public int doEndTag() throws JspException {

        return EVAL_PAGE;

    }

 

    @Override

    public void release() {

        super.release();

        this.user = null;

    }



	public People getUser() {
		return user;
	}



	public void setUser(People user) {
		this.user = user;
	}

   



}
