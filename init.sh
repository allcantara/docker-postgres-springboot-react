#!/bin/bash

echo ""
echo "Configuring Spring Boot backend project..."
echo ""

cd api
./mvnw clean install
cd ../

echo "Ok"

echo ""
echo ""
echo "Setting up ReactJS frontend project..."
echo ""

cd web
npm install
cd ../

echo "Ok"

echo ""
echo ""
echo "Running Docker Compose..."
echo ""

docker-compose up --build
echo ""
echo "Finished!"

