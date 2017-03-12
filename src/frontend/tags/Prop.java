package frontend.tags;


import javax.servlet.ServletContext;
import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;

import backend.core.Dictonary;
import backend.core.PropertiesMgr;
import backend.core.TieServlet;

import java.io.*;

public class Prop extends TagSupport {
	
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 2046588770511145708L;
	
	private String key;
   
   public void setKey(String key) {
      this.key = key;
   }
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		
		JspWriter out =  pageContext.getOut();
		   PropertiesMgr dbProp = null;
		   Dictonary dic = null;
		   ServletContext con = pageContext.getServletContext();
	       if (key != null) {
		          /* Use message from attribute */

			   if(con.getAttribute("Dictonary") != null){
				   dic = (Dictonary) con.getAttribute(Dictonary.QualifiedName);
				   dbProp = (PropertiesMgr) dic.get(PropertiesMgr.QualifiedName);
			   }
			   
		      String temp = dbProp.getKey(key);
		      if(temp != null){
		    	  if(temp.equals("")){
		    		  try {
						out.print("");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	  }else{
		    		  try {
						out.print(temp);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	  }
		      }else{
		    	  try {
					out.print("");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		      }
	       }    
		
		
		return super.doStartTag();
	}
}
