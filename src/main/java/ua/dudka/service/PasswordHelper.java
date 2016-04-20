package ua.dudka.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;

/**
 * Created by RASTA on 20.04.2016.
 */
@Service
public class PasswordHelper implements PasswordEncoder {

    private MessageDigest md;

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
        return rawPassword.equals(encodedPassword);
    }
}
