# Microservices with Spring Cloud kaddem-ms Project

"Kaddem" started as a school project, aiming to simulate student enrollment, contract management, department allocation, and team assignments within a university context. Originally, it was a traditional monolithic backend built using Spring Boot. But who says school projects need to be mundane? I've taken it a step further by transforming "Kaddem" into an exciting microservices-based version. This repository showcases my journey of enhancing "Kaddem" with the power of microservices, breathing fresh life into the project. 


## Prerequisites

Before running the application, make sure you have the following software installed and configured:

1. WAMP or XAMPP with a running MySQL database.
2. An IDE like IntelliJ. While you can use your preferred IDE, I recommend IntelliJ for its seamless handling of simultaneous microservices.
3. Java 8 installed on your system.
4. Download and install Consul from this link: https://developer.hashicorp.com/consul/downloads?product_intent=consul
5. Clone this repository to your computer.

## Installation and Setup

Follow these steps to set up and run the application:

### Step I - Starting the consul service

1. Navigate to the folder where you installed Consul and open a command prompt in that location.

2. Execute the following command:

  ```bash
  consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=192.168.100.44
  ```
  ![Consul folder](https://raw.githubusercontent.com/youssefalmia/blockchain-dapp-cs-challenge/main/ProjectRelatedPics/Rootroot.png)

  ![CMD command](https://raw.githubusercontent.com/youssefalmia/blockchain-dapp-cs-challenge/main/ProjectRelatedPics/Rootroot.png)

3. Access the Consul service at: http://localhost:8500/ui/dc1/services  

### Step II - Starting the the rest of the services

1. Start by opening your WAMP or XAMPP and ensure the MySQL database is running.

2. Since configurations are centralized in the microservices architecture, head to `kaddem-ms/config-repo` to find the configuration for all microservices.

3. Since we are running all of the services on our machine, open `etudiant-service.properties` and `university-service.properties` files, update your database credentials or configuration settings as needed. Here's a picture if you didn't know how to:

  ![Database Config](https://raw.githubusercontent.com/youssefalmia/blockchain-dapp-cs-challenge/main/ProjectRelatedPics/Rootroot.png)

4. now start the project in this order:
  4.1. `GatewayServiceApplication`
  4.2. `ConfigServiceApplication`
  4.3. `EtudiantServiceApplication`
  4.4. `UniversityServiceApplication`
Refer to the GIF for guidance.

  ![Starting the microservices GIF](https://github.com/youssefalmia/blockchain-dapp-cs-challenge/blob/main/ProjectRelatedPics/BlockchainTrackingApp.gif)


### Step III - Testing the Project

Now you can explore the project. I've provided a Postman Collection named `[TWIN-PROJECT] MS-KADDEM.postman_collection.json` for easy import and experimentation with requests.


Examples of Microservices Excellence:

Experience the dynamic capabilities of microservices in action. Even if the `student-service` and `university-service` are separate, inserting a student with a non-existing department adds the department to the database.

  ![Adding Department from Student MS](https://github.com/youssefalmia/student/blob/main/BlockchainTrackingApp.gif)

### Contributing
Contributions to the project are welcome. Feel free to submit issues and pull requests.