#!/usr/bin/env bash

echo "Removing containers..."
docker rm mongo mongo-express -f

echo "Up the dynamoDB container..."
docker-compose -f docker-compose.yml up --build -d
