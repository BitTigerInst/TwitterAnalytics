# connect to aws MySQL in teriminal
mysql -h twitteranalytics.ch5zv01juus7.us-west-2.rds.amazonaws.com -P 3306 -u octopus -p

show databases

# create database
CREATE DATABASE tweets;

# create tables
# q2
CREATE TABLE q2(tweet_id bigint primary key, text text, created_at varchar(255));

# q3
CREATE TABLE q3(tweet_id bigint primary key, user_id bigint);

# q4
CREATE TABLE q4(tweet_id bigint primary key, retweeted_user_id bigint);

