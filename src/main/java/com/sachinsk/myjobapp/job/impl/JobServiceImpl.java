package com.sachinsk.myjobapp.job.impl;

import com.sachinsk.myjobapp.job.Job;
import com.sachinsk.myjobapp.job.JobService;

import java.util.ArrayList;
import java.util.List;

public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return List.of();
    }

    @Override
    public void createJob() {

    }
}
