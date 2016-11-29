package rrs;

import static org.testng.Assert.*;
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
    
    public void messageShouldBeSendToAllSubscribedClients() {
        RaceResultsService raceResults = new RaceResultsService();
        Client clientA = mock(Client.class);
        Client clientB = mock(Client.class);
        Message message = mock(Message.class);
        
        raceResults.addSubscriber(clientA);
        raceResults.addSubscriber(clientB);
        raceResults.send(message);
        
        verify(clientA).receive(message);
        verify(clientB).receive(message);
    }
}
