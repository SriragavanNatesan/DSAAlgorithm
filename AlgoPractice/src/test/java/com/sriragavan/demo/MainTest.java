package com.sriragavan.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {


    @Test
    void printMessage() {
        new Main().printMessage("Hello ");
    }
}