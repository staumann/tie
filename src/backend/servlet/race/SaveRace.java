package backend.servlet.race;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DB;

import backend.core.BackendServlet;
import backend.core.PropertiesMgr;
import backend.rapi.RaceRO;

/**
 * Servlet implementation class SaveRace
 */
@WebServlet("/SaveRace")
public class SaveRace extends BackendServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveRace() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();

		RaceRO raceRO = mapper.readValue(request.getInputStream(), RaceRO.class);
		raceRO.setRaceId(UUID.randomUUID().toString());
		DB cdb = (DB) getDictonary().get("currentDB");
		PropertiesMgr dbProb = (PropertiesMgr) getDictonary().get("dbProp");
		
		
		cdb.getCollection(dbProb.getKey("db.raceCollection")).insert(raceRO);
		
		response.setStatus(200);
		response.getWriter().write("Sucess");
		
	}

}
