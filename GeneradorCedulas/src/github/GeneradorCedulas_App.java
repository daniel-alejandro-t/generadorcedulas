/*
 * 		Este pequeño programa repasa los números desde 2499999999L a 0100000000L en busca de los números de cédula validos,
 * 		es decir, lo que cumplan el argoritmo son guardados en un txt, buenisimo para usarlo en ataques de fuerza bruta.
 * 		
 * 		La validación de la provincia y la del número de digitos se han omitido en éste generador por obvias razones.
 * 		
 * 		En un futuro quisiera hacerlo orientado a objetos y crearle una pequeña interfaz gráfica que, por ejemplo nos genere el 
 * 		diccionario de una provincia determinada.
 */
package github;
import java.io.*;
import java.util.*;
public class GeneradorCedulas_App {
	//TODO MEJORA Hacer que pueda generar muchos diccionarios de una vez
	//TODO Idea: Hacer que el programa cree un diccionario con los numeros de varias provincias ordenadas
	//TODO Tomar el tiempo que le lleva procesar e intentar optimizarlo
	public static void main(String[] args) {
		Scanner entrada=new Scanner (System.in);
		
		String dondeGuardar;
		
		long cedulasInvalidas=0L, cedulasValidas=0L, cedulaMaxima=0L, cedulaMinima=0L;
                
        char[] posicionChar = {0,0,0,0,0,0,0,0,0,0};	//Para poder guardarlos
        int [] posicionInt  = {0,0,0,0,0,0,0,0,0,0};	//Para poder hacer las operaciones de validación
        
        System.out.println("Bienvenid@ al Generador de cédulas ecuatorianas  Por favor, ingrese la \n"
							+ "ubicación donde quiera guardar el diccionario generado y asegurese \n"
        					+ "de que tenga permisos de escritura: \n"
							+ " Ejemplo: /home/MiUsuario/Documentos (en Linux): ");
        
        
        dondeGuardar=entrada.nextLine();
        
        System.out.println("Ahora ingrese 0 si desea generar un diccionario con \n todas las cédulas del país ó  "
        					+ "si desea solo de una provincia,\n ingrese el codigo: ");
        
        //Establece el rango de #s de cédula a tratar
        int cedulaGenerar=entrada.nextInt();
        
        switch(cedulaGenerar){
        	case 0:  cedulaMaxima=2499999999L;	cedulaMinima=100000000L;	break;	//Todos los digitos
        	/*
        	 * Daba un error al querer guardar los # con un 0 delante, asi que se lo quite, 
        	 * mas adelante, guardare cada # en un array y le anteponere el 0.
        	 * Linea 116-117
        	 */
        	case 1:  cedulaMaxima=199999999L;	cedulaMinima=100000000L; 	break;
        	case 2:  cedulaMaxima=299999999L;	cedulaMinima=200000000L; 	break;	
        	case 3:  cedulaMaxima=399999999L;	cedulaMinima=300000000L; 	break;
        	case 4:  cedulaMaxima=499999999L;	cedulaMinima=400000000L; 	break;	
        	case 5:  cedulaMaxima=599999999L;	cedulaMinima=500000000L; 	break;
        	case 6:  cedulaMaxima=699999999L;	cedulaMinima=600000000L;	break;		
        	case 7:  cedulaMaxima=799999999L;	cedulaMinima=700000000L;	break;		
        	case 8:  cedulaMaxima=899999999L;	cedulaMinima=800000000L;	break;		
        	case 9:  cedulaMaxima=999999999L;	cedulaMinima=900000000L;	break;		
        	
        	case 10: cedulaMaxima=1099999999L;	cedulaMinima=1000000000L; 	break;	
        	case 11: cedulaMaxima=1199999999L;	cedulaMinima=1100000000L; 	break;	
        	case 12: cedulaMaxima=1299999999L;	cedulaMinima=1200000000L; 	break;	
        	case 13: cedulaMaxima=1399999999L;	cedulaMinima=1300000000L; 	break;	
        	case 14: cedulaMaxima=1499999999L;	cedulaMinima=1400000000L; 	break;	
        	case 15: cedulaMaxima=1599999999L;	cedulaMinima=1500000000L; 	break;	
        	case 16: cedulaMaxima=1699999999L;	cedulaMinima=1600000000L; 	break;	
        	case 17: cedulaMaxima=1799999999L;	cedulaMinima=1700000000L; 	break;	
        	case 18: cedulaMaxima=1899999999L;	cedulaMinima=1800000000L; 	break;	
        	case 19: cedulaMaxima=1999999999L;	cedulaMinima=1900000000L; 	break;	
        	case 20: cedulaMaxima=2099999999L;	cedulaMinima=2000000000L;	break;	
        	case 21: cedulaMaxima=2199999999L;	cedulaMinima=2100000000L;	break;	
        	case 22: cedulaMaxima=2299999999L;	cedulaMinima=2200000000L; 	break;	
        	case 23: cedulaMaxima=2399999999L;	cedulaMinima=2300000000L; 	break;	
        	case 24: cedulaMaxima=2499999999L;	cedulaMinima=2400000000L; 	break;
        }
        
		for(long i=cedulaMaxima; i>=cedulaMinima; i--){	
								
				Boolean validacionTercero = false, validacionUltimo = false;	//Vuelve a poner los boolean en false:
				
				String cadena=Long.toString(i);			//Convertimos nuestro Long a String
				
				//Rellena los Arrays Int y Char 
				if(cadena.length()==9){	
					posicionInt[0]=0;
					posicionChar[0]='0';	
					for(int y=1; y<(cadena.length()+1); y++){
						posicionChar[y]=(char)cadena.charAt(y-1);	
						posicionInt[y]=Character.getNumericValue(posicionChar[y]);
					}
				}else{
					for(int y=0; y<cadena.length(); y++){
						posicionChar[y]=(char)cadena.charAt(y);	
						posicionInt[y]=Character.getNumericValue(posicionChar[y]);
					}
				}			        
				if(Cedula.getValidarUltimo(posicionInt, posicionChar) && Cedula.getValidarTercero(posicionInt[2])){	         		     
		        	cedulasValidas++;
		        	try {
				     	FileWriter archivo=new FileWriter(Archivos.getNombreArchivoCedula(dondeGuardar, cedulaGenerar), true);	//true es para que sobrescriba una cedula encima de otra
		        		BufferedWriter mibuffer=new BufferedWriter(archivo);	//Guardamos en un buffer el fichero		
		        		mibuffer.write(posicionChar, 0, 10);
		        		mibuffer.newLine();	//Salta a la siguiente linea
		    			mibuffer.close();	//Cerramos el flujo para que escriba lo que guardo en el
		        	 } catch (IOException e) {
		        		 System.out.println("Error: ");
			     		//TODO System.err
		        		 e.printStackTrace();
		     		}
		        }else{
	        		cedulasInvalidas++;
		        }
				System.out.println("Cédula valida: " + cedulasValidas + " Cédulas invalidas: " + cedulasInvalidas);
		}	
	}
}
