package com.yang.jwt;

import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;
import java.util.function.BiConsumer;

/**
 * @author yang
 * @date 2023/5/30 13:13
 */
public class JwtTests {

    private static long tokenExpriation = 1000 * 60 * 60 *24;
    private static String tokenSignKey = "yang123";

    /**
     * 解析jwt
     */
    @Test
    public void testGetToken(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuaWNrbmFtZSI6IkhlbGVuIiwiYXZhdGFyIjoiMS5qcGciLCJyb2xlIjoiYWRtaW4iLCJzdWIiOiJzcmItdXNlciIsImlzcyI6InlhbmciLCJhdWQiOiJ5YW5nIiwiaWF0IjoxNjg1NDI2NDk5LCJleHAiOjE2ODU1MTI4OTksIm5iZiI6MTY4NTQyNjUxOSwianRpIjoiMDU1MmUzZjMtODFhNC00NjI5LTgwZWItYWJkZDQ1NjhjNGFkIn0.4UDw_Wl6HN0PIn6Ht5sVEyWDhUln_cA3tNYzVzSLjpU";
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser.setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        System.out.println(claims);
        String nickname = (String) claims.get("nickname");
        String avatar = (String) claims.get("avatar");
        String role = (String) claims.get("role");

        System.out.println(nickname);
        System.out.println(avatar);
        System.out.println(role);

        String id = claims.getId();
        System.out.println(id);
    }

    /**
     * 创建jwt
     */
    @Test
    public void testCreatedToken(){
        JwtBuilder builder = Jwts.builder();
        //头，载荷，签名哈希
        String jwtToken = builder
                //头
                .setHeaderParam("alg", "HS256")
                .setHeaderParam("typ", "JWT")
                //载荷:自定义信息
                .claim("nickname", "Helen")
                .claim("avatar", "1.jpg")
                .claim("role", "admin")
                //载荷：默认信息
                .setSubject("srb-user")//令牌主题
                .setIssuer("yang")
                .setAudience("yang")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpriation)) //过期时间
                .setNotBefore(new Date(System.currentTimeMillis() + 1000 * 20))//生效时间
                .setId(UUID.randomUUID().toString())
                //签名哈希
                .signWith(SignatureAlgorithm.HS256, tokenSignKey)
                //组装jwt字符串
                .compact();
        System.out.println(jwtToken);
    }
}
