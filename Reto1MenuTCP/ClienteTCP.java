package Reto1MenuTCP;
/*
 * 
Alfredo Alejandro Alvarez Acuña
Hace 4 días
Reto Sockets TCP
Generar un menu por consola en el cliente con las siguientes opciones
MENU
-opcion 1
-opcion 2
-opcion 3
-salir

Cuando el cliente seleccione la opcion 1 desplegar "papel" y volver al menu
Cuando el cliente seleccione la opcion 2 desplegar "piedra" y volver al menu
Cuando el cliente seleccione la opcion 3 desplegar "tijera" y volver al menu
Cuando el cliente seleccione la opcion salir cerrar el socket
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class ClienteTCP {
	//instanciamos el logger
	public static void main(String[] args) throws IOException {
		//socket para el cliente
		Socket socketcliente = null;
		//elementos necesarios para el flujo de entrada y salida
		BufferedReader entrada = null;
		PrintWriter salida = null;
		
		System.out.println("****** CLIENTE ******");
		try {
			//instanciamos el socket con el respectivo inetaddress y el puerto.
			socketcliente = new Socket("localhost", 8888);
			//instanciamos los flujos de entrada y salida para el manejo de datos
			entrada = new BufferedReader(new InputStreamReader(socketcliente.getInputStream()));
			salida = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketcliente.getOutputStream())), true);
			
		}catch (Exception e) {

		}
		//instanciamos el buffer de entrada de datos
		BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
		String opcion;
		String respuesta;
		try {
//			do {
//				System.out.println("============MENU=================\n1.Opcion 1.\n2.Opcion 2\\n3.Opcion 3.\\n4.Salir\n=================================");
//				System.out.println("==> Escoga una opcion valida...");
//				System.out.print("Ingrese su opcion:\t");
//				opcion = lee.readLine();
//				//enviamos la opcion elegida
//				salida.println(opcion);
//				//recibimos la respuesta
//				respuesta = entrada.readLine();
//				//imprimimos la respuesta del servidor
//				System.out.println("Elegiste: "+respuesta);
//			}while(opcion.equals("4"));
			while(true) {
				System.out.println("============MENU=================\n 1.Opcion 1 \n 2.Opcion 2 \n 3.Opcion 3.\n 4.Salir\n=================================");
				System.out.println("==> Escoga una opcion valida...");
				System.out.print("Ingrese su opcion:\t");
				opcion = lee.readLine();
				//enviamos la opcion elegida
				salida.println(opcion);
				//recibimos la respuesta
				respuesta = entrada.readLine();
				if(opcion.equals("4")) break;
				//imprimimos la respuesta del servidor
				System.out.println("\t\t=> Elegiste: "+respuesta+" <=");
			
			}
		}catch (Exception e) {
		}
		//liberamos recursos de los flujos de entrada y salida
		salida.close();
		entrada.close();
		lee.close();
		//liberamos al socket
		socketcliente.close();
	}
}
