package backend.servlet;

import java.net.UnknownHostException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.mongodb.Mongo;

import backend.core.Dictonary;
import backend.core.PropertiesMgr;
import backend.db.GameHelper;
import backend.db.PlayerHelper;
import backend.db.RaceHelper;
import backend.db.TechHelper;

/**
 * Servlet implementation class Init
 */
@WebServlet(asyncSupported = true, loadOnStartup=0,  urlPatterns = { "/Init" })
public class Init extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Init() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		Dictonary dic = new Dictonary();
		PropertiesMgr propMgr = new PropertiesMgr("default", config.getServletContext().getRealPath("/"));
		PropertiesMgr dbProp = new PropertiesMgr("tiedb", config.getServletContext().getRealPath("/"));
		String error = "";
		Mongo instance = null;
		
		try{
			instance = new Mongo(dbProp.getKey("db.hostname"), new Integer(dbProp.getKey("db.port")));
		}catch(UnknownHostException e){
			error = "No Connection to Database!!!";
			System.out.println(error);
			System.out.println("ErrorMeldung" + e.getMessage());
		}
		dic.put(TechHelper.QualifiedName, new TechHelper(dic));
		dic.put(PlayerHelper.QualifiedName, new PlayerHelper(dic));
		dic.put(RaceHelper.QualifiedName, new RaceHelper(dic));
		dic.put(GameHelper.QualifiedName, new GameHelper(dic));
		dic.put("dbName", dbProp.getKey("db.mainDB"));
		dic.put("colName", dbProp.getKey("db.mainCollection"));
		dic.put("currentDB", instance.getDB((String) dic.get("dbName"))); 
		dic.put("Mongo", instance);
		dic.put("ServerPath", config.getServletContext().getRealPath("/"));
		dic.put("ServerContextPath", config.getServletContext().getContextPath());
		dic.put(PropertiesMgr.QualifiedName, propMgr);
		dic.put("dbProp", dbProp);
		
		//Push Dictonary into the Servletcontext
		config.getServletContext().setAttribute(Dictonary.QualifiedName, dic);
	}

}
