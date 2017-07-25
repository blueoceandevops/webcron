package br.eti.archanjo.webcron.domain;

import br.eti.archanjo.webcron.dtos.JobsDTO;
import br.eti.archanjo.webcron.dtos.UserDTO;
import br.eti.archanjo.webcron.entities.mysql.JobsEntity;
import br.eti.archanjo.webcron.repositories.mysql.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cron {
    private final JobsRepository jobsRepository;

    @Autowired
    public Cron(JobsRepository jobsRepository) {
        this.jobsRepository = jobsRepository;
    }

    public List<JobsDTO> listJobs(UserDTO client, Integer limit, Integer page) {
        Page<JobsEntity> jobs = jobsRepository.findAllByUserId(client.getId(), new PageRequest(page, limit));
        jobs.toString();
        return null;
    }
}
