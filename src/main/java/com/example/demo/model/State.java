package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;


@Data
@Entity
@Table(name = "state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    public static List<String> getStates() {
        return Arrays.asList("Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna",
                "Béjaïa", "Biskra", "Béchar", "Blida", "Bouira",
                "Tamanrasset", "Tébessa", "Tlemcen", "Tiaret",
                "Tizi Ouzou", "Algiers", "Djelfa", "Jijel", "Sétif",
                "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma",
                "Constantine", "Médéa", "Mostaganem", "M'Sila", "Mascara",
                "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arréridj",
                "Boumerdès", "El Tarf", "Tindouf", "Tissemsilt", "El Oued",
                "Khenchela", "Souk Ahras", "Tipaza", "Mila", "Aïn Defla",
                "Naâma", "Aïn Témouchent", "Ghardaïa", "Relizane");
    }
    // Add a list of states
    private static List<String> states = Arrays.asList("Adrar", "Chlef", "Laghouat", "Oum El Bouaghi", "Batna",
            "Béjaïa", "Biskra", "Béchar", "Blida", "Bouira",
            "Tamanrasset", "Tébessa", "Tlemcen", "Tiaret",
            "Tizi Ouzou", "Algiers", "Djelfa", "Jijel", "Sétif",
            "Saïda", "Skikda", "Sidi Bel Abbès", "Annaba", "Guelma",
            "Constantine", "Médéa", "Mostaganem", "M'Sila", "Mascara",
            "Ouargla", "Oran", "El Bayadh", "Illizi", "Bordj Bou Arréridj",
            "Boumerdès", "El Tarf", "Tindouf", "Tissemsilt", "El Oued",
            "Khenchela", "Souk Ahras", "Tipaza", "Mila", "Aïn Defla",
            "Naâma", "Aïn Témouchent", "Ghardaïa", "Relizane");

    // constructors, getters, and setters lombock
}

