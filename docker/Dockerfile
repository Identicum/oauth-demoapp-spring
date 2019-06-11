FROM identicum/tomcat:latest AS build-env

RUN yum -y install git
ENV JAVA_HOME /etc/alternatives/java_sdk
RUN wget https://archive.apache.org/dist/maven/maven-3/3.5.3/binaries/apache-maven-3.5.3-bin.tar.gz -O /tmp/maven.tgz && \
    tar -xvzf /tmp/maven.tgz --directory /usr/share/ && \
    rm -f /tmp/maven.tgz && \
    mv /usr/share/apache-maven-* /usr/share/apache-maven && \
    ln -s /usr/share/apache-maven/bin/mvn /usr/bin/mvn
ENV MAVEN_HOME /usr/share/apache-maven

RUN git clone https://github.com/Identicum/oauth-demoapp-spring.git /source
WORKDIR /source
RUN /usr/bin/mvn package

# ############################################################################
# Build runtime image
FROM identicum/tomcat:latest
MAINTAINER Gustavo J Gallardo <ggallard@identicum.com>

RUN yum -y install unzip
COPY --from=build-env /source/target/spring-oauth-demo-0.0.1-SNAPSHOT.war /tmp/demo-app.war
RUN unzip -qq /tmp/demo-app.war -d /usr/local/tomcat/webapps/demo-app && \
    rm -f /tmp/demo-app.war
