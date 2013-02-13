<%@ page import="org.fsarmiento.league.maker.sample.Champion" %>



<div class="fieldcontain ${hasErrors(bean: championInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="champion.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${championInstance?.name}" />
</div>

