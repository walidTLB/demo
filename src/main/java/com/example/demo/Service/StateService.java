package com.example.demo.Service;

import com.example.demo.Repository.IStateRepository;
import com.example.demo.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StateService implements IStateService {
    @Autowired
    private IStateRepository stateRepository;
@Override
    @PostConstruct
    public void init() {
        // Retrieve the list of states
        List<String> states = State.getStates();

        // Populate the State entity
        for (String name : states) {
            State state = new State();
            state.setName(name);
            stateRepository.save(state);
        }
    }
}

