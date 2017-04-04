# aydoo2017
Ejercicio Libreria

El modelo permite resolver el problema.
Tengo la clase libreria que contiente una lista de Venta. La Venta posee un Cliente, 
un Mes, un Producto y la cantidad de productos.
La clase abstracta Producto englobla a las clases Libro, ArticuloDeLibreria,
y Suscripcion que a suvez Suscripcion es padre de Periodico y Revista. Cada objeto
sabe calcular su precio.
El punto flojo que noto es en la parte de Periodico y Revista a los que debo pasarles
un booleano  para indicar si son productos individuales o si deben comportarse como suscripciones
y asi manejar el calculo de precio en cada caso.

