// Crear nodos de usuario
CREATE (juan:Usuario {id: 1, nombre: 'Juan Pérez'})
CREATE (ana:Usuario {id: 2, nombre: 'Ana Gómez'})

// Crear nodos de productos
CREATE (laptop:Producto {id: 1, nombre: 'Laptop X200'})
CREATE (smartphone:Producto {id: 2, nombre: 'Smartphone Y10'})

// Crear nodos de categorías
CREATE (electronica:Categoria {id: 1, nombre: 'Electrónica'})
CREATE (tecnologia:Categoria {id: 2, nombre: 'Tecnología'})

// Relacionar productos con categorías
CREATE (laptop)-[:PERTENECE_A]->(electronica)
CREATE (smartphone)-[:PERTENECE_A]->(tecnologia)

// Relacionar usuarios con productos buscados
CREATE (juan)-[:BUSCÓ]->(laptop)
CREATE (juan)-[:BUSCÓ]->(smartphone)
CREATE (ana)-[:BUSCÓ]->(laptop)
