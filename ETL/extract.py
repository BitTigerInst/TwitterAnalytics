import json
from datetime import datetime


input_file = '../sample_data/sample-tweets.20131002-044445.json'

#output_file = open('../sample_data/output1.json', 'r')

with open(input_file, 'r') as f:
	result=[]
	for line in f:
		line = line.strip()
		if line:
			my_dict = {}
			item = json.loads(line)
			my_dict['tweet_id'] = item['id']
			created_at_origin_time = item['created_at']
			#parse the created time
			created_at = datetime.strptime(created_at_origin_time, '%a %b %d %H:%M:%S +0000 %Y')
			created_at.strftime('%Y-%m-%d+%H:%M:%S')
			my_dict['created_at'] = created_at
			my_dict['text'] = item['text']
			my_dict['user_id'] = item['user']['id']
			if 'retweeted_status' in line:
				my_dict['etweeted_id'] = item['retweeted_status']['user']['id']
			print my_dict
	result.append(my_dict)