package backend.mgr;

import javax.rmi.CORBA.Tie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import backend.core.TieServlet;
import backend.core.interfaces.ExtendedServlet.Authentication;

public class SessionMgr {

	//We don't want any instance of this Class
	private SessionMgr() {
		
	}
	
	public static HttpSession getSession(HttpServletRequest request) {
		return request.getSession(true);
	}
	
	public static Object getSessionAttribute(String key, HttpServletRequest request) {
		HttpSession session = SessionMgr.getSession(request);
		
		Object returnValue = session.getAttribute(key);
		
		return returnValue;
	}
	
	public static Boolean loginSession(String gameId, HttpServletRequest request, Authentication aut) {
		HttpSession session = SessionMgr.getSession(request);
		
		session.setAttribute(TieServlet.loginState, aut);
		session.setAttribute(TieServlet.gameId, gameId);
		
		return Boolean.TRUE;
	}
	
	public static Boolean isAdmin(HttpServletRequest request) {
		
		Authentication aut = (Authentication) SessionMgr.getSessionAttribute(TieServlet.loginState, request);
		
		return Authentication.Admin.equals(aut);
		
	}
	
	public static void logoutSession(HttpServletRequest request) {
		HttpSession session = SessionMgr.getSession(request);
		
		session.removeAttribute(TieServlet.loginState);
		session.removeAttribute(TieServlet.gameId);
	}
}
