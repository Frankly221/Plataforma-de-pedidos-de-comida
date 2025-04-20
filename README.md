# Plataforma-de-pedidos-de-comida
RappiClone es una aplicación de backend construida con Java 21, Spring Boot 3.2+ y arquitectura limpia (Clean Architecture), que simula una plataforma de pedidos de comida tipo Rappi o Uber Eats. 


Este proyecto forma parte de mi portafolio para demostrar habilidades en desarrollo backend avanzado, diseño de arquitecturas desacopladas, patrones de diseño y buenas prácticas con Java.

#----------------------------------------------------------------------------------------
✨ Características principales
📦 Microservicios independientes (Usuarios, Productos, Pedidos, Pagos, Notificaciones)

🔐 Autenticación y autorización con JWT y control de roles (cliente, restaurante, repartidor)

📄 Arquitectura limpia (hexagonal) con separación clara de responsabilidades

💳 Simulación de pagos (integración con Stripe)

🚚 Seguimiento del pedido en tiempo real (Kafka, WebSocket o similar)

🛠️ Comunicación entre servicios (REST o mensajería con Kafka/RabbitMQ)

☁️ Configuración centralizada (Spring Cloud Config)

🚪 API Gateway para entrada única al sistema

🧪 Pruebas unitarias y de integración

🐳 Docker y Docker Compose para levantar todo el ecosistema fácilmente

#----------------------------------------------------------------------------------------

📦 Tecnologías utilizadas

Lenguaje :	Java 21
Framework :	Spring Boot 3.2+, Spring Cloud
Arquitectura :	Clean Architecture / Hexagonal
Seguridad :	Spring Security + JWT
Base de datos :	MySQL / PostgreSQL
Mensajería :	Kafka / RabbitMQ (a definir según módulo)
Configuración :	Spring Cloud Config
Gateway :	Spring Cloud Gateway
Contenedores :	Docker + Docker Compose
Documentación : API	Swagger / OpenAPI


#----------------------------------------------------------------------------------------
🧩 Estado del proyecto
🔨 En desarrollo. Actualmente construyendo el microservicio de Productos con estructura modular y arquitectura limpia.
