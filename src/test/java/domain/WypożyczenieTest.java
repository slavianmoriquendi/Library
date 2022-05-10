package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.configuration.IMockitoConfiguration;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WypożyczenieTest {
    @Mock
    Wypożyczenie wypożyczenieTest;

//Czemu to wywalaNullPoiintera?
    @Test
    void schouldSetProperPrzewidywanDataOddania() {
        //given
        //Wypożyczenie wypożyczenieTest = mock(Wypożyczenie.class);
        when(wypożyczenieTest.getLibraryResource().getResourceType()).thenReturn(ResourceType.BOOK);
        when(wypożyczenieTest.getDataWypożyczenia()).thenReturn(LocalDate.of(2022,01,01));

        //when
        wypożyczenieTest.ustalPrzewidywanąDatęOddania();
        // then
        verify(wypożyczenieTest.getPrzewidywanaDataOddania().isEqual(LocalDate.of(2022,01,31)));
    }

}