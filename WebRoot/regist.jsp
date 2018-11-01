
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<title>adminregist</title>
<jsp:include page="header.jsp"></jsp:include>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="${pageContext.request.contextPath }/adminregist" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="adminname" />
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									验证码:
									<img id="num" src="${pageContext.request.contextPath }/ValidationCode" />
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="code" />
								</td>
						</table>
				    	<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>	
					</form>
				</div>
			</div>
		<jsp:include page="footer.jsp"></jsp:include>
