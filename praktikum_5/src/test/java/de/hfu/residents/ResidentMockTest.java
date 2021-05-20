package de.hfu.residents;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.easymock.EasyMock.*;

import de.hfu.residents.repository.ResidentRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import de.hfu.residents.repository.ResidentRepositoryStub;
import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.service.BaseResidentService;
import de.hfu.residents.service.ResidentServiceException;

public class ResidentMockTest {
    List<Resident> residents = new ArrayList<Resident>();
    BaseResidentService baseresidentService = new BaseResidentService();

    @SuppressWarnings("deprecation")
    Resident mueller = new Resident("Daniel", "Mueller", "Musterstr. 13", "Furtwangen", new Date(1997, Calendar.APRIL, 30));
    @SuppressWarnings("deprecation")
    Resident muenster = new Resident("Erich", "Muenster", "Maxstr. 9", "Furtwangen", new Date(1990, Calendar.JULY, 4));
    @SuppressWarnings("deprecation")
    Resident mustermann = new Resident("Max", "Mustermann", "Maxstr. 5", "Villingen", new Date(1980, Calendar.APRIL, 5));
    @SuppressWarnings("deprecation")
    Resident hejer = new Resident("Dany", "Heyer", "Mienenstr. 40", "Furtwangen", new Date(1997, Calendar.MAY, 20));
    @SuppressWarnings("deprecation")
    Resident mueller_turgau = new Resident("Samanta", "Mueller", "Lochstr. 45", "Furtwangen", new Date(2004, Calendar.NOVEMBER, 12));
    @Before
    public void addResidents(){
        residents.add(mueller);
        residents.add(muenster);
        residents.add(mustermann);
        residents.add(hejer);
        residents.add(mueller_turgau);
    }
    @Test
    public void getFilteredResidentsTest() {
        ResidentRepository residentRespository = createMock(ResidentRepository.class);
        baseresidentService.setResidentRepository(residentRespository);
        Resident testResidentName = new Resident("D*", "*", "M*", "F", null);
        List<Resident> filteredList = baseresidentService.getFilteredResidentsList(testResidentName);
        expect(residentRespository.getResidents()).andStubReturn(residents);
        replay(residentRespository);
        baseresidentService.setResidentRepository(residentRespository);

        Resident residentOne = new Resident("D*", "*", "M*", "F", null);
        List<Resident> filteredResident = baseresidentService.getFilteredResidentsList(residentOne);
        assertThat(filteredResident.get(0).getFamilyName(), equalTo("Mueller"));
        assertThat(filteredResident.get(0).getCity(), equalTo("Furtwangen"));
        assertThat(filteredResident.get(1).getFamilyName(), equalTo("Heyer"));

        Resident testResidentEmpty = new Resident("Hilde", "Brunner", "Musterstr. 13", "Steinmauern", null);
        List<Resident> filteredEmtpy = baseresidentService.getFilteredResidentsList(testResidentEmpty);
        assertThat(filteredEmtpy.isEmpty(), equalTo(true));


        Resident oneResident = new Resident ("*", "*", "Maxstr.*", "*", null );
        List<Resident> filteredMList = baseresidentService.getFilteredResidentsList(oneResident);
        assertThat(filteredMList.get(0).getGivenName(), equalTo("Erich"));
        assertThat(filteredMList.get(1).getGivenName(), equalTo("Max"));
        assertThat(filteredMList.size(), equalTo(2));

        Resident testFullResidentList = new Resident("*", "*", "*", "*", null );
        List<Resident> filteredAll = baseresidentService.getFilteredResidentsList(testFullResidentList);
        int allResidents = filteredAll.size();
        assertEquals(allResidents, 5);
        @SuppressWarnings("deprecation")
        Resident testDateResident = new Resident("*", "*", "*", "*", new Date(1980, Calendar.APRIL, 5));
        List<Resident> filteredDateList = baseresidentService.getFilteredResidentsList(testDateResident);
        assertEquals(filteredDateList.get(0).getFamilyName(), "Mustermann");

        verify(residentRespository);
    }
}