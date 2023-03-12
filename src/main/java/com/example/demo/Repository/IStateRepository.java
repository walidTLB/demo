package com.example.demo.Repository;

import com.example.demo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface IStateRepository extends JpaRepository<State, Long> {
    @Query("SELECT s.name FROM State s")
    List<String> getStates();
    State findStateByName(String name);
    List<State> findAllStatesByAlphabeticalOrder();
    State findStateByMatriculeNumber(String matriculeNumber);
    List<State> findStatesWithMostUsers();

}
