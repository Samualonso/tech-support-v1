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
    HashMap<HashSet<String>, String> respuestaConcreta;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        HashSet<String> conjunto1 = new HashSet<>();
        conjunto1.add("problema");
        conjunto1.add("windows");
        conjunto1.add("crash");
        HashSet<String> conjunto2 = new HashSet<>();
        conjunto2.add("problema");
        HashSet<String> conjunto3 = new HashSet<>();
        conjunto3.add("windows");
        HashSet<String> conjunto4 = new HashSet<>();
        conjunto4.add("crash");
        respuestaConcreta = new HashMap<>();
        respuestaConcreta.put(conjunto1, "Podría tratarse de un crasheo temporal.");
        respuestaConcreta.put(conjunto2, "¿Que problema ocurre?");
        respuestaConcreta.put(conjunto3, "¿Qué codigo de error aparece?");
        respuestaConcreta.put(conjunto4, "¿En que sistema operativo ocurrió el crasheo?");
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
        
        respuesta  = respuestaConcreta.get(userInput);
        
        if(respuesta == null){
            respuesta = respuestas.get(aleatorio.nextInt(respuestas.size()));
        }
        return respuesta;
    }
}
