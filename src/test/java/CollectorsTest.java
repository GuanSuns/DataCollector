import org.junit.Test;
import org.suns.data.collector.collectors.sheet424.Sheet424PersonalCollector;
import org.suns.data.collector.collectors.sheet428.Sheet428CoreCollector;
import org.suns.data.collector.collectors.sheet428.Sheet428PersonalCollector;

/**
 * Created by guanl on 6/28/2017.
 */
public class CollectorsTest {

    @Test
    public void test_sheet411personal(){
        try{
            //Sheet411PersonalCollector.inspect();
            //Sheet411CoreCollector.inspect();
            Sheet428CoreCollector.inspect();
        }catch (Exception e){
            e.printStackTrace();
        }

        return;
    }
}
