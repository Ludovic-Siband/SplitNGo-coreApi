.PHONY: dev prod up down logs

# Start in development mode (hot reload)
dev:
	BUILD_MODE=dev docker-compose up --build -d

# Start in production mode (compiled JAR)
prod:
	BUILD_MODE=prod docker-compose up --build

# Start using default settings
up:
	docker-compose up --build

# Stop and remove containers
down:
	docker-compose down

# Show and follow logs
logs:
	docker-compose logs -f
