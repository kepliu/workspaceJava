package vogella.tutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class ArticleManagerTest  {

       private ArticleCalculator calculator = mock(ArticleCalculator.class);
       @Mock private ArticleDatabase database;
       //@Spy private UserProvider userProvider = new ConsumerUserProvider();

       // creates instance of ArticleManager
       // and performs constructor injection on it
       @InjectMocks private ArticleManager manager;

       @Test public void shouldDoSomething() {
         // assume that ArticleManager has a method called initialize which calls a method
         // addListener with an instance of ArticleListener
         manager.initialize();
         
           // validate that addListener was called
         verify(database).addListener(any(ArticleListener.class));
       }
} 

