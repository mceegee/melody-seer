# melody-seer
## MARTA CARBONELL GIMÉNEZ

*Ad-free music and videos*

### Unidad de Trabajo 4 - Usabilidad

**Aspecto, color, iconos, texto, distribución de los componentes.**

    1. ASPECTO:

    - Cambios sustanciales en el aspecto: arreglo de la alineación de los componentes, unificación del tipo de iconos, disminución del número de colores. 
     
    2. COLOR:

        - Reducción del número de colores usados al suprimirse la clasificación de los vídeos según local, cloud o ambos. Ahora se hace mediante iconos. 

        - Reducción del número de colores al cambiar el tipo de iconos utilizados: han pasado de ser iconos a todo color a ser flat icons. 


    3. ICONOS: 

        - Se añade un botón de retorno a un label que representa una flecha apuntando a la izquierda en el PreferencesPanel

        - Se añade el símbolo de una carpeta en todos los botones donde el usuario puede seleccionar la carpeta deseada (Uno en DownloadPanel, dos en PreferencesPanel)

        - Cambio en la visualización de archivos locales, en la nube y ambos: se pasa de leyenda mediante colores a uso de iconos para hacerlo más claro. 

        - Filtro mediante icono de búsqueda + tooltip

        - Eliminación de iconos innecesarios


    4. TEXTO

    - Se aumenta la cantidad de texto de la aplicación para ayudar a la usabilidad, principalmente mediante feedback a las acciones que se toman.

    - Uso de colores y negrita para ayudar con la comprensión de lo que ocurre: rojo para errores, negrita para marcar títulos.


     5. DISTRIBUCIÓN DE LOS COMPONENTES:

         Para mejorar el aspecto de la aplicación, se ha cambiado la distribución de los componentes, puesto que no estaban alineados. Para conseguirlo, se han usado:
          - Card Layout: Para poder ir mostrando los diferentes paneles sin que estos ocupen espacio
          - MigLayout: Para distribuir los elementos en la rejilla. En este caso, hemos consultado los siguientes documentos
          http://www.miglayout.com/
          http://www.migcalendar.com/miglayout/mavensite/docs/cheatsheet.pdf 
          http://www.miglayout.com/QuickStart.pdf 

         - Se ha movido el Media Panel a la ventana principal.


**Affordance. Feedback. Restricciones.**

     1. AFFORDANCE

     - De manera predeterminada, los ComboBox con el formato ya tienen una opción preseleccionada en lugar de aparecer en blanco. Así, el usuario pude percibir mejor qué opciones están disponibles según la categoría.

    
     2. FEEDBACK:

     - Se añade mensaje de fallo de login en color rojo. Se elimina el JOptionPane para hacer menos intrusivo el feedback.

     - JTextFields para informar al usuario de la carpeta en que se van a descargar los archivos y los archivos temporales en DownloadPanel y PreferencesPanel.

     - Feedback al subir, bajar y eliminar vídeos mediante lbls y JoptionPane

     - Mensaje de error en caso de recibir Error 403 de yt-dlp

     - Feedback en caso de no encontrar el programa yt-dlp


     3. RESTRICCIONES: 

     - No se permite al usuario pulsar el botón de login a menos que haya completado los campos de username y password. 
       En caso de borrar el contenido, se vuelve a deshabilitar el botón. Implementación mediante KeyAdapter. 

     - No se permite subir archivos que ya están en la nube. Tampoco se permiten descargar archivos que ya se tienen locales. 

**Otras mejoras en la usabilidad**

     - Arreglado problema con la progress bar: ya muestra la barra completa al finalizar la descarga sin importar el formato de % que recibamos.

     - Mejoras en la recuperación de archivos locales, lo cual lleva a que ya no aparezcan archivos locales con tamaño 0.

**Gestión de errores**

     - Aviso al usuario en caso de que el login sea incorrecto mediante mensaje en la pantalla correspondiente.
    
     - Aviso en caso de no encontrar el programa yt-dlp mediante un mensaje al usuario.
    
     - Aviso en caso de que yt-dlp no funcione correctamente por error 403 (en ocasiones ocurre si se intentan descargar varios archivos seguidos).

