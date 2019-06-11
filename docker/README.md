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
    spring.thymeleaf.cache=false
    security.oauth2.client.client-authentication-scheme=form
    security.oauth2.client.scope=openid
    security.oauth2.client.client-id={CLIENT_ID}
    security.oauth2.client.client-secret={CLIENT_SECRET}
    security.oauth2.client.access-token-uri={TOKEN_ENDPOINT}
    security.oauth2.client.user-authorization-uri={AUTHORIZATION_ENDPOINT}
    security.oauth2.resource.user-info-uri={USERINFO_ENDPOINT}

#### Run the container
Run the image, binding associated ports, and mounting the present working
directory:

    docker run -p 8080:8080 -v $(pwd)/application.properties:/usr/local/tomcat/webapps/demo-app/WEB-INF/classes/application.properties identicum/oauth-demoapp-spring
