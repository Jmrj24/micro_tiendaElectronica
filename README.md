# Tienda de Electrodomésticos Online

Este proyecto tiene como objetivo crear una tienda de electrodomésticos online utilizando una arquitectura de microservicios. El sistema está diseñado para ofrecer una experiencia de compra fluida y eficiente, con tres microservicios interconectados para gestionar productos, carritos de compras y ventas.

## Tecnologías Utilizadas

- **Lenguaje**: Java
- **Frameworks**: 
  - Spring Boot
  - Spring Cloud (Service Registry, Service Discovery, Load Balancing, Circuit Breaker, API Gateway, Config Server)
  - Spring Data JPA
- **Base de Datos**: MySQL
- **ORM**: Hibernate
- **Pruebas**: Postman
- **Contenerización**: Docker
- **Control de Versiones**: Git, GitHub

## Arquitectura

La aplicación está basada en una arquitectura de microservicios que incluye tres componentes principales:

1. **Microservicio de Productos**:
   - Gestiona el catálogo de productos disponibles en la tienda.
   - Proporciona información detallada como código, nombre, marca y precio.
   - Garantiza que la información de los productos esté siempre actualizada.

2. **Microservicio de Carrito de Compras**:
   - Permite a los usuarios agregar y quitar productos de su carrito.
   - Cada carrito tiene un identificador único y almacena el precio total de los productos agregados.
   - Facilita la interacción del usuario con la tienda y asegura un proceso de compra transparente.

3. **Microservicio de Ventas**:
   - Registra todas las ventas realizadas en la plataforma.
   - Cada venta está asociada a un carrito de compras específico y contiene la información de los productos vendidos.
   - Calcula el monto total de la venta al consultar el carrito de compras.

## Patrones de Diseño Implementados

- **Service Registry & Service Discovery**: Para la localización y descubrimiento de microservicios en un entorno distribuido.
- **Load Balancing**: Distribución de las solicitudes entre varias instancias de los servicios para mejorar la escalabilidad.
- **Circuit Breaker**: Para prevenir fallos en cascada y mejorar la resiliencia del sistema.
- **API Gateway**: Para centralizar el acceso a los microservicios y simplificar la gestión de las rutas.
- **Config Server**: Para gestionar la configuración centralizada de los microservicios.

Pruebas
Se utilizaron pruebas de API con Postman para verificar el funcionamiento de los microservicios, tanto en el entorno local como en un entorno cercano a producción.

