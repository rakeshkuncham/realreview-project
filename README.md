# realreview-project

# RealReview - DevOps Automation Project


### ✅ README for `main` branch (Assessment 2)

# DevOps Assessment 2 - Extended EC2 Automation with S3 and IAM

## Description
This is an extension of Assessment 1. It automates infrastructure provisioning with additional AWS services and includes:

## Features

1. **S3 Bucket**:
   - Creates an S3 bucket with a configurable name.
   - Uploads static assets from a **private GitHub repo**.
   - Uploads EC2 logs (e.g., `/var/log/cloud-init.log`) to the bucket after instance shutdown.

2. **S3 Policy**:
   - Public read access for static assets.
   - Lifecycle rule to delete logs after 7 days.

3. **IAM Role**:
   - Creates a role `EC2S3AccessRole`.
   - Attaches `AmazonS3FullAccess` policy.
   - Attaches the role to the EC2 instance.
   - Verifies EC2 can list files from the S3 bucket.

## Tools Used
- Terraform or CloudFormation
- AWS CLI / Python (boto3)
- Shell scripting (Bash)

## How to Run
Update the Terraform variables and execute:
```bash
terraform init
terraform apply
