#!/bin/bash

# Update and install necessary packages
yum update -y
yum install -y java-1.8.0 git wget aws-cli at

# Clone your Spring Boot app repo from GitHub
cd /home/ec2-user
git clone https://github.com/rakeshkuncham/realreview-project.git
cd realreview-project

# Download and configure Spring Boot CLI
wget https://repo1.maven.org/maven2/org/springframework/boot/spring-boot-cli/2.7.5/spring-boot-cli-2.7.5-bin.tar.gz
tar -xvzf spring-boot-cli-2.7.5-bin.tar.gz
export PATH=$PATH:/home/ec2-user/spring-2.7.5/bin

# Run the Spring Boot application from built JAR
java -jar target/*.jar &

# Upload static assets (e.g., HTML/CSS/JS) to S3
aws s3 cp static/ s3=${S3_BUCKET_NAME}/static/ --recursive

# Create shutdown service to upload logs to S3
cat <<EOF > /etc/systemd/system/log-upload.service
[Unit]
Description=Upload logs to S3 on shutdown
DefaultDependencies=no
Before=shutdown.target

[Service]
Type=oneshot
ExecStart=/bin/bash /opt/upload-logs.sh
RemainAfterExit=yes

[Install]
WantedBy=shutdown.target
EOF

# Create script to upload logs
cat <<EOF > /opt/upload-logs.sh
#!/bin/bash
aws s3 cp /var/log/cloud-init.log s3://${S3_BUCKET_NAME}/logs/cloud-init.log
EOF

chmod +x /opt/upload-logs.sh
systemctl enable log-upload.service

# Optional: Auto shutdown EC2 after 1 hour to save cost
echo "sudo shutdown -h +60" | at now
