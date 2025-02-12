import redis
import pyodbc
from neo4j import GraphDatabase
import time

# Conexión a Redis
r = redis.StrictRedis(host='localhost', port=6379, db=0)

# Conexión a SQL Server
conn = pyodbc.connect('DRIVER={SQL Server};SERVER=localhost;DATABASE=RecomendacionesDB;UID=sa;PWD=tu_contraseña')
cursor = conn.cursor()

# Conexión a Neo4j
driver = GraphDatabase.driver("bolt://localhost:7687", auth=("neo4j", "neo4j"))
session = driver.session()

# Función para almacenar las búsquedas en Redis
def store_search(user_id, product_id):
    key = f"user:{user_id}:searches"
    r.lpush(key, product_id)
    r.ltrim(key, 0, 4)  # Mantener solo las últimas 5 búsquedas
    r.expire(key, 86400)  # Expira en 24 horas

# Función para obtener las últimas búsquedas de un usuario
def get_recent_searches(user_id):
    key = f"user:{user_id}:searches"
    return r.lrange(key, 0, -1)  # Devuelve las últimas búsquedas

# Función para verificar si la caché ha expirado
def check_cache_expiry(user_id):
    key = f"user:{user_id}:searches"
    return r.ttl(key)  # Devuelve el tiempo restante antes de que expire

# Función para almacenar en SQL Server si la caché ha expirado
def store_search_in_sql(user_id, product_id):
    cursor.execute("INSERT INTO Busquedas (UsuarioID, ProductoID) VALUES (?, ?)", user_id, product_id)
    conn.commit()

# Función para sincronizar con Neo4j
def sync_with_neo4j(user_id, product_id):
    session.run("MERGE (u:Usuario {id: $user_id}) "
                "MERGE (p:Producto {id: $product_id}) "
                "MERGE (u)-[:BUSCÓ]->(p)", user_id=user_id, product_id=product_id)

# Función para almacenar y sincronizar búsquedas
def store_search_and_sync(user_id, product_id):
    store_search(user_id, product_id)  # Almacenar en Redis
    
    # Si la caché ha expirado, almacenar en SQL Server
    if check_cache_expiry(user_id) <= 0:
        store_search_in_sql(user_id, product_id)
    
    # Sincronizar con Neo4j
    sync_with_neo4j(user_id, product_id)

# Ejemplo de uso:
store_search_and_sync(1, 1)  # Ejemplo para el usuario 1 y el producto 1
