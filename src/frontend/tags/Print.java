package frontend.tags;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Print extends TagSupport {

	private String value;
	   
	public void setValue(String value) {
	    this.value = value;
	}
	
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		
		String outPut = (String) pageContext.getRequest().getAttribute(value);
		
		if(outPut == null){
			outPut = "";
		}
		JspWriter out =  pageContext.getOut();		
		
		try {
			out.print(outPut);
		} catch (IOException e) {
			System.out.println("Error printing Dic Value :" + e);
		}

		return super.doStartTag();
	}
}
