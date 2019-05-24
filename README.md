# Pasos para mover un paquete del proyecto a un submódulo

- Crear el repositorio del submódulo. Agregar un readme (el repositorio del submódulo no puede estar vacío al agregarlo al repositorio del proyecto).

- Agregar el submódulo:

git submodule add git@github.com:elagarrigue/AyDS-JSubModuleSpotifyData.git libs/SpotifyData

![](docs/screenshots/01.png)

- En el proyecto de IntelliJ, crear un nuevo módulo (android library).

![](docs/screenshots/02.png)

![](docs/screenshots/03.png)

![](docs/screenshots/04.png)

- Seleccionen la carpeta del submódulo.

![](docs/screenshots/05.png)

![](docs/screenshots/06.png)

- Actualizar el .gitignore del submódule (copiar el mismo que el del proyecto base). Hacer commit y push del submódulo y del proyecto.

![](docs/screenshots/07.png)

- Crear en el módulo un paquete con nombre relevante.

![](docs/screenshots/08.png)

- Mover el paquete “external” de model al módulo.

![](docs/screenshots/09.png)

- El nuevo módulo tiene ahora referencias a retrofit y gson. COPIAR esas dependencias de app/build.gradle a libs/SpotifyData/build.gradle.
Nota: moverlas debería ser suficiente, pero al sacarlas no exporta las librerías en el assemble y tira error en runtime.

![](docs/screenshots/10.png)

![](docs/screenshots/11.png)

- El proyecto va a dejar de compilar, ya que el código de external no lo tenemos más. 

![](docs/screenshots/12.png)

- Lo primero que hay que hacer es agregar la dependencia del nuevo módulo vía gradle. 

![](docs/screenshots/12b.png)

- Es necesario agregar el include en settings

![](docs/screenshots/12c.png)

- Además, hace falta agregar la depencia en Module Settings. 
Nota: Esto debería poder hacerse via gradle mediante ‘compile project’ pero no está funcionando. Dado que lo siguiente modifica archivos del ide ignorados en el repo, hay q agregarlo en cada copia local.

![](docs/screenshots/13.png)

![](docs/screenshots/14.png)

![](docs/screenshots/15.png)

![](docs/screenshots/16.png)

![](docs/screenshots/17.png)

![](docs/screenshots/18.png)

- Si external no era independiente (tenia referencias por fuera del paquete), el modulo no va a compilar. 

![](docs/screenshots/19.png)


- En este caso, tenemos que implementar nuestra propia clase (una copia de Song), y luego hacer la conversión en Repository.

![](docs/screenshots/20.png)

![](docs/screenshots/21.png)

![](docs/screenshots/22.png)

- Hacer Clean, build, run. Una vez que compile y ejecute correctamente hacer commit y push del repo del submódulo, y del proyecto. 

![](docs/screenshots/23.png)



