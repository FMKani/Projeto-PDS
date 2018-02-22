package moneywise.resources;

import javax.xml.bind.DatatypeConverter;

public class Encryption {

    public static String encrypt(String texto) {
        return DatatypeConverter.printBase64Binary(texto.getBytes());
    }

    public static String decrypt(String encoded) {
        return new String(DatatypeConverter.parseBase64Binary(encoded));
    }
    
    public static boolean checkPassword(String senha, String hash){
        String senhaDecrypted = decrypt(hash);
        return senha.equals(senhaDecrypted);
    }

}
