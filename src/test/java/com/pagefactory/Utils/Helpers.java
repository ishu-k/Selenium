package com.pagefactory.Utils;

import java.util.Random;

public class Helpers {
    public int randomNumberGenerator(int size){
        Random random = new Random();
        return random.nextInt(size-1);
    }
}
