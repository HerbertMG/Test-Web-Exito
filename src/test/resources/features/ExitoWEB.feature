#language: es

Característica: Como usuario de la web Exito.com, quiero comprar productos y agregarlos al carrito, para gestionar mis compras

  Antecedentes: Ingresar a la Web
    Dado que un usuario ingresa al HOME de la WEB


  @Escenario1
  Esquema del escenario: [TEST-001] - Validar productos agregados correctamente en el carrito
    Cuando selecciona una <categoria> con <subcategoria>
    Y selecciona <cantidad> productos aleatorios con cantidades aleatorias
    Entonces se validara el nombre de los productos en el carrito
    Y se valida el precio total
    Y se valida la cantidad de cada producto agregado
    Y se valida el total de productos agregados
    Ejemplos:
      | categoria  | subcategoria | cantidad |
      | Dormitorio | Cabeceras    | 5        |
