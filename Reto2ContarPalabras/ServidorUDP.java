package Reto2ContarPalabras;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
	 public static void main(String[] args) {
		try {
			System.out.println("****** SERVIDOR INICIADO ******");
			DatagramSocket socketUDP = new DatagramSocket(8888);
			byte[] bufer = new byte[1024];
			
			while(true) {
				DatagramPacket peticion = new DatagramPacket(bufer,bufer.length);
				socketUDP.receive(peticion);
				
				String men = new String(peticion.getData());
				System.out.println("Datos: "+men);
				String cadena = recuperadato(men, peticion.getLength());
				String tamaño[] = cadena.split(" ");
				int cantidad = tamaño.length - 1;
				String env = "Tiene: "+cantidad+" palabras"; 
				byte[] enviar = env.getBytes();
				DatagramPacket mensaje = new DatagramPacket(enviar, env.length(), peticion.getAddress(), peticion.getPort());
				socketUDP.send(mensaje);
				
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	 public static String recuperadato(String cad, int tam) {
		 String res = " ";
		 for(int i = 0; i<tam; i++) {
			 res += cad.charAt(i);
		 }
		 return res;
	 }

}
