# Examen Mercadolibre
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar
contra los X-Mens.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un
humano es mutante basándose en su secuencia de ADN.
Para eso te ha pedido crear un programa con un método o función con la siguiente firma:

## boolean isMutant(String[] dna);

En donde recibirás como parámetro un array de Strings que representan cada fila de una tabla
de (NxN) con la secuencia del ADN. Las letras de los Strings solo pueden ser: (A,T,C,G), las
cuales representa cada base nitrogenada del ADN.

![enter image description here](https://fotos.subefotos.com/861243f53091dc5758f70d9e73b3ec44o.jpg)

## No-Mutante Mutante

Sabrás si un humano es mutante, si encuentras más de una secuencia de cuatro letras
iguales, de forma oblicua, horizontal o vertical.
Ejemplo (Caso mutante):
String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
En este caso el llamado a la función isMutant(dna) devuelve “true”.
Desarrolla el algoritmo de la manera más eficiente posible.

## Desafíos:
### Nivel 1:
Programa (en cualquier lenguaje de programación) que cumpla con el método pedido por
Magneto.
### Nivel 2:
Crear una API REST, hostear esa API en un cloud computing libre (Google App Engine,
Amazon AWS, etc), crear el servicio “/mutant/” en donde se pueda detectar si un humano es
mutante enviando la secuencia de ADN mediante un HTTP POST con un Json el cual tenga el
siguiente formato:
POST → /mutant/
{
“dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}
En caso de verificar un mutante, debería devolver un HTTP 200-OK, en caso contrario un
403-Forbidden
### Nivel 3:
Anexar una base de datos, la cual guarde los ADN’s verificados con la API.
Solo 1 registro por ADN.
Exponer un servicio extra “/stats” que devuelva un Json con las estadísticas de las
verificaciones de ADN: {“count_mutant_dna”:40, “count_human_dna”:100: “ratio”:0.4}
Tener en cuenta que la API puede recibir fluctuaciones agresivas de tráfico (Entre 100 y 1
millón de peticiones por segundo).
Test-Automáticos, Code coverage > 80%.

# Solución
Se analizo la forma de evaluar una matrix de caracteres con 4 procesadores de forma vertical, horizontal, diagonal hacia arriba y diagonal hacia abajo.
Se verifico por cada procesador la suma de caracter que realiza match y al ser igual a 4 y dos grupos de caracteres que forman el GEN mutante, de tal forma tenemos la posibilidad de verificar siempre cualquier grupo de caracteres de ADN y sobretodo dinamizar el request de entrada para el analisis de los genes mutantes.


#### Tecnología Utilizada
- Eclipse
- Java 8
- Jdk 1.8
- Maven 3
- spring boot
- Google Cloud
- Google Cloud SQL (mysql)

#### Url Api Google Cloud 
https://mutants-detect.nw.r.appspot.com/

##### Metodo Post
https://mutants-detect.nw.r.appspot.com/mutant/

Content-Type: application/json

Request Mutante Permitido
```json
{
  "dna": [
    "AACCCC",
    "CTCAGC",
    "ACCAAA",
    "ACAAAC",
    "CAAATC",
    "CAACAA"] 
}
```
Response Status: 200 OK
MUTANT

Request Humano Permitido
```json
{
  "dna": 
  [
    "ACCTATC",
    "CTCACTT",
    "ACGCTAT",
    "ACCTACC",
    "CAATTCC",
    "CACCAAT",
    "CAACAAT"
  ]
}
```
Response Status: 403 Forbidden
ADN HUMAN!

##### Metodo Get STATS
https://mutants-detect.nw.r.appspot.com/stats/

Response
```json
{
"count_human_dna": 2,
"count_mutant_dna": 2,
"ratio": 1.0
}
```