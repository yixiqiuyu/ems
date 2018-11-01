
<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>

<jsp:include page="header.jsp"></jsp:include>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						注册
					</h1>
					<form action="${pageContext.request.contextPath }/addemp" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" />
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									工资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" />
								</td>
							</tr>
							
							
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="f"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									出生日期：
								</td>
								<td valign="middle" align="left">
									<input type="date" class="inputgri" name="birthday"/>
								</td>
							
							</tr>

							<tr>
								<td valign="middle" align="right">
									分数:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="score" />
								</td>
							</tr>
						</table>
				    	<p>
							<input type="submit" class="button" value="Submit &raquo;" />
						</p>
						
					</form>
				</div>
			</div>
		<jsp:include page="footer.jsp"></jsp:include>
