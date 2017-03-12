<%@ taglib prefix="tie" uri="../WEB-INF/custom.tld"%>

<div class="headline">
	<tie:prop key="tie.start.headline"/>
</div>
<div class="start-body">
	<div class="login-form-container">
		<div class="form-row">
			<label for="game-name">
				<tie:prop key="tie.start.game" />
			</label>
			<input type="text" name="game-name">
		</div>
		<div class="form-row">
			<label for="game-password">
				<tie:prop key="tie.start.pw"/>
			</label>
			<input type="password" name="game-password">
		</div>
		<div class="form-row">
			<div class="button-container">
				<span class="global-button-1 login-button">
					<tie:prop key="tie.start.login"/>
				</span>
			</div>
			<div class="button-container">
				<a href="/tie/NewGame">
					<tie:prop key="tie.start.newgame"/>
				</a>
			</div>
		</div>
	</div>
</div>