package frontend.tags;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Condition extends SimpleTagSupport {
	
	private String condition;
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	@Override
	public void doTag() throws JspException, IOException {
		
		String[] conditions = condition.split(" ");
		Boolean showBody = Boolean.FALSE;
		
		if(conditions.length  == 0) {
			getJspBody().getJspContext().getOut().write("");
			
		}
		
		if(conditions.length == 1) {
			showBody = Boolean.getBoolean(conditions[0]);
			
			if(showBody) {
				StringWriter sw = new StringWriter();
				
				getJspBody().invoke(sw);
				
				getJspBody().getJspContext().getOut().write(sw.toString());
			}
		}
		
		if(!showBody) {
			PageContext pageContext = (PageContext) getJspContext();
			
			Object operant1 = pageContext.getRequest().getAttribute(conditions[0]);
			Object operant2 = pageContext.getRequest().getAttribute(conditions[2]);
			Boolean eq = conditions[1].equals("EQ");
			if(operant1 instanceof String && operant2 instanceof String) {
				String op1 = operant1.toString();
				String op2 = operant2.toString();
				
				
				showBody = eq ? op1.equals(op2) : !op1.equals(op2);
						
			}else if (operant1 instanceof Integer && operant2 instanceof Integer) {
				Integer op1 = Integer.getInteger(operant1.toString());
				Integer op2 = Integer.getInteger(operant2.toString());
				
				showBody = eq ? op1 == op2 : op1 != op2;
			}else if(operant1 instanceof Double && operant2 instanceof Double) {
				Double op1 = Double.valueOf(operant1.toString());
				Double op2 = Double.valueOf(operant2.toString());
				
				showBody = eq ? op1 == op2 : op1 != op2;
			}
		}
		
		if(showBody) {
			
			StringWriter sw = new StringWriter();
			getJspBody().invoke(sw);
			getJspBody().getJspContext().getOut().write(sw.toString());
		}
		
		super.doTag();
	}

}
