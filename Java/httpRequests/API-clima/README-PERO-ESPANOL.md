API CLIMA

API: https://api.open-meteo.com/v1/forecast
Ciudad: Madrid, España
Formato de datos: JSON

Proceso de ejecución:

- Importación de los módulos necesarios.
- Declaración de la URL.
- Inicio del método "main" con una instrucción "println" que muestra un título principal.
- Creación de un "HttpClient", que será el encargado de enviar nuestras solicitudes.
- Construcción del "HttpRequest", donde preparamos la URL y la llamada.
- Envío de las solicitudes mediante el método ".send()" del cliente y almacenamiento de la respuesta de la API en un objeto "HttpResponse" de tipo "String".
- Comprobación de posibles errores.
- Guardado de la información recibida en forma de logs dentro del directorio "evidencias".
- Transformación del JSON recibido a un formato con el que Java pueda trabajar.
- Declaración de variables para almacenar los parámetros contenidos en el JSON, como "viento" (wind) y "temperatura" (temperature).
- Impresión de todos los parámetros en la consola.
- Conversión de las condiciones climáticas, representadas mediante códigos numéricos, a cadenas de texto legibles para el usuario mediante la función "describirClima()".
- Gestión de errores en caso de que el script genere alguna excepción.

USO DE IA: Sí

Tal como lo solicitaba la actividad, utilicé inteligencia artificial, en este caso ChatGPT, para que primero me explicara de diferentes maneras qué es SOA y cuáles son sus diferencias con los microservicios, además de resolver otras dudas que tenía antes de comenzar.

Luego, le pedí a ChatGPT que generara el código y que posteriormente me explicara qué hace cada una de sus partes, ya que todavía no había realizado solicitudes HTTP mediante Java. Todo esto asegurándome de que realmente estuviera aprendiendo y comprendiendo lo que hacía.

Por último, utilicé ChatGPT para traducir este mismo archivo README.md al español, ya que originalmente lo había escrito en inglés para poder publicarlo como proyecto en mi página de GitHub.