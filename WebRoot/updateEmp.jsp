<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"></jsp:include>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					
					<form action="${pageContext.request.contextPath }/updateemployee" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="left">
									<input type="hidden" class="inputgri" name="id" value="${requestScope.emp.id}" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${requestScope.emp.name}"/>
								</td>
							</tr>
							
							<tr>
								<td valign="middle" align="right">
									工资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="${requestScope.emp.salary}"/>
								</td>
							</tr>
							
							
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="${requestScope.emp.age}"/>
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
									<input type="text" class="inputgri" name="birthday" value="${requestScope.emp.birthday}"/>
								</td>
							
							</tr>

							<tr>
								<td valign="middle" align="right">
									分数:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="score" value="${requestScope.emp.score}"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="Confirm" />
						</p>
					</form>
				</div>
			</div>
	<jsp:include page="footer.jsp"></jsp:include>
