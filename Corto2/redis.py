import redis

# Conexión a Redis
r = redis.StrictRedis(host='localhost', port=6379, db=0)

# Función para almacenar las búsquedas en Redis
def store_search(user_id, product_id):
    key = f"user:{user_id}:searches"
    # Agregar búsqueda al inicio (si ya hay 5, eliminar la más antigua)
    r.lpush(key, product_id)
    r.ltrim(key, 0, 4)  # Mantener solo las últimas 5 búsquedas
    # Establecer un tiempo de expiración de 24 horas
    r.expire(key, 86400)  # 86400 segundos = 24 horas

# Función para obtener las últimas 5 búsquedas
def get_recent_searches(user_id):
    key = f"user:{user_id}:searches"
    return r.lrange(key, 0, -1)  # Devuelve las 5 últimas búsquedas

# Función para verificar si la caché expiró
def check_cache_expiry(user_id):
    key = f"user:{user_id}:searches"
    return r.ttl(key)  # Devuelve el tiempo restante antes de que expire
