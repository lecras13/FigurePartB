package com.epam.figure.repository;

import com.epam.figure.observer.CubeObservable;
import com.epam.figure.specification.CubeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CubeRepositoryImpl implements CubeRepository {
    private static final Logger LOGGER = LogManager.getLogger();
    private static CubeRepositoryImpl instance;
    private List<CubeObservable> cubeRepository;

    private CubeRepositoryImpl(){
        cubeRepository = new ArrayList<>();
    }

    public static CubeRepositoryImpl getInstance(){
        LOGGER.info("Getting repository");
        if (instance == null) {
            instance = new CubeRepositoryImpl();
        }
        return instance;
    }

    public List<CubeObservable> getCubeRepository(){
        return cubeRepository;
    }

    public void setCubeRepository(List<CubeObservable> cubeRepository){
        LOGGER.info("Set new repository");
        this.cubeRepository = cubeRepository;
    }

    @Override
    public void addCube(CubeObservable cubeObservable){
        LOGGER.info("Add new cube to repository");
        this.cubeRepository.add(cubeObservable);
    }

    @Override
    public void removeCube(CubeObservable cubeObservable){
        LOGGER.info("Delete cube from repository");
        this.cubeRepository.remove(cubeObservable);
    }

    @Override
    public void updateCube(CubeObservable cubeObservable){
        LOGGER.info("Update cube repository by new cube");
        for (CubeObservable cubeRepos : cubeRepository) {
            if (cubeRepos.getId() == cubeObservable.getId()) {
                int index = cubeRepository.indexOf(cubeRepos);
                cubeRepository.set(index, cubeObservable);
            }
        }
    }

    @Override
    public void sortByTag(Comparator sortByTag){
        LOGGER.info("Sort repository");
        Collections.sort(cubeRepository, sortByTag);
    }

    @Override
    public List<CubeObservable> query(CubeSpecification cubeSpecification){
        LOGGER.info("Query repository by specification");
        List<CubeObservable> listQuery = new ArrayList<>();
        for (CubeObservable c : cubeRepository) {
            if (cubeSpecification.specified(c)) {
                listQuery.add(c);
            }
        }
        if (listQuery.size() == 0) {
            LOGGER.info("Cube with that specification not found!");
        }
        return listQuery;
    }


    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CubeRepositoryImpl that = (CubeRepositoryImpl) o;
        return Objects.equals(cubeRepository, that.cubeRepository);
    }

    @Override
    public int hashCode(){
        return Objects.hash(cubeRepository);
    }

    @Override
    public String toString(){
        return "CubeRepositoryImpl{" +
                "cubeRepository=" + cubeRepository +
                '}';
    }
}
