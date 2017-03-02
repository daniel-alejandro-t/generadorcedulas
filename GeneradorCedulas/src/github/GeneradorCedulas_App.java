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
public class GeneradorCedulas_App {

	public static void main(String[] args) {
		
		long cedulasValidas=0L;
		long cedulasInvalidas=0L;

		int sumaImpares = 0;
		int sumaPares=0;
		int sumaTotal=0;
        int resultPosicionImparPor2=0;
        int decenaSuperior=0;
                
        int[] posicion = {0,0,0,0,0,0,0,0,0,0};	//tipo de dato
        
		for(long i=2499999999L; i>=0100000000L; i--){	//Para la prueba inicia con 1104342785L  termina en 1104342784L
			/*	
			 *  Evitamos tratar números menores para evitar la excepciónen que daba la linea 34:
			 * 	java.lang.StringIndexOutOfBoundsException: String index out of range: 9
			 */
			if(i>=0100000000L){					
				//Vuelve a poner los boolean en false:				
				Boolean validacionTercero = false;
			    Boolean validacionUltimo = false;
				
				String cadena=Long.toString(i);			//Convertimos nuestro Long a String
		//		System.out.println("Variable i= " + i);	//impresión de prueba
				
				//Extrae cada posición de la cadena y lo guarda en un array
		        for(int y=0; y<=(cadena.length()-1); y++){
		        	int valorTemporal=cadena.charAt(y);
		        	posicion[y]=Character.getNumericValue(valorTemporal);
		//        	System.out.println("posición: " + y +"= " + posicion[y]);	//Print de prueba de la posición
		        }
		        
		        //Valida si la tercera posición es menor que 6
		        if(posicion[2] < 6){
		        	validacionTercero = true;
		        }
		        
		      //TODO Multiplica *2 los impares:
		        for(int n = 0 ; n<=6 ; n+=2){	//Solo verá los impares
		        	//a guarda en cada vuelta valor de los impares multiplicado por 2
		            resultPosicionImparPor2 = posicion[n] * 2;	
		            //Si el resultado de las posiciones impares *2 es mayor que 9, restamos 9
		            if( resultPosicionImparPor2 > 9 ){
		            	resultPosicionImparPor2-= 9;
		            }
		            //Despues de tratar cada valor lo guarda en la variable sumaImpares
		            sumaImpares+=resultPosicionImparPor2;
		        }        
		        /*
		         * Codigo original que sospecho que no funciona:
		        int ultimoDigito = (sumaImpares/10+1)*10-sumaImpares;	//v vale 1
		        if (ultimoDigito >= 10){								
		        	ultimoDigito = 0;
		        	}
		        */	
		        //Codigo nuevo:
		        //Conseguimos la suma de pares excepto el último:
		        for(int x=1; x<=7;x+=2){
		        	sumaPares+=posicion[x];
		        }
		        //Se sumaPares + sumaImpares
		        sumaTotal=sumaPares+sumaImpares;
		        //Consiguimos la decena superior
		        decenaSuperior=(sumaTotal/10+1)*10;
		        //TODO el resultado tiene que ser igual que el ultimo digito si es válida
		        int ultimoDigito=decenaSuperior-sumaTotal;
		        //Posicion que es detipo char lo convertimos a int
		        if(ultimoDigito == posicion[9]){						
		        	validacionUltimo = true;
		        }

		        if(validacionUltimo && validacionTercero){	         		     
		        	cedulasValidas++;
		        	System.out.println("Cédula valida: " + cedulasValidas);
		        }else{
	        		cedulasInvalidas++;
		        	System.out.println("Cédulas invalidas: " + cedulasInvalidas);
		        }
			}
		}	
	}
}
//TODO Refactorizar
