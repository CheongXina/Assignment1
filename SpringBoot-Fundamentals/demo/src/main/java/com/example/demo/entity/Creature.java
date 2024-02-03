package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ui.Model;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Creature {

    public String creatureID;
    public String creatureName;
    public String creatureSpecies;
    public boolean bFemale;
    public double height;
    public double weight;



    public Creature(String creatureID, String creatureName) {
        this.creatureID = creatureID;
        this.creatureName = creatureName;
    }
}
