package com.example.demo.Service;

import javax.annotation.PostConstruct;

public interface IStateService {
    @PostConstruct
    void init();
}
