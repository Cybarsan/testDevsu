# Prueba tecnica de Devsu para desarrollador Backend Java Spring Boot

## Json para agregar clientes / personas, se pasa el parametro idcliente en el endpoint

'''{
        "contrasenia": "1234567",
        "estado": true,
        "persona": {
            "nombres": "Juana",
            "apellidos": "De Arco",
            "fechanacimiento": "1974-07-05T04:00:00.000+00:00",
            "nroidentificacion": "654654654",
            "telefono": "595984552663",
            "direccion": "Rue de la Bastille, France",
            "genero": "Femenino",
            "edad": 50
        }
    }
'''	
	
## Json Para modificar clientes / personas, se pasa el parametro idcliente en el endpoint 
'''
{
    "contrasenia": "2222222",
    "estado": true,
    "persona": {
        "nombres": "Juan",
        "apellidos": "Osorio",
        "fechanacimiento": "1995-03-22T04:00:00.000+00:00",
        "nroidentificacion": "222111",
        "telefono": "595991777888",
        "direccion": "Alejandria N° 5252",
        "genero": "Masculino",
        "edad": 30
    }
}
'''
## Json para crear una nueva cuenta
// URL: 
'''
{
        "nrocuenta": "555444333",
        "tipocuenta": "Cuenta Corriente",
        "saldoinicial": 1500.0,
        "estado": true,
        "idcliente": 1
    }
'''
	
	//Json para registrar un movimiento
	//URL: localhost:8080/cuentas-app/movimientos
	//Contenido del Body
'''	
	{
        "valormovimiento": 850.00,
        "estado": true,
        "cuentas": {
            "idcuenta": 6
        }
    }
'''	
