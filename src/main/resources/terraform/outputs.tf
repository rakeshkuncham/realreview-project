output "instance_public_ip" {
  description = "The public IP of the EC2 instance"
  value       = aws_instance.realreview.public_ip
}

output "s3_bucket_name" {
  description = "S3 bucket name"
  value       = aws_s3_bucket.static_assets.bucket
}
