# disruptive-guestbook ( Spring Boot 2 with Kotlin demo)


This is a demo how to deploy a spring boot app to k8s, based on the demo 

## Requirements

* Docker Desktop with [Docker-Compose](https://docs.docker.com/compose/install/)
* JDK 11 
* Giphy API-Key (can be created [here](https://developers.giphy.com/dashboard/))

## Run the application locally 

1. Set your giphy api key in [application.properties](spring-kotlin-demo/src/main/resources/application.properties)
2. Start the local mongodb by `docker-compose up`
3. Build and run the Application by `./gradlew bootRun`
4. Open the web application in your browser:  [http://localhost:8080](http://localhost:8080)
5. Stop the mongodb by `docker-compose down`


## Prepare k8s on docker desktop

1. Enable kubernetes on docker desktop : https://docs.docker.com/desktop/kubernetes/ 
2. Install nginx ingress controller:  https://kubernetes.github.io/ingress-nginx/deploy/#docker-desktop
3. Install mongodb into cluster:
```bash
kubectl apply -f deploy/db/mongodb.yaml
```

## Deploy the app
0. Build the container & check that no pod is running  
```bash
./gradlew build
kubectl get pods
docker build -t disruptive-guestbook:1.0.0 .
```
1. Apply the [deployment resource](deploy/deployment.yaml)
```bash
kubectl apply -f deploy/deployment.yaml 
watch kubectl get pods
```
2. Port-Forward into pod
```bash
kubectl port-forward disruptive-guestbook-677f8c5589-l7b8c 8080:8080
open http://localhost:8080
```
3. Apply the [service resource](deploy/service.yaml)
```bash
kubectl apply -f deploy/service.yaml 
kubectl get service disruptive-guestbook
```
4. Port-Forward into service
```bash
kubectl port-forward service/disruptive-guestbook 8081:80
open http://localhost:8081
```
5. Apply the [ingress resource](deploy/ingress.yaml)
```bash
kubectl apply -f deploy/ingress.yaml
open http://disruptive.127.0.0.1.nip.io
```

6. Apply the [deployment with enviorment variable resource](deploy/deployment-with-env.yaml) to add api key and DB config
```bash
# First change API Key then
kubectl apply -f deploy/deployment-with-env.yaml
open http://disruptive.127.0.0.1.nip.io
```

8. Make Change in app, build new version and deploy
```bash
# fix index.html
./gradlew build
docker build -t disruptive-guestbook:1.1.0 .
# update version number in deploy/deployment-with-env.yaml
kubectl apply -f deploy/deployment-with-env.yaml
```
