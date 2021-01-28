import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/**
 * The responder class represents a response generator object.
 * It is used to generate an automatic response to an input string.
 * 
 * @author     Michael KÃ¶lling and David J. Barnes
 * @version    0.1 (2011.07.31)
 */
public class Responder
{
    //Genera numeros aleatorios
    Random aleatorio;
    //Almacena objetos de tipo String
    ArrayList<String> respuestas;
    //Almacena respuestas a ciertas preguntas
    HashMap<String, String> respuestaConcreta;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        respuestaConcreta = new HashMap<>();
        respuestaConcreta.put("windows", "El problema no es de nuestra aplicación sino de windows");
        respuestaConcreta.put("ubuntu", "El problema no es de nuestra aplicación sino de ubuntu");
        respuestaConcreta.put("mac", "El problema no es de nuestra aplicación sino de mac");
        respuestaConcreta.put("android", "El problema no es de nuestra aplicación sino de android");
        aleatorio = new Random();
        respuestas = new ArrayList<>();
        respuestas.add("Muy interesante, cuentame más.");
        respuestas.add("Ya veo cual es el problema.");
        respuestas.add("Necesito hablarlo con mi jefe.");
        respuestas.add("Le voy a pasar con mis superiores.");
        respuestas.add("Dejame pensar cual podría ser el problema.");
    }

    /**
     * Generate a response.
     * @return   A string that should be displayed as the response
     */
    public String generateResponse(HashSet<String> userInput)
    {
        String respuesta = null;
        for(String elemento : userInput){
            if(respuesta == null){
                respuesta = respuestaConcreta.get(elemento);
            }
        }
        
        if(respuesta == null){
            respuesta = respuestas.get(aleatorio.nextInt(respuestas.size()));
        }
        return respuesta;
    }
}
