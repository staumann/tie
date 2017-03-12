<%@ taglib prefix="tie" uri="../WEB-INF/custom.tld"%>

<div class="new-tech-wrapper">
	<div class="tech-headline">
		<h2><tie:prop key="tie.newtech.headline"/></h2>
	</div>
	<div class="tech-body">
		<form name="new-tech-form">
			<div class="item-container">
				<label for="tech-title">
					<tie:prop key="tie.newtech.titlelabel"/>
				</label>
				<input type="text" name="tech-title" placeholder="<tie:prop key="tie.newtech.titleplaceholder"/>">
			</div>
			<div class="item-container">
				<label for="tech-description">
					<tie:prop key="tie.newtech.titledescription"/>
				</label>
				<textarea name="tech-description"></textarea>
			</div>
			<div class="item-container">
				<jsp:include page="inc/tech.jsp"></jsp:include>
			</div>
		</form>
	</div>
	<div class="tech-footer">
		<a href="" class="global-button-1 save-new-tech">
			<tie:prop key="common.save"/>
		</a>
	</div>
</div>