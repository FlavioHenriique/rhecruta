/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dacrhecruta.javamail;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author flavio
 */
public class Teste {
    public static void main(String[] args) {
        //NotificacoesEmail n = new NotificacoesEmail(new EnviaEmail());
        List<String> lista = Arrays.asList("F","B","C");
        String array = "";
        for (String s : lista){
            array += s + ",";
        }
        System.out.println(array.substring(0,array.length()-1));
    }
  
}
