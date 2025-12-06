# melody-seer
## MARTA CARBONELL GIMÉNEZ

*Ad-free music and videos*

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

DI02_02

Problema: Fecha en ISO
Recursos: https://stackoverflow.com/questions/3914404/how-to-get-current-moment-in-iso-8601-format-with-date-hour-and-minute 

Problema: Llamadas constantes a la API aunque no estemos en la pantalla adecuada
Solución: isShowing()
Recursos: https://forums.oracle.com/ords/apexds/post/isvisible-problem-5963