


<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL name="<%=UserFormWebPortletKeys.USERFORMACTION %>" var="addUser"/>

<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="captcha.verification.failed" />
<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeDuplicate.class %>" message="key.must.not.duplicated" />
<liferay-ui:error exception="<%= EmailAddressException.class %>" message="invalid.email.addres" />
<liferay-ui:error exception="<%= ContactBirthdayException.class %>" message="invalid.date" />
<liferay-ui:error exception="<%= ParseException.class %>" message="invalid.date" />
<liferay-ui:error exception="<%= NameNotFoundException.class %>" message="invalid.name.or.surname" />
<liferay-ui:success key="thanks.for.your.registration" message="thanks.for.your.registration" />
    
<aui:form action="<%=addUser%>" name="<portlet:namespace/>userForm">
	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:row>
				<aui:col width="50">
					<aui:input label="form.name" name="name" type="text" required="true">
						<aui:validator name="maxLength" errorMessage="form.max.length.name">"15"</aui:validator>
					</aui:input>
				</aui:col>
				<aui:col width="50">
					<aui:input label="form.surname" name="surname" type="text" required="true">
						<aui:validator name="maxLength" errorMessage="form.max.length.surname">50</aui:validator>
					</aui:input>	
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<%-- <aui:input label="form.birthday" name="birthday" placeholder ="MM-dd-yyyy" type="text" required="true">--%>
					<aui:input label="form.birthday" autocomplete="off" type="date" placeholder="MM-dd-yyyy" required="true" name="birthday" id="birthday">
						<aui:validator name="date"></aui:validator>
						<aui:validator name="custom" errorMessage="invalid.date">
							function(value){
								
								let inputDate = new Date(value)
								let minimumAge = new Date()
								let maximumAge = new Date()
								
								minimumAge.setFullYear(minimumAge.getFullYear()-18)
								maximumAge.setFullYear(maximumAge.getFullYear()-99)
								
								if (inputDate> minimumAge || inputDate < maximumAge){
									return false;
								}
								return true
							}
						</aui:validator>
					</aui:input>
				</aui:col>
				<aui:col width="50">
					<aui:input label="form.email" name="email" type="email" id="email"required="true">
						<aui:validator name="email"></aui:validator>
						<aui:validator name="maxLength" errorMessage="form.max.length.email">75</aui:validator>
					</aui:input>
					
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="50">
					<aui:input label="form.repeat.email" name="emailConfirmed" type="email" required="true">
						<aui:validator name="equalTo" errorMessage="form.confirm.email">'#<portlet:namespace />email'</aui:validator>
					</aui:input>
				</aui:col>
				<aui:col width="50">
					<liferay-captcha:captcha/>

				</aui:col>
			</aui:row>
			<aui:row>
				<aui:button-row>		
					<aui:button name="submitButton" type="submit" value="form.submit"  />
				</aui:button-row>
			</aui:row>
		</aui:fieldset>
	</aui:fieldset-group>

</aui:form>

