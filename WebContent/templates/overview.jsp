<%@page import="java.util.List, backend.rapi.PlayerRO, java.util.Collections, java.util.Iterator,backend.rapi.RaceRO"%>
<%@ taglib prefix="tie" uri="../WEB-INF/custom.tld"%>

<div class="headline-container">
	<h2><tie:prop key="tie.overview.headline"/></h2>
</div>
<%
	Object ob = pageContext.getRequest().getAttribute("players");
	List<PlayerRO> players = null;
	
	if(ob != null) {
		players = (List<PlayerRO>) ob;
		
		Iterator<PlayerRO> iter = players.iterator();
		%>
			<div class="player-container">
				<%
					while(iter.hasNext()) {
						PlayerRO player = iter.next();
						
						%>
							<div class="player-entry">
								<%=player.getPlayerName() %>
							</div>
						<%
					}
				%>
			</div>
		<%
	}
	
	ob = pageContext.getRequest().getAttribute("races");
	List<RaceRO> races = null;
	if(ob != null) {
		races = (List<RaceRO>) ob;
	}else {
		races = Collections.EMPTY_LIST;
	}
	
	Iterator<RaceRO> rIter = races.iterator();
	%>
<div class="no-player-container">
	<%
		if(players == null) {
			%><tie:prop key="tie.overview.noplayers" /><%
		}
	%>
	
	<div class="button-container">
		<span class="add-player-button global-button-1">
			<tie:prop key="tie.addplayer" />
		</span>
	</div>
	
	<div class="add-player-box" style="display: none;">
		<div class="player-entry">
			<label for="player-name"><tie:prop key="tie.overview.player.name.label" /></label>
			<input type="text" name="player-name" maxlength="20" />
			<%
				if(rIter.hasNext()) {
			%>
			<select name="player-race">
				<%
					while(rIter.hasNext()) {
						RaceRO r = rIter.next();
						
				%>
					<option value="<%=r.getRaceId() %>"><%=r.getRaceName() %></option>
				<%
					}
				%>
			</select>
			<%
				}
			%>
			<span class="add-player-link"><tie:prop key="tie.overview.add.player.submit"/></span>
		</div>
	</div>
</div>
	