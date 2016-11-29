package rrs;

import org.testng.annotations.*;
import static org.mockito.Mockito.*;

@Test
public class RaceResultsServiceTest {
    
    public void subscribedClientShouldReceiveMessage() {
        RaceResultsService raceResults = new RaceResultsService();
        Client client = mock(Client.class);
        Message message = mock(Message.class);
        
        raceResults.addSubscriber(client);
        raceResults.send(message);
        
        verify(client).receive(message);
    }
}
