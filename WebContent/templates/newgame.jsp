
<%@ taglib prefix="tie" uri="../WEB-INF/custom.tld"%>

<div class="headline">
	<tie:prop key="tie.newgame.headline"/>
</div>
<div class="new-game-body">
	<div class="form-row">
			<label for="game-name">
				<tie:prop key="tie.newgame.game" />
			</label>
			<input type="text" name="game-name">
		</div>
		<div class="form-row">
			<label for="game-password">
				<tie:prop key="tie.newgame.pw"/>
			</label>
			<input type="password" name="game-password">
		</div>
		<div class="form-row">
			<label for="game-password-rep">
				<tie:prop key="tie.newgame.pw.repeat"/>
			</label>
			<input type="password" name="game-password-rep">
		</div>
		<div class="form-row">
			<div class="button-container">
				<span class="global-button-1 create-game">
					<tie:prop key="tie.newgame.create"/>
				</span>
			</div>
			<div class="button-container">
				<a href="/tie/Start">
					<tie:prop key="common.back"/>
				</a>
			</div>
		</div>
</div>