<%@ page import="java.util.Collection,backend.rapi.TechnologieRO,java.util.Iterator" %>

<%
	Object listOBj = request.getAttribute("techlist");
	Collection<TechnologieRO> col = null;
	Iterator<TechnologieRO> iter = null;
	
	if(listOBj instanceof Collection<?>) {
		col = (Collection<TechnologieRO>) listOBj;
		iter = col.iterator();
	}
	
	
	while(iter.hasNext()) {
		TechnologieRO tech=  iter.next();
%>
			<div class="cb-container">
				<input type="checkbox" id="tech-<%=tech.getTechId() %>" class="precondition-cb" data-uuid="<%=tech.getTechId() %>">
				<label for="tech-<%=tech.getTechId() %>"><%=tech.getTechName() %></label>
			</div>
<%
	}
%>