<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="registration">
<form action="controller" method="post"> 
  <p align="center">Create an account:</p><br>
  <div>     
    
    Email<br><input type="email" id="email" name="email" size="30px" required placeholder="Example: one@gmail.com">
    <br>
    
    Phone number<br><input type="tel" id="tel" name="tel" size="30px" required placeholder="Example: +375291111111" pattern="(\+)([0-9]){12}">
    <br>
    
    Login<br><input type="text" id="login" name="login" required>    
    <br>
    
    Password<br><input type="password" id="password" name="password" required>    
           
  </div><br>
  
  <div>
    <input type="hidden" name="command" value="do_registration" />
    <input type="submit" value="Register"/>
    <button type="reset">Clear</button>
  </div>
  
</form>  

</div>
