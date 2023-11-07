# TP3_PARCIAL_BELGRANO_GRUPO4
Grupo 4: Alarcon:: clarAlarconDev, Barboza
: melisabarboza , Guzman: Rosa2108, Espiñeira: JoacoEspi y Fontana: CorinaFM

1. En el caso que se pida extender la app para otros tipos de
mascotas, por ejemplo gatos, ¿la app es flexible? ¿Qué cambios
realizarían?

EL proyecto se ha diseñado con una estructura modular que fomenta la reutilización de código. Esto significa que la aplicación es flexible y se puede extender para incluir nuevas entidades sin problemas. Actualmente, la estructura incluye componentes como RecyclerView, Drawer y Bottom Navigation, los cuales son completamente adaptables para incorporar una nueva entidad.

Cambios: Anexo de Nueva Entidad sumado a su estructura DAO (Data Access Object)

2. ¿Qué tipo de arquitectura usaron y por qué? ¿Podría mejorarla?

Se uso el patrón MVVM (Model-View-ViewModel) resulto beneficioso debido a su capacidad para separar de manera efectiva la lógica, la interfaz de usuario y la presentación de datos. Mejora la reactividad de la interfaz de usuario al permitir la notificación de cambios en los datos, facilita las pruebas , y hace que el mantenimiento y la adaptación a cambios sean más sencillos. En resumen, permite tener una arquitectura organizada y escalable.

3. ¿Tuvieron fugas o retención de memoria? ¿Qué consideraciones
tuvieron en cuenta?

En ocasiones, la sincronización de Gradle descargaba archivos de gran tamaño, lo que generaba problemas al intentar cargar los cambios en Git. Para abordar este problema, se implementó la pausa en la descarga automática de actualizaciones de Gradle desde Internet al configurar la propiedad en "False". Esta optimización ha tenido un impacto significativo en el rendimiento de la aplicación, evitando el agotamiento de recursos de la PC y asegurando un funcionamiento eficiente durante la ejecución de la aplicación.

4. ¿Qué mejoras detectan que podrían realizarle a la app?
ste proyecto ha experimentado varias mejoras significativas para optimizar la aplicación:

- Anexo de Temas: Se han añadido nuevos temas y estilos para una personalización más sencilla de Activities y Fragments.

- Configuración del Modo Oscuro: El Modo Oscuro se configura por defecto, mejorando el diseño y asegurando una experiencia de usuario consistente desde el inicio.

- Mejora en la Persistencia de Datos: Se ha establecido una conexión con una base de datos más eficiente, garantizando una mejor gestión de la persistencia de datos.

Estas mejoras buscan proporcionar un entorno de desarrollo más efectivo y una experiencia de usuario mejorada. Tus sugerencias para seguir mejorando son siempre bienvenidas.
