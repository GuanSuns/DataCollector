import org.junit.Test;
import org.suns.collector.sheet411.Sheet411CoreCollector;
import org.suns.collector.sheet411.Sheet411PersonalCollector;
import org.suns.collector.sheet421.Sheet421CoreCollector;
import org.suns.collector.sheet421.Sheet421PersonalCollector;

/**
 * Created by guanl on 6/28/2017.
 */
public class CollectorsTest {

    @Test
    public void test_sheet411personal(){
        try{
            //Sheet411PersonalCollector.inspect();
            //Sheet411CoreCollector.inspect();
            Sheet421PersonalCollector.inspect();
            Sheet421CoreCollector.inspect();
        }catch (Exception e){
            e.printStackTrace();
        }

        return;
    }
}
