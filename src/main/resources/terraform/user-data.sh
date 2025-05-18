#!/bin/bash
# Update and install dependencies
yum update -y
yum install -y java-1.8.0 git wget

# Clone your Spring Boot app repo
cd /home/ec2-user
git clone https://github.com/rakeshkuncham/realreview-project.git
cd realreview-project

# Build or run your Spring Boot app (example for JAR)
wget https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-cli/2.7.5/spring-boot-cli-2.7.5-bin.tar.gz
tar -xvzf spring-boot-cli-2.7.5-bin.tar.gz
export PATH=$PATH:/home/ec2-user/spring-2.7.5/bin

# Assuming you already have a JAR built, otherwise run `./mvnw package`
java -jar target/*.jar &

# Schedule auto-stop after 1 hour to save cost
echo "sudo shutdown -h +60" | at now
