# Modificación del perfil de usuario

| Profile Antes | EditProfile Antes |
|:---:|:---:|
| <img width="532" src="https://github.com/user-attachments/assets/652e5c1b-e125-459e-87b6-68d7f2595041" /> | <img width="532" src="https://github.com/user-attachments/assets/7bdf8c0c-6f2a-4d7d-9ea5-21b6442f8706" /> | 


| Profile después | EditProfile después |
|:---:|:---:|
| <img width="532" height="1166" alt="image" src="https://github.com/user-attachments/assets/0d6a13f9-fdff-4476-afe3-d5c588b268df" /> | <img width="532" height="1169" alt="image" src="https://github.com/user-attachments/assets/d08c559c-81f1-4504-9e29-df66e3cff295" /> |
 


## 1. Pantalla de perfil (ProfileScreen)

Se ha modificado la pantalla del perfil para mostrar la información del usuario de una forma más organizada y visual.

Los cambios realizados son:

- **Cabecera:** se ha añadido el título «El meu perfil» junto a un botón para acceder a la edición.
- **Información del usuario:** se muestra la foto de perfil, el nombre y el correo electrónico.
- **Datos personales:** se muestran la altura, el peso, la edad y el género mediante tarjetas individuales.
- **Objetivo:** se ha añadido una sección donde se muestra el objetivo personal del usuario.

También se ha añadido desplazamiento vertical para poder consultar toda la información sin que quede fuera de la pantalla.

Se ha creado el componente `DadaPerfil()` para reutilizar el diseño de las tarjetas que muestran los datos personales.

## 2. Pantalla de edición (EditProfileScreen)

Se ha creado una pantalla para permitir al usuario modificar los datos de su perfil.

Las funcionalidades añadidas son:

- **Foto de perfil:** permite seleccionar una imagen de la galería o eliminar la foto seleccionada para volver a la imagen predeterminada.
- **Datos personales:** permite modificar el nombre, el correo electrónico, la fecha de nacimiento y el género.
- **Datos físicos:** permite introducir la altura y el peso.
- **Objetivo:** permite seleccionar entre ganar masa muscular, perder grasa o mantener el peso.
- **Botones de acción:** se han añadido dos botones para guardar los cambios o cancelar la edición.

Para facilitar la introducción de datos, se han utilizado campos `OutlinedTextField`, un selector de fechas personalizado (`OutlinedDatePickerField`) y menús desplegables (`MenuDesplegable`).

## 3. Gestión de los datos (MainActivity)

Se ha modificado `MainActivity` para controlar la navegación entre las dos pantallas y gestionar la información del usuario.

Se utiliza `remember` junto con `mutableStateOf` y `mutableIntStateOf` para almacenar los datos y mantenerlos actualizados.

También se han creado variables temporales para la edición. De esta manera:

- Al entrar en la edición, los datos originales se copian en las variables temporales.
- Al pulsar **Guardar cambios**, los nuevos valores se guardan y se actualiza el perfil.
- Al pulsar **Cancelar**, se descartan los cambios y se vuelve al perfil sin modificar los datos originales.

Así se consigue que los cambios solo se apliquen cuando el usuario confirma que quiere guardarlos.

## 4. Componentes utilizados

- `ProfileScreen()`: muestra la información del perfil.
- `EditProfileScreen()`: permite editar los datos del usuario.
- `DadaPerfil()`: muestra los datos personales mediante tarjetas reutilizables.
- `MenuDesplegable()`: permite seleccionar opciones mediante un menú desplegable.
- `OutlinedDatePickerField()`: permite seleccionar la fecha de nacimiento mediante un calendario.

## 5. Resultado final

Se han actualizado las pantallas del perfil y de edición para ofrecer una interfaz más organizada y permitir modificar los datos personales, físicos y los objetivos del usuario.

Además, se ha implementado la gestión de los cambios para que el perfil se actualice correctamente al guardar y mantenga los datos originales si se cancela la edición.
