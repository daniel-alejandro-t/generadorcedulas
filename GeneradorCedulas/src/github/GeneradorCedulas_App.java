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

	public static void main(String[] args) {
		Scanner entrada=new Scanner (System.in);
		
		String dondeGuardar;
		
		long cedulasValidas=0L;
		long cedulasInvalidas=0L;

		long cedulaMaxima=0L;
		long cedulaMinima=0L;
		
		int sumaImpares = 0;
		int sumaPares=0;
		int sumaTotal=0;
        int resultPosicionImparPor2=0;
        int decenaSuperior=0;
                
        char[] posicionChar = {0,0,0,0,0,0,0,0,0,0};
        char[] posicionInt  = {0,0,0,0,0,0,0,0,0,0};
        
        System.out.println("Bienvenid@ al Generador de cédulas ecuatorianas \n Por favor, "
							+ " ingrese la ubicación donde quiera guardar el diccionario generado \n"
        					+ " y asegurese de que tenga permisos de escritura: \n"
							+ " Ejemplo: /home/MiUsuario/Documentos (en Linux): ");
        
        /*	TODO BUG Al generar cédulas menores a 9, incluido el diccionario de todo el pais
         *  y provincias menores a 10 no concatena al final el nombre del fichero .txt segun el debug
         */
        
        //TODO MEJORA Hacerlo orientado a objetos despues de terminar 
        //TODO MEJORA Hacer que pueda generar muchos diccionarios de una vez
        //TODO Idea: Hacer que el programa cree un diccionario con los numeros de varias provincias ordenadas
        //TODO Refactorizar
        
        dondeGuardar=entrada.nextLine();
        
        //Agrega la '/' al final, si no lo tiene
        if(dondeGuardar.charAt(dondeGuardar.length()-1)!='/'){
        	dondeGuardar+='/';
        }
        
        System.out.println("Ahora ingrese 0 si desea generar un diccionario con \n todas las cédulas del país ó  "
        					+ "si desea solo de una provincia,\n ingrese el codigo: ");
        
        //Establece el nombre al diccionario y el rango de #s de cédula
        switch(entrada.nextInt()){
        	case 0:  cedulaMaxima=2499999999L;	cedulaMinima=100000000L; dondeGuardar+="CedulasEcuador.txt";	break;	//Todos los digitos
        										//TODO Revisar si le agrega al final el 0
        	/*
        	 * Daba un error al querer guardar los # con un 0 delante, asi que
        	 * se lo quite, mas adelante, guardare cada # en un array y le anteponere el 0.
        	 * Linea 116-117
        	 */
        	case 1:  cedulaMaxima=199999999L;	cedulaMinima=100000000L; dondeGuardar+="CedulasAzuay.txt"; 		break;
        	case 2:  cedulaMaxima=299999999L;	cedulaMinima=200000000L; dondeGuardar+="CedulasBolivar.txt"; 	break;	
        	case 3:  cedulaMaxima=399999999L;	cedulaMinima=300000000L; dondeGuardar+="CedulasCañar.txt"; 		break;
        	case 4:  cedulaMaxima=499999999L;	cedulaMinima=400000000L; dondeGuardar+="CedulasCarchi.txt"; 	break;	
        	case 5:  cedulaMaxima=599999999L;	cedulaMinima=500000000L; dondeGuardar+="CedulasCotopaxi.txt"; 	break;
        	case 6:  cedulaMaxima=699999999L;	cedulaMinima=600000000L; dondeGuardar+="CedulasChimborazo.txt";	break;		
        	case 7:  cedulaMaxima=799999999L;	cedulaMinima=700000000L; dondeGuardar+="CedulasElOro.txt";		break;		
        	case 8:  cedulaMaxima=899999999L;	cedulaMinima=800000000L; dondeGuardar+="CedulasEsmeraldas.txt";	break;		
        	case 9:  cedulaMaxima=999999999L;	cedulaMinima=900000000L; dondeGuardar+="CedulasGuayas.txt";		break;		
        	
        	case 10: cedulaMaxima=1099999999L;	cedulaMinima=1000000000L; dondeGuardar+="CedulasImbabura.txt";		break;	
        	case 11: cedulaMaxima=1199999999L;	cedulaMinima=1100000000L; dondeGuardar+="CedulasLoja.txt";			break;	
        	case 12: cedulaMaxima=1299999999L;	cedulaMinima=1200000000L; dondeGuardar+="CedulasLosRios.txt";		break;	
        	case 13: cedulaMaxima=1399999999L;	cedulaMinima=1300000000L; dondeGuardar+="CedulasManabi.txt";		break;	
        	case 14: cedulaMaxima=1499999999L;	cedulaMinima=1400000000L; dondeGuardar+="CedulasMSantiago.txt";		break;	
        	case 15: cedulaMaxima=1599999999L;	cedulaMinima=1500000000L; dondeGuardar+="CedulasNapo.txt";			break;	
        	case 16: cedulaMaxima=1699999999L;	cedulaMinima=1600000000L; dondeGuardar+="CedulasPastaza.txt";		break;	
        	case 17: cedulaMaxima=1799999999L;	cedulaMinima=1700000000L; dondeGuardar+="CedulasPichincha.txt";		break;	
        	case 18: cedulaMaxima=1899999999L;	cedulaMinima=1800000000L; dondeGuardar+="CedulasTungurahua.txt";	break;	
        	case 19: cedulaMaxima=1999999999L;	cedulaMinima=1900000000L; dondeGuardar+="CedulasZChinchipe.txt";	break;	
        	case 20: cedulaMaxima=2099999999L;	cedulaMinima=2000000000L; dondeGuardar+="CedulasGalapagos.txt";		break;	
        	case 21: cedulaMaxima=2199999999L;	cedulaMinima=2100000000L; dondeGuardar+="CedulasSucumbios.txt";		break;	
        	case 22: cedulaMaxima=2299999999L;	cedulaMinima=2200000000L; dondeGuardar+="CedulasOrellana.txt";		break;	
        	case 23: cedulaMaxima=2399999999L;	cedulaMinima=2300000000L; dondeGuardar+="CedulasSantoDomingo.txt";	break;	
        	case 24: cedulaMaxima=2499999999L;	cedulaMinima=2400000000L; dondeGuardar+="CedulasSantaElena.txt";	break;
        }
        
        //TODO Ajustar el programa para tratar los # de cédula que empiezan con 01 hasta 09 
        
		for(long i=cedulaMaxima; i>=cedulaMinima; i--){	
			/*	
			 *  Evitamos tratar números menores para evitar la excepción:
			 * 	java.lang.StringIndexOutOfBoundsException: String index out of range: 9
			 */
			
			//Trata los # que empiezan de 01 para arriba
			if(i>=010000000L){					
				//Vuelve a poner los boolean en false:				
				Boolean validacionTercero = false;
			    Boolean validacionUltimo = false;
				
				String cadena=Long.toString(i);			//Convertimos nuestro Long a String
				
				/*	Extrae cada posición de la cadena, lo guarda en una variable en su valor ASCII
		         *	que luego convertimos a int y guardamos en posición[y]:
				 */
				
				//Para tratar # de 9 digitos que no pueden llevar el 0 delante
				if(cadena.length()==9){	
					posicionChar[0]=0;
					posicionInt[0]=0;
					for(int y=0; y<cadena.length(); y++){
						posicionInt[y+1]=cadena.charAt(y);
						posicionChar[y+1]=(char)posicionInt[y+1];	//TODO
					}
				}else{
					for(int y=0; y<cadena.length(); y++){
						int valorTemporal=cadena.charAt(y);
						posicionChar[y]=(char)valorTemporal;	//TODO
					}
				}	
		        //Valida si la tercera posición es menor que 6
				String tercer=Character.toString(posicionChar[2]);
				int tercerDigito=Integer.parseInt(tercer);
				if(tercerDigito < 6){
		        	validacionTercero = true;
		        }
		        
		      // Multiplica *2 los impares menos el ultimo:
		        for(int n = 0 ; n<=8 ; n+=2){	//Solo verá los impares
		        	//Guarda en cada vuelta valor de los impares multiplicado por 2
		            resultPosicionImparPor2 =posicionInt[n]* 2;	//TODO la cadena no tiene el formato apropiado.
		            //Si el resultado de las posiciones impares *2 es mayor que 9, restamos 9
		            if( resultPosicionImparPor2 > 9 ){
		            	resultPosicionImparPor2-= 9;
		            }
		            //Despues de tratar cada valor lo guarda en la variable sumaImpares
		            sumaImpares+=resultPosicionImparPor2;
		        }        
		        //Sumamos los pares menos el último:
		        for(int x=1; x<=7;x+=2){
		        	String temporal=""+posicionChar[x];
		        	sumaPares+=Integer.parseInt(temporal);
		        }
		        //TODO Problema al convertir de char a int
		        sumaTotal=sumaPares+sumaImpares;

		        decenaSuperior=(sumaTotal/10+1)*10;
		        //TODO el resultado tiene que ser igual que el ultimo digito si la cédula es válida
		        int ultimoDigito=decenaSuperior-sumaTotal;
		        
		        if (ultimoDigito >= 10){								
		        	ultimoDigito = 0;
		        }
		        
		        String ultimo=Character.toString(posicionChar[9]);
				int ultimoCaracter=Integer.parseInt(ultimo);
		        if(ultimoDigito == ultimoCaracter){		//TODO Se está comparando un char con un int				
		        	validacionUltimo = true;
		        }

		        if(validacionUltimo && validacionTercero){	         		     
		        	cedulasValidas++;
		        	
		        //TODO tener cuidado al guardar las cedulas que tienen el 0 delante	
		    		System.out.println("Cédula valida: " + cedulasValidas + " Cédulas invalidas: " + cedulasInvalidas);

		        	
		        	
//		        	System.out.println("Cédula valida: " + cedulasValidas);
		        	
		        	 try {
				     	FileWriter myFile=new FileWriter(dondeGuardar, true);	//true es para que sobrescriba una cedula encima de otra
		        		BufferedWriter mibuffer=new BufferedWriter(myFile);	//Guardamos en un buffer el fichero		
		        		mibuffer.write(posicionChar, 0, 10);
		        		mibuffer.newLine();	//Salta a la siguiente linea
		    			mibuffer.close();	//No cerramos el flujo todavia ya que volveremos a el
		        	 } catch (IOException e) {
		     			e.printStackTrace();
		     			System.out.println("Error: ");
		     			//TODO System.err
		     		}
		        }else{
	        		cedulasInvalidas++;
		        }
			}
		}	
		System.out.println("Cédula valida: " + cedulasValidas + " Cédulas invalidas: " + cedulasInvalidas);
	}
}
