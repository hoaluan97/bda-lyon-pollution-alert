import  yaml
import requests
import time
from multiprocessing import Pool
from kafka import KafkaProducer
from kafka.errors import KafkaError
import json

import csv

# producer kafka to pubish to kafka port
producer = KafkaProducer(bootstrap_servers=['node-5:9092'] ,  value_serializer=lambda v: json.dumps(v).encode('utf-8')  ) 

lyon = '07481'
input_files = ['synop.201910.csv', 'synop.201911.csv', 'synop.201912.csv']

for file in input_files:
    with open(file) as csvfile:
        reader = csv.DictReader(csvfile, delimiter=';')
        print('_______________________________________________________________________________')
        for row in reader:
            toSend = {}
            if row['numer_sta'] == lyon:
                toSend['date'] = row['date']
                toSend['temperature'] = row['t']
                toSend['humidity'] = row['u']
                toSend['windspeed'] = row['ff']
                print(toSend)
                producer.send('group-AMZOHONG-meteo', toSend)