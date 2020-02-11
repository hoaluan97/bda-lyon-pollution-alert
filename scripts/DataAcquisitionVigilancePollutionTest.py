# import  yaml
import requests
import time
# from multiprocessing import Pool
from kafka import KafkaProducer
from kafka.errors import KafkaError
import json

#producer kafka to pubish to kafka port
producer = KafkaProducer(bootstrap_servers=['node-5:9092'] ,  value_serializer=lambda v: json.dumps(v).encode('utf-8')  ) 


proxies = {
    "http": "http://proxy.univ-lyon1.fr:3128",
    "https": "http://proxy.univ-lyon1.fr:3128",
}

# display communes
def get_data_communes():
    request = requests.get('http://api.atmo-aura.fr/communes?api_token=7f26db48d7e569ba4064fa4e6ad18c9b' , proxies = proxies )
    # test if response is OK
    if request.status_code == 200:
        last_page = request.json()["last_page"]
        # get each commun
        while (last_page > 0):
            request_page_json = requests.get(
                'http://api.atmo-aura.fr/communes?api_token=7f26db48d7e569ba4064fa4e6ad18c9b&page=' + str(
                    last_page) , proxies = proxies ).json()
            data_communes = request_page_json["data"]
            for p in data_communes:
                print("================> Commune : " + p['commune'])
                vigilance_data(p["commune"], p["vigilances"])
                indices_data(p["commune"], p["indices"])
            last_page = last_page - 1;
    else:
        print("Pas de donnees sur les communes ! STATUS CODE != 200")


# display vigilance data aboout a commune
def vigilance_data(commune_name, vigilance_url):
    request = requests.get(vigilance_url , proxies = proxies )
    # test if response is OK
    if request.status_code == 200:
        # get data in json format
        data_vigilance_file_json = request.json()
        data_vigilance = data_vigilance_file_json["vigilances"]
        # recuperer nombre de pages de donnees
        last_page = int(data_vigilance["last_page"])

        # To get each data
        # boucle for each json page ( &page=1 , &page=2 ......)
        while (last_page > 0):
            print("==> Vigilance Data from page :  " + str(last_page))
            request_page = requests.get(vigilance_url + '&page=' + str(last_page) , proxies = proxies )
            if request_page.status_code == 200:
                request_page_json = request_page.json()
                data = request_page_json["vigilances"]
                for p in (sorted(data["data"], key=lambda d: d["date_debut"])):
                    p["commune"] = commune_name
                    p["type"] = "vigilance"
                    producer.send('group-AMZOHONG-vigilances',p)
                time.sleep(3)
                print("-----------------------------")
                last_page = last_page - 1

    else:
        print("Pas de donnees ! STATUS CODE != 200")


# recuperer les indices pour chaque commune
def indices_data(commune_name, indices_url):
    request = requests.get(indices_url , proxies = proxies )
    # test if response is OK
    if request.status_code == 200:
        # get data in json format
        data_indices_file_json = request.json()
        # recuperer nombre de pages de donnees
        last_page = data_indices_file_json["indices"]["last_page"]

        # To get each data
        # boucle for each json page ( &page=1 , &page=2 ......)
        while (last_page > 0):
            print("==> Indices Data from page :  " + str(last_page))
            request_page = requests.get(indices_url + '&page=' + str(last_page) , proxies = proxies )
            if request_page.status_code == 200:
                request_page_json = request_page.json()
                data = request_page_json["indices"]
                for p in (sorted(data["data"], key=lambda d: d["date"])):
                    p["commune"] = commune_name
                    p["type"] = "indice"
                    producer.send('group-AMZOHONG-indices',p)

                time.sleep(3)
                print("\n\n\n")
                last_page = last_page - 1
            


    else:
        print("Pas de donnees ! STATUS CODE != 200")


# paralileser

get_data_communes()
