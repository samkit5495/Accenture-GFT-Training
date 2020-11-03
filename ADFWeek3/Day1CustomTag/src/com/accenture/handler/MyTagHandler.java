package com.accenture.handler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class MyTagHandler extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			pageContext.getOut().println("Custom Tag is open");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return SKIP_BODY;
		return EVAL_BODY_AGAIN;
	}
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		try {
			pageContext.getOut().println("Custom Tag is closed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return SKIP_BODY;
		return SKIP_PAGE;
	}
}
