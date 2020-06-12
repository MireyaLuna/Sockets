package Reto1MenuTCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServidorTCP {
	public static void main(String[] args) throws IOException {
		//instanciamos el serversocket para la conexion
		ServerSocket socketservidor = null;
		//un socket cliente para aceptar la conexion posteriormente
		Socket socketcliente = null;
		//instanciamos el buffer para la entrada de datos
		BufferedReader entrada = null;
		//instanciamos un printwriter para el flujo de salida de datos
		PrintWriter salida = null;

		System.out.println("****** SERVIDOR INICIADO ******");
		try {
			//instanciamos el socket del servidor en el puerto 8888
			socketservidor = new ServerSocket(8888);
		}catch (Exception e) {
		}

		try {

			while(true) {
				//instanciamos la conexion entre el socket del cliente y del servidor
				socketcliente = socketservidor.accept();
				//instanciamos los flujos de entrada de datos
				entrada = new BufferedReader(new InputStreamReader(socketcliente.getInputStream()));
				//instanciamos los flujos de salida de datos
				salida = new PrintWriter( new BufferedWriter(new OutputStreamWriter(socketcliente.getOutputStream())), true);
				String respuesta;
				//creamos un while para que se acepten varias peticiones.
				while(true)
				{
					//recibimos la peticion del cliente
					String opcion = entrada.readLine();
					//imprimimos el mensaje recibido en la consola del servidor
					System.out.println("Opcion "+opcion);

					switch(opcion) {
					case "1":
						respuesta = "papel";
						salida.println(respuesta);
						break;
					case "2":
						respuesta = "piedra";
						salida.println(respuesta);
					case "3":
						respuesta = "tijera";
						salida.println(respuesta);
					case "4":
						break;
					}
	}
			}
		}catch (Exception e) {

		}
		//liberamos los recursos de cada flujo
		salida.close();
		entrada.close();
		//liberamos los recursos de cada socket
		socketservidor.close();
		socketcliente.close();
	}
}
