# API DE BÚSQUEDA DE ALERTAS

Esta es un API Restfull que permite consultar las alertas de los servidores de MeLi por medio de diferentes propiedades que permiten una identificación rápida de las alertas y a que servidores pertenecen.

EL problema planteado se describe en la siguiente [wiki](https://github.com/boti2011/challenge-meli/wiki/Planteamiento-del-problema).

## Instalación

Se debe tener instalado lo siguiente:
- Gradle versión 6.7.1
- JDK1.8

Usar brew para la instalación de estos paquetes.

- [Install java with brew](https://devqa.io/brew-install-java/)
- [Install gradle with brew](https://docs.gradle.org/current/userguide/installation.html)

## Uso
Clonar el repositorio de forma local


```git
git clone https://github.com/boti2011/challenge-meli-query.git
```
Abrir una consola en la raíz donde fue clonado el repositorio.

Ejecutar los siguientes comandos para descargar las dependencias y verificar que el proyecto corra correctamente (verificar tener la versión de java y gradle correspondiente):

```gradle
gradle --refresh-dependencies
gradle clean build
```
Para ejecutar el API realizar: 

```gradle
gradle bootrun
```

## Consumir API
Puede realizar el consumo a través de postman, descargando el siguiente [archivo](https://github.com/boti2011/challenge-meli-query/tree/master/src/main/resources/postman)
### NOTA

Para consumir el API desplegado, cambiar [http://localhost:8093/]() por [http://challenge-meli-query.herokuapp.com/]()
