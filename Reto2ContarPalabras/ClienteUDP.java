package Reto2ContarPalabras;
/*
 * Reto:
Generar un programa con sockets UDP. 
Donde lea una cadena y devuelva la cantidad de 
palabras que existen en esa cadena.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {
	public static void main(String[] args) {
		try {
			System.out.println("****** CLIENTE ******");
			DatagramSocket socketUDP = new DatagramSocket();
			int puerto = 8888;
			InetAddress host =InetAddress.getByName("localhost");
			BufferedReader lee = new BufferedReader(new InputStreamReader(System.in));
			
			String cadena;
			
			while(true) {
				cadena = lee.readLine();
				if(cadena.equals("salir")) break;
				byte[] mensaje = cadena.getBytes();
				DatagramPacket peticion = new DatagramPacket(mensaje, cadena.length(), host, puerto);
				socketUDP.send(peticion);
				
				byte [] bufres = new byte[1024];
				DatagramPacket respuesta = new DatagramPacket(bufres, bufres.length);
				socketUDP.receive(respuesta);
				String res = new String(respuesta.getData());
				System.out.println("La respuesta del servidor: "+res);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
