package github;

public class Archivos {
	/*
	 * @author darxalex
	 */
	public static String getNombreArchivoCedula(String rutaArchivo, int provincia){
		/*
		 * Agrega la '/' al final de la ruta, si no lo tiene
		 * @param el String con la ruta del archivo y el numero de la provincia
		 * para darle un nombre personalizado al diccionario con extencion .txt
		 * 
		 * @return el nombre del archivo
		 */
		//Agrega la '/' al final de la ruta, si no lo tiene
        if(rutaArchivo.charAt(rutaArchivo.length()-1)!='/'){
        	rutaArchivo+='/';
        }
        switch(provincia){
    	case 0:	rutaArchivo+="CedulasEcuador.txt";	break;	//Todos los digitos
    	/*
    	 * Daba un error al querer guardar los # con un 0 delante, asi que se lo quite, 
    	 * mas adelante, guardare cada # en un array y le anteponere el 0.
    	 * Linea 116-117
    	 */
    	case 1: rutaArchivo+="CedulasAzuay.txt"; 		break;
    	case 2: rutaArchivo+="CedulasBolivar.txt";	 	break;	
    	case 3: rutaArchivo+="CedulasCañar.txt"; 		break;
    	case 4: rutaArchivo+="CedulasCarchi.txt"; 		break;	
    	case 5: rutaArchivo+="CedulasCotopaxi.txt"; 	break;
    	case 6: rutaArchivo+="CedulasChimborazo.txt";	break;		
    	case 7: rutaArchivo+="CedulasElOro.txt";		break;		
    	case 8: rutaArchivo+="CedulasEsmeraldas.txt";	break;		
    	case 9: rutaArchivo+="CedulasGuayas.txt";		break;		
    	
    	case 10: rutaArchivo+="CedulasImbabura.txt";		break;	
    	case 11: rutaArchivo+="CedulasLoja.txt";			break;	
    	case 12: rutaArchivo+="CedulasLosRios.txt";			break;	
    	case 13: rutaArchivo+="CedulasManabi.txt";			break;	
    	case 14: rutaArchivo+="CedulasMSantiago.txt";		break;	
    	case 15: rutaArchivo+="CedulasNapo.txt";			break;	
    	case 16: rutaArchivo+="CedulasPastaza.txt";			break;	
    	case 17: rutaArchivo+="CedulasPichincha.txt";		break;	
    	case 18: rutaArchivo+="CedulasTungurahua.txt";		break;	
    	case 19: rutaArchivo+="CedulasZChinchipe.txt";		break;	
    	case 20: rutaArchivo+="CedulasGalapagos.txt";		break;	
    	case 21: rutaArchivo+="CedulasSucumbios.txt";		break;	
    	case 22: rutaArchivo+="CedulasOrellana.txt";		break;	
    	case 23: rutaArchivo+="CedulasSantoDomingo.txt";	break;	
    	case 24: rutaArchivo+="CedulasSantaElena.txt";		break;
    }
        return rutaArchivo;
	}
}
