<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!----start-content--->
<div class="content">
    <h3>Login with Username and Password (Authentication with Database)</h3>

    <c:if test="${not empty error}">
        <div class="errorblock">
            Your login attempt was not successful, try again.<br /> Caused :
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
        </div>
    </c:if>
    <form name='f' action="<c:url value='j_spring_security_check' />"
          method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='j_username' value=''>
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='j_password' />
                </td>
            </tr>
            <tr>
                <td colspan='2'>
                    <input name="submit" type="submit" value="submit" />
                    &nbsp;
                    <input name="reset" type="reset" />
                </td>
            </tr>
        </table>

    </form>
    <script type="text/javascript">
        $(document).ready(function(){
            document.f.j_username.focus();
        });
    </script>
</div>
<!----end-content--->