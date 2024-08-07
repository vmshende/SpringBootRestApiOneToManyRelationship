*******************Execution Process**************************
**For running the project the following procedure need to be follow
1.following application need to be installed in your system before running the application.
-any one of the IDE'S Either STS, Eclipse or Vscode.
-Xampp and MySQL Workbench for database related operations.
-PostMan or SOAPUI for sending http request.
2.in MySQL Workbench database already need to be created with
-Database Name: test
-Localhost-3306
-Username-root
-Password-no need to provide just keep it blank.
3.Open the project and inside the project open in.sp.bean package which is the main package and inside that open springBootRestApiOneToManyApplication  right click and run as spring boot application then application will run on the following uri http://localhost:8080 after that
4.open postman select http methods either get,post,put,delete and enter the uri http://localhost:8080 with "/students" i.e http://localhost:8080/students with methode type POST for performing insert operation and enter the data.
5.All the url is provided in the controller class for performing diiffrent database related opratons.

	
