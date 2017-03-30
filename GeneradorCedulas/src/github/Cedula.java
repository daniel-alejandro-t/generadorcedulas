package github;

public class Cedula {
	// @author darxalex
	 	 
	public static boolean getValidarTercero(int tercerDigito){
		/*
		 *  @param Tercer dígito del # de cédula
		 *  @return True si el digito es de una cédula real, False, si no.
		 */
		if(tercerDigito<6){
			return true;
		}else{
			return false;
		}
	}
	
	//TODO Intentar que solo use un array para ahorrar recursos
	public static boolean getValidarUltimo(int cedulaInt[], char cedulaChar[]){
		/* @param Número de cédula en formato Int
		 * 
		 * @return True si el digito es de una cédula real, False, si no.
		 */

		int sumaImpares = 0, sumaPares=0, sumaTotal=0, resultPosicionImparPor2=0, decenaSuperior=0;
		 // Multiplica *2 los impares menos el ultimo:
        for(int n = 0 ; n<=8 ; n+=2){	//Solo verá los impares (5 números)
        	//Guarda en cada vuelta valor de los impares multiplicado por 2
            resultPosicionImparPor2 =cedulaInt[n]* 2;
            //Si el resultado de las posiciones impares *2 es mayor que 9, restamos 9
            if( resultPosicionImparPor2 > 9 ){
            	resultPosicionImparPor2-= 9;
            }
            //Despues de tratar cada valor lo guarda en la variable sumaImpares
            sumaImpares+=resultPosicionImparPor2;
        }     
        
        //Sumamos los pares menos el último:
        for(int x=1; x<=7;x+=2){
        	sumaPares+=cedulaInt[x];
        	
        	/*	TODO Codigo antiguo comentado, borrar al probar el nuevo
        	 * 	y dejar de pedir como parámetro cedulaChar[]
        	 * TODO Revisar javadoc
        	String temporal=""+cedulaChar[x];
        	sumaPares+=Integer.parseInt(temporal);
        	*/
        }
        
        sumaTotal=sumaPares+sumaImpares;

        decenaSuperior=(sumaTotal/10+1)*10;
        // el resultado tiene que ser igual que el ultimo digito si la cédula es válida
        int ultimoDigito=decenaSuperior-sumaTotal;
        
        if (ultimoDigito >= 10){								
        	ultimoDigito = 0;
        }
        
        if(ultimoDigito == cedulaInt[9]){					
        	return true;
        }else{
        	return false;
        }
	}
}
