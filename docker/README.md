# oauth-demoapp-spring
OAuth2 demo app using Java Spring security.

## Source
Source code can be found at: https://github.com/Identicum/oauth-demoapp-spring

## Usage

### Install

Pull `identicum/oauth-demoapp-spring` from the Docker repository:

    docker pull identicum/oauth-demoapp-spring


Or build `identicum/oauth-demoapp-spring` from source:

    git clone https://github.com/Identicum/oauth-demoapp-spring.git
    cd oauth-demoapp-spring/docker
    docker build -t identicum/oauth-demoapp-spring .

### Run

#### Customize your application.properties
* Get base file from https://github.com/Identicum/oauth-demoapp-spring/blob/master/src/main/resources/application.properties
* Customize to your environment

#### Run the container
Run the image, binding associated ports, and mounting your custom application.properties:

    docker run -p 8080:8080 -v $(pwd)/application.properties:/usr/local/tomcat/webapps/oauth-demoapp-spring/WEB-INF/classes/application.properties identicum/oauth-demoapp-spring
