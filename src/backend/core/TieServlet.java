package backend.core;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import backend.core.interfaces.ExtendedServlet;
import backend.db.GameHelper;
import backend.db.RaceHelper;
import backend.db.TechHelper;
import backend.rapi.ResponseObject;

public abstract class TieServlet extends HttpServlet implements ExtendedServlet {

	/**
	 * 
	 */
	
	public final static String titleAttribute = "title";
	public final static String templateAttriube = "template";
	public final static String loginState = "loginState";
	public final static String gameId = "gameId";
	private Dictonary dic = null;
	private PropertiesMgr prop = null;
	private TechHelper techhelper = null;
	private RaceHelper racehelper = null;
	private GameHelper gamehelper = null;
	protected ResponseObject resp = null;
	private static final long serialVersionUID = -9002259634934825019L;
	
	public Dictonary getDictonary() {
		if(dic != null) {
			return dic;
		}else {
			dic = (Dictonary) this.getServletContext().getAttribute(Dictonary.QualifiedName);
			
			return dic;
		}
	}
	
	public GameHelper getGameHelper() {
		if(gamehelper != null) {
			return gamehelper;
		}else {
			gamehelper = (GameHelper) this.getDictonary().get(GameHelper.QualifiedName);
			return gamehelper;
		}
	}
	
	public TechHelper getTechHelper() {
		if(techhelper != null) {
			return techhelper;
		}else {
			techhelper = (TechHelper) this.getDictonary().get(TechHelper.QualifiedName);
			return techhelper;
		}
	}
	
	public RaceHelper getRaceHelper() {
		if(racehelper == null){
			racehelper = (RaceHelper) this.getDictonary().get(RaceHelper.QualifiedName);
		}
		
		return racehelper;
	}
	
	@Override
	public void init() {
		this.getProperties();
		this.getDictonary();
		this.getTechHelper();
		this.resp = new ResponseObject();
	}
	
	public void setDictonaryValue(String key, Object value) {
		Dictonary d = this.getDictonary();
		
		d.put(key, value);
		
		updateDiconary(d);
	}
	
	private void updateDiconary(Dictonary dic) {
		this.dic = dic;
		
		this.getServletContext().setAttribute(Dictonary.QualifiedName, dic);
	}
	
	public PropertiesMgr getProperties() {
		if(prop != null) {
			return prop;
		}else {
			prop = (PropertiesMgr) this.getDictonary().get(PropertiesMgr.QualifiedName);
			return prop;
		}
	}
	
	public void setTemplate(String template, HttpServletRequest request) {
		PropertiesMgr prop = this.getProperties();
		
		request.setAttribute(titleAttribute, prop.getKey("tie." + template + ".title"));
		request.setAttribute(templateAttriube, template);
	}
	
	public void setDispatcher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("appframe.jsp").forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(this.checkAuthenticationState(request)) {
			this.setDefaultParameter(request, response);
			this.handleRequest(request, response);	
		}else {
			response.sendRedirect("/tie/Start");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(this.checkAuthenticationState(request)) {
			this.setDefaultParameter(request, response);
			this.handleRequest(request, response);	
		}else {
			response.sendRedirect("/tie/Start");
		}
	}
	
	private Boolean checkAuthenticationState(HttpServletRequest request) {
		
		if(this.getRequiredAuthenticationMethod().equals(Authentication.None)) {
			return Boolean.TRUE;
		}else {
			HttpSession session = request.getSession(true);
			
			Authentication loginState = (Authentication) session.getAttribute(TieServlet.loginState);
			
			if(loginState != null) {
				return loginState.equals(this.getRequiredAuthenticationMethod());
			}else {
				return Boolean.FALSE;
			}
		}
	}
	
	protected void putObjectToResponse(HttpServletResponse response, Object obj) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		Writer writer = response.getWriter();
		
		writer.write(mapper.writeValueAsString(obj));
		response.setStatus(200);
		
	}

}
