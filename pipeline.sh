#!/usr/bin/env bash
set -e
oc whoami &> /dev/null || oc login
oc project srang-quarkus
cd bracket-api
mvn clean install -Pdev

oc get secret gh-pkg-secret &>/dev/null || oc apply -f .configuration/gh-secret.yaml

oc cancel-build bc/madness-manager
#helm upgrade --dry-run --repo https://charts.bitnami.com/bitnami --version 8.9.4 --install --wait madness-data postgresql
#helm upgrade --dry-run --install  madness-manager ./src/main/k8s/madness-manager -n srang-quarkus

#helm upgrade --install  madness-manager ./src/main/k8s/madness-manager -n srang-quarkus
#
#oc start-build bc/madness-manager
#
#oc logs -f bc/madness-manager
#
#oc rollout restart deployment/madness-manager