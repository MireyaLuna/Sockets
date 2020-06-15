package Reto1MenuTCP;

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
			while(true) {
				System.out.println("============MENU=================\n 1.Opcion 1 \n 2.Opcion 2 \n 3.Opcion 3.\n 4.Salir\n=================================");
				do {
					System.out.println("==> Escoga una opcion valida...!!!");
					System.out.print("Ingrese su opcion:\t");
					opcion = lee.readLine();
					opcion = opcion.trim();
					System.out.println("=================================");
				}while(!opcion.equals("1") && !opcion.equals("2") && !opcion.equals("3") && !opcion.equals("4"));
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
