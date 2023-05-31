#language: es
Característica: Automatizacion Test

  Antecedentes: 
    Dado un usuario que ingrese a la pagina de fallabella

  @RegistrarUsuarioFallabella
  Esquema del escenario: Registrar usuario en fallabella
    Cuando seleccione el desplegable registrarte
    Y llene el formulario con la siguiente informacion <Nombre><PrimerApellido><RUT><Celular><Correo><Contrasena>
    Entonces se permite el registro de un usuario en el portal

    Ejemplos: 
      | Nombre   | PrimerApellido   | RUT           | Celular      | Correo                   | Contrasena    |
      | "pepito" | "Perez Carrillo" | "9.995.632-1" | "3133421083" | "emailprueba0016@mail.com" | "Password123" |

  @EliminarProductosCarrito
  Esquema del escenario: Eliminar productos seleccionados del carrito
    Cuando realice la busqueda <Busqueda>
    Y seleccione el producto con nombre <Producto>
    Y agrege al carrito aumentando la cantidad maxima por producto
    Entonces permite eliminar la cantidad total de la orden

    Ejemplos: 
      | Busqueda       | Producto                                 |
      | "control Play" | "Mando control para play station 4 rojo" |

  @HacerCompraPorCarrito
  Esquema del escenario: Realizar la compra por el carrito
    Cuando realice la busqueda <Busqueda>
    Y seleccione el producto con nombre <Producto>
    Y agrege al carrito aumentando la cantidad maxima por producto
    Y se agregue el <Correo> para continuar la compra
    Y agregue una direccion valida <Direccion>
    Entonces se permite hacer la compra con los datos en medios de pago <NumeroTarjeta><CVV><RUT><Mes><Ano>

    Ejemplos: 
      | Busqueda       | Producto                                 | Correo                   | Direccion                                                             | NumeroTarjeta  | CVV    | RUT              | Mes  | Ano    |
      | "control Play" | "Mando control para play station 4 rojo" | "Praueasdasdba1aas23@mail.com" | "Av. Carlos Valdovinos 200, San Joaquín, Región Metropolitana, Chile" | "321351651651" | "1236" | "12345678910110" | "04" | "2023" |
