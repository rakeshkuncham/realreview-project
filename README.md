# realreview-project

# DevOps Assessment 1 - Automate EC2 Deployment

## Description
This script automates the deployment of an EC2 instance using Terraform. It includes the following features:

1. Spins up an EC2 instance of a specific type.
2. Installs dependencies (e.g., Java, Git).
3. Clones a GitHub repository and deploys the application.
4. Tests if the application is reachable via port 80.
5. Automatically stops the instance after a set duration for cost saving.

## Features
- Configurable instance type, dependencies, and repo (with default values).
- Supports cloning from private GitHub repos (bonus task).
- Script is located in: `src/main/resources/`

## How to Run
Update the variables in the Terraform script or via CLI and execute the script with:
```bash
terraform init
terraform apply

