package de.hfu.residents.repository;

import de.hfu.residents.domain.Resident;

import java.util.List;

public class ResidentRespositoryStub implements ResidentRepository{
    private List<Resident> residents;
    @Override
    public List<Resident> getResidents() {
        return this.residents;
    }
    public void addResident(Resident resident) {
        this.residents.add(resident);
    }
}
