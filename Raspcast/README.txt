          
             Project DA opdracht 2 van Kristof Dewilde en Jan Pecquet

 ______    ________   ______   ______   ______   ________   ______   _________  
/_____/\  /_______/\ /_____/\ /_____/\ /_____/\ /_______/\ /_____/\ /________/\ 
\:::_ \ \ \::: _  \ \\::::_\/_\:::_ \ \\:::__\/ \::: _  \ \\::::_\/_\__.::.__\/ 
 \:(_) ) )_\::(_)  \ \\:\/___/\\:(_) \ \\:\ \  __\::(_)  \ \\:\/___/\  \::\ \   
  \: __ `\ \\:: __  \ \\_::._\:\\: ___\/ \:\ \/_/\\:: __  \ \\_::._\:\  \::\ \  
   \ \ `\ \ \\:.\ \  \ \ /____\:\\ \ \    \:\_\ \ \\:.\ \  \ \ /____\:\  \::\ \ 
    \_\/ \_\/ \__\/\__\/ \_____\/ \_\/     \_____\/ \__\/\__\/ \_____\/   \__\/ 


              https://github.com/Qrivi/UCLL-DA/tree/master/Raspcast



Dit project bestaat uit twee root modules:
 - "parser" runt op de Raspberry Pi en verwerkt lowkey de sensorgegenereerde data
 - "app", met eronder "model" en "api" verwerken de data van "parser" in een RESTful JSON API
     

/* -----
  SETUP
  ---- */

1)
JDBC connection pool aanmaken met minimum alle noodzakelijke configuratie om standaard CRUD-acties, CREATE TABLE en DROP TABLE te kunnen uitvoeren met de opgegeven user.

 - Url
 - DatabaseName
 - ServerName
 - User
 - Password

2)
JDBC resource aanmaken met de naam "jdbc/RaspcastJNDI", gebruik makend van de pool gedefiniëerd in bovenstaande stap.

3)
Config.java.example dupliceren en renamen naar Config.java, en eventueel aanpassen met eigen configuratie. De stadaardconfiguratie is ingevuld in Config.java.example.

 - Raspcast/parser/src/main/java/be/krivi/ucll/da/raspcast/parser/config/Config.java.example
 - Raspcast/api/src/main/java/be/krivi/ucll/da/raspcast/api/config/Config.java.example

