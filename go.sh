echo api service stopping..
docker-compose down
echo api service starting..
docker-compose  up -d --build
