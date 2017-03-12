<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tie" uri="../WEB-INF/custom.tld"%>


<div class="settings-wrapper">
	<div class="headline">
		<tie:prop key="tie.settings.headline"/>
	</div>
	<script type="x/mustache" class="race-mustache">
		{{#.}}
			<div class="race-inner">
				<div class="race-name">
					{{raceName}}
				</div>
				<div class="more-infos" data-raceid="{{raceId}}">
					<tie:prop key="tie.settings.moreinfos" />	
				</div>
				<div class="race-body">
					<div class="sub-headline"><tie:prop key="tie.settings.description.headline" /></div>
					<div class="description">{{description}}</div>
					<div class="sub-headline"><tie:prop key="tie.settings.trade.headline" /></div>
					<div class="trade">{{tradeContract1}} | {{tradeContract2}}</div>
					<div class="battle-value-headline">
						<tie:prop key="tie.setings.battleValue.space" />
					</div>
					<div class="battle-value-container cf">
						<div class="item">
							<div class="label">
								<tie:prop key="common.cruiser" />
							</div>
							<div class="value">
								{{battleValueCruiser}}
							</div>
						</div>
						<div class="item">
							<div class="label">
								<tie:prop key="common.destroyer" />
							</div>
							<div class="value">
								{{battleValueDestroyer}} / {{battleValueDestroyerAnitFighter}}
							</div>
						</div>
						<div class="item">
							<div class="label">
								<tie:prop key="common.dreadnought" />
							</div>
							<div class="value">
								{{battleValueDreadnought}}
							</div>
						</div>
						<div class="item">
							<div class="label">
								<tie:prop key="common.warSun" />
							</div>
							<div class="value">
								{{battleValueWarSun}}
							</div>
						</div>
						<div class="item">
							<div class="label">
								<tie:prop key="common.freighter" />
							</div>
							<div class="value">
								{{battleValueFreighter}}
							</div>
						</div>
						<div class="item">
							<div class="label">
								<tie:prop key="common.fighter" />
							</div>
							<div class="value">
								{{battleValueFighter}}
							</div>
						</div>
						<div class="item">
							<div class="label">
								<tie:prop key="common.pds" />
							</div>
							<div class="value">
								{{battleValuePDS}}
							</div>
						</div>
						<div class="item"></div>
					</div>
					<div class="battle-value-headline">
						<tie:prop key="tie.setings.battleValue.ground" />
					</div>
					<div class="battle-value-container cf">
						<div class="item">
							<div class="label">
								<tie:prop key="common.groundForces" />
							</div>
							<div class="value">
								{{battleValueGroundForce}}
							</div>
						</div>
						<div class="item">
							<div class="label">
								<tie:prop key="common.mechs" />
							</div>
							<div class="value">
								{{battleValueMech}}
							</div>
						</div>
						<div class="item"></div><div class="item"></div>
					</div>
				</div>
			</div>
		{{/.}}
	</script>
	
	<script type="x/mustache" class="tech-mustache">
		<div class="tech-container">
			{{#.}}
				<div class="teh-inner">
					<div class="race-name">
						{{techName}}
					</div>
					<div class="more-infos" data-techid="{{techId}}">
						<tie:prop key="tie.settings.moreinfos" />	
					</div>
					<div class="tech-body">
						{{description}}
					</div>
				</div>
			{{/.}}
		</div>
	</script> 
	<script type="x/mustache" class="game-mustache">
		<div class="game-container">
			{{#. }}
				<div class="game-row cf">
					<div class="cb-container">
						<input type="checkbox" class="game-checkbox" name="game-{{gameId}}-cb" id="game-{{gameId}}-cb" value="{{gameId}}" />
					</div>
					<div class="desc-container">
						<label for="game-{{gameId}}-cb">
							{{gameName}}
						</label>
					</div>
				</div>
			{{/.}}
			<div class="button-container">
				<span class="delete-game-button global-button-1">
					<tie:prop key="common.delete" />
				</span>
			</div>
		</div>
	</script>
	<div class="acc-container">
		<h2 data-type="race"><tie:prop key="tie.settings.races.headline"/></h2>
		<div class="race-container loader">
		</div>
		<h2 data-type="tech"><tie:prop key="tie.settings.techs.headline"/></h2>
		<div class="tech-container loader">
		</div>
		<h2 data-type="game"><tie:prop key="tie.settings.games.headline" /></h2>
		<div class="game-container loader">
		</div>
	</div>
</div>
<div class="footer-container cf">
	<div class="link-container">
		<a class="global-button-1" href="/tie/AddRace"><tie:prop key="tie.settings.addrace" /></a>
	</div>
	<div class="link-container">
		<a class="global-button-1" href="/tie/AddTech"><tie:prop key="tie.settings.addtech" /></a>
	</div>
</div>