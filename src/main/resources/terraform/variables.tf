variable "aws_region" {
  default = "us-east-1"
}

variable "instance_type" {
  default = "t2.micro"
}

variable "key_name" {
  description = "SSH key name"
  default     = "your-key-name"
}

variable "repo_url" {
  description = "GitHub repo to clone"
  default     = "https://github.com/rakeshkuncham/realreview-project.git"
}

variable "app_port" {
  default = 80
}
