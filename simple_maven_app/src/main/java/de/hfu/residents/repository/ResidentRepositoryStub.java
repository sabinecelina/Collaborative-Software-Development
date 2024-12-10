package de.hfu.residents.repository;

import de.hfu.residents.domain.Resident;

import java.util.ArrayList;
import java.util.List;

public class ResidentRepositoryStub implements ResidentRepository{
    private List<Resident> residents = new ArrayList<Resident>();;
    @Override
    public List<Resident> getResidents() {
        return this.residents;
    }
    public void addResident(Resident resident) {
        this.residents.add(resident);
    }
}