package xyz.frt.demo.common;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author phw
 * @date Created in 04-09-2018
 * @description
 */
public class JWTUtil {

    /**
     * 设置token过期时间为5分钟
     */
    public static final long EXPIRE_TIME = 5*60*1000;

    public static boolean verify(String token, String username, String id, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .withClaim("id", id)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取token中的Username信息
     * 无需解密也可以获得
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException ex) {
            return null;
        }
    }

    /**
     * 获取token中的Id信息
     * 无需解密也可以获得
     * @param token
     * @return
     */
    public static String getId(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("id").asString();
        } catch (JWTDecodeException ex) {
            return null;
        }
    }

    /**
     * 生成签名
     * 五分钟后过期
     * @param username
     * @param id
     * @param secret
     * @return
     */
    public static String sign(String username, String id, String secret) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withClaim("username", username)
                    .withClaim("id", id)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
