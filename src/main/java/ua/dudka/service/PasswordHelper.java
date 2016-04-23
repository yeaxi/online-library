package ua.dudka.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by RASTA on 20.04.2016.
 */
@Service
public class PasswordHelper implements PasswordEncoder {

    private MessageDigest md;

    public PasswordHelper() {
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // TODO: 21.04.2016 add logger

        }
    }

    @Override
    public String encode(CharSequence rawPassword) {
        if (md == null) {
            return rawPassword.toString();
        }

        md.update(rawPassword.toString().getBytes());

        byte[] bytes = md.digest();

        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}
