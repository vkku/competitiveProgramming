package main.java.arrays;

import org.junit.Test;

public class URLEncoderTest {

    URLEncoder urlEncoder = new URLEncoder();

    @Test
    public void testUrlEncoder(){
        urlEncoder.encodeStringToUrl("vkku.me/blog january");
    }
}
