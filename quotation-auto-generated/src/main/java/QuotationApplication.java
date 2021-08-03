import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class QuotationApplication {

    private static final Logger logger= LoggerFactory.getLogger(QuotationApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(QuotationApplication.class, args);
        logger.info("QuotationApplication start success!!!!!");
    }

}
