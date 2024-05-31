package com.weblab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//для теста сделал метод чекстатус из прайват в паблик

class DotTest {
    @Test
    void testCheckStatus(){
        Dot instance = new Dot();
        instance.setX(1.1F);
        instance.setY(1.5F);
        instance.checkStatus();
        // Вывод статуса после вызова checkStatus
        assertFalse(instance.getStatus());
    }

}