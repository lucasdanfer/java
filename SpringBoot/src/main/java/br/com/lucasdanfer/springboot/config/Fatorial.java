package br.com.lucasdanfer.springboot.config;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Fatorial {
    
    private static final int[] NOTAS = {1, 50, 100, 20, 5, 10, 2};
    
    public static void main (String[] args) {
    
        Arrays.sort(NOTAS);
        System.out.println(Arrays.toString(NOTAS));
        
    }
    
    private static Map<Double, Integer> calculaMinimasNotas(List<Double> notas, Integer valor) {
        return null;
    }

}
