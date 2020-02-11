Pour automatiser le script d'acquisition des données:
1) lancer la commande "crontab -e"
2)Creer un shell qui fait appel au script par la commande: "python3 emplacement/script.py"
3) Ajouter une ligne dans la configuration:
17     05     *     *     *         /emplacement/nom_fichier.sh
la premiere colonne indique la minute et la deuxieme indique l'heure.

Le script python envoie les donnees directement vers un producer Kafka.