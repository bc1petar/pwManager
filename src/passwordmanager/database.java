package passwordmanager;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.DestroyFailedException;


/**
 *
 * @author ptrmr
 */

public class database implements Serializable {

    public List<accounts> db = new ArrayList<>();

    public void addAcc(accounts kn) {
        this.db.add(kn);
    }

    public void saveAccounts() throws IOException {
        Iterator<accounts> it = this.db.iterator();
        BufferedWriter br = new BufferedWriter(new FileWriter("db.txt", true));
        while (it.hasNext()) {
            accounts next = it.next();
            String content = "Web service: " + next.getDescription() + "\tUsername: " + next.getUsername() + "\tPassword: " + next.getPassword();
            br.append(content);
            br.newLine();
        }
        br.close();
    }

    public void saveAndEncrypt(String key) throws FileNotFoundException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, DestroyFailedException {
        FileOutputStream fos = new FileOutputStream("db.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this.db);
        oos.close();
        fos.close();
        byte encrypted[] = null;
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte k[] = md.digest(key.getBytes());
        SecretKeySpec sk = new SecretKeySpec(k, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, sk);
        encrypted = c.doFinal(Files.readAllBytes(Paths.get("db.txt")));
        new File("db.txt").delete();
        Files.write(Paths.get("db.aes"), encrypted);
    }

    public void decryptAndShow(String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, ClassNotFoundException {
        try{
            
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte k[] = md.digest(key.getBytes());
        SecretKeySpec sk = new SecretKeySpec(k, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, sk);
        byte fileContent[] = c.doFinal(Files.readAllBytes(Paths.get("db.aes")));
        ByteArrayInputStream bis = new ByteArrayInputStream(fileContent);
        ObjectInput ois = new ObjectInputStream(bis);
        db = (ArrayList<accounts>) ois.readObject();
        bis.close();
        ois.close();  
        saveAccounts();
        
        }catch(Exception e){
            System.out.println("Wrong key");
        }
    }
}
