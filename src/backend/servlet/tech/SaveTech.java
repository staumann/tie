package backend.servlet.tech;

import backend.core.BackendServlet;
import backend.core.PropertiesMgr;
import backend.rapi.TechnologieRO;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;

/**
 * Servlet implementation class SaveTech
 */
@WebServlet("/SaveTech")
public class SaveTech extends BackendServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveTech() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();

		TechnologieRO techRO = mapper.readValue(request.getInputStream(), TechnologieRO.class);
		techRO.setTechId(UUID.randomUUID().toString());
		DB cdb = (DB) getDictonary().get("currentDB");
		PropertiesMgr dbProb = (PropertiesMgr) getDictonary().get("dbProp");
		
		
		cdb.getCollection(dbProb.getKey("db.techCollection")).insert(techRO);
		
		response.setStatus(200);
		response.getWriter().write("Sucess");
	}
}
