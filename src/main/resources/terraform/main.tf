provider "aws" {
  region = var.aws_region
}

resource "aws_instance" "realreview" {
  ami                    = "ami-0c94855ba95c71c99" # Amazon Linux 2 (for us-east-1)
  instance_type          = var.instance_type
  key_name               = var.key_name
  associate_public_ip_address = true

  vpc_security_group_ids = [aws_security_group.allow_http.id]

  user_data = file("${path.module}/scripts/user-data.sh")

  tags = {
    Name = "realreview-app"
  }
}

resource "aws_security_group" "allow_http" {
  name        = "allow_http"
  description = "Allow HTTP and SSH"

  ingress {
    description = "HTTP"
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    description = "SSH"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}
