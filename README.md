# Tienda-Generica

/***********************************    PROYECTO HECHO EN MYSQL, SPRING BOOT Y THYMELEAF    ***********************************\

	PARA INICIAR ABRIR EL PROYECTO EN NEATBEANS O ECLIPSE Y DAR EL BUILD AL PROYECTO PARA QUE DESCARGUE LAS 
	LIBRERIAS NECESARIAS.
	¡¡¡¡ NOTA !!!!: TANTO PARA NETBEANS O ECLIPSE ES NECESARIO TENER EL PLUGIN DE SPRING BOOT INSTALADO.

	HECHO LO ANTERIOR SIGA ESTOS PASOS:

---->	1- EJECUTAR EL SCRIPT: "ScriptInicial" en MySQL --> ESTO CREARA LAS TABLAS NECESARIAS PARA QUE PUEDA FUNCIONAR
	   EL PROYECTO.
	
---->	2- AL EJECUTAR EL SCRIPT SE CREARA LOS ROLES ADMIN Y USER, ADEMAS SE CREARA UN USUARIO ADMIN CON LOS SIGUIENTES
	   DATOS PARA QUE SE PUEDA LOGUEAR POR PRIMERA VEZ: usuario: admin , password: admin123456

	   NOTA: SI QUIERE CAMBIAR ESTOS VALORES DE ADMIN HAGA LO SIGUIENTE:

		 1-ELIMINE LOS DATOS CREADOS DEL USUARIO ADMIN EN LA TABLA USUARIO EN MYSQL Y LUEGO APLICAR CAMBIOS

		 2-EN SU IDE QUE ESTE USANDO Y EN EL PROYECTO UBIQUE ESTE PAQUETE -> Source Packages/Tienda.Generica.config
		   /CreateAdmin.java

                 3-EN LA CLASE CreateAdmin DESCOMENTE LO QUE ESTA COMENTADO Y LUEGO MODIFIQUE LOS DATOS QUE DESEE EN:
		   cedula,email,usuario,password, etc.

		 4-AHORA DE CLICK DERECHO EN Source Packages/Tienda.Generica/TiendaGenericaApplication.java, Y LUEGO RUN FILE,
		   ESTO ES PARA EJECUTAR EL PROYECTO

		 5- CUANDO EL PROYECTO YA TERMINE DE INICIAR, ACTUALICE LA BASE DATOS EN MYSQL Y REVICE SI SE CREO LOS DATOS DE
		    ADMIN EN LA TABLA USUARIO

		 6- LUEGO DEBE VOLVER A DEJAR LA CLASE CreateAdmin.java COMO ESTABA: COMENTANDO DE NUEVO LO QUE SE HABIA
		    DESCOMENTADO EN EL PASO 3 -> ESTO PARA QUE AL MOMENTO DE VOLVER A EJECUTAR EL PROYECTO NO VUELVA A CREAR
 		    EL USUARIO ADMIN Y GENERE ERROR

---->	3- EJECUTAR EL PROYECTO DANDO CLICK DERECHO SOBRE LA CLASE Source Packages/Tienda.Generica/TiendaGenericaApplication.java

---->   4- ABRIR EL NAVEGADOR Y NAVEGAR EN http://localhost:8080/ EN DONDE LE PEDIRA UN LOGIN CUYO USUARIO Y PASSWORD,
	   SE ESPECIFICARON EN EL PASO 2

---->   5- LISTO YA PUEDE OBSERVAR EL PROYECTO COMO TAL FUNCIONANDO

---->   6- EN EL PROYECTO ESTA UN ARCHIVO CSV DE GUIA PARA SUBIR PRODUCTOS

EXITOS , ESPERO LES SIRVA
