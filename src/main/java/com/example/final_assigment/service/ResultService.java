package com.example.final_assigment.service;

import com.example.final_assigment.model.Assigment;
import com.example.final_assigment.model.Result;
import com.example.final_assigment.repository.AssigmentRepository;
import com.example.final_assigment.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final ResultRepository resultRepository;

    private final AssigmentRepository assigmentRepository;

    public void setResult(Long assigmentId, Boolean isPass) {
        Optional<Assigment> assigment = assigmentRepository.findById(assigmentId);
        assigment.ifPresent(value -> resultRepository.save(Result.builder().isPass(isPass).assigment(value).build()));
    }

    public List<Result> getAll() {
        return resultRepository.findAll();
    }

    public List<Result> getListByAssigmentId(Long assigmentId) {
        Optional<Assigment> assigment = assigmentRepository.findById(assigmentId);
        return assigment.map(resultRepository::findAllByAssigment).orElse(null);
    }

}
