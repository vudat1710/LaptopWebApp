// Copy this content in tomcat servers context.xml
// fill the usernam, password and database name
<Resource name="jdbc/laptopsDatabase" auth="Container"
		type="javax.sql.DataSource" username="..." password=".."
		driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/..." maxActive="8" maxIdle="4" />