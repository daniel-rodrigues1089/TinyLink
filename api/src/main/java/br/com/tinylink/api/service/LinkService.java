package br.com.tinylink.api.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tinylink.api.models.Link;
import br.com.tinylink.api.repository.LinkRepository;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    private static final Logger logger = LoggerFactory
            .getLogger(LinkService.class);

    public boolean add(Link link){

        try {
            linkRepository.save(link);
            return true;
        } catch(Exception e){
            return false;
        }

    }

    public List<Link> list(){
        return linkRepository.findAll();
    }

    public Optional<Link> findLinkByCode(Integer code) {
        logger.info("ENTREI");

        return linkRepository.findByCode(code);
    }
}
