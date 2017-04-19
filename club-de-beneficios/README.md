# aydoo2017
Ejercicio Club de Beneficios

Tengo la clase CLubDeBeneficios que se encarga de realizar las operaciones para recoleccionde datos de los mails que planteaba el problema. Eśta tiene una lista de Establecimientos y estos a su vez la lista de Sucursales que se encargadn de realizar las ventas. La clase Venta se encarga de relacionar los datos que corresponden con el reporte de ahorros del cliente que luego son tomados y relacionados en la clase ReporteDeAhorros.
La clase abstracta Beneficio englobla a las clases BeneficioDescuento, BeneficioDosPorUno y cada uno se encarga de armar los productos con los importes correspondientes al enviarselos.Supuse que el beneficio 2 x 1 se aplica a 2 productos q son el mas caro y el mas barato dando por sin costo al mas barato, pero siempre aplicando solo a 2 de los productos que compre el cliente.
Una parte que quedo medio extraña es en la clase de ClubDeBeneficios al calcular el reporte de Ahorros realizo muchos foreach para obtener los distintos clientes que hay en cada venta. No se si esa parte podria mejorarse de alguna manera



