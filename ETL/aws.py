# connect to aws S3 in teriminal

# Step1: download aws-shell on my laptop
sudo pip install aws-shell

# Step2: connect to aws, and configure it
$ aws configure
AWS Access Key ID [None]:
AWS Secret Access Key [None]:
Default region name [None]:
Default output format [None]:

# create new EMR cluster

# connect to EMR by SSH
$ ssh -i ./twitter.pem -ND 8157 hadoop@ec2-50-19-45-59.compute-1.amazonaws.com
Are you sure you want to continue connecting (yes/no)? yes
$ chmod 400 twitter.pem # change the key
$ ssh -i ./twitter.pem -ND 8157 hadoop@ec2-50-19-45-59.compute-1.amazonaws.com

# configure a proxy management tool
# download the proxy form: enable foxyproxy standard on chrom extension





mysql -h twitteranalytics.ch5zv01juus7.us-west-2.rds.amazonaws.com -P 3306 -u octopus -p

show databases
