import org.junit.Test;
import org.suns.data.collector.collectors.sheet411.Sheet411CoreCollector;
import org.suns.data.collector.collectors.sheet411.Sheet411PersonalCollector;
import org.suns.data.collector.collectors.sheet421.Sheet421CoreCollector;
import org.suns.data.collector.collectors.sheet421.Sheet421PersonalCollector;
import org.suns.data.collector.collectors.sheet424.Sheet424CoreCollector;
import org.suns.data.collector.collectors.sheet424.Sheet424PersonalCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426CoreCollector;
import org.suns.data.collector.collectors.sheet426.Sheet426PersonalCollector;
import org.suns.data.collector.collectors.sheet428.Sheet428CoreCollector;
import org.suns.data.collector.collectors.sheet428.Sheet428PersonalCollector;
import org.suns.data.collector.collectors.sheet429.Sheet429CoreCollector;
import org.suns.data.collector.collectors.sheet429.Sheet429PersonalCollector;

/**
 * Created by guanl on 6/28/2017.
 */
public class CollectorsTest {

    @Test
    public void test_sheet411personal(){
        try{
            //Sheet411PersonalCollector.inspect();
            //Sheet411CoreCollector.inspect();
            //Sheet421CoreCollector.inspect();
            //Sheet411CoreCollector.inspect();
            //Sheet411PersonalCollector.inspect();
            //Sheet421CoreCollector.inspect();
            //Sheet421PersonalCollector.inspect();
            //Sheet424PersonalCollector.inspect();
            //Sheet424CoreCollector.inspect();
            //Sheet429CoreCollector.inspect();
            //Sheet429PersonalCollector.inspect();
            //Sheet426PersonalCollector.inspect();
            Sheet426CoreCollector.inspect();

        }catch (Exception e){
            e.printStackTrace();
        }

        return;
    }
}
