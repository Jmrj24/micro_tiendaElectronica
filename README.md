<h1 align="center">Tienda Electrónica |Microservicios|</h1>
Este proyecto tuvó como objetivo crear una tienda de electrodomésticos online basada en una arquitectura de microservicios, para ofrecer una experiencia de compra fluida y eficiente. El sistema se compone de tres microservicios interconectados, cada uno encargado de una función clave en el proceso de compra:


Microservicio de Productos: Este servicio gestiona el catálogo de productos disponibles en la tienda, permitiendo listar los electrodomésticos y proporcionando detalles esenciales como código, nombre, marca y precio individual de cada artículo. Este servicio garantiza que la información de los productos esté siempre actualizada y sea accesible para otros servicios y usuarios.

Microservicio de Carrito de Compras: Este microservicio administra el carrito de compras de cada usuario, permitiéndoles agregar y quitar productos a su carrito. Cada carrito tiene un identificador único y un campo que almacena el precio total de los productos agregados. Este servicio es esencial para mantener la interacción del usuario con la tienda, asegurando que el proceso de compra sea claro y transparente.

Microservicio de Ventas: Este servicio se encarga de registrar todas las ventas realizadas en la plataforma. Cada venta recibe un número de identificación único y una fecha, y está asociada a un carrito de compras específico. A través de esta asociación, el microservicio de ventas puede calcular el monto total de la venta al consultar el carrito de compras, y obtener la lista de productos vendidos mediante la integración con el servicio de productos. Esto asegura que cada venta esté completamente documentada y que la información de los productos vendidos sea precisa.

La comunicación entre estos tres microservicios permite una integración fluida y un manejo eficiente de productos, carritos y ventas, brindando a los usuarios una experiencia de compra óptima.
