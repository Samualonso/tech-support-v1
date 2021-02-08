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
    private HashSet<String> conjunto1;
    private HashSet<String> conjunto2;
    /**
     * Construct a Responder - nothing to do
     */
    public Responder()
    {
        conjunto1 = new HashSet<>();
        conjunto1.add("linux");
        conjunto1.add("crash");
        conjunto1.add("problem");
        conjunto2 = new HashSet<>();
        conjunto2.add("windows");
        conjunto2.add("corrupt");
        conjunto2.add("problem");
        respuestaConcreta = new HashMap<>();
        respuestaConcreta.put(conjunto1, "Podría tratarse de un crasheo temporal.");
        respuestaConcreta.put(conjunto2, "El problema puede ser un virus.");
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
        int palabrasClave = 0;
        int palabrasClaveAnteriores = 0;
        Iterator<HashSet<String>> iterador = respuestaConcreta.keySet().iterator();
        
        while(iterador.hasNext()){
            palabrasClave = 0;
            HashSet<String> respuestaHashSet = iterador.next();
            for(String key : respuestaHashSet){
                if(userInput.contains(key)){
                    palabrasClave++;
                }
            }
            if(palabrasClave > 0 && palabrasClaveAnteriores <= palabrasClave){
                respuesta = respuestaConcreta.get(respuestaHashSet);
                palabrasClaveAnteriores = palabrasClave;
            }
        }
        
        if(respuesta == null){
            respuesta = respuestas.get(aleatorio.nextInt(respuestas.size()));
        }
        return respuesta;
    }
}
