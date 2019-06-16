FROM identicum/centos-java-maven:latest AS build-env

RUN git clone https://github.com/Identicum/oauth-demoapp-spring.git .
RUN /usr/bin/mvn package

# ############################################################################
# Build runtime image
FROM identicum/centos-tomcat:latest
MAINTAINER Gustavo J Gallardo <ggallard@identicum.com>

RUN yum -y install unzip
COPY --from=build-env /source/target/spring-oauth-demo-0.0.1-SNAPSHOT.war /tmp/demo-app.war
RUN unzip -qq /tmp/demo-app.war -d /usr/local/tomcat/webapps/demo-app && \
    rm -f /tmp/demo-app.war
