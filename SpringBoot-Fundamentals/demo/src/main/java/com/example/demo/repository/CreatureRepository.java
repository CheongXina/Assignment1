package com.example.demo.repository;
import com.example.demo.entity.Creature;
import com.example.demo.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CreatureRepository {
    private List<Creature> creatureDataList = new ArrayList<Creature>();
    public CreatureRepository(){
        Creature c1 = new Creature("1", "Ramiel");
        Creature c2 = new Creature("2", "Sarqiel");
        Creature c3 = new Creature("3", "Satariel");
        Creature c4 = new Creature("4", "Mysterious Entity");

        creatureDataList.add(c1);
        creatureDataList.add(c2);
        creatureDataList.add(c3);
        creatureDataList.add(c4);
    }
    public List<Creature> findAll() {
        return creatureDataList;
    }
    public Creature findById(String id) {
        System.out.println("entered ID is: "+id);
        for (Creature inst : creatureDataList){
            if (inst.creatureID.equals(id))
                return inst;
        }
        return new Creature("404", "noone"); //Don't worry, he's temporary
    }
    public String deleteById(String id) {
        String msg = "Failed, creature not found.";
        Creature toDelete = new Creature(); //Java is an inferior language for forcing you to waste memory like this
        for (Creature inst : creatureDataList){
            if (inst.creatureID.equals(id)){
                msg = inst.creatureName + " deleted succesfully!";
                toDelete = inst;
            }
        }
        creatureDataList.remove(toDelete); //Cannot remove list items while they are being iterated over, so had to do it after iteration
        //Even if I check if it's null, dumb Java still won't let me compile, forcing me to waste memory above.
        //Forced safety is terrible feature. I know what I'm doing.
        return msg;
    }
    public Creature updateById(String id, String newName) {
        for (Creature inst : creatureDataList){
            if (inst.creatureID.equals(id)){
                inst.creatureName = newName;
                return inst;
            }}
        return new Creature("404", "noone");
    }
}
