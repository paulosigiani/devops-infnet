#!/bin/bash

echo "Criando namespace..."
kubectl create namespace musicoapp

echo "Sobe PV do Prometheus"
kubectl apply -f monitoramento/prometheus-pv.yaml -n musicoapp

echo "Sobe PVC do Prometheus"
kubectl apply -f monitoramento/prometheus-pvc.yaml -n musicoapp

echo "Sobe Deploy do Prometheus/Grafana"
kubectl apply -f monitoramento/prometheus-grafana-deploy.yaml -n musicoapp

echo "Sobe service do Prometheus"
kubectl apply -f monitoramento/prometheus-svc.yaml -n musicoapp

echo "Sobe service do Grafana"
kubectl apply -f monitoramento/grafana-svc.yaml -n musicoapp

echo "Sobe PV do musico/banco-de-dados"
kubectl apply -f musico-pv.yaml -n musicoapp

echo "Sobe PVC do musico/banco-de-dados"
kubectl apply -f banco-pvc.yaml -n musicoapp

echo "Sobe Deploy banco de dados"
kubectl apply -f banco-deploy.yaml -n musicoapp

echo "Sobe Deploy da aplicação"
kubectl apply -f musico-deploy.yaml -n musicoapp

echo "Sobe service da aplicação"
kubectl apply -f musico-svc.yaml -n musicoapp

echo "Sobe service do banco de dados"
kubectl apply -f banco-svc.yaml -n musicoapp

echo "Sobe service do monitoramento do banco de dados"
kubectl apply -f banco-monitoramento-svc.yaml -n musicoapp

echo "Pronto. Script executado."