### Unidad de Trabajo 3 - Creación de componentes visuales

### DI02_02

Problema: Fecha en ISO

Recursos: https://stackoverflow.com/questions/3914404/how-to-get-current-moment-in-iso-8601-format-with-date-hour-and-minute 

Problema: Llamadas constantes a la API aunque no estemos en la pantalla adecuada

Solución: isShowing()

Recursos: https://forums.oracle.com/ords/apexds/post/isvisible-problem-5963

### DI02_03 

Problema: Excepción al deserializar la fecha

Solución: anotación @JsonFormat

Recursos: https://stackoverflow.com/questions/40327970/deserialize-java-8-localdatetime-with-jacksonmapper 


Problema: Diferentes colores según origen de los archivos

Solución: Creación de clase TableCellRenderer

Recursos: https://stackoverflow.com/questions/3875607/change-the-background-color-of-a-row-in-a-jtable
http://stackoverflow.com/questions/45925416/confusion-over-a-jtables-setdefaultrenderer-method 
https://stackoverflow.com/questions/18167512/java-jtable-sort-with-tablecellrenderer 

### Unidad de Trabajo 1 - Confección de interfaces de usuario

**MAIN**

* Problema: La aplicación se tiene que cerrar al pulsar el botón de Exit

Solución: System.exit(NORMAL);

Recursos: 
Explicación en Stack Overflow: https://stackoverflow.com/questions/33017359/how-to-make-window-close-on-clicking-exit-menuitem

**EN PREFERENCES**

* Problema: Uso de ProcessBuilder

Solución y recursos: Publicados en el foro de la unidad en la plataforma.

* Problema: no entiendo qué hace el método publish() en el método doInBackground

Solución: consulta online

Recursos: 
explicación en Stack Overflow https://stackoverflow.com/questions/18535303/how-are-the-publish-and-process-methods-on-swingworker-properly-used 

* Problema: no funciona la Progress Bar

Solución: usando regex se hace split de los mensajes que nos pasa yt-ldp y se alimenta el porcentaje al objeto de la Progress Bar usando el método setValue().

Recursos: 
Pasar de Matcher a String: https://stackoverflow.com/questions/25277300/how-to-return-a-string-which-matches-the-regex-in-java
Cómo alimentar información de progreso a la Progress Bar: https://docs.oracle.com/javase/tutorial/uiswing/components/progress.html

* Problema: quiero seleccionar un directorio usando JFileChooser

Solución: uso de JFileChooser con la opción DIRECTORIES_ONLY + guardar el path absoluto del directorio

Recursos: 
Vídeo de Youtube: https://www.youtube.com/watch?v=HQ8JAbHmOvs 
Stack Overflow: https://stackoverflow.com/questions/10083447/selecting-folder-destination-in-java 

* Problema: Necesito añadir distintas opciones al ProcessBuilder

Solución: usar diferentes argumentos para el comando

Recursos: 
Documentación de Oracle: https://docs.oracle.com/javase/8/docs/api/java/lang/ProcessBuilder.html#ProcessBuilder-java.util.List- 

**EN ABOUT**

* Problema: necesito que se cierre solo el diálogo cuando pulso el botón de Close

Solución: método dispose()

Recursos: 
Stack Overflow:  https://stackoverflow.com/questions/6969164/button-for-closing-a-jdialog 

### DI01_02

* Problema: serialización de los objetos

Recursos: https://www.geeksforgeeks.org/java/serialization-and-deserialization-in-java/ 

* Problema: Extraer información diferente de objetos de la misma clase, que se alimentan del método toString()

Solución: creación de clases intermedias -- MyFileMimeModel y MyFileDateModel

* Problema: ordenación de tablas

Recursos: https://www.youtube.com/watch?v=K648UkfJQMY

* Problema: filtrado de tablas

Recursos: https://www.youtube.com/watch?v=6EclI2pzLiU

* Problema: el filtrado no funcionaba bien

Solución: uso de Pattern.quote

Recursos: https://stackoverflow.com/questions/79557037/java-jtable-rowfilter-doesnt-work-properly 

