package integration;

import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import connection.TqsBasicHttpClient;
import geocoding.Address;
import geocoding.AddressResolverService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressResolverIT {

    AddressResolverService resolver = new AddressResolverService(new TqsBasicHttpClient());

    @BeforeEach
    public void init(){
    }


    @Test
    public void whenGoodCoordidates_returnAddress() throws IOException, URISyntaxException, ParseException {

        Optional<Address> result = resolver.findAddressForLocation(40.63436, -8.65616);

        //return
        Address expected = new Address( "Avenida da Universidade", "Aveiro","3810-489", "");

        assertTrue( result.isPresent());
        assertEquals( expected, result.get());

    }

    @Test
    public void whenBadCoordidates_thenReturnNoValidAddrress() throws IOException, URISyntaxException, ParseException {

        //todo
        // repeat the same tests conditions from AddressResolverTest, without mocks
        Optional<Address> result = resolver.findAddressForLocation( -361,-361);
        // verify no valid result
        assertFalse( result.isPresent());
        
    }

}
