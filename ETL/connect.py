import boto3
import botocore

# Let's use Amazon S3
s3 = boto3.resource('s3')

# Print out bucket names
access_key = 'AKIAI5RYI3H76O5MGJZA'
secret_key = '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'

# Print out bucket names
for bucket in s3.buckets.all():
    print(bucket.name)