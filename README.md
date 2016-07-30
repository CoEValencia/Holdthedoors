# Chirri chat
![alt tag](https://github.com/CoEValencia/Holdthedoors/blob/master/Chirri_Capture.png)
##Requeriments:

1. JavaSE 1.7
2. Maven 3
3. Sencha Cmd 6.1.2

##Instructions:
1. Clone the project from https://github.com/CoEValencia/Holdthedoors.git
2. Unzip it.
3. On CLI change directory to \Holdthedoors-master\chirr\chirr_server\chirr\core
Run: 
```sh
mvn clean install -U -DskipTest
```
Once it is finished you can run the server and database running the next command:
```sh
java -jar \target\NAMEOFTHEJARINTHEFOLDER.jar
```
Now the server should be running.

Since we are using Sencha for the Front-end, let's prepare the app.
Open another CLI and you should be able to run:
```sh
sencha
```
Before running the app, you need to copy Extjs libraries in \Holdthedoors-master\Holdthedoors-master\chirr\chirr_client
The folder containing the libraries should be called "ext".

Once you placed the libraries yo can run the app:
```sh
cd  \Holdthedoors-master\chirr\chirr_client\chirr
```
```sh
sencha app watch
```

####You can find the app in [localhost:1841/chirr/]

####Made by HoldTheDoors
[localhost:1841/chirr/]: <http://localhost:1841/chirr/>
