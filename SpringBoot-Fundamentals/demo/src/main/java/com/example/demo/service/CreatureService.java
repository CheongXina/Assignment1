package com.example.demo.service;

import com.example.demo.entity.Creature;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ComponentScan
public class CreatureService {
    @Autowired
    private CreatureRepository creatureRepository;
    public CreatureService(CreatureRepository mockDataRepository) {
        this.creatureRepository = mockDataRepository;
    }
    public String deleteById(String id) {
        return creatureRepository.deleteById(id);
    }
    public Creature findById(String id) {
        return creatureRepository.findById(id);
    }
    public Creature updateById(String id, String newName) {
        return creatureRepository.updateById(id,newName);
    }

    public Creature create(String id, String newName) {
        return creatureRepository.create(id,newName);
    }
    public List<Creature> getAllData() {
        return creatureRepository.findAll();
    }
}
