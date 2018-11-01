<%@ page pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath }" var="base_path"/>
<jsp:include page="header.jsp"></jsp:include>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!
					</h1>
					
					<table class="table">
					
						<tr class="table_header">
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								Age
							</td>
							<td>
								Birthday
							</td>
							<td>
								Sex
							</td>
							<td>
								Score
							</td>
							<td>
								Operation
							</td>
						</tr>
						
					<c:forEach var="employee" items="${requestScope.employees }" varStatus="sta">
					
						<tr class=
						   <c:if test="${sta.count%2==0 }">
						     "row2"
						   </c:if>
						   <c:if test="${sta.count%2!=0 }">  
						     "row1"
						   </c:if>
						     >
						     <td hidden>
						     ${employee.id}
						     </td>
				    		<td>
								${employee.name }
							</td>
							<td>
								${employee.salary }
							</td>
							<td>
								${employee.age }
							</td>
							<td>
								${employee.birthday }
							</td>
							
							<td>
								<c:if test="${employee.sex=='f'}">
								   女
								</c:if>
								<c:if test="${employee.sex!='f'}">
								   男
								</c:if>
							</td>
							<td>
								${employee.score }
							</td>
							
							<td>
								<a href="<c:url context='${base_path}' value='/deleteemployee'/>?id=${employee.id}">delete emp</a>&nbsp;<a href="<c:url context='${base_path}' value='/querybyid'/>?id=${employee.id}">update emp</a>
							</td>
						</tr>
					</c:forEach>	
						
					</table>
					<p>
						<input type="button" class="button" value="Add Employee" onclick="location='addEmp.jsp'"/>
					</p>
				</div>
			</div>
	<jsp:include page="footer.jsp"></jsp:include>
