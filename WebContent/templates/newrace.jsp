<%@ taglib prefix="tie" uri="../WEB-INF/custom.tld"%>

<div class="form-wrapper">
	<h2 class="form-headline">
		<tie:prop key="tie.newrace.headline"/>
	</h2>
	<div class="form-wrapper-inner">
		<form action="" method="post" name="new-race-form">
			<div class="form-row cf">
				<label for="raceName">
					<tie:prop key="tie.newrace.name.label" />
				</label>
				<input type="text" name="raceName" placeholder="<tie:prop key="tie.newrace.name.placeholder"/>" />
			</div>
			<div class="form-row">
				<div class="form-row cf">
					<textarea name="special-ability"></textarea>
					<label for="special-ability"><tie:prop key="tie.newrace.specialability" /></label>
				</div>
			</div>
			<div class="form-row cf">
				<div class="battle-value-container">
					<input type="tel" name="battleCruiser" value="7" maxlength="1">
					<label for="battleCruiser"><tie:prop key="tie.newrace.battle.cruiser" /></label>
				</div>
			</div>
			<div class="form-row cf">
				<div class="battle-value-container cf">
					<div class="mulitple-inputs">
						<input type="tel" name="battleDestroyer" value="9" maxlength="1"> / <input type="tel" name="battleDestroyerantifighter" value="9" maxlength="1">
					</div>
					<label for="battleDestroyer"><tie:prop key="tie.newrace.battle.destroyer" /></label>
				</div>
			</div>
			<div class="form-row cf">
				<div class="battle-value-container cf">
					<input type="tel" name="battleDreadnought" value="5" maxlength="1">
					<label for="battleDreadnought"><tie:prop key="tie.newrace.battle.dreadnought" /></label>
				</div>
			</div>
			<div class="form-row">
				<div class="battle-value-container cf">
					<input type="tel" name="battleFighter" value="9" maxlength="1">
					<label for="battleFighter"><tie:prop key="tie.newrace.battle.fighter" /></label>
				</div>
			</div>
			<div class="form-row cf">
				<div class="battle-value-container cf">
					<input type="tel" name="battleFreighter" value="9" maxlength="1">
					<label for="battleFreighter"><tie:prop key="tie.newrace.battle.freighter" /></label>
				</div>
			</div>
			<div class="form-row cf">
				<div class="battle-value-container cf">
					<input type="tel" name="battlegroundforce" value="8" maxlength="1">
					<label for="battlegroundforce"><tie:prop key="tie.newrace.battle.groundforce" /></label>
				</div>
			</div>
			<div class="form-row cf">
				<div class="battle-value-container cf">
					<input type="tel" name="battlemech" value="6" maxlength="1">
					<label for="battlemech"><tie:prop key="tie.newrace.battle.mech" /></label>
				</div>
			</div>
			<div class="form-row cf">
				<div class="battle-value-container cf">
					<input type="tel" name="battlepds" value="7" maxlength="1">
					<label for="battlepds"><tie:prop key="tie.newrace.battle.pds" /></label>
				</div>
			</div>
			<div class="form-row cf">
				<div class="trade-contract-container cf">
					<h3><tie:prop key="tie.newrace.tradecontracts.headline" /></h3>
					<div class="sub-container">
						<select name="trade1">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select>
						<select name="trade2">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select>
					</div>
				</div>
			</div>
			<div class="form-row cf">
				<div class="battle-value-container cf">
					<textarea name="description"></textarea>
					<label for="description"><tie:prop key="tie.newrace.description" /></label>
				</div>
			</div>
			<div class="form-row cf">
				<h3><tie:prop key="tie.newrace.techs" /></h3>
				<jsp:include page="inc/tech.jsp"></jsp:include>
			</div>
			<div class="form-row cf">
				<h3><tie:prop key="tie.newrace.startingUnits"/></h3>
				<div class="unit-container">
					<div class="column-1">
						<div class="item">
							<label for="fighter-input"><tie:prop key="tie.newrace.startingUnits.fighter"/></label>
							<input type="tel" name="fighter-input" id="fighter-input" value="0">
						</div>
						<div class="item">
							<label for="freighter-input"><tie:prop key="tie.newrace.startingUnits.freighter"/></label>
							<input type="tel" name="freighter-input" id="freighter-input" value="0">
						</div>
						<div class="item">
							<label for="destroyer-input"><tie:prop key="tie.newrace.startingUnits.destroyer"/></label>
							<input type="tel" name="destroyer-input" id="destroyer-input" value="0">
						</div>
						<div class="item">
							<label for="cruiser-input"><tie:prop key="tie.newrace.startingUnits.cruiser"/></label>
							<input type="tel" name="cruiser-input" id="cruiser-input" value="0">
						</div>
						<div class="item">
							<label for="dreadnought-input"><tie:prop key="tie.newrace.startingUnits.dreadnought"/></label>
							<input type="tel" name="dreadnought-input" id="dreadnought-input" value="0">
						</div>
					</div>
					<div class="column-2">
						<div class="item">
							<label for="warSun-input"><tie:prop key="tie.newrace.startingUnits.warSun"/></label>
							<input type="tel" name="warSun-input" id="warSun-input" value="0">
						</div>
						<div class="item">
							<label for="pds-input"><tie:prop key="tie.newrace.startingUnits.pds"/></label>
							<input type="tel" name="pds-input" id="pds-input" value="0">
						</div>
						<div class="item">
							<label for="spaceDocks-input"><tie:prop key="tie.newrace.startingUnits.spaceDocks"/></label>
							<input type="tel" name="spaceDocks-input" id="spaceDocks-input" value="0">
						</div>
						<div class="item">
							<label for="groundForces-input"><tie:prop key="tie.newrace.startingUnits.groundForces"/></label>
							<input type="tel" name="groundForces-input" id="groundForces-input" value="0">
						</div>
						<div class="item">
							<label for="mechs-input"><tie:prop key="tie.newrace.startingUnits.mechs"/></label>
							<input type="tel" name="mechs-input" id="mechs-input" value="0">
						</div>
					</div>
				</div>
			</div>
			<div class="button-container">
				<a href="" class="global-button-1 save-new-race">
					<tie:prop key="common.save"/>
				</a>
			</div>
		</form>
	</div>
</div>