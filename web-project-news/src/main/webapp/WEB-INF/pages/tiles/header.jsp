<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="wrapper">
	<div class="newstitle">News management</div>


	<div class="local-link">

		<div align="right">
			<a href=""> en </a> &nbsp;&nbsp; <a	href=""> ru </a> <br />
			<p style="height:6px"></p>
		</div>

		<c:if test="${not (sessionScope.user eq 'active')}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_in" /> 
					Enter login: <input type="text" name="login" value="" /><br />
					<p style="height:3px"></p> 
					Enter password: <input type="password" name="password" value="" /><br />
					<p style="height:3px"></p>

					<c:if test="${not (sessionScope.AuthenticationError eq null)}">
						<font color="red" style="text-transform:uppercase"> 
						   <c:out value="${sessionScope.AuthenticationError}" />&nbsp;&nbsp;						   
						</font> 
					</c:if>
					<c:set var="AuthenticationError" value="" scope="session" />					
					
					<a href="controller?command=go_to_registration_page">Registration</a> &nbsp;&nbsp; <input type="submit" value="Sign In" /><br />
				</form>
			</div>

		</c:if>
		
		<c:if test="${sessionScope.user eq 'active'}">

			<div align="right">
				<form action="controller" method="post">
					<input type="hidden" name="command" value="do_sign_out" /> 
					<input type="submit" value="Sign Out" /><br />
				</form>
			</div>

		</c:if>
	</div>

</div>
