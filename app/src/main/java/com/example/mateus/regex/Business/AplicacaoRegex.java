package com.example.mateus.regex.Business;


import com.example.mateus.regex.entities.TituloEleitor;
import com.example.mateus.regex.utils.TituloValidatorUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AplicacaoRegex {

    public static List<TituloEleitor> aplicacao(String texto){

        String regex = "[0-9]{8}[0-2][0-9]{3}";
        //String texto = "820506521546ewdasda437301050124sdsa805342051023qwert111111111111";
        List<TituloEleitor> listaDeTitulos = new ArrayList<>();

        // Expressão regular sendo compilada
        Pattern p = Pattern.compile(regex);

        // Joga a expressão compilada no texto
        Matcher m = p.matcher(texto);


        // Enquanto achar o que eu estiver procurando
        while (m.find()) {

            TituloEleitor te = new TituloEleitor();
            // Todos títulos válidos inválidos entrarão na recview, mas serão titulados
            te.setTitulo(m.group());

            // valida o título de acordo com a regra matemática
            if (TituloValidatorUtils.validarTitulo(m.group())) {

                if (m.group().charAt(8) == '0' && m.group().charAt(9) == '1') {
                    te.setEstado("São Paulo");
                } else if (m.group().charAt(8) == '0' && m.group().charAt(9) == '2') {
                    te.setEstado("Minas Gerais");
                } else if (m.group().charAt(8) == '0' && m.group().charAt(9) == '3') {
                    te.setEstado("Rio de Janeiro");
                } else if (m.group().charAt(8) == '0' && m.group().charAt(9) == '4') {
                    te.setEstado("Rio. G. D. Sul");
                } else if (m.group().charAt(8) == '0' && m.group().charAt(9) == '5') {
                    te.setEstado("Bahia");
                } else if (m.group().charAt(8) == '0' && m.group().charAt(9) == '6') {
                    te.setEstado("Paraná");
                } else if (m.group().charAt(8) == '0' && m.group().charAt(9) == '7') {
                    te.setEstado("Ceará");
                } else if (m.group().charAt(8) == '0' && m.group().charAt(9) == '8') {
                    te.setEstado("Pernambuco");
                } else if (m.group().charAt(8) == '0' && m.group().charAt(9) == '9') {
                    te.setEstado("Santa Catarina");
                } else if (m.group().charAt(8) == '1' && m.group().charAt(9) == '0') {
                    te.setEstado("Goiás");
                } else if (m.group().charAt(8) == '1' && m.group().charAt(9) == '1') {
                    te.setEstado("Maranhão");
                } else if (m.group().charAt(8) == '1' && m.group().charAt(9) == '2') {
                    te.setEstado("Paraíba");
                } else if (m.group().charAt(8) == '1' && m.group().charAt(9) == '3') {
                    te.setEstado("Pará");
                } else if (m.group().charAt(8) == '1' && m.group().charAt(9) == '4') {
                    te.setEstado("Espírito Santo");
                } else if (m.group().charAt(8) == '1' && m.group().charAt(9) == '5') {
                    te.setEstado("Piauí");
                } else if (m.group().charAt(8) == '1' && m.group().charAt(9) == '6') {
                    te.setEstado("Rio grande do Norte");
                } else if (m.group().charAt(8) == '1' && m.group().charAt(9) == '7') {
                    te.setEstado("Alagoas");
                } else if (m.group().charAt(8) == '1' && m.group().charAt(9) == '8') {
                    te.setEstado("Mato Grosso");
                } else if (m.group().charAt(8) == '1' && m.group().charAt(9) == '9') {
                    te.setEstado("Mato Grosso do Sul");
                } else if (m.group().charAt(8) == '2' && m.group().charAt(9) == '0') {
                    te.setEstado("Distrito Federal");
                } else if (m.group().charAt(8) == '2' && m.group().charAt(9) == '1') {
                    te.setEstado("Sergipe");
                } else if (m.group().charAt(8) == '2' && m.group().charAt(9) == '2') {
                    te.setEstado("Amazonas");
                } else if (m.group().charAt(8) == '2' && m.group().charAt(9) == '3') {
                    te.setEstado("Rondônia");
                } else if (m.group().charAt(8) == '2' && m.group().charAt(9) == '4') {
                    te.setEstado("Acre");
                } else if (m.group().charAt(8) == '2' && m.group().charAt(9) == '5') {
                    te.setEstado("Amapá");
                } else if (m.group().charAt(8) == '2' && m.group().charAt(9) == '6') {
                    te.setEstado("Roraíma");
                } else if (m.group().charAt(8) == '2' && m.group().charAt(9) == '7') {
                    te.setEstado("Tocantis");
                }

            } else{
                te.setEstado("Título inválido");
            }

            listaDeTitulos.add(te);

        }

        return listaDeTitulos;

    } // fim do método


} // fim classe
