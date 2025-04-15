# Use official Jetty base image
FROM jetty:10.0.17-jdk21

# Copy your WAR to Jetty's webapps directory
COPY isdlabs-0.1.war /var/lib/jetty/webapps/

# Expose port 8080 (Jetty's default)
EXPOSE 8080