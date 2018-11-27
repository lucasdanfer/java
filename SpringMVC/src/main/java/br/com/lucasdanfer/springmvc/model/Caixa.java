package br.com.lucasdanfer.springmvc.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Caixa {
    
    private static final int[] NOTAS = {1, 50, 100, 20, 5, 10, 2};
    
    public static void main (String[] args) {
    
        Arrays.sort(NOTAS);
        System.out.println(calculaMinimasNotas(NOTAS, 1377).toString());
    }
    
    private static Map<Integer, Integer> calculaMinimasNotas(int[] notas, Integer valor) {
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i=NOTAS.length-1; i>=0; i--) {
            map.put(NOTAS[i], valor/NOTAS[i]);
            valor = valor%NOTAS[i];
        }
        
        return map;
        
    }

}
